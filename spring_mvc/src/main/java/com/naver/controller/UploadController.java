package com.naver.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller //스프링 이진파일 업로드 컨틀롤러 클래스(자료실 : 파일 첨부 기능 추가)
public class UploadController {
	@GetMapping("/uploadForm")
	//get으로 접근하는 매핑주소를 처리. uploadForm 매핑 주소등록
	public void uploadForm() {
		//리턴 타입이 없는 void형이면 매핑 주소가 jsp파일명이 된다.
		
	}//uploadForm()
	
	//동기식 이진파일 업로드
	@PostMapping("/uploadFormAction")//
	public void uploadFormAction(MultipartFile[] uploadFile, HttpServletRequest reauest) {
		/*
		  MultipartFile 스프링 api를 사용해거 업로드 되는 파일 데이터를 쉽게 처리 
		  다중 파일은 배열로 받는다
		  매개변수 (전달인자명) uploadFile과 input type="file" 의 네임 파라미터 이름이 같아야한다
		 *
		 */
		String uploadFolder = reauest.getRealPath("/resources/upload");
		
		System.out.println("첨부파일 업로드 경로 : " +uploadFolder);
		//파일 첨부 업로드 서버 실제 경로		
		
		for(MultipartFile multi:uploadFile) {
			System.out.println("======================>");
			System.out.println("Upload File Name : " +multi.getOriginalFilename());
			//실제 첨부 파일 명
			System.out.println("Upload File size : " +multi.getSize());
			//업로드 파일 크기
			File saveFile = new File(uploadFolder, multi.getOriginalFilename());
			//파일 객체 생성 
			
			try {
				multi.transferTo(saveFile);
				//업로드 폴더에 첨부파일 실제로 업로드 됨
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//for
	}//uploadFormAction()
	
	/*
	 문제 ) tomcat WAS 서버에 의해서 upload 첨부파일 업로드 해보기 1개-여러개 
	 */
	
	
}
