package com.patis.admin.AD0215;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.patis.model.BoardVO;

@Service("ad0215Service")
public class Ad0215ServiceImpl implements I_Ad0215Service{
	
	@Resource(name = "ad0215DAO")
	private I_Ad0215DAO ad0215DAO;

	@Override
	public int getListCount() {
		return ad0215DAO.getListCount();
	}

	@Override
	public List<BoardVO> getBoardData(int paging) {
		return ad0215DAO.getBoardData(paging);
	}

	@Override
	public int chagneNoticeStatus(int status, int no) {
		return ad0215DAO.chagneNoticeStatus(status, no);
	}

}
