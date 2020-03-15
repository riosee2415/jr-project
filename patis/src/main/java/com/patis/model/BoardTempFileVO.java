package com.patis.model;

public class BoardTempFileVO {
	
	private int TFILE_NO;
	private String TFILE_O_PATH;
	private String TFILE_V_PATH;
	private String TFILE_KEY;
	private int ATTACH_YN;
	
	public int getTFILE_NO() {
		return TFILE_NO;
	}
	public void setTFILE_NO(int tFILE_NO) {
		TFILE_NO = tFILE_NO;
	}
	public String getTFILE_O_PATH() {
		return TFILE_O_PATH;
	}
	public void setTFILE_O_PATH(String tFILE_O_PATH) {
		TFILE_O_PATH = tFILE_O_PATH;
	}
	public String getTFILE_V_PATH() {
		return TFILE_V_PATH;
	}
	public void setTFILE_V_PATH(String tFILE_V_PATH) {
		TFILE_V_PATH = tFILE_V_PATH;
	}
	public String getTFILE_KEY() {
		return TFILE_KEY;
	}
	public void setTFILE_KEY(String tFILE_KEY) {
		TFILE_KEY = tFILE_KEY;
	}
	public int getATTACH_YN() {
		return ATTACH_YN;
	}
	public void setATTACH_YN(int aTTACH_YN) {
		ATTACH_YN = aTTACH_YN;
	}
	@Override
	public String toString() {
		return "BoardTempFileVO [TFILE_NO=" + TFILE_NO + ", TFILE_O_PATH=" + TFILE_O_PATH + ", TFILE_V_PATH="
				+ TFILE_V_PATH + ", TFILE_KEY=" + TFILE_KEY + ", ATTACH_YN=" + ATTACH_YN + "]";
	}
}
