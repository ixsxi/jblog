package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public int insertUser(UserVo userVo) {
		System.out.println("유저다오 접속 ");
		System.out.println(userVo);
		
		return sqlSession.insert("user.insertUser",userVo);
	}

	public UserVo getLogin(UserVo userVo) {
		System.out.println("유저다오 접속(로그인) ");
		System.out.println(userVo);
		
		return sqlSession.selectOne("user.OneUser",userVo);
		
	}

	public UserVo oneUser(String id) {
		System.out.println("유저 다오 접속");
		System.out.println(id);
		
		return sqlSession.selectOne("user.selectUserById",id);
	
	}

}
