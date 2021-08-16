package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.BlogDao;
import com.javaex.vo.BlogVo;

@Service
public class BlogService {

	
	@Autowired
	private BlogDao blogDao;
	
	public BlogVo blogUser(String id) {
		System.out.println("블로그 서비스 아이디:"+id);
		
		BlogVo blogVo = blogDao.blogUser(id);
		
		System.out.println(blogVo);
		return blogVo;
		
	}
	
	//내블로그 눌렀을떄 기본글 가져오기
	public BlogVo getBlog(String id) {
		System.out.println("여긴 블로그 서비스"+id);
		BlogVo blogVo = blogDao.getBlog(id);
		
		return blogVo;
		
		
	}
	//블로그 수정
	public int myBlogUp(String id, String blogTitle, MultipartFile file) {
		System.out.println("blogService.myBlogUp접속");
		System.out.println(id+blogTitle+file);
		
		
		//파일이 있을때
		if(file.getSize() >0 ) {
			
		
		//저장경로
		String saveDir = "C:\\java Study\\upload";
		
		System.out.println();
		
		//파일 서버하드디스크에 저장
		//파일정보를 db에 저장 
		
		
		//뭔파일이름
		String orgName =file.getOriginalFilename();
		System.out.println("orgName:"+orgName);
		
		//확장자
		String exName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		System.out.println("exName:"+exName);
		
		//저장파일이름(관리때문에 겹치지 않는 새이름 부여)
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString()+exName;
		System.out.println("saveName:"+saveName);
		
		//파일패스
		String filePath = saveDir+"\\"+saveName;
		System.out.println("filePath:"+filePath);
		//파일사이즈
		long fileSize = file.getSize();
		System.out.println("fileSize:"+fileSize);
		
		//파일을 서버의 하드 디스크에 저장
		try {
			byte[] fileData = file.getBytes();
			OutputStream out = new FileOutputStream(filePath);
			BufferedOutputStream bout = new BufferedOutputStream(out);
			
			bout.write(fileData);
			bout.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		//2. 파일정보를 db에 저장 --과제
		
		BlogVo blogVo = new BlogVo(id,blogTitle,saveName);
		blogDao.myBlogUp(blogVo);
		
		}else {
			BlogVo blogVo = new BlogVo(id,blogTitle);
			blogDao.myBlogUp2(blogVo);
		}
		return 1;
	}
			
	

}
