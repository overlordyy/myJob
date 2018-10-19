package com.vns.task;

import javax.annotation.Resource;

import com.vns.service.ICalculatorService;
import com.vns.service.IReportPriceService;
import com.vns.service.IReportTokenTxService;
import com.vns.service.IReportTxService;
import com.vns.service.IReportUserService;
import com.vns.service.IReportVnsValueService;
import com.vns.service.ITokenUserService;
import com.vns.service.IVnsUserService;

/**
 * 挖矿计算器参数 定时任务
 * @author Lvp
 *
 */
public class CalculatorTask {

	@Resource
	private ICalculatorService ics;
	@Resource
	private IReportTxService irts;
	@Resource
	private IReportTokenTxService irtts;
	@Resource
	private IReportUserService irus;
	@Resource
	private IReportPriceService irps;
	@Resource
	private IReportVnsValueService irvvs;
	@Resource
	private IVnsUserService ius;
	@Resource
	private ITokenUserService itus;
	
	/**
	 * 统计计算报表数据:
	 * 
	 * 昨日平均算力、难度
	 * 昨日交易量、交易数、手续费
	 * 昨日新增用户
	 * 昨日（最后）币价
	 * 昨日（最后）市值
	 */
	public void statCalculateParam() {
		// 昨日新增用户-添加到用户表
		ius.addYesterdayNewUser();
		// 昨日新增Token用户-添加到Token用户表
		itus.addYesterdayNewTokenUser();
		// 昨日平均算力、难度
		ics.statCalculateParam();
		// 昨日交易量、交易数、手续费
		irts.statistic();
		// 昨日Token交易量、交易数、手续费
		irtts.statistic();
		// 昨日新增用户-添加到报表-用户统计表
		irus.statistic();
		// 昨日（最后）币价
		irps.statistic();
		// 昨日（最后）市值
		irvvs.statistic();
	}
}
