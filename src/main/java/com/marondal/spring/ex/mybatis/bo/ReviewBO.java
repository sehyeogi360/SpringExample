package com.marondal.spring.ex.mybatis.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marondal.spring.ex.mybatis.dao.ReviewDAO;
import com.marondal.spring.ex.mybatis.model.Review;

@Service
public class ReviewBO {

	@Autowired
	private ReviewDAO reviewDAO;
	// 전달받은 id와 일치하는 데이터 조회후 그 결과 리턴
	public Review getReview(int id) {
	
		Review review = reviewDAO.selectReview(id);//review라는객체 에러뜸 여기다가 인자 넣기 
		
		return review;
	}
	
	public int addReview(int storeId, String menu, String userName, double point, String review) {//insert라서 데이터가 많이 사용됨
		
		return reviewDAO.insertReview(storeId, menu, userName, point, review);//자동생성 되지만 순서 확인해주면좋다.
		//리턴타입 준담에 리턴 해주기
	}
	
	
	public int addReviewByObject(Review review) {//행의갯수리턴
		return reviewDAO.insertReviewByObject(review);
	}
}
