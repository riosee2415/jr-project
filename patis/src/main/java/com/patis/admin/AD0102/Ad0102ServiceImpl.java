package com.patis.admin.AD0102;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.patis.admin.AD0101.I_Ad0101DAO;

@Service("ad0102Service")
public class Ad0102ServiceImpl implements I_Ad0102Service{
	
	@Resource(name = "ad0102DAO")
	private I_Ad0102DAO adDAO0102DAO;

	@Override
	public String getTodayConnectData(String today) {
		return adDAO0102DAO.getTodayConnectData(today);
	}
	
}
