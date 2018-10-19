package com.vns.vo;

import java.util.Date;

import com.vns.query.QueryObject;

/**
 * 报表-币价
 * @author Lvp
 *
 */
public class ReportPrice extends QueryObject {

	private long id;
	private double ethPrice; // 以太币币价
	private double dollerPrice; // 美元币价
	private double rmbPrice; // 人民币币价
	private Date createDate;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
