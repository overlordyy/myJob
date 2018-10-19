package com.vns.vo;

import java.util.Date;

import com.vns.query.QueryObject;

/**
 * 报表-用户
 * @author Lvp
 *
 */
public class ReportUser extends QueryObject {

	private long id;
	private int userTotal; // 用户总数
	private int tokenUserTotal; // token用户总数
	private int newUserNum; // 新增用户数
	private int newTokenUserNum; // 新增Token用户数
	private Date createDate;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getUserTotal() {
		return userTotal;
	}
	public void setUserTotal(int userTotal) {
		this.userTotal = userTotal;
	}
	public int getTokenUserTotal() {
		return tokenUserTotal;
	}
	public void setTokenUserTotal(int tokenUserTotal) {
		this.tokenUserTotal = tokenUserTotal;
	}
	public int getNewUserNum() {
		return newUserNum;
	}
	public void setNewUserNum(int newUserNum) {
		this.newUserNum = newUserNum;
	}
	public int getNewTokenUserNum() {
		return newTokenUserNum;
	}
	public void setNewTokenUserNum(int newTokenUserNum) {
		this.newTokenUserNum = newTokenUserNum;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
