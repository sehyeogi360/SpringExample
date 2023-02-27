package com.marondal.spring.ex.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.marondal.spring.ex.jsp.bo.UserBO;
import com.marondal.spring.ex.jsp.model.User;

@Controller
@RequestMapping("/jsp/user")//공통된요소
public class UserController {

	@Autowired
	private UserBO userBO;//객체화
	
	// 이름, 생년월일, 이메일, 자기소개 전달 받고 데이터 저장
//	@RequestMapping(path ="/add", method=RequestMethod.POST) //기본이 겟메소드임 보통	
	@PostMapping("/add")//축약하는 어노테이션이 따로 존재함
	@ResponseBody
	public String addUser(
			@RequestParam("name")String name 
			, @RequestParam("birthday")String birthday
			, @RequestParam("email")String email 
			, @RequestParam("introduce")String introduce) {//parameter로 전달받는다.
			
		int count = userBO.addUser(name, birthday, email, introduce);
		
		return "삽입결과 : " + count;
			
	}
	
	
	public String userInput(){//메소드명은 아무의미없다는것. 파라미터 x 		
		return "jsp/userInput";		
	}
	
	// 가장 최근에 등록된 사용자 정보를 html 로 구성한다. 
	@GetMapping("/lastUser")// 주소없으므로 겟
	public String lastUser(Model model) {//해당 메소드 모델객체 추가
		
		// 최근 등록된 사용자 조회
		User lastUser = userBO.getLastUser();
		
		// 조회된 결과를 jsp에서 쓸수 있도록 셋팅
		model.addAttribute("user", lastUser);		
		
		return "jsp/lastuser";//해당경로 리턴
		
	}
	
	
}
