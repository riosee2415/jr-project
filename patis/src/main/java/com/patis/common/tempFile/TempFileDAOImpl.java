package com.patis.common.tempFile;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.patis.model.BoardTempFileVO;
import com.patis.model.CommentsVO;

@Repository("tempFileDAO")
public class TempFileDAOImpl implements I_TempFileDAO {
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "TempFile-Mapper";

	@Override
	public List<BoardTempFileVO> getTempFileListByKey(String TFILE_KEY) throws SQLException {
		return sqlSession.selectList(NAMESPACE + ".GET_TEMP_FILE_LIST_BY_KEY", TFILE_KEY);
	}

	@Override
	public void setTempFile(BoardTempFileVO tempFileVO) throws SQLException {
		sqlSession.insert(NAMESPACE + ".SET_TEMP_FILE", tempFileVO);
	}

	@Override
	public void removeTempFile(String TFILE_KEY) throws SQLException {
		sqlSession.delete(NAMESPACE + ".REMOVE_TEMP_FILE", TFILE_KEY);
	}
	
}
