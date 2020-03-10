package com.patis.model;

public class CommentsVO {
	
	private int CO_NO;
	private String CO_BOARD_TYPE;
    private int CO_PARENT_NO;
    private String CO_DESCRIPTION;
    private String CO_CREATE_TIME;
    private int CO_USE_YN;
    private String CO_AUTHOR;
    
    
	public String getCO_AUTHOR() {
		return CO_AUTHOR;
	}
	public void setCO_AUTHOR(String cO_AUTHOR) {
		CO_AUTHOR = cO_AUTHOR;
	}
	public int getCO_NO() {
		return CO_NO;
	}
	public void setCO_NO(int cO_NO) {
		CO_NO = cO_NO;
	}
	public String getCO_BOARD_TYPE() {
		return CO_BOARD_TYPE;
	}
	public void setCO_BOARD_TYPE(String cO_BOARD_TYPE) {
		CO_BOARD_TYPE = cO_BOARD_TYPE;
	}
	public int getCO_PARENT_NO() {
		return CO_PARENT_NO;
	}
	public void setCO_PARENT_NO(int cO_PARENT_NO) {
		CO_PARENT_NO = cO_PARENT_NO;
	}
	public String getCO_DESCRIPTION() {
		return CO_DESCRIPTION;
	}
	public void setCO_DESCRIPTION(String cO_DESCRIPTION) {
		CO_DESCRIPTION = cO_DESCRIPTION;
	}
	public String getCO_CREATE_TIME() {
		return CO_CREATE_TIME;
	}
	public void setCO_CREATE_TIME(String cO_CREATE_TIME) {
		CO_CREATE_TIME = cO_CREATE_TIME;
	}
	public int getCO_USE_YN() {
		return CO_USE_YN;
	}
	public void setCO_USE_YN(int cO_USE_YN) {
		CO_USE_YN = cO_USE_YN;
	}

    
    
}
