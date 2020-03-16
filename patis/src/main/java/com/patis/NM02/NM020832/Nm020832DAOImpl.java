package com.patis.NM02.NM020832;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.patis.model.BoardVO;

@Repository("nm020832DAO")
public class Nm020832DAOImpl implements I_Nm020832DAO{
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	private static final String NOTICE_NAMESPACE = "Notice-Mapper";
	private static final String EVENT_ALERT_NAMESPACE = "Event_Alert-Mapper";
	private static final String EVENT_ARCHIVE_NAMESPACE = "Event_Archive-Mapper";

	@Override
	public List<BoardVO> getNoticeMainList() throws SQLException {
		return sqlSession.selectList(NOTICE_NAMESPACE + ".GET_NOTICE_MAIN_LIST");
	}
	
	@Override
	public List<BoardVO> getNoticeList(int paging) throws SQLException {
		return sqlSession.selectList(NOTICE_NAMESPACE + ".GET_NOTICE_LIST", paging);
	}
	
	@Override
	public List<BoardVO> getNoticeSearchList(Map<String, Object> params) throws SQLException {
		return sqlSession.selectList(NOTICE_NAMESPACE + ".GET_NOTICE_SEARCH_LIST", params);
	}

	@Override
	public BoardVO getNotice(int b_no) throws SQLException {
		return sqlSession.selectOne(NOTICE_NAMESPACE + ".GET_NOTICE", b_no);
	}

	@Override
	public int getNoticeListCount() throws SQLException {
		return sqlSession.selectOne(NOTICE_NAMESPACE + ".GET_NOTICE_LIST_COUNT");
	}
	
	@Override
	public int getNoticeSearchListCount(Map<String, String> params) throws SQLException {
		return sqlSession.selectOne(NOTICE_NAMESPACE + ".GET_NOTICE_SEARCH_LIST_COUNT", params);
	}

	@Override
	public String getNoticeBoardType() throws SQLException {
		String boardType = sqlSession.selectOne(NOTICE_NAMESPACE + ".GET_NOTICE_BOARD_TYPE");
		if(boardType == null)
			boardType = NOTICE_NAMESPACE.replace("-Mapper", "").toUpperCase();
		return boardType;
	}

	@Override
	public BoardVO getPrevNotice(Map<String, Object> params) throws SQLException {
		return sqlSession.selectOne(NOTICE_NAMESPACE + ".GET_PREV_NOTICE", params);
	}
	
	@Override
	public BoardVO getNextNotice(Map<String, Object> params) throws SQLException {
		return sqlSession.selectOne(NOTICE_NAMESPACE + ".GET_NEXT_NOTICE", params);
	}

	@Override
	public int modifyNoticeHitUp(int b_no) throws SQLException {
		return sqlSession.update(NOTICE_NAMESPACE + ".MODIFY_NOTICE_HIT_UP", b_no);
	}
	
	@Override
	public int setNotice(BoardVO boardVO) throws SQLException {
		return sqlSession.insert(NOTICE_NAMESPACE + ".SET_NOTICE", boardVO);
	}

	@Override
	public void modifyNotice(BoardVO boardVO) throws SQLException {
		sqlSession.update(NOTICE_NAMESPACE + ".MODIFY_NOTICE", boardVO);
	}

	@Override
	public void removeNotice(int b_no) throws SQLException {
		sqlSession.delete(NOTICE_NAMESPACE + ".REMOVE_NOTICE", b_no);
	}
	

	
	
	@Override
	public List<BoardVO> getEventAlertList(int paging) throws SQLException {
		return sqlSession.selectList(EVENT_ALERT_NAMESPACE + ".GET_EVENT_ALERT_LIST", paging);
	}
	
	@Override
	public List<BoardVO> getEventAlertSearchList(Map<String, Object> params) throws SQLException {
		return sqlSession.selectList(EVENT_ALERT_NAMESPACE + ".GET_EVENT_ALERT_SEARCH_LIST", params);
	}

	@Override
	public BoardVO getEventAlert(int b_no) throws SQLException {
		return sqlSession.selectOne(EVENT_ALERT_NAMESPACE + ".GET_EVENT_ALERT", b_no);
	}

	@Override
	public int getEventAlertListCount() throws SQLException {
		return sqlSession.selectOne(EVENT_ALERT_NAMESPACE + ".GET_EVENT_ALERT_LIST_COUNT");
	}
	
	@Override
	public int getEventAlertSearchListCount(Map<String, String> params) throws SQLException {
		return sqlSession.selectOne(EVENT_ALERT_NAMESPACE + ".GET_EVENT_ALERT_SEARCH_LIST_COUNT", params);
	}

