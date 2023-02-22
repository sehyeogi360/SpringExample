package com.marondal.spring.ex.database.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marondal.spring.ex.database.dao.UsedGoodsDAO;
import com.marondal.spring.ex.database.model.UsedGoods;

@Service
public class UsedGoodsBO {
	
	@Autowired
	private UsedGoodsDAO usedGoodsDAO; //Autowired 객체관리를 스프링에게 맡기는 것.
	
	//used_goods 모든 데이터 조회 리턴 메소드
	public List<UsedGoods> getUsedGoodsList() {//리턴타입 리스트 bo 용도? 지금단계에선 쓸필욘없지만 중요 요소
		List<UsedGoods> usedGoodsList = usedGoodsDAO.selectUsedGoodsList();
		
		// 데이터 가공
		return usedGoodsList;
		
	}

}
