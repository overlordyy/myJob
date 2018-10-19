package com.vns.service.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.abi.FunctionReturnDecoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.Utils;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;

import redis.clients.jedis.Jedis;
import rx.Subscription;

import com.vns.dao.BlockMapper;
import com.vns.dao.HomeBlockMapper;
import com.vns.dao.TokenMapper;
import com.vns.redisUtils.ConfigUtils;
import com.vns.redisUtils.SerializeUtil;
import com.vns.service.IBlockService;
import com.vns.service.ICalculatorService;
import com.vns.service.IPriceMarketService;
import com.vns.service.ITransactionService;
import com.vns.util.Constants;
import com.vns.util.DateUtil;
import com.vns.util.ServiceUtil;
import com.vns.vo.BlockInfo;
import com.vns.vo.Calculator;
import com.vns.vo.DataResult;
import com.vns.vo.HomeBlock;
import com.vns.vo.PriceMarket;
import com.vns.vo.TableSplitResult;


@Service
public class BlockService implements IBlockService {

	@Autowired
	private HomeBlockMapper hbm;
	@Autowired
	private BlockMapper bm;
	@Autowired
	private TokenMapper tm;
	@Autowired
	private ITransactionService its;
	@Autowired
	private IPriceMarketService pms;
	@Autowired
	private ICalculatorService ics;
	public static Subscription subscription;
	public static String formats = "yyyy-MM-dd HH:mm:ss";
	@Override
	public TableSplitResult<BlockInfo> findBlockList(BlockInfo bi) {
		TableSplitResult<BlockInfo> result = new TableSplitResult<BlockInfo>();
		List<BlockInfo> biList = bm.findBlockListOrder();
		result.setRows(biList);
		result.setTotal(biList.size());
		return result;
	}
	
	/**
	 * 通过高度进行区块查询向后
	 */
	@Override
	public DataResult<BlockInfo> findBlock(int blockNumber,int type) {
		DataResult<BlockInfo> dr = new DataResult<BlockInfo>();
		//判断区块高度查询条件是否为0，如果为0，就查出默认三个区块，如果不为0，则查出前后区块。
		List<BlockInfo> biList = new ArrayList<BlockInfo>();
		if(blockNumber==1){
			biList=bm.findBlock();
		}else{
			biList=bm.findBlockByBlockNumber(blockNumber,type);
		}
		for (BlockInfo bic : biList) {
			bic.setBlockPoundageStr(DateUtil.toDecimal(18, new BigInteger(new BigDecimal(bic.getBlockPoundage()).toString())));
		}
		dr.setDataList(biList);
		dr.setStatus(1);
		dr.setMsg("OK！");
		return dr;
	}
	
	@Override
	public void blockStop(){
		subscription.unsubscribe();
		subscription=null;
	}

	@Override
	public DataResult<BlockInfo> blockDivInfo() {
		DataResult<BlockInfo> dr = new DataResult<BlockInfo>();
		//查询最新区块数据
//		BlockInfo bi = bm.blockDivInfo();
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		bi.setBlockTimeStr(sdf.format(bi.getBlockTime()));
//		//查询创世区块
//		try {
//			Block bk = VnsRpcApi.getBlockByNumber(DefaultBlockParameter.valueOf(BigInteger.valueOf(0)), true);
//			bi.setZeroBlock(bk.getHash());
//	        Long timestamp = bk.getTimestamp().longValue() * 1000;
//			bi.setZeroBlockTime(new Date(timestamp));
//			bi.setZeroBlockTimeStr(sdf.format(timestamp));
//			dr.setData(bi);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return dr;
	}
	
	public static List<Type> decodeFunctionInput(String input) {
        List<Type> results = null;
        if (input.length() < 128) {
            return results;
        }
        results = FunctionReturnDecoder.decode(input.substring(input.length() - 128), Utils.convert(Arrays.asList(new TypeReference<Address>() {
        }, new TypeReference<Uint256>() {
        })));
        return results;
    }

	@Override
	public DataResult<PriceMarket> findVnsNewInfo() {
		Jedis jedis = new Jedis(ConfigUtils.ip, ConfigUtils.port);
		DataResult<PriceMarket> dr = new DataResult<PriceMarket>();
		PriceMarket pm = new PriceMarket();
		PriceMarket hpm = new PriceMarket();
		try{
			//获取24小时前的数据
			hpm = pms.before24HPrice();
			pm = pms.queryRecentPrice();
			pm.setIncrease(new BigDecimal((pm.getDollerPrice()-hpm.getDollerPrice())/hpm.getDollerPrice()*100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
			pm.setPriceCount(bm.rewardSum()+Constants.DictionaryPath.PREDUG);
			dr.setData(pm);
			jedis.set("findVnsNewInfo".getBytes(), SerializeUtil.serialize(dr));
	    }catch(Exception e){
	    	e.printStackTrace();
	    }finally { 
//			JedisUtils.returnResource(jedis);
//			jedis.close();
		}
	    return dr;
	}

	@Override
	public DataResult<HomeBlock> findBlockInfo() {
		Jedis jedis = new Jedis(ConfigUtils.ip, ConfigUtils.port);
		DataResult<HomeBlock> dr = new DataResult<HomeBlock>();
		HomeBlock hb = new HomeBlock();
		try {
			hb=hbm.query();
			//获取全网算力（算力平均值）
			DataResult<Calculator> calculator = ics.getVnsData();
			hb.setHashRate(calculator.getData().getYesterdayHashRateDisplay());
			// 转换全网算力和难度的单位
			ServiceUtil.formatDifficultyAndHashRate(hb);
			dr.setData(hb);
			jedis.set("findBlockInfo".getBytes(), SerializeUtil.serialize(dr));
		} finally { 
//			JedisUtils.returnResource(jedis);
//			jedis.close();
		}
		return dr;
	}

	@Override
	public void operationBlockInfo() {
		HomeBlock hb = new HomeBlock();
		hb = hbm.queryNewData();
		hbm.delete();
		hbm.insert(hb);
	}

	@Override
	public DataResult<BlockInfo> findBlockInfoByHash(String blockHash) {
		DataResult<BlockInfo> dr = new DataResult<BlockInfo>();
		BlockInfo bi = bm.findBlockInfoByHash(blockHash);
		bi.setBlockTimeStr(DateUtil.formatDuring(new Date().getTime()-bi.getBlockTime().getTime()));
		bi.setBlockPoundageStr(DateUtil.toDecimal(18, new BigInteger(new BigDecimal(bi.getBlockPoundage()).toString())));
		bi.setNonceStr(DateUtil.toDecimal(18, new BigInteger(new BigDecimal(bi.getNonce()).toString())));
		dr.setData(bi);
		dr.setStatus(1);
		dr.setMsg("OK！");
		return dr;
	}
}