	@Override
	public String getEventAlertBoardType() throws SQLException {
		String boardType = sqlSession.selectOne(EVENT_ALERT_NAMESPACE + ".GET_EVENT_ALERT_BOARD_TYPE");
		if(boardType == null)
			boardType = EVENT_ALERT_NAMESPACE.replace("-Mapper", "").toUpperCase();
		return boardType;
	}

	@Override
	public BoardVO getPrevEventAlert(Map<String, Object> params) throws SQLException {
		return sqlSession.selectOne(EVENT_ALERT_NAMESPACE + ".GET_PREV_EVENT_ALERT", params);
	}
	
	@Override
	public BoardVO getNextEventAlert(Map<String, Object> params) throws SQLException {
		return sqlSession.selectOne(EVENT_ALERT_NAMESPACE + ".GET_NEXT_EVENT_ALERT", params);
	}

	@Override
	public int modifyEventAlertHitUp(int b_no) throws SQLException {
		return sqlSession.update(EVENT_ALERT_NAMESPACE + ".MODIFY_EVENT_ALERT_HIT_UP", b_no);
	}
	
	@Override
	public int setEventAlert(BoardVO boardVO) throws SQLException {
		return sqlSession.insert(EVENT_ALERT_NAMESPACE + ".SET_EVENT_ALERT", boardVO);
	}

	@Override
	public void modifyEventAlert(BoardVO boardVO) throws SQLException {
		sqlSession.update(EVENT_ALERT_NAMESPACE + ".MODIFY_EVENT_ALERT", boardVO);
	}

	@Override
	public void removeEventAlert(int b_no) throws SQLException {
		sqlSession.delete(EVENT_ALERT_NAMESPACE + ".REMOVE_EVENT_ALERT", b_no);
	}
	
	
	
	
	@Override
	public List<BoardVO> getEventArchiveList(int paging) throws SQLException {
		return sqlSession.selectList(EVENT_ARCHIVE_NAMESPACE + ".GET_EVENT_ARCHIVE_LIST", paging);
	}
	
	@Override
	public List<BoardVO> getEventArchiveSearchList(Map<String, Object> params) throws SQLException {
		return sqlSession.selectList(EVENT_ARCHIVE_NAMESPACE + ".GET_EVENT_ARCHIVE_SEARCH_LIST", params);
	}

	@Override
	public BoardVO getEventArchive(int b_no) throws SQLException {
		return sqlSession.selectOne(EVENT_ARCHIVE_NAMESPACE + ".GET_EVENT_ARCHIVE", b_no);
	}

	@Override
	public int getEventArchiveListCount() throws SQLException {
		return sqlSession.selectOne(EVENT_ARCHIVE_NAMESPACE + ".GET_EVENT_ARCHIVE_LIST_COUNT");
	}
	
	@Override
	public int getEventArchiveSearchListCount(Map<String, String> params) throws SQLException {
		return sqlSession.selectOne(EVENT_ARCHIVE_NAMESPACE + ".GET_EVENT_ARCHIVE_SEARCH_LIST_COUNT", params);
	}

	@Override
	public String getEventArchiveBoardType() throws SQLException {
		String boardType = sqlSession.selectOne(EVENT_ARCHIVE_NAMESPACE + ".GET_EVENT_ARCHIVE_BOARD_TYPE");
		if(boardType == null)
			boardType = EVENT_ARCHIVE_NAMESPACE.replace("-Mapper", "").toUpperCase();
		return boardType;
	}

	@Override
	public BoardVO getPrevEventArchive(Map<String, Object> params) throws SQLException {
		return sqlSession.selectOne(EVENT_ARCHIVE_NAMESPACE + ".GET_PREV_EVENT_ARCHIVE", params);
	}
	
	@Override
	public BoardVO getNextEventArchive(Map<String, Object> params) throws SQLException {
		return sqlSession.selectOne(EVENT_ARCHIVE_NAMESPACE + ".GET_NEXT_EVENT_ARCHIVE", params);
	}

	@Override
	public int modifyEventArchiveHitUp(int b_no) throws SQLException {
		return sqlSession.update(EVENT_ARCHIVE_NAMESPACE + ".MODIFY_EVENT_ARCHIVE_HIT_UP", b_no);
	}
	
	@Override
	public int setEventArchive(BoardVO boardVO) throws SQLException {
		return sqlSession.insert(EVENT_ARCHIVE_NAMESPACE + ".SET_EVENT_ARCHIVE", boardVO);
	}

	@Override
	public void modifyEventArchive(BoardVO boardVO) throws SQLException {
		sqlSession.update(EVENT_ARCHIVE_NAMESPACE + ".MODIFY_EVENT_ARCHIVE", boardVO);
	}

	@Override
	public void removeEventArchive(int b_no) throws SQLException {
		sqlSession.delete(EVENT_ARCHIVE_NAMESPACE + ".REMOVE_EVENT_ARCHIVE", b_no);
	}

}
