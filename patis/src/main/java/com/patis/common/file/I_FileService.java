package com.patis.common.file;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.patis.model.BoardFileVO;
import com.patis.model.BoardTempFileVO;
import com.patis.model.CommentsVO;

public interface I_FileService {

	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 13, 2020
	 * @RETURN : List<BoardFileVO>
	 * @DESC   : BOARD_TYPE, BOARD_NO에 해당하는 파일 조회
	 */
	List<BoardFileVO> getFileList(Map<String, Object> params) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 13, 2020
	 * @RETURN : void
	 * @DESC   : 파일 등록
	 */
	void setFile(BoardFileVO fileVO) throws SQLException;
	
}
