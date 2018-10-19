package com.vns.query;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vns.util.DateUtil;

public class QueryObject {
    private Integer currentPage=0;
    private Integer pageSize=20;
    private String search;
    
    @JsonFormat(pattern="yyyy-MM-dd HH-mm-ss",timezone="GTM+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date beginDate;
    @JsonFormat(pattern="yyyy-MM-dd HH-mm-ss",timezone="GTM+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date endDate;

    public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public Date getBeginDate() {
        return beginDate != null ? DateUtil.getBeginDate(beginDate) : null;
    }
    public Date getEndDate() {
        return endDate != null ? DateUtil.getEndDate(endDate) : null;
    }
    
    public Integer getBeginIndex() {
        return currentPage;
    }

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
