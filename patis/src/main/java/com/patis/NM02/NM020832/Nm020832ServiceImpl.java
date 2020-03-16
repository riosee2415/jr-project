package com.patis.NM02.NM020832;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.patis.model.BoardVO;

@Service("nm020832Service")
public class Nm020832ServiceImpl implements I_Nm020832Service{
	
	@Resource(name = "nm020832DAO")
	private  I_Nm020832DAO nm020832DAO;

	@Override
	public List<BoardVO> getNoticeMainList() throws SQLException {
		return nm020832DAO.getNoticeMainList();
	}
	
	@Override
	public List<BoardVO> getNoticeList(int paging) throws SQLException {
		return nm020832DAO.getNoticeList(paging);
	}

	@Override
	public List<BoardVO> getNoticeSearchList(Map<String, Object> params) throws SQLException {
		return nm020832DAO.getNoticeSearchList(params);
	}

	@Override
	public BoardVO getNotice(int b_no) throws SQLException {
		return nm020832DAO.getNotice(b_no);
	}

	@Override
	public int getNoticeListCount() throws SQLException {
		return nm020832DAO.getNoticeListCount();
	}

	@Override
	public int getNoticeSearchListCount(Map<String, String> params) throws SQLException {
		return nm020832DAO.getNoticeSearchListCount(params);
	}

	@Override
	public String getNoticeBoardType() throws SQLException {
		return nm020832DAO.getNoticeBoardType();
	}

	@Override
	public BoardVO getPrevNotice(Map<String, Object> params) throws SQLException {
		return nm020832DAO.getPrevNotice(params);
	}

	@Override
	public BoardVO getNextNotice(Map<String, Object> params) throws SQLException {
		return nm020832DAO.getNextNotice(params);
	}

	@Override
	public int modifyNoticeHitUp(int b_no) throws SQLException {
		return nm020832DAO.modifyNoticeHitUp(b_no);
	}

	@Override
	public int setNotice(BoardVO boardVO) throws SQLException {
		return nm020832DAO.setNotice(boardVO);
	}

	@Override
	public void modifyNotice(BoardVO boardVO) throws SQLException {
		nm020832DAO.modifyNotice(boardVO);
	}

	@Override
	public void removeNotice(int b_no) throws SQLException {
		nm020832DAO.removeNotice(b_no);
	}
	
	
	
	
	@Override
	public List<BoardVO> getEventAlertList(int paging) throws SQLException {
		return nm020832DAO.getEventAlertList(paging);
	}

	@Override
	public List<BoardVO> getEventAlertSearchList(Map<String, Object> params) throws SQLException {
		return nm020832DAO.getEventAlertSearchList(params);
	}

	@Override
	public BoardVO getEventAlert(int b_no) throws SQLException {
		return nm020832DAO.getEventAlert(b_no);
	}

	@Override
	public int getEventAlertListCount() throws SQLException {
		return nm020832DAO.getEventAlertListCount();
	}

	@Override
	public int getEventAlertSearchListCount(Map<String, String> params) throws SQLException {
		return nm020832DAO.getEventAlertSearchListCount(params);
	}

	@Override
	public String getEventAlertBoardType() throws SQLException {
		return nm020832DAO.getEventAlertBoardType();
	}

	@Override
	public BoardVO getPrevEventAlert(Map<String, Object> params) throws SQLException {
		return nm020832DAO.getPrevEventAlert(params);
	}

	@Override
	public BoardVO getNextEventAlert(Map<String, Object> params) throws SQLException {
		return nm020832DAO.getNextEventAlert(params);
	}

	@Override
	public int modifyEventAlertHitUp(int b_no) throws SQLException {
		return nm020832DAO.modifyEventAlertHitUp(b_no);
	}

	@Override
	public int setEventAlert(BoardVO boardVO) throws SQLException {
		return nm020832DAO.setEventAlert(boardVO);
	}

	@Override
	public void modifyEventAlert(BoardVO boardVO) throws SQLException {
		nm020832DAO.modifyEventAlert(boardVO);
	}

	@Override
	public void removeEventAlert(int b_no) throws SQLException {
		nm020832DAO.removeEventAlert(b_no);
	}
	
	
	
	
	@Override
	public List<BoardVO> getEventArchiveList(int paging) throws SQLException {
		return nm020832DAO.getEventArchiveList(paging);
	}

	@Override
	public List<BoardVO> getEventArchiveSearchList(Map<String, Object> params) throws SQLException {
		return nm020832DAO.getEventArchiveSearchList(params);
	}

	@Override
	public BoardVO getEventArchive(int b_no) throws SQLException {
		return nm020832DAO.getEventArchive(b_no);
	}

	@Override
	public int getEventArchiveListCount() throws SQLException {
		return nm020832DAO.getEventArchiveListCount();
	}

	@Override
	public int getEventArchiveSearchListCount(Map<String, String> params) throws SQLException {
		return nm020832DAO.getEventArchiveSearchListCount(params);
	}

	@Override
	public String getEventArchiveBoardType() throws SQLException {
		return nm020832DAO.getEventArchiveBoardType();
	}

	@Override
	public BoardVO getPrevEventArchive(Map<String, Object> params) throws SQLException {
		return nm020832DAO.getPrevEventArchive(params);
	}

	@Override
	public BoardVO getNextEventArchive(Map<String, Object> params) throws SQLException {
		return nm020832DAO.getNextEventArchive(params);
	}

	@Override
	public int modifyEventArchiveHitUp(int b_no) throws SQLException {
		return nm020832DAO.modifyEventArchiveHitUp(b_no);
	}

	@Override
	public int setEventArchive(BoardVO boardVO) throws SQLException {
		return nm020832DAO.setEventArchive(boardVO);
	}

	@Override
	public void modifyEventArchive(BoardVO boardVO) throws SQLException {
		nm020832DAO.modifyEventArchive(boardVO);
	}

	@Override
	public void removeEventArchive(int b_no) throws SQLException {
		nm020832DAO.removeEventArchive(b_no);
	}


}
