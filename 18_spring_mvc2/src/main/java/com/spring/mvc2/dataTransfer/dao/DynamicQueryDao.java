package com.spring.mvc2.dataTransfer.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mvc2.dataTransfer.domain.OrderDto;

@Repository
public class DynamicQueryDao {

	@Autowired
	private SqlSession sqlSession;
	
	public void ifEx(OrderDto orderDto) {
		sqlSession.insert("dynamicQuery.ifEx" , orderDto);
	}
	
	public void chooseEx(OrderDto orderDto) {
		sqlSession.insert("dynamicQuery.chooseEx" , orderDto);
	}
	
	public void foreachEx(List<OrderDto> orderList) {
		sqlSession.insert("dynamicQuery.foreachEx" , orderList);
	}
	
	public void whereEx(OrderDto orderDto) {
		OrderDto res = sqlSession.selectOne("dynamicQuery.whereEx" , orderDto);
		System.out.println("\n whereEx \n");
		System.out.println(res);
		
	}
	
	public void setEx(OrderDto orderDto) {
		sqlSession.update("dynamicQuery.setEx" , orderDto);
	}
	
	
}
