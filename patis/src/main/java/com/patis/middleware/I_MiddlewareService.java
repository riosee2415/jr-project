package com.patis.middleware;

import java.sql.SQLException;
import java.util.List;

import com.patis.model.Accept_typeVO;
import com.patis.model.CommonVO;
import com.patis.model.PopupVO;

public interface I_MiddlewareService {
	/**
	 * @AUTHOR : 4LEAF.YSH
	 * @DATE   : Mar 2, 2020
	 * @RETURN : List<CommonVO>
	 * @DES    : 테스트를 위한 COMMON 테이블 조회
	 */
	List<CommonVO> selectCommonList() throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.YSH
	 * @DATE   : Mar 2, 2020
	 * @RETURN : List<CommonVO>
	 * @DESC   : 화면 로드 시 COMMON에서 MENU를 가져온다.
	 */
	List<CommonVO> getMenu() throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.YSH
	 * @DATE   : Mar 2, 2020
	 * @RETURN : List<CommonVO>
	 * @DESC   : 화면 로드 시 COMMON에서 MENU를 가져온다.
	 */
	List<CommonVO> getSubMenu() throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.YSH
	 * @DATE   : Mar 2, 2020
	 * @RETURN : List<CommonVO>
	 * @DESC   : 화면 로드 시 COMMON에서 DETAIL_MENU를 가져온다.
	 */
	List<CommonVO> getDetailMenu() throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.YSH
	 * @DATE   : Mar 4, 2020
	 * @RETURN : void
	 * @DESC   : 로그를 출력하는 함수
	 */
	void printLog(String text);
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : Accept_typeVO
	 * @DESC   : 게시판별 권한 정보를 가져온다.
	 */
	Accept_typeVO getAcceptRight(String BOARD_TYPE) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : 2020. 3. 16.
	 * @RETURN : List<CommonVO>
	 * @DESC   : 콤보박스에 사용할 데이터를 가져온다.
	 */
	List<CommonVO> getComboData(String code) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : 2020. 3. 18.
	 * @RETURN : List<PopupVO>
	 * @DESC   : 사용중인 팝업 데이터를 가져온다.
	 */
	List<PopupVO> getUsedPopup();
}
