package com.vns.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.vns.query.QueryObject;

/**
 * 挖矿计算器
 * @author Lvp
 *
 */
public class Calculator extends QueryObject {

	private long id;
	private double yesterdayHashRate; // 昨日全网算力（平均值
	private double yesterdayHashRateDisplay; // 昨日全网算力（平均值），页面显示用，转换了单位的
	private double yesterdayDifficulty; // 昨日挖矿难度（平均值
	private double yesterdayDifficultyDisplay; // 昨日挖矿难度（平均值），页面显示值，转换了单位的
	private int yesterdayBlockNum; // 昨日挖出的区块数（正常区块+叔块）
	private int yesterdayNormalBlockNum; // 昨日挖出的正常区块数
	private int yesterdayUncleBlockNum; // 昨日挖出的叔区块数
	private double yesterdayTxPoundage; // 昨日交易手续费总量（单位VNS
	private double yesterdayTxPoundageWei; // 昨日交易手续费总量（单位Wei
	private double yesterdayBlockReward; // 昨日挖矿出币总量（单位VNS
	private double yesterdayUncleBlockReward; // 昨日叔块挖矿出币总量（单位VNS
	private double yesterdayRefUncleReward; // 昨日引用叔块奖励出币总量（单位VNS
	private int yesterdayRefUncleNum; // 昨日引用叔块数
	private double yesterdayOutputCoins; // 昨日出币总量（单位VNS
	private double yesterdayProduceBlockTime; // 昨日平均出块时长
	private Date yesterdayTime; // 昨天的日期
	
	private double priceRmb; // 币价（人民币
	private double priceDoller; // 币价（美元
	private double myHashRate; // 我的算力
	private double electricPrice; // 电价（单位：度）
	private double power; // 功率 （单位：W）
	private double deviceCost; // 设备成本 
	
	private double dayElectric; // 日耗电量
	private double dayElectricCost; // 日电费成本
	private double dayCoin; // 日收益-币
	private double dayCoinRmb; // 日收益-人民币
	private double dayCoinDoller; // 日收益-美元
	private double dayNetProfit; // 日净收益
	
	private double weekElectric; // 周耗电量
	private double weekElectricCost; // 周电费成本
	private double weekCoin; // 周收益-币
	private double weekCoinRmb; // 周收益-人民币
	private double weekCoinDoller; // 周收益-美元
	private double weekNetProfit; // 周净收益
	
	private double monthElectric; // 月耗电量
	private double monthElectricCost; // 月电费成本
	private double monthCoin; // 月收益-币
	private double monthCoinRmb; // 月收益-人民币
	private double monthCoinDoller; // 月收益-美元
	private double monthNetProfit; // 月净收益
	
	private double yearElectric; // 年耗电量
	private double yearElectricCost; // 年电费成本
	private double yearCoin; // 年收益-币
	private double yearCoinRmb; // 年收益-人民币
	private double yearCoinDoller; // 年收益-美元
	private double yearNetProfit; // 年净收益
	
	private double costRecoveryDay; // 回本时间-天
	private double costRecoveryMonth; // 回本时间-月
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getYesterdayBlockNum() {
		return yesterdayBlockNum;
	}

	public void setYesterdayBlockNum(int yesterdayBlockNum) {
		this.yesterdayBlockNum = yesterdayBlockNum;
	}

	public int getYesterdayNormalBlockNum() {
		return yesterdayNormalBlockNum;
	}

	public void setYesterdayNormalBlockNum(int yesterdayNormalBlockNum) {
		this.yesterdayNormalBlockNum = yesterdayNormalBlockNum;
	}

	public int getYesterdayUncleBlockNum() {
		return yesterdayUncleBlockNum;
	}

	public void setYesterdayUncleBlockNum(int yesterdayUncleBlockNum) {
		this.yesterdayUncleBlockNum = yesterdayUncleBlockNum;
	}

	public int getYesterdayRefUncleNum() {
		return yesterdayRefUncleNum;
	}

	public void setYesterdayRefUncleNum(int yesterdayRefUncleNum) {
		this.yesterdayRefUncleNum = yesterdayRefUncleNum;
	}

	public double getYesterdayHashRate() {
		return yesterdayHashRate;
	}

	public void setYesterdayHashRate(double yesterdayHashRate) {
		this.yesterdayHashRate = yesterdayHashRate;
	}

	public double getYesterdayDifficulty() {
		return yesterdayDifficulty;
	}

	public void setYesterdayDifficulty(double yesterdayDifficulty) {
		this.yesterdayDifficulty = yesterdayDifficulty;
	}

	public double getYesterdayHashRateDisplay() {
		return yesterdayHashRateDisplay;
	}

	public void setYesterdayHashRateDisplay(double yesterdayHashRateDisplay) {
		this.yesterdayHashRateDisplay = yesterdayHashRateDisplay;
	}

	public double getYesterdayDifficultyDisplay() {
		return yesterdayDifficultyDisplay;
	}

	public void setYesterdayDifficultyDisplay(double yesterdayDifficultyDisplay) {
		this.yesterdayDifficultyDisplay = yesterdayDifficultyDisplay;
	}

	public double getYesterdayTxPoundage() {
		return yesterdayTxPoundage;
	}

	public void setYesterdayTxPoundage(double yesterdayTxPoundage) {
		this.yesterdayTxPoundage = yesterdayTxPoundage;
	}

	public double getYesterdayBlockReward() {
		return yesterdayBlockReward;
	}

