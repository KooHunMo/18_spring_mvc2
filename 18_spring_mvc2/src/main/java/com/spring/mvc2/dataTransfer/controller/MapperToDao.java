package com.spring.mvc2.dataTransfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.mvc2.dataTransfer.dao.OrderDao;

@Controller
@RequestMapping("mTOd")
public class MapperToDao {

	@Autowired
	private OrderDao orderDao;
	
	@RequestMapping(value="/selectAll" , method=RequestMethod.GET)
	public String selectAll() {
		orderDao.selectAll();
		return "home";
	}
	
	@RequestMapping(value="/select1" , method=RequestMethod.GET)
	public String select1() {
		orderDao.select1();
		return "home";
	}
	
	@RequestMapping(value="/select2" , method=RequestMethod.GET)
	public String select2() {
		orderDao.select2();
		return "home";
	}
	
	@RequestMapping(value="/select3" , method=RequestMethod.GET)
	public String select3() {
		orderDao.select3();
		return "home";
	}
	
	@RequestMapping(value="/select4" , method=RequestMethod.GET)
	public String select4() {
		orderDao.select4();
		return "home";
	}
	
}
