package com.vns.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.vns.vo.TransactionInfo;

public interface TransactionMapper {

	public List<TransactionInfo> findTransactionList(TransactionInfo ti);
	public int findTransactionListCount(TransactionInfo ti);
	public List<TransactionInfo> findTransactionInfoByBlock(@Param("blockId")String blockId);
	public void addTransaction(TransactionInfo ti);
	public TransactionInfo transactionDivInfo();
	public TransactionInfo findTransactionByHash(TransactionInfo ti);
	/**
	 * 查询昨天的交易发送地址，过滤掉已经存在用户表里的地址
	 * @param tx 昨天的开始时间、结束时间
	 * @return
	 */
	public List<TransactionInfo> getYesterdayTxFromAddr(TransactionInfo tx);
	
	/**
	 * 查询昨天的交易接收地址，过滤掉已经存在用户表里的地址
	 * @param tx 昨天的开始时间、结束时间
	 * @return
	 */
	public List<TransactionInfo> getYesterdayTxToAddr(TransactionInfo tx);
	
	/**
	 * 查询昨天的Token交易发送地址，过滤掉已经存在Token用户表里的地址
	 * @param tx 昨天的开始时间、结束时间
	 * @return
	 */
	public List<TransactionInfo> getYesterdayTokenTxFromAddr(TransactionInfo tx);
	/**
	 * 查询昨天的Token交易接收地址，过滤掉已经存在Token用户表里的地址
	 * @param tx 昨天的开始时间、结束时间
	 * @return
	 */
	public List<TransactionInfo> getYesterdayTokenTxToAddr(TransactionInfo tx);
}
