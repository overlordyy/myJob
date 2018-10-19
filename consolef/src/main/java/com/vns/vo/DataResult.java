package com.vns.vo;

import java.util.List;

public class DataResult<T> {

	private int status;
	private T data;
	private String msg;
	private List<T> dataList;
	
	public DataResult(){
		
	}
	
	public DataResult(int status,T data,String msg,List<T> dataList){
		this.status = status;
		this.data = data;
		this.msg = msg;
		this.dataList = dataList;
	}
	
	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}

	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
