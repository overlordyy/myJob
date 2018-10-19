package com.vns.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vns.service.IPriceMarketService;
import com.vns.service.ITransactionService;
import com.vns.vo.DataResult;
import com.vns.vo.HomeTransactions;
import com.vns.vo.TableSplitResult;
import com.vns.vo.TransactionInfo;

@Controller
@RequestMapping("/priceMarket")
public class VnsPriceMarketController {

	@Autowired
	public IPriceMarketService its;
	
	/**
	 * 获取币价汇率
	 * @param ti
	 * @return
	 */
	@RequestMapping(value="/task",method=RequestMethod.GET)
	@ResponseBody
    public void findTransactionList(TransactionInfo ti)
    {
        its.homeTask();
    }
}
