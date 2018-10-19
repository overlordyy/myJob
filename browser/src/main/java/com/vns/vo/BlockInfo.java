package com.vns.vo;

import java.util.Date;

import com.vns.query.QueryObject;

/**
 * 区块信息
 * @author Lvp
 *
 */
public class BlockInfo extends QueryObject{
	private long id;
	private String blockHash;//区块hash
	private long blockNumber;//区块高度
	private String parentHash;//父hash
	private Date blockTime;//区块生成时间
	private String blockTimeStr;//块龄
	private String miner;//开矿矿工地址
	private long blockSize;//区块大小
	private String difficulty;//当前区块难度
	private String totalDifficulty;//链总难度
	private Integer transactionsNum;//交易数
	private Integer uncleNum;//叔块数
	private String gasLimit;
	private String gasUsed;
	private String extraData;
	private String logsBloom;
	private String mixHash;
	private long nonce;
	private String nonceStr;
	private String receiptsRoot;
	private String sealFields;
	private String sha3Uncles;
	private String stateRoot;
	private String transactionsRoot;
	private String author;
	private int isUncle;//此块是否为叔块
	private long refUncleBlockHeight;//包含此叔块的区块高度
	private float blockPoundage;//区块包含交易的总手续费
	private String blockPoundageStr;//区块包含交易的总手续费
	private float minerReward;//挖矿奖励
	private float refUncleReward;//叔块引用奖励
	private float uncleReward;//叔块奖励
	private float rewardSum;//区块奖励总和
	
	public String getBlockTimeStr() {
		return blockTimeStr;
	}
	public void setBlockTimeStr(String blockTimeStr) {
		this.blockTimeStr = blockTimeStr;
	}
	public String getNonceStr() {
		return nonceStr;
	}
	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}
	public String getBlockPoundageStr() {
		return blockPoundageStr;
	}
	public void setBlockPoundageStr(String blockPoundageStr) {
		this.blockPoundageStr = blockPoundageStr;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBlockHash() {
		return blockHash;
	}
	public void setBlockHash(String blockHash) {
		this.blockHash = blockHash;
	}
	public long getBlockNumber() {
		return blockNumber;
	}
	public void setBlockNumber(long blockNumber) {
		this.blockNumber = blockNumber;
	}
	public String getParentHash() {
		return parentHash;
	}
	public void setParentHash(String parentHash) {
		this.parentHash = parentHash;
	}
	public Date getBlockTime() {
		return blockTime;
	}
	public void setBlockTime(Date blockTime) {
		this.blockTime = blockTime;
	}
	public String getMiner() {
		return miner;
	}
	public void setMiner(String miner) {
		this.miner = miner;
	}
	public long getBlockSize() {
		return blockSize;
	}
	public void setBlockSize(long blockSize) {
		this.blockSize = blockSize;
	}
	public String getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	public String getTotalDifficulty() {
		return totalDifficulty;
	}
	public void setTotalDifficulty(String totalDifficulty) {
		this.totalDifficulty = totalDifficulty;
	}
	public Integer getTransactionsNum() {
		return transactionsNum;
	}
	public void setTransactionsNum(Integer transactionsNum) {
		this.transactionsNum = transactionsNum;
	}
	public Integer getUncleNum() {
		return uncleNum;
	}
	public void setUncleNum(Integer uncleNum) {
		this.uncleNum = uncleNum;
	}
	public String getGasLimit() {
		return gasLimit;
	}
	public void setGasLimit(String gasLimit) {
		this.gasLimit = gasLimit;
	}
	public String getGasUsed() {
		return gasUsed;
	}
	public void setGasUsed(String gasUsed) {
		this.gasUsed = gasUsed;
	}
	public String getExtraData() {
		return extraData;
	}
	public void setExtraData(String extraData) {
		this.extraData = extraData;
	}
	public String getLogsBloom() {
		return logsBloom;
	}
	public void setLogsBloom(String logsBloom) {
		this.logsBloom = logsBloom;
	}
	public String getMixHash() {
		return mixHash;
	}
	public void setMixHash(String mixHash) {
		this.mixHash = mixHash;
	}
	public long getNonce() {
		return nonce;
	}
	public void setNonce(long nonce) {
		this.nonce = nonce;
	}
	public String getReceiptsRoot() {
		return receiptsRoot;
	}
	public void setReceiptsRoot(String receiptsRoot) {
		this.receiptsRoot = receiptsRoot;
	}
	public String getSealFields() {
		return sealFields;
	}
	public void setSealFields(String sealFields) {
		this.sealFields = sealFields;
	}
	public String getSha3Uncles() {
		return sha3Uncles;
	}
	public void setSha3Uncles(String sha3Uncles) {
		this.sha3Uncles = sha3Uncles;
	}
	public String getStateRoot() {
		return stateRoot;
	}
	public void setStateRoot(String stateRoot) {
		this.stateRoot = stateRoot;
	}
	public String getTransactionsRoot() {
		return transactionsRoot;
	}
	public void setTransactionsRoot(String transactionsRoot) {
		this.transactionsRoot = transactionsRoot;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getIsUncle() {
		return isUncle;
	}
	public void setIsUncle(int isUncle) {
		this.isUncle = isUncle;
	}
	public long getRefUncleBlockHeight() {
		return refUncleBlockHeight;
	}
	public void setRefUncleBlockHeight(long refUncleBlockHeight) {
		this.refUncleBlockHeight = refUncleBlockHeight;
	}
	public float getBlockPoundage() {
		return blockPoundage;
	}
	public void setBlockPoundage(float blockPoundage) {
		this.blockPoundage = blockPoundage;
	}
	public float getMinerReward() {
		return minerReward;
	}
	public void setMinerReward(float minerReward) {
		this.minerReward = minerReward;
	}
	public float getRefUncleReward() {
		return refUncleReward;
	}
	public void setRefUncleReward(float refUncleReward) {
		this.refUncleReward = refUncleReward;
	}
	public float getUncleReward() {
		return uncleReward;
	}
	public void setUncleReward(float uncleReward) {
		this.uncleReward = uncleReward;
	}
	public float getRewardSum() {
		return rewardSum;
	}
	public void setRewardSum(float rewardSum) {
		this.rewardSum = rewardSum;
	}
	
}
