package com.vns.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vns.dao.PriceMarketMapper;
import com.vns.service.IDictionaryService;
import com.vns.service.IPriceMarketService;
import com.vns.util.Constants;
import com.vns.util.HttpUtil;
import com.vns.vo.BlockInfo;
import com.vns.vo.DataResult;
import com.vns.vo.DictionaryInfo;
import com.vns.vo.PriceMarket;

/**
 * 币价行情 Service
 * @author Lvp
 *
 */
@Service
public class PriceMarketService implements IPriceMarketService {

	@Autowired
	public PriceMarketMapper pmm;
	
	@Autowired
	public IDictionaryService ids;
	
	/**
	 * 获取24小时前币价
	 */
	public PriceMarket before24HPrice() {
		// 参数对象
		PriceMarket param = new PriceMarket();
		// 取一个当前时间
		Date currentTime = new Date();
		// 设置开始时间为24H前的当前时间，秒为00
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentTime);
		calendar.add(Calendar.DAY_OF_MONTH, -1); // 1天前
		calendar.set(Calendar.SECOND, 0); // 时间为00
		Date beginDate = calendar.getTime();
		param.setBeginDate(beginDate);
		
		// 设置结束时间为24H前的当前时间，秒为59
		calendar.clear();
		calendar.setTime(currentTime);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		calendar.set(Calendar.SECOND, 59);
		Date endDate = calendar.getTime();
		param.setEndDate(endDate);
		
		return pmm.querySingleByTime(param);
	}
	
	/**
	 * 获取最新币价
	 */
	public PriceMarket queryRecentPrice() {
		return pmm.queryRecentPrice();
	}
	
	
	public static void main(String[] args) {
		// 取一个当前时间
		Date currentTime = new Date();
		// 
		SimpleDateFormat sdf=new SimpleDateFormat(Constants.DateAndTime.NORMAL_TIME_FORMAT);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentTime);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		calendar.set(Calendar.SECOND, 0);
		Date beginDate = calendar.getTime();
		System.out.println("beginDate:  " + sdf.format(beginDate));
		
		calendar.clear();
		calendar.setTime(currentTime);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		calendar.set(Calendar.SECOND, 59);
		Date endDate = calendar.getTime();
		System.out.println("endDate:  " + sdf.format(endDate));
		
	}

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
	        fBuyPri = ids.findByKey("INCREASE").getDataValue();
	        pmInfo.setDollerPrice(Double.valueOf(bi.getTicker().getLast()));
	        pmInfo.setRmbPrice(Double.valueOf(bi.getTicker().getLast())*(Double.valueOf(fBuyPri)/100));
	        pmInfo.setEthPrice(Double.valueOf(bi.getTicker().getLast())/Double.valueOf(ethbi.getTicker().getLast()));
	        pmInfo.setCreateTime(new Date(bi.getDate()*1000));
	        pmm.insert(pmInfo);
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	}

	@Override
	public void exchangeRate() {
        String fBuyPri = null;
		// TODO Auto-generated method stub
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
	        DictionaryInfo di = new DictionaryInfo();
	        di.setDataKey("INCREASE");
	        di.setDataValue(fBuyPri);
	        ids.insert(di);
        }
	}
	
}
