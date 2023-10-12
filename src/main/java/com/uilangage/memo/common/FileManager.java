package com.uilangage.memo.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

public class FileManager {

	// 상수 
	public final static String FILE_UPLOAD_PATH = "D:\\information1278\\springproject\\upload\\memo";
	
	
	// file을 특정 디렉토리(폴더)에 저장하고,
	// 해당 파일을 접근할수 있는 url경로를 만들고 리턴
	public static String saveFile(int userId, MultipartFile file){
		
		if(file == null) {
			return null;
		}
		
		// 같은 파일 이름 처리
		// 디렉토리(폴더) 만들어서 파일 저장
		// 로그인한 사용자의 userId 를 디렉토리 이름에 포함
		// 현재 시간 정보를 디렉토리 이름에 포함
		// UNIX TIME : 1970년 1월 1일 기준으로 흐른 시간을 milli second(1/1000) 단위로 표현한 방식
		// ex) / 2_239483930
		
		String directoryName = "/" + userId + "_" +System.currentTimeMillis();
		
		// 디렉토리 생성 ( 폴더 생성 )
		
		String directoryPath = FILE_UPLOAD_PATH + directoryName;
		
		File directory = new File(directoryPath);
		
		if(!directory.mkdir()) {
			// 디렉토리 생성 실패
			return null;
		}
		
		// 파일 저장 
		String filePath = directoryPath + "/" + file.getOriginalFilename();
		
		try {
			byte[] bytes = file.getBytes();
			
			Path path = Paths.get(filePath);
			Files.write(path, bytes);
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
			// 파일 저장실패 
			return null;
		}
		
		// 클라이언트에서 접근가능한 url 규칙을 만들고 해당 문자열을 리턴
		// 파일 경로 : D:\\information1278\\springproject\\upload\\memo/2_239483930/test.png
		// 경로 규칙 : /images/2_239483930/test.png
		
		return "/images" + directoryName + "/" + file.getOriginalFilename();
		
	}
	
	public static boolean removeFile(String filePath) { // /images/2_239483930/test.png
		
		
		if(filePath == null) {
			return false;
		}
		
		// 이미지 파일 경로에서 /images 제거 후
		// upload 경로를 이어 붙여 준다
		String fullFilePath = FILE_UPLOAD_PATH + filePath.replace("/images", "");
		
		Path path = Paths.get(fullFilePath);
		
		// 파일이 존재 하는지
		if(Files.exists(path)) {
			try {
				Files.delete(path);
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
		
		Path dirPath = path.getParent();
		
		// 디렉토리가 존재하는지
		if(Files.exists(dirPath)) {
			try {
				Files.delete(dirPath);
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
		
		return true; 
	}
	
}
