package com.vns.vo;

import java.util.Date;

import com.vns.query.QueryObject;

/**
 * 报表-交易
 * @author Lvp
 *
 */
public class ReportTransation extends QueryObject {

	private long id;
	private double transactionTotal; // 交易总量
	private int transactionNum; // 交易笔数
	private double transactionPoundage; // 交易手续费总量
	private Date createDate; // 统计日期
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getTransactionTotal() {
		return transactionTotal;
	}
	public void setTransactionTotal(double transactionTotal) {
		this.transactionTotal = transactionTotal;
	}
	public int getTransactionNum() {
		return transactionNum;
	}
	public void setTransactionNum(int transactionNum) {
		this.transactionNum = transactionNum;
	}
	public double getTransactionPoundage() {
		return transactionPoundage;
	}
	public void setTransactionPoundage(double transactionPoundage) {
		this.transactionPoundage = transactionPoundage;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
