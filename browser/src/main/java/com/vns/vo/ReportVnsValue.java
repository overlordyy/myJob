package com.vns.vo;

import java.util.Date;

import com.vns.query.QueryObject;

/**
 * 报表-市值
 * @author Lvp
 *
 */
public class ReportVnsValue extends QueryObject {

	private long id;
	private double ethValue;
	private double dollerValue;
	private double rmbValue;
	private Date createDate;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getEthValue() {
		return ethValue;
	}
	public void setEthValue(double ethValue) {
		this.ethValue = ethValue;
	}
	public double getDollerValue() {
		return dollerValue;
	}
	public void setDollerValue(double dollerValue) {
		this.dollerValue = dollerValue;
	}
	public double getRmbValue() {
		return rmbValue;
	}
	public void setRmbValue(double rmbValue) {
		this.rmbValue = rmbValue;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
