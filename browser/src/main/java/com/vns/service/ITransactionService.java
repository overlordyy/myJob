package com.vns.service;

import java.util.List;

import com.vns.vo.DataResult;
import com.vns.vo.HomeTransactions;
import com.vns.vo.TableSplitResult;
import com.vns.vo.TransactionInfo;

public interface ITransactionService {
	
	public TableSplitResult<TransactionInfo> findTransactionList(TransactionInfo ti);
	
	public TableSplitResult<TransactionInfo> findTransactionInfoByBlock(TransactionInfo ti);
	
	public void addTransaction(TransactionInfo ti);
	
	public DataResult<HomeTransactions> transactionDivInfo();
	
	public DataResult<TransactionInfo> findTransactionByHash(TransactionInfo ti);
	
	/**
	 * 查询昨天的发送交易地址，过滤掉已经存在用户表里的地址
	 * @param tx 昨天的开始时间、结束时间
	 * @return
	 */
	public List<TransactionInfo> getYesterdayTxFromAddr();
	
	/**
	 * 查询昨天的接收交易地址，过滤掉已经存在用户表里的地址
	 * @param tx 昨天的开始时间、结束时间
	 * @return
	 */
	public List<TransactionInfo> getYesterdayTxToAddr();
	
	/**
	 * 查询昨天的Token发送交易地址，过滤掉已经存在Token用户表里的地址
	 */
	public List<TransactionInfo> getYesterdayTokenTxFromAddr();
	
	/**
	 * 查询昨天的Token接收交易地址，过滤掉已经存在Token用户表里的地址
	 */
	public List<TransactionInfo> getYesterdayTokenTxToAddr();
}
