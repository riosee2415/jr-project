package com.patis.admin.AD0302;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.patis.model.PopupVO;

@Repository("ad0302DAO")
public class Ad0302DAOImpl implements I_Ad0302DAO{
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "AdminPopup-Mapper";

	@Override
	public List<PopupVO> getPopupList() {
		return sqlSession.selectList(NAMESPACE + ".GET_ALL_POPUP");
	}

	@Override
	public int popupUpload(Map<String, String> params) {
		return sqlSession.update(NAMESPACE + ".MODIFY_POPUP", params);
	}

	@Override
	public int modifyPopupUse(Map<String, String> params) {
		return sqlSession.update(NAMESPACE + ".MODIFY_USE", params);
	}

}
