package com.camp.camping.Utility;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.camp.camping.utility.CryptoUtil;

@SpringBootTest
public class UtilityTest {
    
    @Test
	void contextLoads() throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		String plainText = "id01";

		System.out.println("원본 데이터 : " + plainText);
		String enc_plainText = CryptoUtil.sha512(plainText);
		System.out.println("SHA-512방식 암호화 " + enc_plainText);
		
		String plainText2 = "id01";
		String enc_plainText2 = CryptoUtil.sha512(plainText2);
		
		if(enc_plainText.equals(enc_plainText2)) {
			System.out.println("OK");
		}
		
		
		System.out.println("-------------------------------------------------");
		
		String key = "123456testsogood";
		
		String enStr = CryptoUtil.encryptAES256(plainText, key);
		System.out.println("AES 256 방식 암호화 : " + enStr);
		
		String deStr = CryptoUtil.decryptAES256(enStr, key);
		System.out.println("AES 256 방식 복호화 :" + deStr);
	}
}
