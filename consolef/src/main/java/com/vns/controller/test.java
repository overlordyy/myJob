package com.vns.controller;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.web3j.abi.FunctionReturnDecoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.Utils;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.Request;
import org.web3j.protocol.core.methods.response.EthBlock;
import org.web3j.protocol.core.methods.response.EthBlock.Block;
import org.web3j.protocol.core.methods.response.EthBlock.TransactionObject;
import org.web3j.protocol.core.methods.response.EthBlock.TransactionResult;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.vns.VnsWeb3j;

import rx.Subscription;

import com.vns.service.impl.Web3Service;
import com.vns.vo.BlockInfo;
import com.vns.vo.TransactionInfo;

public class test {

	public static Subscription subscription;
	public static void main(String[] args) {
		VnsWeb3j vnsWeb3j = Web3Service.getVnsWeb3j();
		Request<?,EthBlock> block = vnsWeb3j.ethGetBlockByHash("0x62939329bdb21759eaa0b8e50213a87817afc0302cc37e536cab18b4597abff6", false);
		String inpt = "0x";
		if(!inpt.equals(inpt)){
			System.out.println(1);
		}
//		VnsWeb3j vnsWeb3j = VnsWeb3j.build(new HttpService("http://132.232.166.46:8585/"));
//		try {
//			EthGetBalance ethGetBalance = vnsWeb3j.ethGetBalance("0x1C4749A6e7082aac17083029c9eb2DCe4045d912", DefaultBlockParameter.valueOf("latest")).send();
//			String balance = ethGetBalance.getBalance().toString();
//			EthBlockNumber bn = vnsWeb3j.ethBlockNumber().send();
//			if(subscription==null){
//				subscription = 
//					vnsWeb3j.catchUpToLatestAndSubscribeToNewBlocksObservable(DefaultBlockParameter.valueOf(BigInteger.valueOf(20000)), false)
//					.subscribe(block -> {
//					Date date = new Date();
//					Block bl = block.getBlock();
//					BlockInfo bi = new BlockInfo();
////					bi.setBlockID(bl.getHash());
////					bi.setBlockNumber(bl.getNumber().longValue());
////					bi.setBlockMiner(bl.getMiner());
////			        Long timestamp = bl.getTimestamp().longValue() * 1000;
////					bi.setBlockTime(new Date(timestamp));
////					bi.setBlockVolume(bl.getSize().longValue());
//					//通过区块去查询交易
//					EthBlock eblock=null;
//					DefaultBlockParameter param = DefaultBlockParameter.valueOf(BigInteger.valueOf(bl.getNumber().longValue()));
//					try {
//						eblock = vnsWeb3j.ethGetBlockByNumber(param,true).send();
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//					List<TransactionResult> transactions = eblock.getBlock().getTransactions();
//					for (TransactionResult tr : transactions) {
//						TransactionInfo ti = new TransactionInfo();
//						TransactionObject to = (TransactionObject) tr.get();
//						ti.setTransactionID(to.getHash());
//						ti.setBlockId(to.getBlockHash());
//						ti.setBlockNumber(to.getBlockNumber().longValue());
//						ti.setAmount(String.valueOf(to.getValue().longValue()));
//						ti.setPayer(to.getFrom());
//						ti.setReceiver(to.getTo());
//						List<Type> s = decodeFunctionInput(to.getInput());
//						System.out.println();
////						its.addTransaction(ti);
//					}
////					bi.setTxAmount(transactions.size());
////					bm.insertBlock(bi);
//				});
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
	public static List<Type> decodeFunctionInput(String input) {
        List<Type> results = null;
        if (input.length() < 128) {
            return results;
        }
        results = FunctionReturnDecoder.decode(input.substring(input.length() - 128), Utils.convert(Arrays.asList(new TypeReference<Address>() {
        }, new TypeReference<Uint256>() {
        })));
        return results;
    }

}
