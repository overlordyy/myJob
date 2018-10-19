package com.vns.service.impl;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vns.dao.PriceMarketMapper;
import com.vns.service.IHomeService;
import com.vns.util.HttpUtil;
import com.vns.vo.BlockInfo;
import com.vns.vo.DataResult;
import com.vns.vo.PriceMarket;

@Service
public class HomeService implements IHomeService {

	@Autowired
	private PriceMarketMapper pm;
	@Override
	public void homeTask() {
		DataResult<BlockInfo> dr = new DataResult<BlockInfo>();
		PriceMarket pmInfo = new PriceMarket();
		PriceMarket bi = null;
		PriceMarket ethbi = null;
        String fBuyPri = null;
	    try {
	        StringBuffer sb = new StringBuffer();
	        //请求交易所vns的实时数据
	        String strRead = HttpUtil.get("http://api.cex.plus/api/v1/ticker.do?symbol=vns_usdt");
	        if(strRead != null) {
	        	bi = JSON.parseObject(strRead, PriceMarket.class);
	        }
	        //取出交易所eth的实时数据
	        String ethbStrRead = HttpUtil.get("http://api.cex.plus/api/v1/ticker.do?symbol=eth_usdt");
	        if(ethbStrRead != null) {
	        	ethbi = JSON.parseObject(ethbStrRead, PriceMarket.class);
	        }
	        //取出当前货币汇率
	        String rmbquot = HttpUtil.get("http://web.juhe.cn:8080/finance/exchange/rmbquot?key=8a4bbaf6bc93bd89a8f6ffc235182b06");
	        if(rmbquot != null) {
		        ObjectMapper objectMapper = new ObjectMapper();
		        Map map=JSONObject.parseObject(rmbquot);
		        JSONArray jsonArray = (JSONArray) map.get("result");
		        for (Object obj : jsonArray) {
		        	Map hsMap = (Map) obj;
		        	Map dataMap = (Map) hsMap.get("data1");
		        	fBuyPri = (String) dataMap.get("fBuyPri");
				}
	        	ethbi = JSON.parseObject(ethbStrRead, PriceMarket.class);
	        }
	        pmInfo.setDollerPrice(Double.valueOf(bi.getTicker().getLast()));
	        pmInfo.setRmbPrice(Double.valueOf(bi.getTicker().getLast())*Double.valueOf(fBuyPri));
	        pmInfo.setEthPrice(Double.valueOf(bi.getTicker().getLast())/Double.valueOf(ethbi.getTicker().getLast()));
	        pmInfo.setCreateTime(new Date(bi.getDate()*1000));
	        pm.insert(pmInfo);
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	}

}
