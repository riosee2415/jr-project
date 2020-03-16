package com.patis.admin.AD0103;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.patis.model.EmpVO;

@Service("ad0103Service")
public class Ad0103ServiceImpl implements I_Ad0103Service{
	
	@Resource(name = "ad0103DAO")
	private I_Ad0103DAO adDAO0103DAO;

	@Override
	public List<EmpVO> getAllUser() {
		return adDAO0103DAO.getAllUser();
	}

	@Override
	public EmpVO getUserById(String userId) {
		return adDAO0103DAO.getUserById(userId);
	}

}
