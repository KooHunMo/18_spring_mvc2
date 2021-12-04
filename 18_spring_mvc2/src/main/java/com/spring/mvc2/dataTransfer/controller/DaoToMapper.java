package com.spring.mvc2.dataTransfer.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.mvc2.dataTransfer.dao.OrderDao;
import com.spring.mvc2.dataTransfer.domain.OrderDto;

@Controller
@RequestMapping("dTOm")
public class DaoToMapper {

	@Autowired
	private OrderDao orderDao;
	
	
	// 예시 1) 단일 데이터 전송
	@RequestMapping(value="/insertData1" ,method=RequestMethod.GET)
	public String insertData1() {
		orderDao.insertData1("테스트 유저1");
		return "home";
	}
	
	// 예시 2) DTO 전송
	@RequestMapping(value="/insertData2" ,method=RequestMethod.GET)
	public String insertData2() {
		
		OrderDto orderDto = new OrderDto();
		orderDto.setMemberId("테스트유저2");
		orderDto.setProductCode("테스트상품코드2");
		orderDto.setProductName("테스트상품명2");
		
		orderDao.insertData2(orderDto);
		
		return "home";
	}
	
	@RequestMapping(value="/insertData3" ,method=RequestMethod.GET)
	public String insertData3() {
		
		Map<String, String> orderMap = new HashMap<String, String>();
		orderMap.put("memberId" , "테스트유저3");
		orderMap.put("productCode" , "테스트상품코드3");
		orderMap.put("productName" , "테스트상품명3");
		orderDao.insertData3(orderMap);
		
		return "home";
		
	}
	
}