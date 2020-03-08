package com.patis.admin.AD0101;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.patis.model.LoginLogVO;

@Service("ad0101Service")
public class Ad0101ServiceImpl implements I_Ad0101Service{
	
	
	@Resource(name = "ad0101DAO")
	private I_Ad0101DAO adDAO0101DAO;

	@Override
	public List<LoginLogVO> getLogData(int paging) {
		return adDAO0101DAO.getLogData(paging);
	}
	
	
	
	

}
