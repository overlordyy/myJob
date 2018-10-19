package com.vns.vo;

import java.util.Date;

import com.vns.query.QueryObject;

/**
 * Token信息
 * @author Lvp
 *
 */
public class TokenInfo extends QueryObject{
	private long id;
	private String contractAddress; // 合约地址
    private String tokenEnName; // 英文名
    private String tokenCnName; // 中文名
    private String tokenName;   // 简称
    private String tokenTotal;  // token总量
    private String tokenReceivetAddress;    // token接收地址
    private String tokenPrecision;  // token精度
    private String tokenPublisher;  // token登记人（发行方）
    private String tokenPublicKey;  // 公钥
    private String tokenPrivateKey; // 私钥
    private String tokenType;   // token类型
    private Date publishTime;   // 登记（发行）时间
    private Date validityTime;  // 有效期
    private int tokenStatus; // 状态 （待审核/审核通过/审核失败）
    private String airdropPercent; // 全网空投百分比
    private String logoUrl; // logo图片地址
    private String remark;  // 备注
    private int tokenExaminedStatus;//审核时token的状态
    private String tokenExaminedContent;//审核时审核意见
    private int tokenExamined;
    private long tokenBalance;
    private long tokenDecimals;
    
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
	public long getTokenBalance() {
		return tokenBalance;
	}
	public void setTokenBalance(long tokenBalance) {
		this.tokenBalance = tokenBalance;
	}
	public long getTokenDecimals() {
		return tokenDecimals;
	}
	public void setTokenDecimals(long tokenDecimals) {
		this.tokenDecimals = tokenDecimals;
	}
	public int getTokenExamined() {
		return tokenExamined;
	}
	public void setTokenExamined(int tokenExamined) {
		this.tokenExamined = tokenExamined;
	}
	public int getTokenExaminedStatus() {
		return tokenExaminedStatus;
	}
	public void setTokenExaminedStatus(int tokenExaminedStatus) {
		this.tokenExaminedStatus = tokenExaminedStatus;
	}
	public String getTokenExaminedContent() {
		return tokenExaminedContent;
	}
	public void setTokenExaminedContent(String tokenExaminedContent) {
		this.tokenExaminedContent = tokenExaminedContent;
	}
	public String getTokenEnName() {
		return tokenEnName;
	}
	public void setTokenEnName(String tokenEnName) {
		this.tokenEnName = tokenEnName;
	}
	public String getTokenCnName() {
		return tokenCnName;
	}
	public void setTokenCnName(String tokenCnName) {
		this.tokenCnName = tokenCnName;
	}
	public String getTokenName() {
		return tokenName;
	}
	public void setTokenName(String tokenName) {
		this.tokenName = tokenName;
	}
	public String getTokenTotal() {
		return tokenTotal;
	}
	public void setTokenTotal(String tokenTotal) {
		this.tokenTotal = tokenTotal;
	}
	public String getTokenReceivetAddress() {
		return tokenReceivetAddress;
	}
	public void setTokenReceivetAddress(String tokenReceivetAddress) {
		this.tokenReceivetAddress = tokenReceivetAddress;
	}
	public String getTokenPrecision() {
		return tokenPrecision;
	}
	public void setTokenPrecision(String tokenPrecision) {
		this.tokenPrecision = tokenPrecision;
	}
	public String getTokenPublisher() {
		return tokenPublisher;
	}
	public void setTokenPublisher(String tokenPublisher) {
		this.tokenPublisher = tokenPublisher;
	}
	public String getTokenPublicKey() {
		return tokenPublicKey;
	}
	public void setTokenPublicKey(String tokenPublicKey) {
		this.tokenPublicKey = tokenPublicKey;
	}
	public String getTokenPrivateKey() {
		return tokenPrivateKey;
	}
	public void setTokenPrivateKey(String tokenPrivateKey) {
		this.tokenPrivateKey = tokenPrivateKey;
	}
	public String getTokenType() {
		return tokenType;
	}
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}
	public Date getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	public Date getValidityTime() {
		return validityTime;
	}
	public void setValidityTime(Date validityTime) {
		this.validityTime = validityTime;
	}
	public int getTokenStatus() {
		return tokenStatus;
	}
	public void setTokenStatus(int tokenStatus) {
		this.tokenStatus = tokenStatus;
	}
	public String getAirdropPercent() {
		return airdropPercent;
	}
	public void setAirdropPercent(String airdropPercent) {
		this.airdropPercent = airdropPercent;
	}
	public String getLogoUrl() {
		return logoUrl;
	}
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
