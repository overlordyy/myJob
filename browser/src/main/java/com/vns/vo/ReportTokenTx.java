package com.vns.vo;

import java.util.Date;

import com.vns.query.QueryObject;

/**
 * 报表-Token交易
 * @author Lvp
 *
 */
public class ReportTokenTx extends QueryObject {

	private long id;
	private double toeknTxTotal; // Token交易总量
	private int tokenTxNum; // Token交易笔数
	private double tokenTxPoundage; // Token交易手续费总量
	private Date createDate; // 统计日期
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getToeknTxTotal() {
		return toeknTxTotal;
	}
	public void setToeknTxTotal(double toeknTxTotal) {
		this.toeknTxTotal = toeknTxTotal;
	}
	public int getTokenTxNum() {
		return tokenTxNum;
	}
	public void setTokenTxNum(int tokenTxNum) {
		this.tokenTxNum = tokenTxNum;
	}
	public double getTokenTxPoundage() {
		return tokenTxPoundage;
	}
	public void setTokenTxPoundage(double tokenTxPoundage) {
		this.tokenTxPoundage = tokenTxPoundage;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
}
