package com.patis.admin.AD0102;

import java.util.List;
import java.util.Map;

import com.patis.model.ConnectRecordVO;

public interface I_Ad0102DAO {

	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : 2020. 3. 15.
	 * @RETURN : String
	 * @DESC   : 오늘 날짜 기준 접속자 수를 가져온다.
	 */
	String getTodayConnectData(String today);
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : 2020. 3. 15.
	 * @RETURN : String
	 * @DESC   : 시작일과 종료일을 기준으로 접속자 수를 가져온다.
	 */
	String getSearchConnectData(Map<String, String> params);
	
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : 2020. 3. 15.
	 * @RETURN : List<ConnectRecordVO>
	 * @DESC   : 오늘날짜 접속통계의 디테일 정보를 가져온다.
	 */
	List<ConnectRecordVO> getTodayDetailConnectData(String today);

	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : 2020. 3. 15.
	 * @RETURN : List<ConnectRecordVO>
	 * @DESC   : 시작일과 종료일을 기준으로 디테일 정보를 가져온다.
	 */
	List<ConnectRecordVO> getSearchDetailConnectData(Map<String, String> params); 
}

