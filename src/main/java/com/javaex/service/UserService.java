package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.dao.BlogDao;
import com.javaex.dao.UserDao;
import com.javaex.vo.BlogVo;
import com.javaex.vo.UserVo;

@Repository
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BlogDao blogDao; 
	
	//회원가입
	public int joinUser(UserVo userVo) {
		System.out.println("회원가입 서비스 join접속");
		
		System.out.println(userVo);
		userDao.insertUser(userVo);
		
		String id = userVo.getId();
		String blogTitle = userVo.getUserName()+"의 블로그입니다.";
		
		BlogVo blogVo = new BlogVo(id, blogTitle);
		
		   blogDao.insertBlog(blogVo);
		 return 1; 
		
	 
	}

	//로그인
	public UserVo getLogin(UserVo userVo) {
		System.out.println("로그인 서비스 Login접속");
		System.out.println(userVo);
		
		UserVo authUser = userDao.getLogin(userVo);
		System.out.println("=======");
		System.out.println(authUser);
		return authUser;
		
	}
	//아이디 중복체크 	
	public boolean getUser(String id) {
		System.out.println("유저 서비스.id 중복체크");
		
		UserVo userVo = userDao.oneUser(id);
		System.out.println("리턴된 userVo"+userVo);
		
		if(userVo == null) { //db에 없는 경우 --> 사용할 수 있는 아이디
			return true;
		}else { // db에 있는 경우 --> 사용중인 아이디
			return false;
		}
		
		
	}
}
