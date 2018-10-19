package com.vns.util;

import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.vns.VnsWeb3j;

public class Web3jUtil {

	public static VnsWeb3j getVwj() {
		return VnsWeb3j.build(new HttpService("http://132.232.166.46:8585/"));
	}
	
}
