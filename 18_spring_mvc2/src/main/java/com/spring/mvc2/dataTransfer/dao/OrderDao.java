package com.spring.mvc2.dataTransfer.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mvc2.dataTransfer.domain.OrderDto;

@Repository
public class OrderDao {

	@Autowired
	private SqlSession sqlSession;
	
	/*
	 * 
	 * # Mapper To Dao
	 * 
	 *  - [ mybatis 연결 설정 ] 
	 *     1) [ pom.xml ] 의존성 추가
	 *     2) [ root-context.xml ] db 연결 정보 설정
	 *     3) [ mybatis-config.xml ] mybatis설정 정보 
 	 *     4) [ *.xml ] mapper 파일 생성
 	 *     5) SqlSession 객체를 생성하여 쿼리문을 실행한다.
 	 *     
	 *  - 한개의 데이터를 조회할 경우      .selectOne() 메서드를 사용한다.
	 *  - 한개 이상의 데이터를 조회할 경우 .selectList() 메서드를 사용하며 반환데이터는 List로 처리할 수 있다.
	 *      주의) mapper파일에서의 resultType이 List가 아니고 . selectList() 메서드로 List를 처리한다.
	 *  
	 *  - insert쿼리를 사용할 경우 .insert() 메서드를 사용한다.
	 *  - update쿼리를 사용할 경우 .update() 메서드를 사용한다.
	 *  - delete쿼리를 사용할 경우 .delete() 메서드를 사용한다.
	 *  
	 * */
	
	// 1) Mapper > Dao 전송 예시
	public void selectAll() {
		
		System.out.println("\n selectAll \n");
		
		List<OrderDto> orderList = sqlSession.selectList("order.selectAll");
		
		for (OrderDto orderDto : orderList) {
			System.out.println(orderDto);
		}
		
		
	}
	
	// 2) Mapper > Dao 전송 예시
	public void select1() {
		
		System.out.println("\n select1 \n");
		
		int count = sqlSession.selectOne("order.select1");
		System.out.println("count : " + count);
		
	}
	
	// 3) Mapper > Dao 전송 예시
	public void select2() {
		
		System.out.println("\n select2 \n");
		
		List<OrderDto> orderList = sqlSession.selectList("order.select2");
		
		for (OrderDto orderDto : orderList) {
			System.out.println(orderDto);
		}
		
	}
	
	// 4) Mapper > Dao 전송 예시
	public void select3() {
		
		System.out.println("\n select3 \n");
		
		List<Map<String, Object>> orderList = sqlSession.selectList("order.select3");
		
		for (Map<String, Object> map : orderList) {
			System.out.println(map);
			System.out.println("memberId : "     + map.get("memberId"));
			System.out.println("orderId : "      + map.get("orderId"));
			System.out.println("productName : "  + map.get("productName"));
			System.out.println("productPrice : " + map.get("productPrice"));
			System.out.println("tax : " 		 + map.get("tax"));
			System.out.println("afterTax : "     + map.get("afterTax"));
			System.out.println("orderCount : "   + map.get("orderCount"));
			System.out.println("totalPrice : "   + map.get("totalPrice"));
			System.out.println("imageName : "    + map.get("imageName"));
			System.out.println("imageType : "    + map.get("imageType"));
			System.out.println("fileSize : "     + map.get("fileSize"));
			System.out.println();
		}
		
	}
	
	// 4) Mapper > Dao 전송 예시
	public void select4() {
		
		System.out.println("\n select4 \n");
		
		List<Map<String, Object>> orderList = sqlSession.selectList("order.select4");
		
		for (Map<String, Object> map : orderList) {
			System.out.println(map);
			System.out.println("memberId : "     + map.get("memberId"));
			System.out.println("orderId : "      + map.get("orderId"));
			System.out.println("productName : "  + map.get("productName"));
			System.out.println("productPrice : " + map.get("productPrice"));
			System.out.println("tax : " 		 + map.get("tax"));
			System.out.println("afterTax : "     + map.get("afterTax"));
			System.out.println("orderCount : "   + map.get("orderCount"));
			System.out.println("totalPrice : "   + map.get("totalPrice"));
			System.out.println("imageName : "    + map.get("imageName"));
			System.out.println("imageType : "    + map.get("imageType"));
			System.out.println("fileSize : "     + map.get("fileSize"));
			System.out.println();
		}
		
	}
	
	/*
	 * 
	 * # Dao To Mapper
	 * 
	 *  - 2개 이상의 파라미터를 mapper로 전달할 수 없고 오직 1개의 파라미터만 전송이 가능하다.
	 *  - 2개 이상의 데이터는 Dto , Map형식으로 전송한다.
	 *  - 전송되는 복수의 데이터가 Dto의 멤버로 포함되어 있으면 일반적으로 Dto 전송 방식을 사용하고
	 *    전송되는 복수의 데이터가 Dto의 멤버에 포함되어 있지 않은 경우 Map 전송 방식을 사용한다.
	 * 
	 * */
	
	// 1) Dao To Mapper 단일 데이터 전송 예시
	public void insertData1(String memberId) {
		sqlSession.insert("order.insertSingleData" , memberId);
	}
	
	
	// 2) Dao To Mapper Dto 전송 예시
	public void insertData2(OrderDto orderDto) {
		sqlSession.insert("order.insertDto" , orderDto);
	}
	
	
	// 3) Dao To Mapper Map 전송 예시
	public void insertData3(Map<String,String> orderMap) {
		sqlSession.insert("order.insertMap" , orderMap);
	}
	
	
}
