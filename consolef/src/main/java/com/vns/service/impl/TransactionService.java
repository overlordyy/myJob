package com.vns.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.abi.FunctionReturnDecoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.Utils;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;

import com.vns.dao.TransactionMapper;
import com.vns.service.ITransactionService;
import com.vns.vo.DataResult;
import com.vns.vo.TableSplitResult;
import com.vns.vo.TransactionInfo;

@Service
public class TransactionService implements ITransactionService{

	@Autowired
	public TransactionMapper tm;
	/**
	 * 查询所有交易
	 */
	@Override
	public TableSplitResult<TransactionInfo> findTransactionList(TransactionInfo ti) {
		TableSplitResult<TransactionInfo> result = new TableSplitResult<TransactionInfo>();
		int count = tm.findTransactionListCount(ti);
		if(count != 0){
			result.setRows(tm.findTransactionList(ti));
			result.setTotal(count);
		}
		return result;
	}
	
	/**
	 * 根据区块查询交易
	 */
	@Override
	public TableSplitResult<TransactionInfo> findTransactionInfoByBlock(String blockId) {
		TableSplitResult<TransactionInfo> result = new TableSplitResult<TransactionInfo>();
		TransactionInfo ti = new TransactionInfo();
		ti.setBlockHash(blockId);
		int count = tm.findTransactionListCount(ti);
		if(count != 0){
			result.setRows(tm.findTransactionList(ti));
			result.setTotal(count);
		}
		return result;
	}

	@Override
	public void addTransaction(TransactionInfo ti) {
		tm.addTransaction(ti);
	}

	@Override
	public DataResult<TransactionInfo> transactionDivInfo() {
		DataResult<TransactionInfo> dr = new DataResult<TransactionInfo>();
		//查询最新区块数据
		dr.setData(tm.transactionDivInfo());
		return dr;
	}

	@Override
	public List<TransactionInfo> findAllTransaction() {
		List<TransactionInfo> tiList = new ArrayList<TransactionInfo>();
		tiList = tm.findAllTransaction(0);
		return tiList;
	}

	@Override
	public void updateTransactionToAddressByInput() {
		List<TransactionInfo> tiList = new ArrayList<TransactionInfo>();
		tiList = tm.updateTransactionToAddressByInput();
		//循环解析Input，并把交易里面的ToAddress修改
		for (TransactionInfo ti : tiList) {
			//解析input
			List<Type> t = decodeFunctionInput(ti.getInput());
			if(t!=null){
				ti.setToAddress(t.get(0).toString());
				tm.updateTransactionToAddress(ti);
			}
		}
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