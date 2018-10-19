package com.vns.task;

import javax.annotation.Resource;

import com.vns.service.IBlockService;
import com.vns.service.IPriceMarketService;
import com.vns.service.ITokenService;
import com.vns.service.ITransactionService;

public class HomeTask {

	@Resource
	private IBlockService ihs;
	@Resource
	private ITransactionService its;
	@Resource
	private ITokenService itokens;
	@Resource
	private IPriceMarketService ips;
	public void show(){
		ihs.operationBlockInfo();
	}
	
	public void exchangeRate(){
		ips.exchangeRate();
	}
	
	public void homeTask(){
		ips.homeTask();
	}
	
	public void addRedisData(){
		ihs.findVnsNewInfo();
		ihs.findBlockInfo();
		its.transactionDivInfo();
		itokens.findHomeToken();
	}
	
//	public void homeTask(){
//		ips.homeTask();
//	}
}
