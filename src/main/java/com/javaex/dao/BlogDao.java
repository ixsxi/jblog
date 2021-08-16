package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BlogVo;

@Repository
public class BlogDao {

	@Autowired
	private SqlSession sqlSession;
	
	public int insertBlog(BlogVo blogVo) {
		
		sqlSession.insert("blog.insertBlog",blogVo);
		return 1;
		
	}

	public BlogVo blogUser(String id) {

		return sqlSession.selectOne("blog.selectBlog",id);
	}
	
	//기본글 가져오기
	public BlogVo getBlog(String id) {
		return sqlSession.selectOne("blog.selectBlogOne",id);
		
	
		
	}
	//파일이있을때
	public void myBlogUp(BlogVo blogVo) {
		System.out.println("여기는 블로그다오 //myBlogUp");
		System.out.println(blogVo);
		
		sqlSession.update("blog.updateBlog",blogVo);
	}

	//파일이없을때
	public void myBlogUp2(BlogVo blogVo) {
		System.out.println("여기는 블로그다오 //myBlogUp2");
		System.out.println(blogVo);
		sqlSession.update("blog.updateBlog2",blogVo);
	}
		
	
}
