package com.patis.admin.AD0102;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.patis.admin.AD0101.I_Ad0101DAO;
import com.patis.model.ConnectRecordVO;

@Service("ad0102Service")
public class Ad0102ServiceImpl implements I_Ad0102Service{
	
	@Resource(name = "ad0102DAO")
	private I_Ad0102DAO adDAO0102DAO;

	@Override
	public String getTodayConnectData(String today) {
		return adDAO0102DAO.getTodayConnectData(today);
	}

	@Override
	public String getSearchConnectData(Map<String, String> params) {
		return adDAO0102DAO.getSearchConnectData(params);
	}

	@Override
	public List<ConnectRecordVO> getTodayDetailConnectData(String today) {
		return adDAO0102DAO.getTodayDetailConnectData(today);
	}

	@Override
	public List<ConnectRecordVO> getSearchDetailConnectData(Map<String, String> params) {
		return adDAO0102DAO.getSearchDetailConnectData(params);
	}
	
}
