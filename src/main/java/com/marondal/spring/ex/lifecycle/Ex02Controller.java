package com.marondal.spring.ex.lifecycle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Ex02Controller {
	
	@RequestMapping("/lifecycle/ex02")//url 넣기
	public String jspResponse() {		
		return "lifecycle/ex02";//application.propertis 설정후 앞에지우고 .jsp 지우기
	}	
	
}
