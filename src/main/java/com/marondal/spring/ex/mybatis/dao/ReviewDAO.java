package com.marondal.spring.ex.mybatis.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.marondal.spring.ex.mybatis.model.Review;

@Repository
public interface ReviewDAO {

	public Review selectReview(@Param("id") int id);//param 추가 변수에 저장될값 xml에 쓰일 키워드
	
	public int insertReview(//줄바꾸기 parameter값이 나열될때 이렇게 하기
			@Param("storeId")int storeId, 
			@Param("menu")String menu, 
			@Param("userName")String userName, 
			@Param("point")double point, 
			@Param("review")String review);
	
	public int insertReviewByObject(Review review);
}
