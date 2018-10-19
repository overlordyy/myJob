package com.vns.query;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vns.util.DateUtil;

/**
 * Created by Administrator on 2018/7/11.
 */
public class TokenQueryObject extends QueryObject {
    private String tokenPublisher;

    @JsonFormat(pattern="yyyy-MM-dd HH-mm-ss",timezone="GTM+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date beginDate;
    @JsonFormat(pattern="yyyy-MM-dd HH-mm-ss",timezone="GTM+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    public Date getBeginDate() {
        return beginDate != null ? DateUtil.getEndDate(beginDate) : null;
    }
    public Date getEndDate() {
        return endDate != null ? DateUtil.getEndDate(endDate) : null;
    }

    public String getTokenPublisher() {
        return StringUtils.hasLength(tokenPublisher) ? tokenPublisher : null;
    }
	public void setTokenPublisher(String tokenPublisher) {
		this.tokenPublisher = tokenPublisher;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
    
}
