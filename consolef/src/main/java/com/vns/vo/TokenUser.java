package com.vns.vo;

import com.vns.query.QueryObject;

/**
 * Token的用户，用以统计Token有多少用户使用
 * @author Lvp
 *
 */
public class TokenUser extends QueryObject{
	public int id;
	private String contractAddress; // 合约地址
	private String userAddress; // 用户地址
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	
}
