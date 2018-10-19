package com.vns.service.impl;
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
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.Request;
import org.web3j.protocol.core.methods.response.EthBlock;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.core.methods.response.EthBlock.Block;
import org.web3j.protocol.core.methods.response.EthBlock.TransactionObject;
import org.web3j.protocol.core.methods.response.EthBlock.TransactionResult;
import org.web3j.protocol.core.methods.response.EthGetTransactionReceipt;
import org.web3j.protocol.vns.VnsWeb3j;

import rx.Subscription;

import com.vns.api.VnsTokenRpcApi;
import com.vns.dao.BlockMapper;
import com.vns.service.IBlockService;
import com.vns.service.ITokenService;
import com.vns.service.ITransactionService;
import com.vns.util.DateUtil;
import com.vns.vo.BlockInfo;
import com.vns.vo.DataResult;
import com.vns.vo.TableSplitResult;
import com.vns.vo.TokenInfo;
import com.vns.vo.TransactionInfo;


@Service
public class BlockService implements IBlockService {

	@Autowired
	private BlockMapper bm;
	@Autowired
	private ITransactionService its;
	@Autowired
	private ITokenService itokens;
	
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
	 * 通过高度进行区块查询
	 */
	@Override
	public DataResult<BlockInfo> findBlock(int blockNumber) {
		DataResult<BlockInfo> dr = new DataResult<BlockInfo>();
		//判断区块高度查询条件是否为0，如果为0，就查出默认三个区块，如果不为0，则查出前后区块。
		if(blockNumber==1){
			dr.setDataList(bm.findBlock());
			dr.setStatus(1);
			dr.setMsg("OK！");
		}else{
			//查询高度减1和高度加1的区块
			dr.setDataList(bm.findBlockByBlockNumber(blockNumber));
			dr.setStatus(1);
			dr.setMsg("OK！");
		}
		return dr;
	}

