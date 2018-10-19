package com.vns.query;

public class QueryObject {
    private Integer currentPage = 0;
    private Integer pageSize = 10;

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

}
