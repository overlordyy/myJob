package com.vns.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import redis.clients.jedis.Jedis;

import com.vns.redisUtils.ConfigUtils;
import com.vns.redisUtils.JedisUtils;
import com.vns.redisUtils.SerializeUtil;
import com.vns.service.IBlockService;
import com.vns.vo.BlockInfo;
import com.vns.vo.DataResult;
import com.vns.vo.HomeBlock;
import com.vns.vo.PriceMarket;
import com.vns.vo.TableSplitResult;

@Controller
@RequestMapping("/block")
public class VnsBlockInfoController {
	@Autowired
	private IBlockService ibs;
	
	@RequestMapping(value="/blockStop",method=RequestMethod.GET)
	@ResponseBody
    public void blockStop(BlockInfo bi)
    {
        ibs.blockStop();
    }
	
	@RequestMapping(value="/listInfo",method=RequestMethod.GET)
	@ResponseBody
    public TableSplitResult findBlockList(BlockInfo bi)
    {
        return ibs.findBlockList(bi);
    }

	@RequestMapping(value="/findBlock",method=RequestMethod.GET)
	@ResponseBody
    public DataResult<BlockInfo> findBlock(HttpServletRequest request)
    {
		String blockNumber = request.getParameter("blockNumber");
		String type = request.getParameter("type");
        return ibs.findBlock(Integer.parseInt(blockNumber),Integer.parseInt(type));
    }
	
	
	@RequestMapping(value="/blockDivInfo",method=RequestMethod.GET)
	@ResponseBody
    public DataResult<BlockInfo> blockDivInfo()
    {
        return ibs.blockDivInfo();
    }
	
	/**
	 * 查询vns最新信息
	 * @return
	 */
	@RequestMapping(value="/findVnsNewInfo",method=RequestMethod.GET)
	@ResponseBody
	public DataResult<PriceMarket> findVnsNewInfo(){
		Jedis jedis = JedisUtils.getJedis();
		try {
			if(jedis.exists("findVnsNewInfo".getBytes())){
				return (DataResult<PriceMarket>) SerializeUtil.unserialize(jedis.get("findVnsNewInfo".getBytes()));
			}else{
				return ibs.findVnsNewInfo();
			}
		} finally { 
			//JedisUtils.returnResource(jedis);
//			jedis.close();
		}
	}
	
	/**
	 * 查询vns最新信息
	 * @return
	 */
	@RequestMapping(value="/findBlockInfo",method=RequestMethod.GET)
	@ResponseBody
	public DataResult<HomeBlock> findBlockInfo(){
//		Jedis jedis = JedisUtils.getJedis();
		Jedis jedis = new Jedis(ConfigUtils.ip, ConfigUtils.port);
		try {
			if(jedis.exists("findBlockInfo".getBytes())){
				return (DataResult<HomeBlock>) SerializeUtil.unserialize(jedis.get("findBlockInfo".getBytes()));
			}else{
				return ibs.findBlockInfo();
			}
		} finally { 
			//JedisUtils.returnResource(jedis);
//			jedis.close();
		}
	}
	
	/**
	 * 根据区块hash查询区块信息
	 * @return
	 */
	@RequestMapping(value="/findBlockInfoByHash",method=RequestMethod.GET)
	@ResponseBody
	public DataResult<BlockInfo> findBlockInfoByHash(HttpServletRequest request){
		String blockHash = request.getParameter("blockHash");
        return ibs.findBlockInfoByHash(blockHash);
	}
	
}
