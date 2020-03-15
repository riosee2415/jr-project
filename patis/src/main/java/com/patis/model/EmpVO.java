package com.patis.model;

public class EmpVO {
	
	private int USER_NO;
	private String USER_ID; 
	private String USER_PASSWORD;
	private String USER_NAME;
	private String USER_DEPARTMENT;
	private int USER_RIGHT;
	private String USER_GROUP;
	private String PASS_HINT;
	private String HINT_ANSWER;
	private int USER_TEL;
	private int USER_MOBILE;
	private String USER_AVATAR;
	private String USER_EMAIL;
	private String SECRET_KEY;
	
	public int getUSER_NO() {
		return USER_NO;
	}
	public void setUSER_NO(int uSER_NO) {
		USER_NO = uSER_NO;
	}
	public String getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}
	public String getUSER_PASSWORD() {
		return USER_PASSWORD;
	}
	public void setUSER_PASSWORD(String uSER_PASSWORD) {
		USER_PASSWORD = uSER_PASSWORD;
	}
	public String getUSER_NAME() {
		return USER_NAME;
	}
	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}
	public String getUSER_DEPARTMENT() {
		return USER_DEPARTMENT;
	}
	public void setUSER_DEPARTMENT(String uSER_DEPARTMENT) {
		USER_DEPARTMENT = uSER_DEPARTMENT;
	}
	public int getUSER_RIGHT() {
		return USER_RIGHT;
	}
	public void setUSER_RIGHT(int uSER_RIGHT) {
		USER_RIGHT = uSER_RIGHT;
	}
	public String getUSER_GROUP() {
		return USER_GROUP;
	}
	public void setUSER_GROUP(String uSER_GROUP) {
		USER_GROUP = uSER_GROUP;
	}
	public String getPASS_HINT() {
		return PASS_HINT;
	}
	public void setPASS_HINT(String pASS_HINT) {
		PASS_HINT = pASS_HINT;
	}
	public String getHINT_ANSWER() {
		return HINT_ANSWER;
	}
	public void setHINT_ANSWER(String hINT_ANSWER) {
		HINT_ANSWER = hINT_ANSWER;
	}
	public int getUSER_TEL() {
		return USER_TEL;
	}
	public void setUSER_TEL(int uSER_TEL) {
		USER_TEL = uSER_TEL;
	}
	public int getUSER_MOBILE() {
		return USER_MOBILE;
	}
	public void setUSER_MOBILE(int uSER_MOBILE) {
		USER_MOBILE = uSER_MOBILE;
	}
	public String getUSER_AVATAR() {
		return USER_AVATAR;
	}
	public void setUSER_AVATAR(String uSER_AVATAR) {
		USER_AVATAR = uSER_AVATAR;
	}
	public String getUSER_EMAIL() {
		return USER_EMAIL;
	}
	public void setUSER_EMAIL(String uSER_EMAIL) {
		USER_EMAIL = uSER_EMAIL;
	}
	public String getSECRET_KEY() {
		return SECRET_KEY;
	}
	public void setSECRET_KEY(String sECRET_KEY) {
		SECRET_KEY = sECRET_KEY;
	}
	@Override
	public String toString() {
		return "EmpVO [USER_NO=" + USER_NO + ", USER_ID=" + USER_ID + ", USER_PASSWORD=" + USER_PASSWORD
				+ ", USER_NAME=" + USER_NAME + ", USER_DEPARTMENT=" + USER_DEPARTMENT + ", USER_RIGHT=" + USER_RIGHT
				+ ", USER_GROUP=" + USER_GROUP + ", PASS_HINT=" + PASS_HINT + ", HINT_ANSWER=" + HINT_ANSWER
				+ ", USER_TEL=" + USER_TEL + ", USER_MOBILE=" + USER_MOBILE + ", USER_AVATAR=" + USER_AVATAR
				+ ", USER_EMAIL=" + USER_EMAIL + ", SECRET_KEY=" + SECRET_KEY + "]";
	}

}
