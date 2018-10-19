package com.vns.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vns.service.IBlockService;
import com.vns.vo.BlockInfo;
import com.vns.vo.DataResult;
import com.vns.vo.TableSplitResult;

@Controller
@RequestMapping("/block")
public class VnsBlockInfoController {

	@Autowired
	private IBlockService ibs;
	
	@RequestMapping(value="/blockSta",method=RequestMethod.GET)
	@ResponseBody
    public void blockSta(BlockInfo bi)
    {
        ibs.blockSta();
    }
	
	@RequestMapping(value="/seqNewBlock",method=RequestMethod.GET)
	@ResponseBody
    public void seqNewBlock()
    {
        ibs.seqNewBlock();
    }
	
	@RequestMapping(value="/blockStop",method=RequestMethod.GET)
	@ResponseBody
    public void blockStop(BlockInfo bi)
    {
        ibs.blockStop();
    }
	
	@RequestMapping(value="/listInfo",method=RequestMethod.GET)
	@ResponseBody
    public TableSplitResult findBlockList(BlockInfo bi)
    {
        return ibs.findBlockList(bi);
    }

	@RequestMapping(value="/findBlock",method=RequestMethod.GET)
	@ResponseBody
    public DataResult<BlockInfo> findBlock(HttpServletRequest request)
    {
		String blockNumber = request.getParameter("blockNumber");
        return ibs.findBlock(Integer.parseInt(blockNumber));
    }
	
	
	@RequestMapping(value="/blockDivInfo",method=RequestMethod.GET)
	@ResponseBody
    public DataResult<BlockInfo> blockDivInfo()
    {
        return ibs.blockDivInfo();
    }
	
	@RequestMapping(value="/findTokenInfo",method=RequestMethod.GET)
	@ResponseBody
    public void findTokenInfo()
    {
        ibs.findTokenInfo();
    }
}
