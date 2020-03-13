package com.patis.common.file;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.patis.model.BoardFileVO;

@Repository("fileDAO")
public class FileDAOImpl implements I_FileDAO {
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "File-Mapper";

	public List<BoardFileVO> getFileList(Map<String, Object> params) throws SQLException {
		return sqlSession.selectList(NAMESPACE + ".GET_FILE_LIST", params);
	}
	
	public void setFile(BoardFileVO fileVO) throws SQLException {
		sqlSession.insert(NAMESPACE + ".SET_FILE", fileVO);
	}
	
}
