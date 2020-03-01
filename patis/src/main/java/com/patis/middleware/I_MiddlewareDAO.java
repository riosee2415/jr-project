package com.patis.middleware;

import java.sql.SQLException;
import java.util.List;

import com.patis.model.CommonVO;

public interface I_MiddlewareDAO {
	List<CommonVO> selectCommonList() throws SQLException;
}
