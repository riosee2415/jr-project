package com.patis.model;

public class BoardFileVO {
	private int FILE_NO;
	private String FILE_O_PATH;
	private String FILE_V_PATH;
	private int BOARD_NO;
	private String BOARD_TYPE;
	private int ATTACH_YN;
	
	public int getFILE_NO() {
		return FILE_NO;
	}
	public void setFILE_NO(int fILE_NO) {
		FILE_NO = fILE_NO;
	}
	public String getFILE_O_PATH() {
		return FILE_O_PATH;
	}
	public void setFILE_O_PATH(String fILE_O_PATH) {
		FILE_O_PATH = fILE_O_PATH;
	}
	public String getFILE_V_PATH() {
		return FILE_V_PATH;
	}
	public void setFILE_V_PATH(String fILE_V_PATH) {
		FILE_V_PATH = fILE_V_PATH;
	}
	public int getBOARD_NO() {
		return BOARD_NO;
	}
	public void setBOARD_NO(int bOARD_NO) {
		BOARD_NO = bOARD_NO;
	}
	public String getBOARD_TYPE() {
		return BOARD_TYPE;
	}
	public void setBOARD_TYPE(String bOARD_TYPE) {
		BOARD_TYPE = bOARD_TYPE;
	}
	public int getATTACH_YN() {
		return ATTACH_YN;
	}
	public void setATTACH_YN(int aTTACH_YN) {
		ATTACH_YN = aTTACH_YN;
	}
	@Override
	public String toString() {
		return "BoardFileVO [FILE_NO=" + FILE_NO + ", FILE_O_PATH=" + FILE_O_PATH + ", FILE_V_PATH=" + FILE_V_PATH
				+ ", BOARD_NO=" + BOARD_NO + ", BOARD_TYPE=" + BOARD_TYPE + ", ATTACH_YN=" + ATTACH_YN + "]";
	}
}
