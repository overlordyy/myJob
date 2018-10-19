package com.vns.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vns.service.ICalculatorService;
import com.vns.vo.Calculator;
import com.vns.vo.DataResult;

@Controller
@RequestMapping("/calculator")
public class VnsCalculatorControler {

	@Autowired
	private ICalculatorService cs;
	
	/**
	 * 获取 VNS 全网数据
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/getVnsData",method=RequestMethod.GET)
	@ResponseBody
    public DataResult<Calculator> getVnsData(HttpServletRequest request)
    {
        return cs.getVnsData();
    }
	
	/**
	 * 计算个人收益
	 * @param param
	 * @return
	 */
	@RequestMapping(value="/calculate",method=RequestMethod.POST)
	@ResponseBody
    public DataResult<Calculator> calculate(Calculator param)
    {
        return cs.calculateMyReward(param);
    }

	
	/**
	 * 定时任务未执行时，通过Url执行数据统计
	 * @param request
	 */
	@RequestMapping(value="/stat",method=RequestMethod.GET)
	@ResponseBody
    public void stat(HttpServletRequest request)
    {
        cs.statCalculateParam();;
    }
}
