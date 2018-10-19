package com.vns.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vns.dao.DictionaryMapper;
import com.vns.service.IDictionaryService;
import com.vns.vo.DictionaryInfo;

@Service
public class DictionaryService implements IDictionaryService {

	@Autowired
	public DictionaryMapper dm;
	@Override
	public void insert(DictionaryInfo di) {
		DictionaryInfo diInfo = new DictionaryInfo();
		diInfo = dm.findByKey(di);
		if(diInfo==null){
			dm.insert(di);
		}else{
			dm.updateByKey(di);
		}
	}
	
	@Override
	public DictionaryInfo findByKey(String key) {
		DictionaryInfo vo = new DictionaryInfo();
		vo.setDataKey(key);
		vo = dm.findByKey(vo);
		return vo;
	}
}
