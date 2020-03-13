package com.patis.common.tempFile;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.patis.model.BoardTempFileVO;
import com.patis.model.CommentsVO;

public interface I_TempFileService {

	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 13, 2020
	 * @RETURN : List<BoardTempFileVO>
	 * @DESC   : 키 값으로 임시 파일 목록 조회 
	 */
	List<BoardTempFileVO> getTempFileListByKey(String TFILE_KEY) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 13, 2020
	 * @RETURN : void
	 * @DESC   : 임시 파일 생성
	 */
	void setTempFile(BoardTempFileVO tempFileVO) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 13, 2020
	 * @RETURN : void
	 * @DESC   : 키 값으로 임시 파일 제거
	 */
	void removeTempFile(String TFILE_KEY) throws SQLException;
	
}
