package com.vns.service;

import com.vns.vo.DictionaryInfo;

public interface IDictionaryService {

	public void insert(DictionaryInfo di);
	
	public DictionaryInfo findByKey(String key);
}
