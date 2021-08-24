package com.kh.team3.common.wrapper;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EncryptWrapper extends HttpServletRequestWrapper {

	public EncryptWrapper(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getParameter(String key) {
		String value = "";
		//request 에 담긴 파라미터 key 값이 userPwd, newPwd 인경우 
		if(key !=null &&(key.equals("userPwd")||key.equals("newPwd"))) {
			// 암호화 기법 공부하기
			// 해시 -> 단방향 암호화 기법
			// 인크립션-> 양방향 암호화 기법 
		try {
			// SHA-512 암호화 객체 이용
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			// 비밀번호에 해당하는 값만 if 문안에 들어왔을거고 이걸 바이트 배열에 넣을것
			// 전달받은 비번을 바이트 배열로 받기
			byte[] bytes = super.getParameter(key).getBytes(Charset.forName("UTF-8"));
			// md 객체에 변환한 바이트 배열을 전달해서갱신
			md.update(bytes);
			// java.util.Base64 인코더를 이용하여 암호화된 바이트 배열을 인코딩 과정을 통해 문자열로 출력
			value = Base64.getEncoder().encodeToString(md.digest());
		}catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
			
			
		}else {
			value = super.getParameter(key);
		}
		
		return value;
	}
	 
}
