package com.vns.api;

import java.io.IOException;

import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthBlock;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.core.methods.response.EthCall;
import org.web3j.protocol.core.methods.response.EthEstimateGas;
import org.web3j.protocol.core.methods.response.EthGasPrice;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.core.methods.response.EthTransaction;

import com.vns.service.impl.Web3Service;

public class VnsRpcApi {

	public static String estimateGas(Transaction transacation) throws IOException{
		EthEstimateGas ethEstimateGas = Web3Service.getVnsWeb3j().ethEstimateGas(transacation).send();
		return ethEstimateGas.getAmountUsed().toString();
	}
	
	public static String getGasPrice() throws IOException{
		EthGasPrice ethGasPrice = Web3Service.getVnsWeb3j().ethGasPrice().send();
		return ethGasPrice.getGasPrice().toString();
	}
	
	public static String blockNumber() throws IOException{
		EthBlockNumber ethBlockNumber = Web3Service.getVnsWeb3j().ethBlockNumber().send();
		return ethBlockNumber.getBlockNumber().toString();
	}
	
	public static String getBalance(String address,DefaultBlockParameter defaultBLockParameter) throws IOException{
		EthGetBalance ethGetbalance = Web3Service.getVnsWeb3j().ethGetBalance(address, defaultBLockParameter).send();
		return ethGetbalance.getBalance().toString();
	}
	
	public static String getTransactionCOunt(String address,DefaultBlockParameter defaultBLockParameter) throws IOException{
		EthGetTransactionCount ethGetTransactionCount = Web3Service.getVnsWeb3j().ethGetTransactionCount(address, defaultBLockParameter).send();
		return ethGetTransactionCount.getTransactionCount().toString();
	}
	
	public static EthBlock.Block getBlockByNumber(DefaultBlockParameter defaultBLockParameter,boolean returnFullTransactionObjects) throws IOException{
		EthBlock ethBlock = Web3Service.getVnsWeb3j().ethGetBlockByNumber(defaultBLockParameter, returnFullTransactionObjects).send();
		return ethBlock.getBlock();
	}
	public static EthSendTransaction sendRawTransaction(String signedTransactionData)throws IOException{
		EthSendTransaction ethSendTransaction = Web3Service.getVnsWeb3j().ethSendRawTransaction(signedTransactionData).send();
		return ethSendTransaction;
	}
	public static String call(Transaction transaction,DefaultBlockParameter defaultBLockParameter) throws IOException{
		EthCall ethCall = Web3Service.getVnsWeb3j().ethCall(transaction, defaultBLockParameter).send();
		return ethCall.getValue();
	}
	public static org.web3j.protocol.core.methods.response.Transaction getTransactionByHash(String TransactionHash) throws IOException{
		EthTransaction ethTransaction = Web3Service.getVnsWeb3j().ethGetTransactionByHash(TransactionHash).send();
		if(ethTransaction.getTransaction().isPresent()){
			return ethTransaction.getTransaction().get();
		}
		return null;
	}
}
