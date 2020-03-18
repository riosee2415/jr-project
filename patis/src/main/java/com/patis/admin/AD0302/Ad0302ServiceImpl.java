package com.patis.admin.AD0302;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.patis.model.PopupVO;

@Service("ad0302Service")
public class Ad0302ServiceImpl implements I_Ad0302Service{
	
	@Resource(name = "ad0302DAO")
	private I_Ad0302DAO ad0302DAO;

	@Override
	public List<PopupVO> getPopupList() {
		return ad0302DAO.getPopupList();
	}

	@Override
	public int popupUpload(Map<String, String> params) {
		return ad0302DAO.popupUpload(params);
	}

	@Override
	public int modifyPopupUse(Map<String, String> params) {
		return ad0302DAO.modifyPopupUse(params);
	}

	
}
