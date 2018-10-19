package com.vns.service.impl;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.vns.VnsWeb3j;

public class Web3Service {

	private static HttpService vnsHttpService;
	private static HttpService ethHttpService;
	private static VnsWeb3j vnsWeb3j;
	private static Web3j ethWeb3j;
	
	public static HttpService getVnsHttpService(){
		if(vnsHttpService==null){
			vnsHttpService = new HttpService("http://132.232.166.46:8585/");
		}
		return vnsHttpService;
	}
	
	public static VnsWeb3j getVnsWeb3j(){
		if(vnsWeb3j == null){
			vnsWeb3j = VnsWeb3j.build(getVnsHttpService());
		}
		return vnsWeb3j;
	}
}
