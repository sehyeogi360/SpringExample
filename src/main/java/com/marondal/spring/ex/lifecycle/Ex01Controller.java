package com.marondal.spring.ex.lifecycle;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Ex01Controller {
	
	@RequestMapping("/lifecycle/ex01/1") // 예제 1번의 첫번째 라는 뜻
	@ResponseBody
	public String stringResponse() {
		return "예제 1번 문자열을 담은 Response";		
	}
	
	
	// 맵을 리턴하는 메소드 
	@RequestMapping("/lifecycle/ex01/2")//url mapping 기존 같았으면 두개의 페이지, 두개의 객체 만듦
	@ResponseBody //response annotation 404 뜨면 한두번정도는 서버 껐다켜보기
	public Map<String, Integer> mapResponse() { 
		
		// "apple" : 1500
		
		Map<String, Integer> fruitMap = new HashMap<>();
		
		fruitMap.put("apple", 1500);
		fruitMap.put("banana", 3000);
		fruitMap.put("orange", 1000);
		
		return fruitMap;// 얘가 리턴되는 순간 json 문자열을 만들어내서 json response가 담기는것
		
		
	}
	
	
}
