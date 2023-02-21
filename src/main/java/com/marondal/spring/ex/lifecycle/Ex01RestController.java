package com.marondal.spring.ex.lifecycle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marondal.spring.ex.lifecycle.model.Person;

@RestController // @Controller + @ResponseBody
@RequestMapping("/lifecycle/ex01")// 공통요소만 잡아줌
public class Ex01RestController {
	
	@RequestMapping("/3") //위에 적었으니 3,4 만 적어주면 된다.
	public String stringReponse() {		
		return "안녕하세요 <br> RestController 입니다";//html로 전달		
	}

	//response 안쓰는 메소드도 있따고 함
	
	// 직접 만든 클래스 객체를 리턴
	@RequestMapping("/4")
	public Person objectResponse() {//import
		Person person = new Person();//생성자 만든적 없으므로 기본생성자로 객체생성
		person.setName("김인규");
		person.setAge(28);
		
		return person;
	}
	
	//데이터만을 저장하는 클래스 모델 or DTO
	// status 코드를 포함한 response
	@RequestMapping("/5")
	public ResponseEntity<Person> entityResponse() {//responseentity 를 리턴
		Person person = new Person();//생성자 만든적 없으므로 기본생성자로 객체생성
		person.setName("김인규");
		person.setAge(28);
		
		ResponseEntity<Person> entity = new ResponseEntity(person, HttpStatus.INTERNAL_SERVER_ERROR);//500 server error
		
		return entity;//entity 객체리턴
	}
	
	
	
	
	
}
