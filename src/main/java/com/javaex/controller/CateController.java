package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CateController {

	
	//카테고리 추가
	@RequestMapping(value="/{id}/admin/category/insert")
	public int CateInsert() {
		
		return 1;
		
	}
	
	
	
}
