package com.kh.team3.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRenamePolicy implements FileRenamePolicy{

	@Override
	public File rename(File originFile) {   // 업로드할 원본파일이 전달됨
		System.out.println("파일 폴리스 접근");
		System.out.println("originFile : " + originFile);
		String originName = originFile.getName();
		System.out.println("originName : " +  originName);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String currentTime = sdf.format(new Date());
		System.out.println("currentTime : " +  currentTime);
		int random = (int)(Math.random()*90000+10000);
		
		String ext = "";
		
		int dot = originName.lastIndexOf(".");
		ext = originName.substring(dot);
		System.out.println("ext : " + ext);
		String fileName = currentTime+random+ext;
		System.out.println("fileName : " + fileName);
		File renameFile = new File(originFile.getParent(), fileName);
		System.out.println("renameFIle : "+ renameFile );
	
		System.out.println("파일 폴리스 리턴");
		
		
		return renameFile;
	}

}
