package com.hitoo.sys.download.service.impl;

import org.springframework.stereotype.Service;

import com.hitoo.frame.base.BaseService;
import com.hitoo.sys.download.service.DownLoadService;
import com.hitoo.sys.entity.DownLoad;

@Service
public class DownLoadServiceImpl extends BaseService implements DownLoadService{
	
	/**
	 * 常用下载
	 */
	@Override
	public DownLoad querydownLoadAssistFile(String fileID) throws Exception {
		return commonDao.findEntityByID(DownLoad.class, fileID);
	}
	
}