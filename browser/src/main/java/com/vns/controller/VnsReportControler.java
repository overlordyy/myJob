package com.vns.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vns.service.ICalculatorService;
import com.vns.service.IReportPriceService;
import com.vns.service.IReportTokenTxService;
import com.vns.service.IReportTxService;
import com.vns.service.IReportUserService;
import com.vns.service.IReportVnsValueService;
import com.vns.vo.Calculator;
import com.vns.vo.Report;
import com.vns.vo.ReportPrice;
import com.vns.vo.ReportTokenTx;
import com.vns.vo.ReportTransation;
import com.vns.vo.ReportUser;
import com.vns.vo.ReportVnsValue;

@Controller
@RequestMapping("/report")
public class VnsReportControler {

	@Autowired
	private ICalculatorService cs;
	@Autowired
	private IReportTxService rts;
	@Autowired
	private IReportTokenTxService rtts;
	@Autowired
	private IReportUserService rus;
	@Autowired
	private IReportPriceService rps;
	@Autowired
	private IReportVnsValueService rvvs;
	
	/**
	 * 报表-算力
	 * @param request
	 */
	@RequestMapping(value="/hashRateReport",method=RequestMethod.GET)
	@ResponseBody
    public List<Report> hashRateReport(HttpServletRequest request) {
		List<Calculator> hashs = cs.getReportAllData();
		List<Report> reports = new ArrayList<Report>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Calculator hash = null;
		for (int i = 0; i < hashs.size(); i++) {
			hash = hashs.get(i);
			Report report = new Report();
			report.setY(hash.getYesterdayHashRate()/1000);
			report.setDt(sdf.format(hash.getYesterdayTime()));
			reports.add(report);
		}
		
		return reports;
	}
	
	/**
	 * 报表-难度
	 * @param request
	 */
	@RequestMapping(value="/diffcultyReport",method=RequestMethod.GET)
	@ResponseBody
    public List<Report> diffcultyReport(HttpServletRequest request) {
		List<Calculator> hashs = cs.getReportAllData();
		List<Report> reports = new ArrayList<Report>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Calculator hash = null;
		for (int i = 0; i < hashs.size(); i++) {
			hash = hashs.get(i);
			Report report = new Report();
			report.setY(hash.getYesterdayDifficulty()/1000/1000);
			report.setDt(sdf.format(hash.getYesterdayTime()));
			reports.add(report);
		}
		
		return reports;
	}
	
	/**
	 * 报表-交易笔数
	 * @param request
	 */
	@RequestMapping(value="/txReport",method=RequestMethod.GET)
	@ResponseBody
    public List<Report> txReport(HttpServletRequest request) {
		List<?> txs = rts.getReportAllData();
		List<Report> reports = new ArrayList<Report>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		ReportTransation tx = null;
		for (int i = 0; i < txs.size(); i++) {
			tx = (ReportTransation)txs.get(i);
			Report report = new Report();
			report.setY(tx.getTransactionNum());
			report.setDt(sdf.format(tx.getCreateDate()));
			reports.add(report);
		}
		
		return reports;
	}
	
	/**
	 * 报表-Token交易笔数
	 * @param request
	 */
	@RequestMapping(value="/tokenTxReport",method=RequestMethod.GET)
	@ResponseBody
    public List<Report> tokenTxReport(HttpServletRequest request) {
		List<?> tokenTxs = rtts.getReportAllData();
		List<Report> reports = new ArrayList<Report>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		ReportTokenTx tokenTx = null;
		for (int i = 0; i < tokenTxs.size(); i++) {
			tokenTx = (ReportTokenTx)tokenTxs.get(i);
			Report report = new Report();
			report.setY(tokenTx.getTokenTxNum());
			report.setDt(sdf.format(tokenTx.getCreateDate()));
			reports.add(report);
		}
		
		return reports;
	}
	
