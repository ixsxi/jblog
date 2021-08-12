package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//로그인폼
	@RequestMapping(value = "/loginForm",method = {RequestMethod.GET,RequestMethod.POST})
	public String loginForm() {
		System.out.println("유저컨트롤러.loginForm접속");
		
		return "user/loginForm";
		
	}
	
	//회원가입
	@RequestMapping(value = "/joinForm",method = {RequestMethod.GET,RequestMethod.POST})
	public String joinForm() {
		System.out.println("유저컨트롤러.joinForm접속");
		return "user/joinForm";
		
	}
	//회원가입
	@RequestMapping(value = "/join",method = {RequestMethod.GET,RequestMethod.POST})
	public String join(@ModelAttribute UserVo userVo) {
		System.out.println("회원가입 컨트롤러 join접속");
		System.out.println(userVo);
		
		userService.joinUser(userVo);
		
		return "user/joinSuccess";
		
	}
	//로그인
	@RequestMapping(value="/login",method = {RequestMethod.GET,RequestMethod.POST})
	public String login(@ModelAttribute UserVo userVo,HttpSession session) {
		System.out.println("login 로그인 들어옴 ");
		System.out.println(userVo);
		
		 UserVo authUser = userService.getLogin(userVo);
		 System.out.println(authUser+"sss");
		 
		 //로그인 성공하면 하는거
		 if(authUser != null) {
			 System.out.println("로그인성공");
			 session.setAttribute("authUser", authUser);
			 return "redirect:/";
		 }else{
			 System.out.println("로그인 실패");
			 
			 return "redirect:/";
		 }
		 
		
		
	}
	
	//로그아웃
	@RequestMapping(value="logout",method = {RequestMethod.GET,RequestMethod.POST})
	public String logout(HttpSession session) {
		session.removeAttribute("authUser");
		session.invalidate();
		
		return "redirect:/";
	}
	
	
	
	
	//아이디체크 ajax
	
	@ResponseBody
	@RequestMapping(value ="/idcheck",method = {RequestMethod.GET,RequestMethod.POST})
	public boolean idCheck(@RequestParam("id")String id) {
		System.out.println("idcheck접속");
		System.out.println(id);
		
		boolean state = userService.getUser(id);
		
		return state;
		
	}
}
