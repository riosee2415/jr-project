package com.patis.model;

public class LoginLogVO {
	private String LOG_NO;
	private String LOG_ID;
	private String LOG_IP;
	private String LOG_DATE;
	public String getLOG_NO() {
		return LOG_NO;
	}
	public void setLOG_NO(String lOG_NO) {
		LOG_NO = lOG_NO;
	}
	public String getLOG_ID() {
		return LOG_ID;
	}
	public void setLOG_ID(String lOG_ID) {
		LOG_ID = lOG_ID;
	}
	public String getLOG_IP() {
		return LOG_IP;
	}
	public void setLOG_IP(String lOG_IP) {
		LOG_IP = lOG_IP;
	}
	public String getLOG_DATE() {
		return LOG_DATE;
	}
	public void setLOG_DATE(String lOG_DATE) {
		LOG_DATE = lOG_DATE;
	}
	@Override
	public String toString() {
		return "LoginLogVO [LOG_NO=" + LOG_NO + ", LOG_ID=" + LOG_ID + ", LOG_IP=" + LOG_IP + ", LOG_DATE=" + LOG_DATE
				+ "]";
	}
	
}
