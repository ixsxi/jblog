package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.BlogService;
import com.javaex.vo.BlogVo;

@Controller
@RequestMapping(value ="/")
public class BlogController {

	
	@Autowired
	private BlogService blogService;
	
	//블로그 메인
	@RequestMapping(value="{id}",method= {RequestMethod.GET,RequestMethod.POST})
	public String blogId(@PathVariable("id") String id ,Model model) {
		System.out.println("블로그메인 (자기아이디)");
		
		
		
		//블로그 정보 가져오기
		System.out.println(id);
		BlogVo blogVo = blogService.blogUser(id);
		
		System.out.println("blog컨트롤러blogVo:"+blogVo);
		
		model.addAttribute("blogVo", blogVo);
		
		//블로그 메인jsp 에서 쓸 블로그 vo id(주소창에 있는거 패스어쩌구로 따와야됨)로 where절 주고 가져와서 모델에 담고 보내주기
		//보내준 다음에 블로그 메인 jsp에서 {blogVo.id} 요런식으로 세팅
		
		return "blog/blog-main";
	}
	

	
}