	/**
	 * 报表-新增交易地址数=新增用户数
	 * @param request
	 */
	@RequestMapping(value="/newUserReport",method=RequestMethod.GET)
	@ResponseBody
    public List<Report> newUserReport(HttpServletRequest request) {
		List<?> users = rus.getReportAllData();
		List<Report> reports = new ArrayList<Report>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		ReportUser user = null;
		for (int i = 0; i < users.size(); i++) {
			user = (ReportUser)users.get(i);
			Report report = new Report();
			report.setY(user.getNewUserNum());
			report.setDt(sdf.format(user.getCreateDate()));
			reports.add(report);
		}
		
		return reports;
	}
	
	/**
	 * 报表-交易地址数=用户数
	 * @param request
	 */
	@RequestMapping(value="/totalUserReport",method=RequestMethod.GET)
	@ResponseBody
    public List<Report> totalUserReport(HttpServletRequest request) {
		List<?> users = rus.getReportAllData();
		List<Report> reports = new ArrayList<Report>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		ReportUser user = null;
		for (int i = 0; i < users.size(); i++) {
			user = (ReportUser)users.get(i);
			Report report = new Report();
			report.setY(user.getUserTotal());
			report.setDt(sdf.format(user.getCreateDate()));
			reports.add(report);
		}
		
		return reports;
	}
	
	/**
	 * 报表-新增Token交易地址数=新增Token用户数
	 * @param request
	 */
	@RequestMapping(value="/newTokenUserReport",method=RequestMethod.GET)
	@ResponseBody
    public List<Report> newTokenUserReport(HttpServletRequest request) {
		List<?> users = rus.getReportAllData();
		List<Report> reports = new ArrayList<Report>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		ReportUser user = null;
		for (int i = 0; i < users.size(); i++) {
			user = (ReportUser)users.get(i);
			Report report = new Report();
			report.setY(user.getNewTokenUserNum());
			report.setDt(sdf.format(user.getCreateDate()));
			reports.add(report);
		}
		
		return reports;
	}
	
	/**
	 * 报表-Token交易地址数=Token用户数
	 * @param request
	 */
	@RequestMapping(value="/totalTokenUserReport",method=RequestMethod.GET)
	@ResponseBody
    public List<Report> totalTokenUserReport(HttpServletRequest request) {
		List<?> users = rus.getReportAllData();
		List<Report> reports = new ArrayList<Report>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		ReportUser user = null;
		for (int i = 0; i < users.size(); i++) {
			user = (ReportUser)users.get(i);
			Report report = new Report();
			report.setY(user.getTokenUserTotal());
			report.setDt(sdf.format(user.getCreateDate()));
			reports.add(report);
		}
		
		return reports;
	}
	
	/**
	 * 报表-币价
	 * @param request
	 */
	@RequestMapping(value="/priceReport",method=RequestMethod.GET)
	@ResponseBody
    public List<Report> priceReport(HttpServletRequest request) {
		List<?> prices = rps.getReportAllData();
		List<Report> reports = new ArrayList<Report>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		ReportPrice price = null;
		for (int i = 0; i < prices.size(); i++) {
			price = (ReportPrice)prices.get(i);
			Report report = new Report();
			report.setY(price.getRmbPrice());
			report.setDt(sdf.format(price.getCreateDate()));
			reports.add(report);
		}
		
		return reports;
	}
	
