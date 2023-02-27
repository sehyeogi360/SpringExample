package com.marondal.spring.ex.jsp.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.marondal.spring.ex.jsp.model.User;

@Repository
public interface UserDAO {
	
	public int insertUser(//return type int
			@Param("name") String name
			, @Param("birthday") String birthday
			, @Param("email")String email
			, @Param("introduce")String introduce);

	
	public User selectLastUser();
}