	public void setYesterdayBlockReward(double yesterdayBlockReward) {
		this.yesterdayBlockReward = yesterdayBlockReward;
	}

	public double getYesterdayUncleBlockReward() {
		return yesterdayUncleBlockReward;
	}

	public void setYesterdayUncleBlockReward(double yesterdayUncleBlockReward) {
		this.yesterdayUncleBlockReward = yesterdayUncleBlockReward;
	}

	public double getYesterdayRefUncleReward() {
		return yesterdayRefUncleReward;
	}

	public void setYesterdayRefUncleReward(double yesterdayRefUncleReward) {
		this.yesterdayRefUncleReward = yesterdayRefUncleReward;
	}

	public double getYesterdayOutputCoins() {
		return yesterdayOutputCoins;
	}

	public void setYesterdayOutputCoins(double yesterdayOutputCoins) {
		this.yesterdayOutputCoins = yesterdayOutputCoins;
	}

	public double getYesterdayProduceBlockTime() {
		return yesterdayProduceBlockTime;
	}

	public void setYesterdayProduceBlockTime(double yesterdayProduceBlockTime) {
		this.yesterdayProduceBlockTime = yesterdayProduceBlockTime;
	}

	public Date getYesterdayTime() {
		return yesterdayTime;
	}

	public void setYesterdayTime(Date yesterdayTime) {
		this.yesterdayTime = yesterdayTime;
	}

	public double getPriceRmb() {
		return priceRmb;
	}
	public void setPriceRmb(double priceRmb) {
		this.priceRmb = priceRmb;
	}
	public double getPriceDoller() {
		return priceDoller;
	}
	public void setPriceDoller(double priceDoller) {
		this.priceDoller = priceDoller;
	}
	public double getMyHashRate() {
		return myHashRate;
	}
	public void setMyHashRate(double myHashRate) {
		this.myHashRate = myHashRate;
	}
	public double getElectricPrice() {
		return electricPrice;
	}
	public void setElectricPrice(double electricPrice) {
		this.electricPrice = electricPrice;
	}
	public double getPower() {
		return power;
	}
	public void setPower(double power) {
		this.power = power;
	}
	public double getDeviceCost() {
		return deviceCost;
	}
	public void setDeviceCost(double deviceCost) {
		this.deviceCost = deviceCost;
	}
	public double getDayElectric() {
		return dayElectric;
	}
	public void setDayElectric(double dayElectric) {
		this.dayElectric = dayElectric;
	}
	public double getDayElectricCost() {
		return dayElectricCost;
	}
	public void setDayElectricCost(double dayElectricCost) {
		this.dayElectricCost = dayElectricCost;
	}
	public double getDayCoin() {
		return dayCoin;
	}
	public void setDayCoin(double dayCoin) {
		this.dayCoin = dayCoin;
	}
	public double getDayCoinRmb() {
		return dayCoinRmb;
	}
	public void setDayCoinRmb(double dayCoinRmb) {
		this.dayCoinRmb = dayCoinRmb;
	}
	public double getDayCoinDoller() {
		return dayCoinDoller;
	}
	public void setDayCoinDoller(double dayCoinDoller) {
		this.dayCoinDoller = dayCoinDoller;
	}
	
	public double getWeekElectric() {
		return new BigDecimal(dayElectric*7).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	public double getWeekElectricCost() {
		return new BigDecimal(dayElectricCost*7).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	public double getWeekCoin() {
		return new BigDecimal(dayCoin*7).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	public double getWeekCoinRmb() {
		return new BigDecimal(dayCoinRmb*7).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	public double getWeekCoinDoller() {
		return new BigDecimal(dayCoinDoller*7).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	public double getMonthElectric() {
		return new BigDecimal(dayElectric*30).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	public double getMonthElectricCost() {
		return new BigDecimal(dayElectricCost*30).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	public double getMonthCoin() {
		return new BigDecimal(dayCoin*30).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	public double getMonthCoinRmb() {
		return new BigDecimal(dayCoinRmb*30).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	public double getMonthCoinDoller() {
		return new BigDecimal(dayCoinDoller*30).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	public double getYearElectric() {
		return new BigDecimal(dayElectric*365).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	public double getYearElectricCost() {
		return new BigDecimal(dayElectricCost*365).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	public double getYearCoin() {
		return new BigDecimal(dayCoin*365).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	public double getYearCoinRmb() {
		return new BigDecimal(dayCoinRmb*365).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	public double getYearCoinDoller() {
		return new BigDecimal(dayCoinDoller*365).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	public double getCostRecoveryDay() {
		return costRecoveryDay;
	}
	public void setCostRecoveryDay(int costRecoveryDay) {
		this.costRecoveryDay = costRecoveryDay;
	}
	public double getCostRecoveryMonth() {
		return new BigDecimal(costRecoveryDay/30).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	public double getYesterdayTxPoundageWei() {
		return yesterdayTxPoundageWei;
	}

	public void setYesterdayTxPoundageWei(double yesterdayTxPoundageWei) {
		this.yesterdayTxPoundageWei = yesterdayTxPoundageWei;
	}

	public double getDayNetProfit() {
		return new BigDecimal(dayCoinRmb-dayElectricCost).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	public double getWeekNetProfit() {
		return new BigDecimal(getWeekCoinRmb()-getWeekElectricCost()).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	public double getMonthNetProfit() {
		return new BigDecimal(getMonthCoinRmb()-getMonthElectricCost()).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	public double getYearNetProfit() {
		return new BigDecimal(getYearCoinRmb()-getYearElectricCost()).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	
}
