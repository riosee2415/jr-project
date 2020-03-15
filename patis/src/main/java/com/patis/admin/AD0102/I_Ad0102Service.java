package com.patis.admin.AD0102;

public interface I_Ad0102Service {

	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : 2020. 3. 15.
	 * @RETURN : String
	 * @DESC   : 오늘 날짜 기준 접속자 수를 가져온다.
	 */
	String getTodayConnectData(String today);
	
}
