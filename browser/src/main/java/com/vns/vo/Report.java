package com.vns.vo;

/**
 * 报表类
 * 只提供前端图表需要的参数
 * @author Lvp
 *
 */
public class Report {

	/**
	 * 值，Y轴
	 */
	private double y;
	/**
	 * 日期，X轴
	 */
	private String dt;
	
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public String getDt() {
		return dt;
	}
	public void setDt(String dt) {
		this.dt = dt;
	}
}