	/**
	 * 报表-市值
	 * @param request
	 */
	@RequestMapping(value="/vnsVulueReport",method=RequestMethod.GET)
	@ResponseBody
    public List<Report> vnsVulueReport(HttpServletRequest request) {
		List<?> vvalues = rvvs.getReportAllData();
		List<Report> reports = new ArrayList<Report>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		ReportVnsValue vvalue = null;
		for (int i = 0; i < vvalues.size(); i++) {
			vvalue = (ReportVnsValue)vvalues.get(i);
			Report report = new Report();
			report.setY(vvalue.getRmbValue());
			report.setDt(sdf.format(vvalue.getCreateDate()));
			reports.add(report);
		}
		
		return reports;
	}
	
	
	/**
	 * 初始化算力、难度报表历史数据
	 * 通过Url隐性访问执行
	 * @param request
	 */
	@RequestMapping(value="/initAllReportData",method=RequestMethod.GET)
	@ResponseBody
    public void initAllReportData(HttpServletRequest request) {
		String beginStr = request.getParameter("begin");
		String endStr = request.getParameter("end");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date begin = sdf.parse(beginStr);
			Date end = sdf.parse(endStr);
			
			cs.statHistoryData(begin, end);
			rts.statisticHistory(begin, end);
			rtts.statisticHistory(begin, end);
			rus.statisticHistory(begin, end);
			rps.statisticHistory(begin, end);
			rvvs.statisticHistory(begin, end);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 初始化算力、难度报表历史数据
	 * 通过Url隐性访问执行
	 * @param request
	 */
	@RequestMapping(value="/initHashRateReportData",method=RequestMethod.GET)
	@ResponseBody
    public void initHashRateReportData(HttpServletRequest request) {
		String beginStr = request.getParameter("begin");
		String endStr = request.getParameter("end");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date begin = sdf.parse(beginStr);
			Date end = sdf.parse(endStr);
			
			cs.statHistoryData(begin, end);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	/**
	 * 初始化交易报表历史数据
	 * 通过Url隐性访问执行
	 * @param request
	 */
	@RequestMapping(value="/initTxReportData",method=RequestMethod.GET)
	@ResponseBody
    public void initTxReportData(HttpServletRequest request) {
		String beginStr = request.getParameter("begin");
		String endStr = request.getParameter("end");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date begin = sdf.parse(beginStr);
			Date end = sdf.parse(endStr);
			
			rts.statisticHistory(begin, end);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	/**
	 * 初始化Token交易报表历史数据
	 * 通过Url隐性访问执行
	 * @param request
	 */
	@RequestMapping(value="/initTokenTxReportData",method=RequestMethod.GET)
	@ResponseBody
    public void initTokenTxReportData(HttpServletRequest request) {
		String beginStr = request.getParameter("begin");
		String endStr = request.getParameter("end");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date begin = sdf.parse(beginStr);
			Date end = sdf.parse(endStr);
			
			rtts.statisticHistory(begin, end);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	/**
	 * 初始化用户报表历史数据
	 * 通过Url隐性访问执行
	 * @param request
	 */
	@RequestMapping(value="/initUserReportData",method=RequestMethod.GET)
	@ResponseBody
    public void initUserReportData(HttpServletRequest request) {
		String beginStr = request.getParameter("begin");
		String endStr = request.getParameter("end");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date begin = sdf.parse(beginStr);
			Date end = sdf.parse(endStr);
			
			rus.statisticHistory(begin, end);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	/**
	 * 初始化币价报表历史数据
	 * 通过Url隐性访问执行
	 * @param request
	 */
	@RequestMapping(value="/initPirceReportData",method=RequestMethod.GET)
	@ResponseBody
    public void initPirceReportData(HttpServletRequest request) {
		String beginStr = request.getParameter("begin");
		String endStr = request.getParameter("end");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date begin = sdf.parse(beginStr);
			Date end = sdf.parse(endStr);
			
			rps.statisticHistory(begin, end);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	/**
	 * 初始化币价报表历史数据
	 * 通过Url隐性访问执行
	 * @param request
	 */
	@RequestMapping(value="/initVnsValueReportData",method=RequestMethod.GET)
	@ResponseBody
    public void initVnsValueReportData(HttpServletRequest request) {
		String beginStr = request.getParameter("begin");
		String endStr = request.getParameter("end");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date begin = sdf.parse(beginStr);
			Date end = sdf.parse(endStr);
			
			rvvs.statisticHistory(begin, end);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
