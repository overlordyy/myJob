package com.vns.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import redis.clients.jedis.Jedis;

import com.vns.redisUtils.ConfigUtils;
import com.vns.redisUtils.SerializeUtil;
import com.vns.service.ITransactionService;
import com.vns.vo.DataResult;
import com.vns.vo.HomeTransactions;
import com.vns.vo.TableSplitResult;
import com.vns.vo.TransactionInfo;

@Controller
@RequestMapping("/transaction")
public class VnsTransactionController {

	@Autowired
	public ITransactionService its;
	
	/**
	 * 查询所有交易
	 * @param ti
	 * @return
	 */
	@RequestMapping(value="/listInfo",method=RequestMethod.GET)
	@ResponseBody
    public TableSplitResult findTransactionList(TransactionInfo ti)
    {
        return its.findTransactionList(ti);
    }
	
	/**
	 * 根据区块查询交易
	 * @return
	 */
	@RequestMapping(value="/findTransaction",method=RequestMethod.GET)
	@ResponseBody
	public TableSplitResult<TransactionInfo> findTransactionInfoByBlock(TransactionInfo ti){
		return its.findTransactionInfoByBlock(ti);
	}
	
	/**
	 * 根据区块查询交易
	 * @return
	 */
	@RequestMapping(value="/transactionDivInfo",method=RequestMethod.GET)
	@ResponseBody
	public DataResult<HomeTransactions> transactionDivInfo(){
//		Jedis jedis = JedisUtils.getJedis();
		Jedis jedis = new Jedis(ConfigUtils.ip, ConfigUtils.port);
		try {
			if(jedis.exists("transactionDivInfo".getBytes())){
				return (DataResult<HomeTransactions>) SerializeUtil.unserialize(jedis.get("transactionDivInfo".getBytes()));
			}else{
				return its.transactionDivInfo();
			}
		} finally { 
			//JedisUtils.returnResource(jedis);
//			jedis.close();
		}
	}
	
	/**
	 * 根据交易hash查询交易
	 * @return
	 */
	@RequestMapping(value="/findTransactionByHash",method=RequestMethod.GET)
	@ResponseBody
	public DataResult<TransactionInfo> findTransactionByHash(TransactionInfo ti){
		return its.findTransactionByHash(ti);
	}
}
