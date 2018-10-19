package com.vns.vo;

import java.io.Serializable;

/**
 * 首页交易概览
 * @author Lvp
 *
 */
public class HomeTransactions extends BaseDomain implements Serializable{

	private long transactionsSum; // 累计交易次数
	private double transactionsPriceSum; // 累计交易额
	private double gasSum; // 累计Gas
	private double poundageSum; // 累计手续费
	private String poundageSumStr;
	private float minPoundage; // 单笔最低手续费
	private String minPoundageStr; // 单笔最低手续费
	private String minPoundageTxhash;
	private TransactionInfo minPoundageTx; // 单笔最低手续费的交易
	private float maxPoundage; // 单笔最高手续费
	private String maxPoundageStr; // 单笔最高手续费
	private String maxPoundageTxhash;
	private TransactionInfo maxPoundageTx; // 单笔最高手续费的交易
	private float minTransactionsPrice; // 单笔最低交易额
	private String minTransactionsPriceStr;
	private String minTransactionsPriceHash; // 单笔最低交易额的交易HASH
	private TransactionInfo minTransactionsPriceTx; // 单笔最低交易额的交易
	private float maxTransactionsPrice; // 单笔最高交易额
	private String maxTransactionsPriceStr; // 单笔最高交易额
	private String maxTransactionsPriceHash; // 单笔最高交易额的交易HASH
	private TransactionInfo maxTransactionsPriceTx; // 单笔最高交易额的交易
	
	public String getPoundageSumStr() {
		return poundageSumStr;
	}
	public void setPoundageSumStr(String poundageSumStr) {
		this.poundageSumStr = poundageSumStr;
	}
	public String getMinPoundageStr() {
		return minPoundageStr;
	}
	public void setMinPoundageStr(String minPoundageStr) {
		this.minPoundageStr = minPoundageStr;
	}
	public String getMaxPoundageStr() {
		return maxPoundageStr;
	}
	public void setMaxPoundageStr(String maxPoundageStr) {
		this.maxPoundageStr = maxPoundageStr;
	}
	public String getMinTransactionsPriceStr() {
		return minTransactionsPriceStr;
	}
	public void setMinTransactionsPriceStr(String minTransactionsPriceStr) {
		this.minTransactionsPriceStr = minTransactionsPriceStr;
	}
	public String getMaxTransactionsPriceStr() {
		return maxTransactionsPriceStr;
	}
	public void setMaxTransactionsPriceStr(String maxTransactionsPriceStr) {
		this.maxTransactionsPriceStr = maxTransactionsPriceStr;
	}
	public String getMinPoundageTxhash() {
		return minPoundageTxhash;
	}
	public void setMinPoundageTxhash(String minPoundageTxhash) {
		this.minPoundageTxhash = minPoundageTxhash;
	}
	public String getMaxPoundageTxhash() {
		return maxPoundageTxhash;
	}
	public void setMaxPoundageTxhash(String maxPoundageTxhash) {
		this.maxPoundageTxhash = maxPoundageTxhash;
	}
	public String getMinTransactionsPriceHash() {
		return minTransactionsPriceHash;
	}
	public void setMinTransactionsPriceHash(String minTransactionsPriceHash) {
		this.minTransactionsPriceHash = minTransactionsPriceHash;
	}
	public String getMaxTransactionsPriceHash() {
		return maxTransactionsPriceHash;
	}
	public void setMaxTransactionsPriceHash(String maxTransactionsPriceHash) {
		this.maxTransactionsPriceHash = maxTransactionsPriceHash;
	}
	public long getTransactionsSum() {
		return transactionsSum;
	}
	public void setTransactionsSum(long transactionsSum) {
		this.transactionsSum = transactionsSum;
	}
	public double getTransactionsPriceSum() {
		return transactionsPriceSum;
	}
	public void setTransactionsPriceSum(double transactionsPriceSum) {
		this.transactionsPriceSum = transactionsPriceSum;
	}
	public double getGasSum() {
		return gasSum;
	}
	public void setGasSum(double gasSum) {
		this.gasSum = gasSum;
	}
	public double getPoundageSum() {
		return poundageSum;
	}
	public void setPoundageSum(double poundageSum) {
		this.poundageSum = poundageSum;
	}
	public float getMinPoundage() {
		return minPoundage;
	}
	public void setMinPoundage(float minPoundage) {
		this.minPoundage = minPoundage;
	}
	public TransactionInfo getMinPoundageTx() {
		return minPoundageTx;
	}
	public void setMinPoundageTx(TransactionInfo minPoundageTx) {
		this.minPoundageTx = minPoundageTx;
	}
	public float getMaxPoundage() {
		return maxPoundage;
	}
	public void setMaxPoundage(float maxPoundage) {
		this.maxPoundage = maxPoundage;
	}
	public TransactionInfo getMaxPoundageTx() {
		return maxPoundageTx;
	}
	public void setMaxPoundageTx(TransactionInfo maxPoundageTx) {
		this.maxPoundageTx = maxPoundageTx;
	}
	public float getMinTransactionsPrice() {
		return minTransactionsPrice;
	}
	public void setMinTransactionsPrice(float minTransactionsPrice) {
		this.minTransactionsPrice = minTransactionsPrice;
	}
	public TransactionInfo getMinTransactionsPriceTx() {
		return minTransactionsPriceTx;
	}
	public void setMinTransactionsPriceTx(TransactionInfo minTransactionsPriceTx) {
		this.minTransactionsPriceTx = minTransactionsPriceTx;
	}
	public float getMaxTransactionsPrice() {
		return maxTransactionsPrice;
	}
	public void setMaxTransactionsPrice(float maxTransactionsPrice) {
		this.maxTransactionsPrice = maxTransactionsPrice;
	}
	public TransactionInfo getMaxTransactionsPriceTx() {
		return maxTransactionsPriceTx;
	}
	public void setMaxTransactionsPriceTx(TransactionInfo maxTransactionsPriceTx) {
		this.maxTransactionsPriceTx = maxTransactionsPriceTx;
	}
	
}
