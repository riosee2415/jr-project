package com.patis.common.file;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.patis.model.BoardFileVO;
import com.patis.model.BoardTempFileVO;
import com.patis.model.CommentsVO;

@Repository("fileService")
public class FileServiceImpl implements I_FileService {
	
	@Resource(name="fileDAO")
	private I_FileDAO fileDAO;

	@Override
	public List<BoardFileVO> getFileList(Map<String, Object> params) throws SQLException {
		return fileDAO.getFileList(params);
	}
	
	@Override
	public List<BoardFileVO> getAttachFileList(Map<String, Object> params) throws SQLException {
		return fileDAO.getAttachFileList(params);
	}

	@Override
	public void setFile(BoardFileVO fileVO) throws SQLException {
		fileDAO.setFile(fileVO);
	}

	@Override
	public void removeFile(int file_no) throws SQLException {
		fileDAO.removeFile(file_no);
	}

}
