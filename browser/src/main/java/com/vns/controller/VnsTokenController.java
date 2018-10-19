package com.vns.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import redis.clients.jedis.Jedis;

import com.vns.redisUtils.ConfigUtils;
import com.vns.redisUtils.SerializeUtil;
import com.vns.service.ITokenService;
import com.vns.vo.DataResult;
import com.vns.vo.HomeToken;
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

	@RequestMapping(value="/findHomeToken",method=RequestMethod.GET)
	@ResponseBody
	public DataResult<HomeToken> findHomeToken(){
//		Jedis jedis = JedisUtils.getJedis();
		Jedis jedis = new Jedis(ConfigUtils.ip, ConfigUtils.port);
		try {
			if(jedis.exists("findHomeToken".getBytes())){
				return (DataResult<HomeToken>) SerializeUtil.unserialize(jedis.get("findHomeToken".getBytes()));
			}else{
				return its.findHomeToken();
			}
		} finally{
			//JedisUtils.returnResource(jedis);
//			jedis.close();
		}
	}
}
