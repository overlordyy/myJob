package com.vns.vo;

import java.util.Date;

import com.vns.query.QueryObject;

/**
 * Token的用户，用以统计Token有多少用户使用
 * @author Lvp
 *
 */
public class TokenUser extends QueryObject{
	private long id;
	private String contractAddress; // 合约地址
	private String userAddress; // 用户地址
	private int userNum; // Token用户数量
	private double tokenBalance; // Token 持有量
	private Date createTime;
	private Date updateTime;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getContractAddress() {
		return contractAddress;
	}
	public void setContractAddress(String contractAddress) {
		this.contractAddress = contractAddress;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	public double getTokenBalance() {
		return tokenBalance;
	}
	public void setTokenBalance(double tokenBalance) {
		this.tokenBalance = tokenBalance;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
}
