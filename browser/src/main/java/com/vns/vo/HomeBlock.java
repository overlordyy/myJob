package com.vns.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 首页区块概览
 * @author Lvp
 *
 */
public class HomeBlock extends BaseDomain implements Serializable{

	private long lastBlockHeight; // 最新区块高度
	private long blockSum; // 区块总数
	private long normalBlockSum; // 正常块总数
	private long uncleBlockSum; // 叔块总数
	private long transactionSum;//交易总数
	private float unclePercent; // 步块率=叔块总数/区块总数
	private float transactionsAvg; // 平均交易数=交易总数/正常块总数
	private String zBlockHash;//创世区块hash
	private Date zBlockTime;//创世区块生成时间
	private int blockProduceTime;//相差描述
	private String difficulty;//最新区块难度
	private double hashRate; // 全网算力
	
	public int getBlockProduceTime() {
		return blockProduceTime;
	}
	public void setBlockProduceTime(int blockProduceTime) {
		this.blockProduceTime = blockProduceTime;
	}
	public String getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	public long getTransactionSum() {
		return transactionSum;
	}
	public void setTransactionSum(long transactionSum) {
		this.transactionSum = transactionSum;
	}
	public String getzBlockHash() {
		return zBlockHash;
	}
	public void setzBlockHash(String zBlockHash) {
		this.zBlockHash = zBlockHash;
	}
	public Date getzBlockTime() {
		return zBlockTime;
	}
	public void setzBlockTime(Date zBlockTime) {
		this.zBlockTime = zBlockTime;
	}
	public long getLastBlockHeight() {
		return lastBlockHeight;
	}
	public void setLastBlockHeight(long lastBlockHeight) {
		this.lastBlockHeight = lastBlockHeight;
	}
	public long getBlockSum() {
		return blockSum;
	}
	public void setBlockSum(long blockSum) {
		this.blockSum = blockSum;
	}
	public long getNormalBlockSum() {
		return normalBlockSum;
	}
	public void setNormalBlockSum(long normalBlockSum) {
		this.normalBlockSum = normalBlockSum;
	}
	public long getUncleBlockSum() {
		return uncleBlockSum;
	}
	public void setUncleBlockSum(long uncleBlockSum) {
		this.uncleBlockSum = uncleBlockSum;
	}
	public float getUnclePercent() {
		return unclePercent;
	}
	public void setUnclePercent(float unclePercent) {
		this.unclePercent = unclePercent;
	}
	public float getTransactionsAvg() {
		return transactionsAvg;
	}
	public void setTransactionsAvg(float transactionsAvg) {
		this.transactionsAvg = transactionsAvg;
	}
	public double getHashRate() {
		return hashRate;
	}
	public void setHashRate(double hashRate) {
		this.hashRate = hashRate;
	}
	
}
