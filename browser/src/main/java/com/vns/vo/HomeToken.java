package com.vns.vo;

import java.io.Serializable;

/**
 * 首页Token概览
 * @author Lvp
 *
 */
public class HomeToken extends BaseDomain implements Serializable{

	private int tokenSum; // Token总量
	private long tokenUserSum; // Token用户总数
	private long tokenTransferSum; // Token转账总数
	private double tokenGasSum; // Token累计消耗的Gas总量
	private String tokenGasSumStr; // Token累计消耗的Gas总量
	private double tokenPoundageSum; // Token累计手续费总量
	private String tokenPoundageSumStr; // Token累计手续费总量
	private String maxPoundageToken; // 最高手续费的Token地址
	private float maxPoundage; // 最高手续费 值
	private String maxPoundageStr;
	private String maxUsersToken; // 最多用户数的Token地址
	private int maxUsers; // 最多用户数 值
	
	public String getTokenGasSumStr() {
		return tokenGasSumStr;
	}
	public void setTokenGasSumStr(String tokenGasSumStr) {
		this.tokenGasSumStr = tokenGasSumStr;
	}
	public String getTokenPoundageSumStr() {
		return tokenPoundageSumStr;
	}
	public void setTokenPoundageSumStr(String tokenPoundageSumStr) {
		this.tokenPoundageSumStr = tokenPoundageSumStr;
	}
	public String getMaxPoundageStr() {
		return maxPoundageStr;
	}
	public void setMaxPoundageStr(String maxPoundageStr) {
		this.maxPoundageStr = maxPoundageStr;
	}
	public int getTokenSum() {
		return tokenSum;
	}
	public void setTokenSum(int tokenSum) {
		this.tokenSum = tokenSum;
	}
	public long getTokenUserSum() {
		return tokenUserSum;
	}
	public void setTokenUserSum(long tokenUserSum) {
		this.tokenUserSum = tokenUserSum;
	}
	public long getTokenTransferSum() {
		return tokenTransferSum;
	}
	public void setTokenTransferSum(long tokenTransferSum) {
		this.tokenTransferSum = tokenTransferSum;
	}
	public double getTokenGasSum() {
		return tokenGasSum;
	}
	public void setTokenGasSum(double tokenGasSum) {
		this.tokenGasSum = tokenGasSum;
	}
	public double getTokenPoundageSum() {
		return tokenPoundageSum;
	}
	public void setTokenPoundageSum(double tokenPoundageSum) {
		this.tokenPoundageSum = tokenPoundageSum;
	}
	public String getMaxPoundageToken() {
		return maxPoundageToken;
	}
	public void setMaxPoundageToken(String maxPoundageToken) {
		this.maxPoundageToken = maxPoundageToken;
	}
	public float getMaxPoundage() {
		return maxPoundage;
	}
	public void setMaxPoundage(float maxPoundage) {
		this.maxPoundage = maxPoundage;
	}
	public String getMaxUsersToken() {
		return maxUsersToken;
	}
	public void setMaxUsersToken(String maxUsersToken) {
		this.maxUsersToken = maxUsersToken;
	}
	public int getMaxUsers() {
		return maxUsers;
	}
	public void setMaxUsers(int maxUsers) {
		this.maxUsers = maxUsers;
	}
	
}
