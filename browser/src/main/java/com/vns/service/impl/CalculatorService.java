package com.vns.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vns.dao.CalculatorMapper;
import com.vns.service.ICalculatorService;
import com.vns.service.IPriceMarketService;
import com.vns.util.Constants;
import com.vns.util.DateUtil;
import com.vns.util.ServiceUtil;
import com.vns.vo.Calculator;
import com.vns.vo.DataResult;
import com.vns.vo.PriceMarket;

@Service
public class CalculatorService implements ICalculatorService {

	@Autowired
	private CalculatorMapper clm;
	@Autowired
	private IPriceMarketService pms;
	
	@Override
	public DataResult<Calculator> getVnsData() {
		DataResult<Calculator> dr = new DataResult<Calculator>();
		Date currentTime = new Date();
		Date yesterdayDate = DateUtil.getYesterdayEndDate(currentTime);
		Calculator cl = new Calculator();
		cl.setYesterdayTime(yesterdayDate);
		
		List<Calculator> list = clm.getCalculatorParam(cl);
		// 获取了昨日的全网算力和挖矿难度
		if (null!= list&& list.size()>0) {
			cl = list.get(0);
			cl.setYesterdayHashRateDisplay(ServiceUtil.unitH4KH(cl.getYesterdayHashRate()));
			cl.setYesterdayDifficultyDisplay(ServiceUtil.difficultyH4MH(cl.getYesterdayDifficulty()));
		}
		
		// 获取币价
		PriceMarket pm = new PriceMarket();
		pm = pms.queryRecentPrice();
		
		cl.setPriceRmb(pm.getRmbPrice());
		cl.setPriceDoller(pm.getDollerPrice());
		dr.setData(cl);
		
		return dr;
	}
	
	/**
	 * 统计昨日数据：全网平均算力、全网平均难度、昨日手续费和、昨日出币量、昨日出块量
	 */
	public void statCalculateParam() {
		Date currentTime = new Date();
		Date beginDate = DateUtil.getYesterdayBeginDate(currentTime);
		Date endDate = DateUtil.getYesterdayEndDate(currentTime);
		this.statDataImpl(beginDate, endDate);
	}
	
	/**
	 * 统计、插入数据：全网平均算力、全网平均难度、昨日手续费和、昨日出币量、昨日出块量
	 * @param beginDate 统计的日期 0时0分0秒
	 * @param endDate 统计的日期 23时59分59秒
	 */
	private void statDataImpl(Date beginDate, Date endDate) {
		Calculator param = new Calculator();
		param.setBeginDate(beginDate);
		param.setEndDate(endDate);
		Calculator cl = new Calculator();
		cl = clm.statCalculateParam(param);
		
		// 昨日平均出块时长  = 86400秒/昨日出块数
		double yesterdayProduceBlockTime = Constants.DateAndTime.SECOND_OF_DAY / cl.getYesterdayBlockNum();
		/**
		 * 昨日出块时长（平均）
		 */
		cl.setYesterdayProduceBlockTime(yesterdayProduceBlockTime);
		// 计算全网算力（平均）= 挖矿难度（平均）/ 出块时长（平均）
		double yesterdayHashRate = cl.getYesterdayDifficulty() / yesterdayProduceBlockTime;
		/**
		 *  昨日全网算力（平均）
		 */
		cl.setYesterdayHashRate(yesterdayHashRate);
		
		// 手续费单位转换 wei-> vns
		double yesterdayTxPoundage = cl.getYesterdayTxPoundageWei() / Constants.Trasaction.WEI_4_VNS_UNIT;
		/**
		 *  手续费
		 */
		cl.setYesterdayTxPoundage(yesterdayTxPoundage);
		
		int yesterdayRefUncleNum = cl.getYesterdayRefUncleNum();
		double yesterdayRefUncleReward = (double)yesterdayRefUncleNum * 209 / 32; 
		/**
		 *  区块引用奖励
		 */
		cl.setYesterdayRefUncleReward(yesterdayRefUncleReward);
		
		// 昨日全部奖励（出币量）= 区块引用奖励 + 手续费 + 出块奖励 + 叔块奖励
		double yesterdayOutputCoins = yesterdayRefUncleReward + yesterdayTxPoundage + cl.getYesterdayBlockReward() + cl.getYesterdayRefUncleReward();
		/**
		 *  昨日出币总量（单位VNS
		 */
		cl.setYesterdayOutputCoins(yesterdayOutputCoins);
		/**
		 * 统计时间
		 */
		cl.setYesterdayTime(endDate);
		
		int isExist = clm.isExist(cl);
		if (isExist > 0) {
			// 更新
			clm.update(cl);
		} else {
			// 入库
			clm.insert(cl);
		}
	}

