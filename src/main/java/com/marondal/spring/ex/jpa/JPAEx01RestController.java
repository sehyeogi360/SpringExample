package com.marondal.spring.ex.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marondal.spring.ex.jpa.bo.StudentBO;
import com.marondal.spring.ex.jpa.model.StudentEntity;

@RequestMapping("/jpa")
@RestController
public class JPAEx01RestController {
	
	@Autowired
	private StudentBO studentBO;
	
	// C:create
	@GetMapping("/ex01/1")
	public StudentEntity create() {
			String name = "김인규";
			String phoneNumber = "010-1111-2222";
			String email = "lecture@hagulu.com";
			String dreamJob = "개발자";

			StudentEntity student = studentBO.addStudent(name, phoneNumber, email, dreamJob);

			// save 된 객체를 리턴해주므로 student.getId()로 key를 바로 얻을 수도 있다.
			
			return student;
	}
	
	// U:update
	@GetMapping("/ex01/2")
	public StudentEntity update() {
			// id가 7번인 dreamJob을 변경
			StudentEntity student = studentBO.updateStudentDreamJobById(7, "디자이너");
			return student;
	}

	// D:delete
	@GetMapping("/ex01/3")
	public String delete() {
			studentBO.deleteStudentById(7);
			//studentBO.deleteStudentById(8);
			return "삭제 완료";
	}
	
	
}
