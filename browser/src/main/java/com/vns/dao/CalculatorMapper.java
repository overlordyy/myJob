package com.vns.dao;

import java.util.List;

import com.vns.vo.Calculator;

/**
 * 计算器参数Mapper
 * @author Lvp
 *
 */
public interface CalculatorMapper {

	/**
	 * 获取参数
	 * @return
	 */
	public List<Calculator> getCalculatorParam(Calculator cl);
	
	/**
	 * 获取报表（算力、难度）数据
	 * @param cl:传时间，取某一周期内的
	 * @return
	 */
	public List<Calculator> getReportByTime(Calculator cl);
	
	/**
	 * 获取报表（算力、难度）数据-全部数据
	 * @return
	 */
	public List<Calculator> getReportAllData();
	
	/**
	 * 统计数据（出块数<含叔块>、难度<平均>、昨日手续费总量，昨日区块奖励总量，昨日叔块奖励总量，昨日区块引用次数总量）
	 * @param cl 昨天的时间
	 */
	public Calculator statCalculateParam(Calculator cl);
	
	/**
	 * 判断是否有记录在库里
	 * @return
	 */
	public int isExist(Calculator cl);
	
	/**
	 * 插入
	 * @param cl
	 */
	public void insert(Calculator cl);
	
	/**
	 * 更新
	 * @param cl
	 */
	public void update(Calculator cl);
}
