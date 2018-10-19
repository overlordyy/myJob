package com.vns.vo;

import java.util.Date;
import com.vns.query.QueryObject;

/**
 * 交易信息
 * @author Lvp
 *
 */
public class TransactionInfo extends QueryObject{
	public int id;
	private String hash; // 交易唯一标识，哈希
	private String blockHash; // 区块哈希
	private long blockNumber; // 区块高度
	private String creates; // 
	private String fromAddress; // 发送人（地址
	private String toAddress; // 接收人（地址
	private String txValue; // 交易额
	private float gas; // 
	private float gasPrice; // 
	private String input; // 此字段区分Token
	private String nonce; // 
	private String publicKey; // 
	private String raw; // 
	private String r; // 
	private String s; // 
	private int v; // 
	private String transactionIndex; // 
	private String contractAddress; // 合约地址，如果是Token，此字段有值
	private int transactionType; // 交易类型：0普通交易，1Token交易
	private Date transactionTime;
	private double transactionPoundage;//交易手续费
	private float gasUsed;
	private String status;
	
	public float getGasUsed() {
		return gasUsed;
	}
	public void setGasUsed(float gasUsed) {
		this.gasUsed = gasUsed;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getTransactionTime() {
		return transactionTime;
	}
	public void setTransactionTime(Date transactionTime) {
		this.transactionTime = transactionTime;
	}
	public double getTransactionPoundage() {
		return transactionPoundage;
	}
	public void setTransactionPoundage(double transactionPoundage) {
		this.transactionPoundage = transactionPoundage;
	}
	public float getGas() {
		return gas;
	}
	public void setGas(float gas) {
		this.gas = gas;
	}
	public float getGasPrice() {
		return gasPrice;
	}
	public void setGasPrice(float gasPrice) {
		this.gasPrice = gasPrice;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
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
	public String getCreates() {
		return creates;
	}
	public void setCreates(String creates) {
		this.creates = creates;
	}
	public String getFromAddress() {
		return fromAddress;
	}
	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}
	public String getToAddress() {
		return toAddress;
	}
	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}
	public String getTxValue() {
		return txValue;
	}
	public void setTxValue(String txValue) {
		this.txValue = txValue;
	}
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	public String getNonce() {
		return nonce;
	}
	public void setNonce(String nonce) {
		this.nonce = nonce;
	}
	public String getPublicKey() {
		return publicKey;
	}
	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}
	public String getRaw() {
		return raw;
	}
	public void setRaw(String raw) {
		this.raw = raw;
	}
	public String getR() {
		return r;
	}
	public void setR(String r) {
		this.r = r;
	}
	public String getS() {
		return s;
	}
	public void setS(String s) {
		this.s = s;
	}
	public int getV() {
		return v;
	}
	public void setV(int v) {
		this.v = v;
	}
	public String getTransactionIndex() {
		return transactionIndex;
	}
	public void setTransactionIndex(String transactionIndex) {
		this.transactionIndex = transactionIndex;
	}
	public String getContractAddress() {
		return contractAddress;
	}
	public void setContractAddress(String contractAddress) {
		this.contractAddress = contractAddress;
	}
	public int getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(int transactionType) {
		this.transactionType = transactionType;
	}
}
