package com.patis.common.file;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.patis.model.BoardFileVO;
import com.patis.model.BoardTempFileVO;

public interface I_FileDAO {

	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 13, 2020
	 * @RETURN : List<BoardFileVO>
	 * @DESC   : BOARD_TYPE, BOARD_NO에 해당하는 모든 파일 조회
	 */
	List<BoardFileVO> getFileList(Map<String, Object> params) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 15, 2020
	 * @RETURN : List<BoardFileVO>
	 * @DESC   : BOARD_TYPE, BOARD_NO에 해당하는 첨부 파일 조회
	 */
	List<BoardFileVO> getAttachFileList(Map<String, Object> params) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 13, 2020
	 * @RETURN : void
	 * @DESC   : 파일 등록
	 */
	void setFile(BoardFileVO fileVO) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : void
	 * @DESC   : 파일 삭제
	 */
	void removeFile(int file_no) throws SQLException;
	
}
