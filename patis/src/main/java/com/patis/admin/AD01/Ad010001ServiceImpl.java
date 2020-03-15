package com.patis.admin.AD01;

import java.sql.SQLException;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.codec.net.URLCodec;
import org.springframework.stereotype.Service;

import com.patis.middleware.I_MiddlewareService;
import com.patis.model.EmpVO;
import com.patis.util.AES256Util;

@Service("ad010001Service")
public class Ad010001ServiceImpl implements I_Ad010001Service{

	
	@Resource(name = "ad010001DAO")
	private  I_Ad010001DAO ad010001DAO;
	
	@Resource(name="middlewareService")
	private I_MiddlewareService middlewareService;
	
	@Override
	public int adminLoginCheck(Map<String, String> info) throws SQLException {
		return ad010001DAO.adminLoginCheck(info);
	}

	@Override
	public int adminLoginCheck2(Map<String, String> info) throws SQLException {
		try {
			String privateKey = ad010001DAO.getEmpSecretInfo(info).getSECRET_KEY();
			String skey = AES256Util.getHexStringKey(privateKey);
			AES256Util aes256 = new AES256Util(skey);
			URLCodec codec = new URLCodec();
		
			String encPassword = codec.encode(aes256.aesEncode((String)info.get("input_password")));
			
			middlewareService.printLog("Encoding password: " + encPassword);
			
			info.put("input_password", encPassword);
		} catch(Exception e) {
			System.out.println(e);
		}
		return ad010001DAO.adminLoginCheck2(info);
	}

	@Override
	public int saveLoginData(Map<String, String> info) throws SQLException {
		return ad010001DAO.saveLoginData(info);
	}

	@Override
	public EmpVO getEmpInfo(Map<String, String> info) throws SQLException {
		return ad010001DAO.getEmpInfo(info);
	}

	@Override
	public int lookupConnectReport(Map<String, String> params) {
		return ad010001DAO.lookupConnectReport(params);
	}

	@Override
	public int addConnectReport(Map<String, String> params) {
		return ad010001DAO.addConnectReport(params);
	}

}
