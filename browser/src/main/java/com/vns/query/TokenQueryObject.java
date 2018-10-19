package com.vns.query;

import org.springframework.util.StringUtils;

/**
 * Created by Administrator on 2018/7/11.
 */
public class TokenQueryObject extends QueryObject {
    private String tokenPublisher;


    public String getTokenPublisher() {
        return StringUtils.hasLength(tokenPublisher) ? tokenPublisher : null;
    }
	public void setTokenPublisher(String tokenPublisher) {
		this.tokenPublisher = tokenPublisher;
	}
    
}
