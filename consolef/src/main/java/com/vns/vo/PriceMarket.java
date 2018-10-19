package com.vns.vo;

import java.util.Date;

import com.vns.query.QueryObject;

/**
 * 币价行情
 * @author Lvp
 *
 */
public class PriceMarket extends QueryObject{
	public int id;
	public double ethPrice; // 以太币汇率
	public double dollerPrice; // 美元汇率
	public double rmbPrice; // 人民币汇率
	public Date createTime;
	private Ticker ticker;
	private String fBuyPri;
	private long date;
	
	public long getDate() {
		return date;
	}
	public void setDate(long date) {
		this.date = date;
	}
	public String getfBuyPri() {
		return fBuyPri;
	}
	public void setfBuyPri(String fBuyPri) {
		this.fBuyPri = fBuyPri;
	}
	public Ticker getTicker() {
		return ticker;
	}
	public void setTicker(Ticker ticker) {
		this.ticker = ticker;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getEthPrice() {
		return ethPrice;
	}
	public void setEthPrice(double ethPrice) {
		this.ethPrice = ethPrice;
	}
	public double getDollerPrice() {
		return dollerPrice;
	}
	public void setDollerPrice(double dollerPrice) {
		this.dollerPrice = dollerPrice;
	}
	public double getRmbPrice() {
		return rmbPrice;
	}
	public void setRmbPrice(double rmbPrice) {
		this.rmbPrice = rmbPrice;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
