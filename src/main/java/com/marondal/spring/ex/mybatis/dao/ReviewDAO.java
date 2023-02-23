package com.marondal.spring.ex.mybatis.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.marondal.spring.ex.mybatis.model.Review;

@Repository
public interface ReviewDAO {

	public Review selectReview(@Param("id") int id);//param 추가 변수에 저장될값 xml에 쓰일 키워드
	
}
