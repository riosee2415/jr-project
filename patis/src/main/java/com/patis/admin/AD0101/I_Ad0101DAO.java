package com.patis.admin.AD0101;

import java.util.List;
import java.util.Map;

import com.patis.model.LoginLogVO;

public interface I_Ad0101DAO {
	
	/**
	 * @AUTHOR : 4LEAF.YSH
	 * @DATE   : Mar 8, 2020
	 * @RETURN : List<LoginLogVO>
	 * @DES    : 로그인 정보를 가져오는 함수
	 */
	List<LoginLogVO> getLogData(int paging);


	/**
	 * @AUTHOR : 4LEAF.YSH
	 * @DATE   : Mar 8, 2020
	 * @RETURN : int
	 * @DES    : 데이터를 카운팅 하여 리턴
	 */
	int getListCount();
	
	
	/**
	 * @AUTHOR : 4LEAF.YSH
	 * @DATE   : 2020. 3. 23.
	 * @RETURN : int
	 * @DESC   : 오늘날짜 로그인 기록을 가져온다.
	 */
	String getTodayLoginData(String today) throws Exception;
	
	/**
	 * @AUTHOR : 4LEAF.YSH
	 * @DATE   : 2020. 3. 23.
	 * @RETURN : List<LoginLogVO>
	 * @DESC   : 오늘날짜 로그인 상세기록을 가져온다.
	 */
	List<LoginLogVO> getTodayDetailLoginData(String today)  throws Exception;
	
	 
	
	/**
	 * @AUTHOR : 4LEAF.YSH
	 * @DATE   : 2020. 3. 23.
	 * @RETURN : String
	 * @DESC   : 시작일과 종료일을 기준으로 로그인기록을 카운팅 한다.
	 */
	String getSearchLoginData(Map<String, String> params) throws Exception;
	
	
	/**
	 * @AUTHOR : 4LEAF.YSH
	 * @DATE   : 2020. 3. 23.
	 * @RETURN : List<LoginLogVO>
	 * @DESC   : 시작일과 종료일을 기준으로 데이터를 가져온다.
	 */
	List<LoginLogVO> getSearchDetailLoginData(Map<String, String> params) throws Exception;
}
