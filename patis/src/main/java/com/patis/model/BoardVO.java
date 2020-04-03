package com.patis.model;

public class BoardVO {
	private String ROWNUM;
	private int B_NO;
	private String B_GUBUN;
	private String B_TITLE;
	private String B_DESCRIPTION;
	private String B_AUTHOR;
	private String B_AUTHOR_NO;
	private String B_AUTHOR_ID;
	private String B_AUTHOR_NONE;
	private String B_CREATE_TIME;
	private String B_UPLOAD_TIME;
	private int B_HIT;
	private int B_NOTICE;
	private int B_USE_YN;
	private String B_TYPE;
	private String B_DELETE_TIME;
	private String B_THUMB_PATH;
	private String B_REPLY;
	private String B_REPLY_STATE;
	private String B_REPLY_TIME;
	private String B_REPLY_AUTHOR;
	private int B_REPLY_HIT;
	
	public String getROWNUM() {
		return ROWNUM;
	}
	public void setROWNUM(String rOWNUM) {
		ROWNUM = rOWNUM;
	}
	public String getB_DELETE_TIME() {
		return B_DELETE_TIME;
	}	
	public void setB_DELETE_TIME(String b_DELETE_TIME) {
		B_DELETE_TIME = b_DELETE_TIME;
	}
	public int getB_NO() {
		return B_NO;
	}
	public void setB_NO(int b_NO) {
		B_NO = b_NO;
	}
	public String getB_GUBUN() {
		return B_GUBUN;
	}
	public void setB_GUBUN(String b_GUBUN) {
		B_GUBUN = b_GUBUN;
	}
	public String getB_TITLE() {
		return B_TITLE;
	}
	public void setB_TITLE(String b_TITLE) {
		B_TITLE = b_TITLE;
	}
	public String getB_DESCRIPTION() {
		return B_DESCRIPTION;
	}
	public void setB_DESCRIPTION(String b_DESCRIPTION) {
		B_DESCRIPTION = b_DESCRIPTION;
	}
	public String getB_AUTHOR() {
		return B_AUTHOR;
	}
	public void setB_AUTHOR(String b_AUTHOR) {
		B_AUTHOR = b_AUTHOR;
	}
	public String getB_AUTHOR_NO() {
		return B_AUTHOR_NO;
	}
	public void setB_AUTHOR_NO(String b_AUTHOR_NO) {
		B_AUTHOR_NO = b_AUTHOR_NO;
	}
	public String getB_AUTHOR_ID() {
		return B_AUTHOR_ID;
	}
	public void setB_AUTHOR_ID(String b_AUTHOR_ID) {
		B_AUTHOR_ID = b_AUTHOR_ID;
	}
	public String getB_AUTHOR_NONE() {
		return B_AUTHOR_NONE;
	}
	public void setB_AUTHOR_NONE(String b_AUTHOR_NONE) {
		B_AUTHOR_NONE = b_AUTHOR_NONE;
	}
	public String getB_CREATE_TIME() {
		return B_CREATE_TIME;
	}
	public void setB_CREATE_TIME(String b_CREATE_TIME) {
		B_CREATE_TIME = b_CREATE_TIME;
	}
	public String getB_UPLOAD_TIME() {
		return B_UPLOAD_TIME;
	}
	public void setB_UPLOAD_TIME(String b_UPLOAD_TIME) {
		B_UPLOAD_TIME = b_UPLOAD_TIME;
	}
	public int getB_HIT() {
		return B_HIT;
	}
	public void setB_HIT(int b_HIT) {
		B_HIT = b_HIT;
	}
	public int getB_NOTICE() {
		return B_NOTICE;
	}
	public void setB_NOTICE(int b_NOTICE) {
		B_NOTICE = b_NOTICE;
	}
	public int getB_USE_YN() {
		return B_USE_YN;
	}
	public void setB_USE_YN(int b_USE_YN) {
		B_USE_YN = b_USE_YN;
	}
	public String getB_TYPE() {
		return B_TYPE;
	}
	public void setB_TYPE(String b_TYPE) {
		B_TYPE = b_TYPE;
	}
	public String getB_THUMB_PATH() {
		return B_THUMB_PATH;
	}
	public void setB_THUMB_PATH(String b_THUMG_PATH) {
		B_THUMB_PATH = b_THUMG_PATH;
	}
	public String getB_REPLY() {
		return B_REPLY;
	}
	public void setB_REPLY(String b_REPLY) {
		B_REPLY = b_REPLY;
	}
	public String getB_REPLY_STATE() {
		return B_REPLY_STATE;
	}
	public void setB_REPLY_STATE(String b_REPLY_STATE) {
		B_REPLY_STATE = b_REPLY_STATE;
	}
	public String getB_REPLY_TIME() {
		return B_REPLY_TIME;
	}
	public void setB_REPLY_TIME(String b_REPLY_TIME) {
		B_REPLY_TIME = b_REPLY_TIME;
	}
	public String getB_REPLY_AUTHOR() {
		return B_REPLY_AUTHOR;
	}
	public void setB_REPLY_AUTHOR(String b_REPLY_AUTHOR) {
		B_REPLY_AUTHOR = b_REPLY_AUTHOR;
	}
	public int getB_REPLY_HIT() {
		return B_REPLY_HIT;
	}
	public void setB_REPLY_HIT(int b_REPLY_HIT) {
		B_REPLY_HIT = b_REPLY_HIT;
	}
	@Override
	public String toString() {
		return "BoardVO [ROWNUM=" + ROWNUM + ", B_NO=" + B_NO + ", B_GUBUN=" + B_GUBUN + ", B_TITLE=" + B_TITLE
				+ ", B_DESCRIPTION=" + B_DESCRIPTION + ", B_AUTHOR=" + B_AUTHOR + ", B_AUTHOR_NO=" + B_AUTHOR_NO
				+ ", B_AUTHOR_ID=" + B_AUTHOR_ID + ", B_AUTHOR_NONE=" + B_AUTHOR_NONE + ", B_CREATE_TIME="
				+ B_CREATE_TIME + ", B_UPLOAD_TIME=" + B_UPLOAD_TIME + ", B_HIT=" + B_HIT + ", B_NOTICE=" + B_NOTICE
				+ ", B_USE_YN=" + B_USE_YN + ", B_TYPE=" + B_TYPE + ", B_DELETE_TIME=" + B_DELETE_TIME
				+ ", B_THUMB_PATH=" + B_THUMB_PATH + ", B_REPLY=" + B_REPLY + ", B_REPLY_STATE=" + B_REPLY_STATE
				+ ", B_REPLY_TIME=" + B_REPLY_TIME + ", B_REPLY_AUTHOR=" + B_REPLY_AUTHOR + ", B_REPLY_HIT="
				+ B_REPLY_HIT + "]";
	}
	
}
