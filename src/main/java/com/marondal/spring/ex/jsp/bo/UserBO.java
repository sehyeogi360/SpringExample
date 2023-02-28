package com.marondal.spring.ex.jsp.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marondal.spring.ex.jsp.dao.UserDAO;
import com.marondal.spring.ex.jsp.model.User;

@Service
public class UserBO {
	
	@Autowired
	private UserDAO userDAO;//dao 객체화
	
	//이름, 생년월일, 이메일, 자기소개 저장
	public int addUser(String name, String birthday, String email, String introduce) {
		
		return userDAO.insertUser(name, birthday, email, introduce);
		
	}
	
	public int addUserByObject(User user) {
		return userDAO.insertUserByObject(user);
		
		
	}
	
	public User getLastUser() {//model User로 임포트
		
		return userDAO.selectLastUser();// 다오 메소드 호출
	}
	
}
