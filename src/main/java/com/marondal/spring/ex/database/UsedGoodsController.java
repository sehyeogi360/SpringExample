package com.marondal.spring.ex.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.marondal.spring.ex.database.bo.UsedGoodsBO;
import com.marondal.spring.ex.database.model.UsedGoods;

@Controller
public class UsedGoodsController {

	@Autowired
	private UsedGoodsBO usedGoodsBO;//변수형태로만 만들면 됨 원래 객체형태로 해야함
	
	@RequestMapping("/database/ex01")
	@ResponseBody
	public List<UsedGoods> ex01() {//usedgoods 를 제이손 형태로 만들고 싶었다 우리는. 이대로 하면 만들어지겠구나
		
		// used_goods 목록 가져오기
		List<UsedGoods> usedGoodsList = usedGoodsBO.getUsedGoodsList();//response만드는일만 해주자
		
		return usedGoodsList;
		
	}
}
