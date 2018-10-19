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
	public List<TransactionInfo> findAllTransaction(@Param("from")Integer from);
	public List<TransactionInfo> updateTransactionToAddressByInput();
	public void updateTransactionToAddress(TransactionInfo ti);
}
