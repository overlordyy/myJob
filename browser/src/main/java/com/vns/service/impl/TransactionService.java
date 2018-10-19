package com.vns.service.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.protocol.core.Request;
import org.web3j.protocol.core.methods.response.EthGetTransactionReceipt;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.vns.VnsWeb3j;

import redis.clients.jedis.Jedis;

import com.vns.dao.HomeTransactionsMapper;
import com.vns.dao.TransactionMapper;
import com.vns.redisUtils.ConfigUtils;
import com.vns.redisUtils.SerializeUtil;
import com.vns.service.ITransactionService;
import com.vns.util.DateUtil;
import com.vns.vo.DataResult;
import com.vns.vo.HomeTransactions;
import com.vns.vo.TableSplitResult;
import com.vns.vo.TransactionInfo;

@Service
public class TransactionService implements ITransactionService{

	@Autowired
	private TransactionMapper tm;
	@Autowired
	private HomeTransactionsMapper htm;
	public static Jedis jedis = new Jedis(ConfigUtils.ip, ConfigUtils.port);
	public static VnsWeb3j vnsWeb3j = Web3Service.getVnsWeb3j();
	/**
	 * 查询所有交易
	 */
	@Override
	public TableSplitResult<TransactionInfo> findTransactionList(TransactionInfo ti) {
		TableSplitResult<TransactionInfo> result = new TableSplitResult<TransactionInfo>();
		List<TransactionInfo> tiList = new ArrayList<TransactionInfo>();
		int count = tm.findTransactionListCount(ti);
		try {
			if(count != 0){
				tiList = tm.findTransactionList(ti);
				for (TransactionInfo tis : tiList) {
					Request<?, EthGetTransactionReceipt>  transationReceipt = vnsWeb3j.ethGetTransactionReceipt(tis.getHash());
					TransactionReceipt receipt = transationReceipt.send().getResult();
					tis.setStatus(receipt.getStatus());
					tis.setGasUsed(receipt.getGasUsed().longValue());
					tis.setBlockTimeStr(DateUtil.formatDuring(tis.getBlockTime()));
					tis.setTxValueStr(DateUtil.toDecimal(18, new BigInteger(new BigDecimal(tis.getTxValue()).toString())));
					tis.setGasPriceStr(DateUtil.toDecimal(18, new BigInteger(new BigDecimal(tis.getGasPrice()).toString())));
					tis.setTransactionPoundageStr(DateUtil.toDecimal(18, new BigInteger(new BigDecimal(receipt.getGasUsed().longValue()*tis.getGasPrice()).toString())));
				}
				result.setRows(tiList);
				result.setTotal(count);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 根据区块查询交易
	 */
	@Override
	public TableSplitResult<TransactionInfo> findTransactionInfoByBlock(TransactionInfo ti) {
		TableSplitResult<TransactionInfo> result = new TableSplitResult<TransactionInfo>();
		List<TransactionInfo> tiList = new ArrayList<TransactionInfo>();
		TransactionInfo tia = ti;
		int count = tm.findTransactionListCount(tia);
		try {
			if(count != 0){
				tiList = tm.findTransactionList(tia);
				for (TransactionInfo tis : tiList) {
					Request<?, EthGetTransactionReceipt>  transationReceipt = vnsWeb3j.ethGetTransactionReceipt(tis.getHash());
					TransactionReceipt receipt = transationReceipt.send().getResult();
					tis.setStatus(receipt.getStatus());
					tis.setGasUsed(receipt.getGasUsed().longValue());
					tis.setBlockTimeStr(DateUtil.formatDuring(tis.getBlockTime()));
					tis.setTxValueStr(DateUtil.toDecimal(18, new BigInteger(new BigDecimal(tis.getTxValue()).toString())));
					tis.setGasPriceStr(DateUtil.toDecimal(18, new BigInteger(new BigDecimal(tis.getGasPrice()).toString())));
					tis.setTransactionPoundageStr(DateUtil.toDecimal(18, new BigInteger(new BigDecimal(receipt.getGasUsed().longValue()*tis.getGasPrice()).toString())));
				}
				result.setRows(tiList);
				result.setTotal(count);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public void addTransaction(TransactionInfo ti) {
		tm.addTransaction(ti);
	}

	@Override
	public DataResult<HomeTransactions> transactionDivInfo() {
		Jedis jedis = new Jedis(ConfigUtils.ip, ConfigUtils.port);
		DataResult<HomeTransactions> dr = new DataResult<HomeTransactions>();
		//查询最新区块数据
		HomeTransactions ht = htm.findTransactionData();
		try {
			System.out.println(ht.getTransactionsPriceSum());
			System.out.println(ht.getMaxTransactionsPrice());
			BigDecimal bd1 = new BigDecimal(ht.getTransactionsPriceSum());
			BigDecimal bd3 = new BigDecimal(ht.getMinTransactionsPrice());
			BigDecimal bd2 = new BigDecimal(ht.getMaxTransactionsPrice());
			BigDecimal bd4 = new BigDecimal(ht.getMinPoundage());
			BigDecimal bd5 = new BigDecimal(ht.getMaxPoundage());
			BigDecimal bd6 = new BigDecimal(ht.getGasSum());
			BigDecimal bd7 = new BigDecimal(ht.getPoundageSum());
			ht.setMinTransactionsPriceStr(DateUtil.toDecimal(18,new BigInteger(bd3.toString())));
			ht.setMaxTransactionsPriceStr(DateUtil.toDecimal(18,new BigInteger(bd2.toString())));
			ht.setTransactionsPriceSum(Double.valueOf(DateUtil.toDecimal(18,new BigInteger(bd1.toString()))));
			ht.setMinPoundageStr(DateUtil.toDecimal(18,new BigInteger(bd4.toString())));
			ht.setMaxPoundageStr(DateUtil.toDecimal(18,new BigInteger(bd5.toString())));
			ht.setPoundageSumStr(DateUtil.toDecimal(18,new BigInteger(bd7.toString())));
			dr.setData(ht);
			jedis.set("transactionDivInfo".getBytes(), SerializeUtil.serialize(dr));
		} finally { 
//			JedisUtils.returnResource(jedis);
//			jedis.close();
		}
		return dr;
	}

	@Override
	public DataResult<TransactionInfo> findTransactionByHash(TransactionInfo ti) {
		DataResult<TransactionInfo> dr = new DataResult<TransactionInfo>();
		TransactionInfo tInfo = tm.findTransactionByHash(ti);
		try {
			Request<?, EthGetTransactionReceipt>  transationReceipt = vnsWeb3j.ethGetTransactionReceipt(tInfo.getHash());
			TransactionReceipt receipt = transationReceipt.send().getResult();
			tInfo.setStatus(receipt.getStatus());
			tInfo.setGasUsed(receipt.getGasUsed().longValue());
			tInfo.setBlockTimeStr(DateUtil.formatDuring(new Date().getTime()-tInfo.getTransactionTime().getTime()));
			tInfo.setTxValueStr(DateUtil.toDecimal(18, new BigInteger(new BigDecimal(tInfo.getTxValue()).toString())));
			tInfo.setGasPriceStr(DateUtil.toDecimal(18, new BigInteger(new BigDecimal(tInfo.getGasPrice()).toString())));
			tInfo.setTransactionPoundageStr(DateUtil.toDecimal(18, new BigInteger(new BigDecimal(receipt.getGasUsed().longValue()*tInfo.getGasPrice()).toString())));
			dr.setData(tInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dr;
	}
	
	/**
	 * 查询昨天的发送交易地址，过滤掉已经存在用户表里的地址
	 */
	public List<TransactionInfo> getYesterdayTxFromAddr() {
		Date current = new Date();
		Date begin = DateUtil.getYesterdayBeginDate(current);
		Date end = DateUtil.getYesterdayEndDate(current);
		TransactionInfo param = new TransactionInfo();
		param.setBeginDate(begin);
		param.setEndDate(end);
		
		return tm.getYesterdayTxFromAddr(param);
	}
	
	/**
	 * 查询昨天的接收交易地址，过滤掉已经存在用户表里的地址
	 */
	public List<TransactionInfo> getYesterdayTxToAddr() {
		Date current = new Date();
		Date begin = DateUtil.getYesterdayBeginDate(current);
		Date end = DateUtil.getYesterdayEndDate(current);
		TransactionInfo param = new TransactionInfo();
		param.setBeginDate(begin);
		param.setEndDate(end);
		
		return tm.getYesterdayTxToAddr(param);
	}
	
	/**
	 * 查询昨天的Token发送交易地址，过滤掉已经存在Token用户表里的地址
	 */
	public List<TransactionInfo> getYesterdayTokenTxFromAddr() {
		Date current = new Date();
		Date begin = DateUtil.getYesterdayBeginDate(current);
		Date end = DateUtil.getYesterdayEndDate(current);
		TransactionInfo param = new TransactionInfo();
		param.setBeginDate(begin);
		param.setEndDate(end);
		
		return tm.getYesterdayTokenTxFromAddr(param);
	}
	
	/**
	 * 查询昨天的Token接收交易地址，过滤掉已经存在Token用户表里的地址
	 */
	public List<TransactionInfo> getYesterdayTokenTxToAddr() {
		Date current = new Date();
		Date begin = DateUtil.getYesterdayBeginDate(current);
		Date end = DateUtil.getYesterdayEndDate(current);
		TransactionInfo param = new TransactionInfo();
		param.setBeginDate(begin);
		param.setEndDate(end);
		
		return tm.getYesterdayTokenTxToAddr(param);
	}
}
