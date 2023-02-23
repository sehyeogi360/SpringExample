package com.marondal.spring.ex.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.marondal.spring.ex.mybatis.bo.ReviewBO;
import com.marondal.spring.ex.mybatis.model.Review;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ReviewController {

	@Autowired
	private ReviewBO reviewBO;
	
	// 전달 받은 id 와 일치하는 데이터 조회 그 결과를 json으로 response에 담기
	@RequestMapping("/mybatis/ex01")
	@ResponseBody
	public Review review(
			@RequestParam("id") int id 
//			@RequestParam(value="id", required=false) int id // 비필수 파리미터
//			@RequestParam(value="id", defaultValue="3") int id // default value
			) {//HttpServletRequest request 도 사실 필요없다.
		
//		int id = Integer.parseInt(request.getParameter("id"));
		Review review = reviewBO.getReview(id);//이제 여기서는 숫자
		
		return review;//제이슨 형태로 일단 리스폰스 바디후 return review
		//인자값 안넣고 실행하자 400에러 뜻 요청자체가 잘못됨 주소확인, 리퀘스트가 잘못됨 요청하는 파라미터 확인 
	}
	
}