	@Override
	public DataResult<Calculator> calculateMyReward(Calculator param) {
		DataResult<Calculator> dr = new DataResult<Calculator>();
		// 获得个人算力
		double myHashRate = param.getMyHashRate();
		// 获得全网算力值(可能是用户自己填的）
		double yesterdayHashRateDisplay = param.getYesterdayHashRateDisplay();
		// 单位由 KH 转为 H，方便计算
		double networkHashRate = yesterdayHashRateDisplay * 1000;
		
		Calculator returnVal = param;
		// 计算个人收益  = 个人算力 / 全网算力 * 昨日出币总量
		double myReward1Day = myHashRate / networkHashRate * param.getYesterdayOutputCoins();
		
		// 取2位小数，四舍五入
		double dayCoin = new BigDecimal(myReward1Day).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
		double dayCoinRmb = new BigDecimal(myReward1Day*returnVal.getPriceRmb()).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
		double dayCoinDoller = new BigDecimal(myReward1Day*returnVal.getPriceDoller()).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
		
		returnVal.setDayCoin(dayCoin);
		returnVal.setDayCoinRmb(dayCoinRmb);
		returnVal.setDayCoinDoller(dayCoinDoller);
		
		if (0.0d != returnVal.getPower()) {
			double power = returnVal.getPower() * 24 / 1000;
			double dayElectric = new BigDecimal(power).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
			// 日耗电量
			returnVal.setDayElectric(dayElectric);
		}
		if (0.0d != returnVal.getElectricPrice()) {
			double cost = returnVal.getElectricPrice() * returnVal.getDayElectric();
			double dayElectricCost = new BigDecimal(cost).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
			// 日电费成本
			returnVal.setDayElectricCost(dayElectricCost);
		}
		
		// 计算回本时间
		if (0.0d != returnVal.getDeviceCost()) {
			double costRecoveryDay = returnVal.getDeviceCost() / returnVal.getDayNetProfit();
			int i = (new Double(costRecoveryDay)).intValue();
			returnVal.setCostRecoveryDay(i);
		}
		
		dr.setData(returnVal);
		
		return dr;
	}

	/**
	 * 获取报表（算力、难度）数据
	 * @return
	 */
	public List<Calculator> getReportByTime() {
		Date currentTime = new Date();
		Date nDayAgoBegin = DateUtil.getNdayAgoBeginDate(currentTime, Constants.DateAndTime.TWO_WEEK_OF_DAY);
		Date nDayAgoEnd = DateUtil.getNdayAgoEndDate(currentTime, Constants.DateAndTime.TWO_WEEK_OF_DAY);
		Calculator cl = new Calculator();
		cl.setBeginDate(nDayAgoBegin);
		cl.setEndDate(nDayAgoEnd);
		
		return clm.getReportByTime(cl);
	}
	
	/**
	 * 获取报表（算力、难度）数据-全部数据
	 * @return
	 */
	public List<Calculator> getReportAllData() {
		return clm.getReportAllData();
	}
	
	/**
	 * 统计历史数据，每天的：全网平均算力、全网平均难度、手续费和、出币量、出块量
	 * @param begin 开始日期
 	 * @param end 结束日期
	 */
	public void statHistoryData(Date begin, Date end) {
		// 日期时间都置为0时0分0秒，便于计算日期相隔天数
		Date beginN = DateUtil.get0SecDate(begin);
		Date endN = DateUtil.get0SecDate(end);
		// 区得相隔天数
		int days = DateUtil.differentDaysByMillisecond(beginN, endN);
		if (days < 0) {
			return;
		}
		
		// 根据相隔天数，循环统计这段时间内每一天的数据
		int i = 0; // 如果相隔0天，也得计算一天
		do {
			Date beginDate = DateUtil.getNdayAgoBeginDate(end, i);
			Date endDate = DateUtil.getNdayAgoEndDate(end, i);
			this.statDataImpl(beginDate, endDate);
			i++;
		} while (i < days);
	}
}
