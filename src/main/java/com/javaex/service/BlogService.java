package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
