package com.patis.common.employee;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.codec.net.URLCodec;
import org.springframework.stereotype.Service;

import com.patis.util.AES256Util;


@Service("employeeService")
public class EmployeeServiceImpl implements I_EmployeeService{
	
	@Resource(name="employeeDAO")
	private I_EmployeeDAO employeeDAO;

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
	
	
}
