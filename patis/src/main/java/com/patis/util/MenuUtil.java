package com.patis.util;

public class MenuUtil {

	public static String getBoardName(String btype) {
		String name = null;
		
		switch(btype) {
		case "STATUTE":
			name = "도시재생 관계 법령";
			break;
		case "COMMUNITY":
			name = "마을 커뮤니티";
			break;
		case "NOTICE":
			name = "공지사항";
			break;
		case "EVENT_ALERT":
			name = "행사알림";
			break;
		case "EVENT_ARCHIVE":
			name = "행사자료";
			break;
		case "RELEASE":
			name = "보도자료";
			break;
		case "YARD_OFFICE":
			name = "구청";
			break;
		case "YARD_SUPPORT":
			name = "현장지원센터";
			break;
		case "HIRE":
			name = "채용공고";
			break;
		case "EDU_OFFICE":
			name = "구청";
			break;
		case "EDU_SUPPORT":
			name = "현장지원센터";
			break;
		case "CALENDAR":
			name = "교육 연간일정표";
			break;
		case "CALENDAR_APPLY":
			name = "교육 일정등록 및 신청";
			break;
		case "PRESENTATION":
			name = "주민설명회";
			break;
		case "COLLUSION":
			name = "공모사업 신청";
			break;
		}
		return name;
	}
}
