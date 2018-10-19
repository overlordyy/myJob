package com.vns.vo;

/**
 * 首页交易概览
 * @author Lvp
 *
 */
public class HomeTransactions extends BaseDomain {

	private long transactionsSum; // 累计交易次数
	private double transactionsPriceSum; // 累计交易额
	private double gasSum; // 累计Gas
	private double poundageSum; // 累计手续费
	private float minPoundage; // 单笔最低手续费
	private TransactionInfo minPoundageTx; // 单笔最低手续费的交易
	private float maxPoundage; // 单笔最高手续费
	private TransactionInfo maxPoundageTx; // 单笔最高手续费的交易
	private float minTransactionsPrice; // 单笔最低交易额
	private TransactionInfo minTransactionsPriceTx; // 单笔最低交易额的交易
	private float maxTransactionsPrice; // 单笔最高交易额
	private TransactionInfo maxTransactionsPriceTx; // 单笔最高交易额的交易
	
	
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
