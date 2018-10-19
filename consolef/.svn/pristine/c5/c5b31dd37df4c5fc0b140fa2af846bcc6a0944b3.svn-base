package com.vns.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vns.service.ITokenService;
import com.vns.vo.BlockInfo;
import com.vns.vo.TableSplitResult;
import com.vns.vo.TokenInfo;

@Controller
@RequestMapping("/token")
public class VnsTokenController {

	@Autowired
	public ITokenService its;
	
	@RequestMapping(value="/listInfo",method=RequestMethod.GET)
	@ResponseBody
    public TableSplitResult findTokenList(TokenInfo ti)
    {
        return its.findTokenList(ti);
    }


	@RequestMapping(value="/tokenSta",method=RequestMethod.GET)
	@ResponseBody
    public void tokenSta(BlockInfo bi)
    {
		its.tokenSta();
    }
	
	
}
