package com.vns.vo;

public class Ticker {
//	{"ticker":{"vol":"2337712.14650000","high":"0.00129980","low":"0.00105010","last":"0.00112460","sell":"0.00120000","buy":"0.00111000"},"date":1537197035}
	private String vol;
	private String high;
	private String low;
	private String last;
	private String sell;
	private String buy;
	private String ethLast;
	
	public String getEthLast() {
		return ethLast;
	}
	public void setEthLast(String ethLast) {
		this.ethLast = ethLast;
	}
	public String getVol() {
		return vol;
	}
	public void setVol(String vol) {
		this.vol = vol;
	}
	public String getHigh() {
		return high;
	}
	public void setHigh(String high) {
		this.high = high;
	}
	public String getLow() {
		return low;
	}
	public void setLow(String low) {
		this.low = low;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public String getSell() {
		return sell;
	}
	public void setSell(String sell) {
		this.sell = sell;
	}
	public String getBuy() {
		return buy;
	}
	public void setBuy(String buy) {
		this.buy = buy;
	}
	
}
