package com.patis.admin.AD0301;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.patis.model.Accept_typeVO;

@Service("ad0301Service")
public class Ad0301ServiceImpl implements I_Ad0301Service{
	
	@Resource(name = "ad0301DAO")
	private I_Ad0301DAO ad0301DAO;


	@Override
	public List<Accept_typeVO> getBoardName() {
		return ad0301DAO.getBoardName();
	}


	@Override
	public Accept_typeVO getBoardAdminRightByName(String name) {
		return ad0301DAO.getBoardAdminRightByName(name);
	}


	@Override
	public int boardAcceptRightModify(Map<String, Object> params) {
		return ad0301DAO.boardAcceptRightModify(params);
	}

}
