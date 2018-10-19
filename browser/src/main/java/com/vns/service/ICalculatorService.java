package com.vns.service;

import java.util.Date;
import java.util.List;

import com.vns.vo.Calculator;
import com.vns.vo.DataResult;

/**
 * 计算器Sercie
 * @author Lvp
 *
 */
public interface ICalculatorService {

	/**
	 * 获取 VNS平台数据
	 * @return 全网算力、网络难度、出块时长、币价
	 */
	public DataResult<Calculator> getVnsData();
	
	/**
	 * 统计前一天计算参数（全网算力、难度、昨日出币量），由定时任务每天1点统计更新
	 */
	public void statCalculateParam();
	
	/**
	 * 统计某段时间数据（全网算力、难度、昨日出币量）
	 * @param begin
	 * @param end
	 */
	public void statHistoryData(Date begin, Date end);
	
	/**
	 * 计算收益
	 * @return 返回日收益 和 回本时间
	 */
	public DataResult<Calculator> calculateMyReward(Calculator param);
	
	/**
	 * 获取报表（算力、难度）数据
	 * @param cl:传时间，取某一周期内的
	 * @return
	 */
	public List<Calculator> getReportByTime();
	
	/**
	 * 获取报表（算力、难度）数据-全部数据
	 * @return
	 */
	public List<Calculator> getReportAllData();
}
