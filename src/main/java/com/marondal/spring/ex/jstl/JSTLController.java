package com.marondal.spring.ex.jstl;

import java.util.ArrayList;
import java.util.Date;
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
		
		model.addAttribute("fruitList", fruitList);
		
		// List<Map>
		// 사용자 정보 map (이름, 나이, 취미)		
		List<Map<String, Object>> userList = new ArrayList<>();//맵을 저장할 리스트
		Map<String, Object> map = new HashMap<>();
		map.put("name", "김인규");
		map.put("age", 28);
		map.put("hobby", "댄스");
		userList.add(map);
		
		map = new HashMap<>();//새로운 객체 생성해서 두겠다.
		
		//과제 아닌 과제 맵하나 만들어서 더 추가 해보기.
		//오늘진짜 과제 연습문제 라이브러리2 샘플데이터로 태그 구성후 해보기
		
		// 사용자 정보 리스트
		// 사용자 정보 : 이름, 나이, 취미
		//     키     밸류
		map = new HashMap<>();
		map.put("name", "임세혁");
		map.put("age", 29);
		map.put("hobby", "sleep");
		userList.add(map);
		
		
		model.addAttribute("userList", userList); // 모델이라는 객체를 통해서 키 밸류 형태로 
		
		return "jstl/ex02";
	}
	
	@GetMapping("/ex03")
	public String ex03(Model model) {//모델 객체로 값 채우기	
		
		Date now = new Date();
		
		model.addAttribute("now", now);
		
		String dateString = "2023/03/03 12:11:10";
		model.addAttribute("dateString", dateString);
		
		return "jstl/ex03";	
	}
	
}
