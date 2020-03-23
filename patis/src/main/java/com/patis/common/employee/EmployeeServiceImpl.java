package com.patis.common.employee;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.apache.commons.codec.net.URLCodec;
import org.springframework.stereotype.Service;

import com.patis.admin.AD01.I_Ad010001DAO;
import com.patis.common.mail.I_MailService;
import com.patis.middleware.I_MiddlewareService;
import com.patis.model.EmpVO;
import com.patis.util.AES256Util;


@Service("employeeService")
public class EmployeeServiceImpl implements I_EmployeeService{
	
	@Resource(name="employeeDAO")
	private I_EmployeeDAO employeeDAO;
	
	@Resource(name = "ad010001DAO")
	private  I_Ad010001DAO ad010001DAO;

	@Resource(name="middlewareService")
	private I_MiddlewareService middlewareService;
	
	@Resource(name="mailService")
	private I_MailService mailService;
	
	@Override
	public int dupleCheckId(String joinId) {
		return employeeDAO.dupleCheckId(joinId);
	}

	@Override
	public int joinUs(Map<String, String> params) throws Exception {
		String scKey = AES256Util.generateKey();
		
		
		String skey = AES256Util.getHexStringKey(scKey);
		AES256Util aes256 = new AES256Util(skey);
		URLCodec codec = new URLCodec();
	
		String encPassword = codec.encode(aes256.aesEncode((String)params.get("joinPassword")));
		
		params.put("joinPassword", encPassword);
		params.put("secretKey", scKey);
		
		return employeeDAO.joinUs(params);
	}

	@Override
	public EmpVO mainLogin(Map<String, String> params) throws Exception {
		try {
			String privateKey = ad010001DAO.getEmpSecretInfo(params).getSECRET_KEY();
			String skey = AES256Util.getHexStringKey(privateKey);
			AES256Util aes256 = new AES256Util(skey);
			URLCodec codec = new URLCodec();
		
			String encPassword = codec.encode(aes256.aesEncode((String)params.get("input_password")));
			
			middlewareService.printLog("Encoding password: " + encPassword);
			
			params.put("input_password", encPassword);
		} catch(Exception e) {
			System.out.println(e);
		}
		
		
		return employeeDAO.mainLogin(params);
	}

	@Override
	public int LOGIN_TRY_TO_ZERO(String input_id) throws Exception {
		return employeeDAO.LOGIN_TRY_TO_ZERO(input_id);
	}

	@Override
	public EmpVO getUserInfoByMypage(String input_id) throws Exception {
		return employeeDAO.getUserInfoByMypage(input_id);
	}

	@Override
	public int updateUserInfoMyPage(Map<String, String> params) {
		return employeeDAO.updateUserInfoMyPage(params);
	}

	@Override
	public String findIdType1(Map<String, String> params) {
		return employeeDAO.findIdType1(params);
	}

	@Override
	public String findPwType1(Map<String, String> params) {
		return employeeDAO.findPwType1(params);
	}

	@Override
	public void modifyEmailKey(String userId) throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("userId", userId);
		
		Random random = new Random();
		int emailKey = random.nextInt(9000) + 1000;
		params.put("emailKey", Integer.toString(emailKey));
		
		employeeDAO.modifyEmailKey(params);
		
		mailService.sendFindPwMail(userId);
	}

	@Override
	public String findIdType2(Map<String, String> params) {
		return employeeDAO.findIdType2(params);
	}

	@Override
	public EmpVO getUserInfo(String input_id) throws Exception {
		return employeeDAO.getUserInfo(input_id);
	}

	@Override
	public void modifyUserPassword(Map<String, String> params) throws Exception {
		EmpVO empVO = employeeDAO.getUserSecretInfo(params);

		String privateKey = empVO.getSECRET_KEY();
		String skey = AES256Util.getHexStringKey(privateKey);
		AES256Util aes256 = new AES256Util(skey);
		URLCodec codec = new URLCodec();
	
		String encPassword = codec.encode(aes256.aesEncode((String)params.get("userPw")));
		params.put("userPw", encPassword);
		
		employeeDAO.modifyUserPassword(params);
	}

	@Override
	public int getOnlyLogTryById(String input_id) throws Exception {
		return employeeDAO.getOnlyLogTryById(input_id);
	}

	@Override
	public int addLoginTry(Map<String, Object> params) throws Exception {
		return employeeDAO.addLoginTry(params);
	}
	
}
