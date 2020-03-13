package com.patis.common.tempFile;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.patis.model.BoardTempFileVO;
import com.patis.model.CommentsVO;

@Repository("tempFileService")
public class TempFileServiceImpl implements I_TempFileService {
	
	@Resource(name="tempFileDAO")
	private I_TempFileDAO tempFileDAO;

	@Override
	public List<BoardTempFileVO> getTempFileListByKey(String TFILE_KEY) throws SQLException {
		return tempFileDAO.getTempFileListByKey(TFILE_KEY);
	}

	@Override
	public void setTempFile(BoardTempFileVO tempFileVO) throws SQLException {
		tempFileDAO.setTempFile(tempFileVO);
	}

	@Override
	public void removeTempFile(String TFILE_KEY) throws SQLException {
		tempFileDAO.removeTempFile(TFILE_KEY);
	}
	
}
