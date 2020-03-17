package com.patis.model;

public class Accept_typeVO {
	private String BOARD_TYPE;
	private String VIEW_RIGHT;
	private String WRITE_RIGHT;
	private String BOARD_NAME;
	private String BOARD_CONTROLL_RIGHT;
	
	
	
	public String getBOARD_NAME() {
		return BOARD_NAME;
	}
	public void setBOARD_NAME(String bOARD_NAME) {
		BOARD_NAME = bOARD_NAME;
	}
	public String getBOARD_CONTROLL_RIGHT() {
		return BOARD_CONTROLL_RIGHT;
	}
	public void setBOARD_CONTROLL_RIGHT(String bOARD_CONTROLL_RIGHT) {
		BOARD_CONTROLL_RIGHT = bOARD_CONTROLL_RIGHT;
	}
	public String getBOARD_TYPE() {
		return BOARD_TYPE;
	}
	public void setBOARD_TYPE(String bOARD_TYPE) {
		BOARD_TYPE = bOARD_TYPE;
	}
	public String getVIEW_RIGHT() {
		return VIEW_RIGHT;
	}
	public void setVIEW_RIGHT(String vIEW_RIGHT) {
		VIEW_RIGHT = vIEW_RIGHT;
	}
	public String getWRITE_RIGHT() {
		return WRITE_RIGHT;
	}
	public void setWRITE_RIGHT(String wRITE_RIGHT) {
		WRITE_RIGHT = wRITE_RIGHT;
	}
	@Override
	public String toString() {
		return "Accept_typeVO [BOARD_TYPE=" + BOARD_TYPE + ", VIEW_RIGHT=" + VIEW_RIGHT + ", WRITE_RIGHT=" + WRITE_RIGHT
				+ "]";
	}
}
