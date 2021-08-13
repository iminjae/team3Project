package com.kh.team3.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRenamePolicy implements FileRenamePolicy{

	@Override
	public File rename(File originFile) { //rename 메소드가 실행되면서 업로드할 파일 이름이 전달될거임
		String originName = originFile.getName();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss"); //날짜형식지정
		String currentTime = sdf.format(new Date());
		
		int random = (int)(Math.random()*90000+10000); //랜덤값
		
		String ext = "";
		int dot = originName.lastIndexOf(".");
		ext = originName.substring(dot); // 확장자 
		
		String fileName = currentTime + random + ext; // 날짜 + 랜덤값 + 확장자 = 파일이름
		File renameFile = new File(originFile.getParent(),fileName);
		return renameFile;
	}

	
	
}