	@Override
	public void blockSta() {
		//初始化vnsWeb3j
		VnsWeb3j vnsWeb3j = Web3Service.getVnsWeb3j();
		try {
			if(subscription==null){
				subscription = vnsWeb3j.catchUpToLatestAndSubscribeToNewBlocksObservable(DefaultBlockParameter.valueOf(BigInteger.valueOf(838829)), false).subscribe(block -> {
					//交易集合660029
					List<TransactionInfo> transactionList = new ArrayList<TransactionInfo>();
					//token集合
					List<TokenInfo> tokenList = new ArrayList<TokenInfo>();
					//叔块信息集合
					List<BlockInfo> unclesList = new ArrayList<BlockInfo>();
					//交易手续费集合
					List<Float> gasPriceList = new ArrayList<Float>();
					try {
						Date date = new Date();
						Block bl = block.getBlock();
						BlockInfo bi = new BlockInfo();
						bi.setBlockHash(bl.getHash());
						bi.setBlockNumber(bl.getNumber().longValue());
						bi.setParentHash(bl.getParentHash());
				        Long timestamp = bl.getTimestamp().longValue() * 1000;
						bi.setBlockTime(new Date(timestamp));
						bi.setMiner(bl.getMiner());
						bi.setBlockSize(bl.getSize().longValue());
						bi.setDifficulty(String.valueOf(bl.getDifficulty().longValue()));
						bi.setTotalDifficulty(String.valueOf(bl.getTotalDifficulty().longValue()));
						bi.setUncleNum(bl.getUncles().size());
						//获得叔块信息并将叔块数据放入list中
						System.out.println("++++"+bl.getHash());
						if(bl.getUncles().size()>0){
							for (int i = 0; i < bl.getUncles().size(); i++) {
								BigInteger uni = BigInteger.valueOf(i);
								//通过叔块hash查询叔块信息
								Request<?,EthBlock> uncleBlock = vnsWeb3j.ethGetUncleByBlockHashAndIndex(bl.getHash(),uni);
								EthBlock uncleB = uncleBlock.send();
								BlockInfo uncleBlockInfo = new BlockInfo();
								uncleBlockInfo.setBlockHash(uncleB.getResult().getHash());
								uncleBlockInfo.setBlockNumber(uncleB.getResult().getNumber().longValue());
								uncleBlockInfo.setParentHash(uncleB.getResult().getParentHash());
						        Long unTimestamp = uncleB.getResult().getTimestamp().longValue() * 1000;
						        uncleBlockInfo.setBlockTime(new Date(unTimestamp));
						        uncleBlockInfo.setMiner(uncleB.getResult().getMiner());
						        uncleBlockInfo.setBlockSize(uncleB.getResult().getSize().longValue());
						        uncleBlockInfo.setDifficulty(String.valueOf(uncleB.getResult().getDifficulty().longValue()));
						        uncleBlockInfo.setUncleNum(uncleB.getResult().getUncles().size());
						        uncleBlockInfo.setGasLimit(String.valueOf(uncleB.getResult().getGasLimit().longValue()));
						        uncleBlockInfo.setGasUsed(String.valueOf(uncleB.getResult().getGasUsed().longValue()));
						        uncleBlockInfo.setExtraData(uncleB.getResult().getExtraData());
						        uncleBlockInfo.setLogsBloom(uncleB.getResult().getLogsBloom());
						        uncleBlockInfo.setMixHash(uncleB.getResult().getMixHash());
						        uncleBlockInfo.setNonce(uncleB.getResult().getNonce().longValue());
						        uncleBlockInfo.setReceiptsRoot(uncleB.getResult().getReceiptsRoot());
								String unst = "";
								if(bl.getSealFields()!=null){
									for (String sealStr : uncleB.getResult().getSealFields()) {
										unst += ","+sealStr;
									}
								}
								uncleBlockInfo.setSealFields(unst);
								uncleBlockInfo.setSha3Uncles(uncleB.getResult().getSha3Uncles());
								uncleBlockInfo.setStateRoot(uncleB.getResult().getStateRoot());
								uncleBlockInfo.setTransactionsRoot(uncleB.getResult().getTransactionsRoot());
								uncleBlockInfo.setAuthor(uncleB.getResult().getAuthor());
								uncleBlockInfo.setRefUncleBlockHeight(bl.getNumber().longValue());
								uncleBlockInfo.setIsUncle(1);
								uncleBlockInfo.setMinerReward(DateUtil.uncleRewardInfo(uncleBlockInfo, bl.getNumber().longValue()));
								unclesList.add(uncleBlockInfo);
							}
						}
//						for (String uncle : bl.getUncles()) {
//							//通过叔块hash查询叔块信息
//							BlockInfo uncleBlockInfo = bm.findBlockByHash(uncle);
//							//计算叔块的奖励
//							unclesList.add(uncleBlockInfo);
//						}
						bi.setGasLimit(String.valueOf(bl.getGasLimit().longValue()));
						bi.setGasUsed(String.valueOf(bl.getGasUsed().longValue()));
						bi.setExtraData(bl.getExtraData());
						bi.setLogsBloom(bl.getLogsBloom());
						bi.setMixHash(bl.getMixHash());
						bi.setNonce(bl.getNonce().longValue());
						bi.setReceiptsRoot(bl.getReceiptsRoot());
						String st = "";
						if(bl.getSealFields()!=null){
							for (String sealStr : bl.getSealFields()) {
								st += ","+sealStr;
							}
						}
						bi.setSealFields(st);
						bi.setSha3Uncles(bl.getSha3Uncles());
						bi.setStateRoot(bl.getStateRoot());
						bi.setTransactionsRoot(bl.getTransactionsRoot());
						bi.setAuthor(bl.getAuthor());
						//通过区块去查询交易
						EthBlock eblock=null;
						DefaultBlockParameter param = DefaultBlockParameter.valueOf(BigInteger.valueOf(bl.getNumber().longValue()));
						eblock = vnsWeb3j.ethGetBlockByNumber(param,true).send();
						List<TransactionResult> transactions = eblock.getBlock().getTransactions();
						//添加块的交易书数量
						bi.setTransactionsNum(transactions.size());
						for (TransactionResult tr : transactions) {
							TransactionInfo ti = new TransactionInfo();
							TransactionObject to = (TransactionObject) tr.get();
							List<Type> s = decodeFunctionInput(to.getInput());
							ti.setHash(to.getHash());
							ti.setBlockHash(to.getBlockHash());
							ti.setBlockNumber(to.getBlockNumber().longValue());
							ti.setCreates(to.getCreates());
							ti.setFromAddress(to.getFrom());
							ti.setToAddress(to.getTo());
							ti.setTxValue(to.getValue().toString());
							ti.setGas(to.getGas().floatValue());
							ti.setGasPrice(to.getGasPrice().floatValue());
							Request<?, EthGetTransactionReceipt>  transationReceipt = vnsWeb3j.ethGetTransactionReceipt(to.getHash());
							TransactionReceipt receipt = transationReceipt.send().getResult();
							ti.setStatus(receipt.getStatus());
							ti.setGasUsed(receipt.getGasUsed().floatValue());
							//计算交易并存到集合里面
							gasPriceList.add(receipt.getGasUsed().floatValue()*to.getGasPrice().floatValue());
							ti.setInput(to.getInput());
							ti.setNonce(to.getNonce().toString());
							ti.setPublicKey(to.getPublicKey());
							ti.setRaw(to.getRaw());
							ti.setR(to.getR());
							ti.setS(to.getS());
							ti.setV(to.getV());
							ti.setTransactionIndex(to.getTransactionIndex().toString());
							ti.setTransactionPoundage(receipt.getGasUsed().floatValue()*to.getGasPrice().floatValue());
							ti.setTransactionTime(new Date(timestamp));
							//先判断input是否有值
							if(("0x").equals(ti.getInput())){
								//说明此交易是vns交易
								ti.setTransactionType(0);
							}else{
								//说明此交易是token交易
								EthGetTransactionReceipt transactionReceipt = vnsWeb3j.ethGetTransactionReceipt(to.getHash()).send();
								if(transactionReceipt.getResult().getContractAddress()!=null){
									//说明当前是新合约交易
									//调用查询token信息的方法
									TokenInfo tokeni = findTokenInfo(transactionReceipt.getResult().getContractAddress());
									//将token信息添加到token集合里面
									tokenList.add(tokeni);
									ti.setContractAddress(transactionReceipt.getResult().getContractAddress());
									ti.setTransactionType(1);
								}else{
									//说明不是新合约交易
									//判断Input长度是否大于128
									if(to.getInput().length()>128){
										//截取解析
										List<Type> typeList = decodeFunctionInput(to.getInput());
										TokenInfo tokeni = findTokenInfo(to.getTo());
										//将token信息添加到token集合里面
										tokenList.add(tokeni);
										ti.setContractAddress(to.getTo());
										ti.setTransactionType(1);
										//解析获取到address;
									}
								}
							}
							//将交易信息添加到交易集合里面
							transactionList.add(ti);
						}
						//计算总手续费
						bi.setBlockPoundage(DateUtil.blockPoundage(gasPriceList));
						//挖矿奖励
						bi.setMinerReward(209);
						//计算叔块引用奖励
						bi.setRefUncleReward(DateUtil.refUncleReward(bl.getUncles().size()));
						//计算叔块奖励
						bi.setUncleReward(DateUtil.uncleReward(unclesList, bl.getNumber().longValue()));
						//添加区块
						if(bm.findBlockByHash(bi.getBlockHash())==0){
							bm.insertBlock(bi);
							//添加叔块
							for (BlockInfo uncleBlock : unclesList) {
								if(bm.findBlockByHash(uncleBlock.getBlockHash())==0){
									bm.insertBlock(uncleBlock);
								}
							}
							//添加交易
							for (TransactionInfo transcationinfo : transactionList) {
								its.addTransaction(transcationinfo);
							}
//							//添加token
							for (TokenInfo tokeninfo : tokenList) {
								itokens.addToken(tokeninfo);
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				});
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private TokenInfo findTokenInfo(String address){
		TokenInfo tokeni = new TokenInfo();
		try {
			Utf8String name = VnsTokenRpcApi.name(DateUtil.address, address);
			Uint256 contractBalance = VnsTokenRpcApi.balance(DateUtil.address, address);
			Uint8 decimals = VnsTokenRpcApi.decimals(DateUtil.address, address);
			Utf8String symbol = VnsTokenRpcApi.symbol(DateUtil.address, address);
			Uint256 totalSupply = VnsTokenRpcApi.totalSupply(DateUtil.address, address);
			tokeni.setContractAddress(address);
			if(name!=null){
				tokeni.setTokenEnName(name.toString());
			}
			tokeni.setTokenReceivetAddress(address);
			if(symbol!=null){
				tokeni.setTokenName(symbol.toString());
			}
			if(contractBalance!=null){
				tokeni.setTokenBalance(contractBalance.getValue().longValue());
			}

			if(decimals!=null){
				tokeni.setTokenDecimals(decimals.getValue().longValue());
			}

			if(totalSupply!=null){
				tokeni.setTokenTotal(totalSupply.getValue().toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tokeni;
	}

	@Override
	public void seqNewBlock() {
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
		dr.setData(bm.blockDivInfo());
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
	public void findTokenInfo() {
		List<String> toList = bm.findTokenInfo();
		for (String s : toList) {
			//说明当前是新合约交易
			//调用查询token信息的方法
			TokenInfo tokeni = findTokenInfo(s);
			itokens.addToken(tokeni);
		}
	}

}
