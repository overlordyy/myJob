package com.vns.vo;

/**
 * 首页区块概览
 * @author Lvp
 *
 */
public class HomeBlock extends BaseDomain {

	private long lastBlockHeight; // 最新区块高度
	private long blockSum; // 区块总数
	private long normalBlockSum; // 正常块总数
	private long uncleBlockSum; // 叔块总数
	private float unclePercent; // 步块率=叔块总数/区块总数
	private float transactionsAvg; // 平均交易数=交易总数/正常块总数
	
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
	
}
