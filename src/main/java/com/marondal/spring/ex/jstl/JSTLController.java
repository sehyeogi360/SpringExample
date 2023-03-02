package com.marondal.spring.ex.jstl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jstl")
public class JSTLController {

	
	@GetMapping("/ex01")
	public String ex01() {		
		return "jstl/ex01";
	}
	@GetMapping("/ex02")
	public String ex02(Model model) {	
		
		// 과일 이름 리스트
		List<String>fruitList = new ArrayList<>();
		fruitList.add("사과");
		fruitList.add("딸기");
		fruitList.add("바나나");		
		
		// List<Map>
		// 사용자 정보 map (이름, 나이, 취미)		
		List<Map<String, Object>> userList = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		map.put("name", "김인규");
		map.put("age", 28);
		map.put("hobby", "댄스");
		userList.add(map);
		
		//과제 아닌 과제 맵하나 만들어서 더 추가 해보기.
		//오늘진짜 과제 연습문제 라이브러리2 샘플데이터로 태그 구성후 해보기
		
		model.addAttribute("fruitList", fruitList);
		
		return "jstl/ex02";
	}
	
}
