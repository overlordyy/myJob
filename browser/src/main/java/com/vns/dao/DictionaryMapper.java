package com.vns.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.vns.vo.DictionaryInfo;
import com.vns.vo.TokenInfo;

/**
 * Created by Administrator on 2018/7/11.
 */
public interface DictionaryMapper {

	public void insert(DictionaryInfo di);
	
	public DictionaryInfo findByKey(DictionaryInfo di);
	
	public void updateByKey(DictionaryInfo di);
}
