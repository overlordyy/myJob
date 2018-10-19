package com.vns.vo;

/**
 * 首页总概览
 * @author Lvp
 *
 */
public class HomeInfo extends BaseDomain {

	private long statBlockHeight; // 出币总量统计截止到哪个区块的区块高度
	private double vnsCoinSum; // 出币总量
	private String difficulty; // 全网计算难度，实际取的最新区块的难度
	private String hashRate; // 全网算力
	private double ethPriceSum; // 币价总量=出币总量*当前价格(以太币
	private double dollerPriceSum; // 币价总量=出币总量*当前价格(美元
	private double rmbPriceSum; // 币价总量=出币总量*当前价格(人民币
	
	public long getStatBlockHeight() {
		return statBlockHeight;
	}
	public void setStatBlockHeight(long statBlockHeight) {
		this.statBlockHeight = statBlockHeight;
	}
	public double getVnsCoinSum() {
		return vnsCoinSum;
	}
	public void setVnsCoinSum(double vnsCoinSum) {
		this.vnsCoinSum = vnsCoinSum;
	}
	public String getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	public String getHashRate() {
		return hashRate;
	}
	public void setHashRate(String hashRate) {
		this.hashRate = hashRate;
	}
	public double getEthPriceSum() {
		return ethPriceSum;
	}
	public void setEthPriceSum(double ethPriceSum) {
		this.ethPriceSum = ethPriceSum;
	}
	public double getDollerPriceSum() {
		return dollerPriceSum;
	}
	public void setDollerPriceSum(double dollerPriceSum) {
		this.dollerPriceSum = dollerPriceSum;
	}
	public double getRmbPriceSum() {
		return rmbPriceSum;
	}
	public void setRmbPriceSum(double rmbPriceSum) {
		this.rmbPriceSum = rmbPriceSum;
	}
	
}