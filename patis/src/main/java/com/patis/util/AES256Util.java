package com.patis.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

public class AES256Util {
	private String iv;
	private Key keySpec;

	public AES256Util(String key) throws UnsupportedEncodingException {
		this.iv = key.substring(0, 16);

		byte[] keyBytes = new byte[16];
		byte[] b = key.getBytes("UTF-8");
		int len = b.length;
		if (len > keyBytes.length) {
			len = keyBytes.length;
		}
		System.arraycopy(b, 0, keyBytes, 0, len);
		SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");

		this.keySpec = keySpec;
	}

	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 5, 2020
	 * @RETURN : String
	 * @DESC   : 인자로 들어온 값을 AES256으로 암호화
	 */
	public String aesEncode(String data)
			throws java.io.UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
		c.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(iv.getBytes()));

		byte[] encrypted = c.doFinal(data.getBytes("UTF-8"));
		String enStr = new String(Base64.encodeBase64(encrypted));

		return enStr;
	}

	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 5, 2020
	 * @RETURN : String
	 * @DESC   : AES256으로 암호화된 값을 복호화
	 */
	public String aesDecode(String data)
			throws java.io.UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
		c.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(iv.getBytes("UTF-8")));

		byte[] byteStr = Base64.decodeBase64(data.getBytes());

		return new String(c.doFinal(byteStr), "UTF-8");
	}

	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 5, 2020
	 * @RETURN : String
	 * @DESC   : AES256으로 랜덤 키 생성
	 */
	public static String generateKey() throws Exception {
		KeyGenerator kgen = KeyGenerator.getInstance("AES");
	    kgen.init(256);
	    SecretKey skey = kgen.generateKey();
	    return skey.getEncoded().toString();
	}
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 5, 2020
	 * @RETURN : String
	 * @DESC   : 생성된 키를 16진수로 변환
	 */
	public static String getHexStringKey(String skey) {
		return Hex.encodeHexString(skey.getBytes());
	}
}