package com.patis.admin.AD0302;

import java.util.List;
import java.util.Map;

import com.patis.model.PopupVO;

public interface I_Ad0302Service {

	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : 2020. 3. 18.
	 * @RETURN : List<PopupVO>
	 * @DESC   : 팝업 리스트를 가져온다.
	 */
	List<PopupVO> getPopupList();

	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : 2020. 3. 18.
	 * @RETURN : int
	 * @DESC   : 팝업 수정하기
	 */
	int popupUpload(Map<String, String> params);
	
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : 2020. 3. 18.
	 * @RETURN : int
	 * @DESC   : 팝업 사용중/미사용 처리
	 */
	int modifyPopupUse(Map<String, String> params);
}
