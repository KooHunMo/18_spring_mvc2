package com.spring.mvc2.dataTransfer.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.mvc2.dataTransfer.domain.MemberDto;

@Controller // 중복되는 경로는 Controller에 설정하여 중복되는 url을 줄일 수 있다.
@RequestMapping("vTOc")
public class ViewToController {

	/* 
	 * 	
	 * 	예시 1) HttpServletRequest.
	 * 
	 *  - HttpServletRequest를 직접 이용하여 getParameter메서드를 이용하여 파라메타의 값에 접근 할 수 있다.
	 *  - JSP HttpServletRequest과 사용방법이 같다.
	 * 
	 */
	@RequestMapping(value="/transfer1" , method=RequestMethod.POST)
	public String transfer1(HttpServletRequest request) {
		
		System.out.println("\n transfer1 \n");
		System.out.println("id : "       + request.getParameter("id"));
		System.out.println("password : " + request.getParameter("password"));
		System.out.println("name : "     + request.getParameter("name"));
		System.out.println("email : "    + request.getParameter("email"));
		System.out.println();
		
		return "home";
		
	}
	
	
	
	/*
	 * 
	 *  예시 2) @ModelAttribute , 커맨드객체
	 *  
	 *  - 예시 1번과 같은 방법은 요청 파라미터 개수가 증가할때마다 코드의 길이도 길어지는 단점이 있다. 
	 *  
	 *  - @ModelAttribute속성을 사용하여 Dto형식으로 바인딩 된 데이터로 전달받을 수 있다. 
	 *  
	 *  - @ModelAttribute 의 경우 내부적으로 검증(Validation) 작업을 진행하기 때문에 setter 메서드를 이용하여 값을 바인딩하려고 시도하다가 
	 *   예외를 만날때 작업이 중단되면서 Http 400 Bad Request 가 발생하지 않는다. 
	 *   
	 *  - 커맨드 객체를 사용하여 Dto형식으로 바인된 된 데이터를 전달 받을 수 있다. 
	 *  
	 *  - 요청 파라미터의 name속성의 값이 객체(pojo)의 필드와 일치 할 경우에만 
	 *    요청 파라미터의 name과 POJO의 필드를 setter 메서드를 사용하여 바인딩한다.
	 *  
	 */
	
	//@RequestMapping(value="/transfer2" , method=RequestMethod.POST)
	//public String transfer2(@ModelAttribute MemberDto memberDto) {
	
	@RequestMapping(value="/transfer2" , method=RequestMethod.POST)
	public String transfer2(MemberDto memberDto) {	
		
		System.out.println("\n transfer2 \n");
		System.out.println(memberDto);
		
		return "home";
		
	}
	
	/* 
	 * 예시 3) @RequestParam Map<K,V>
	 * 
	 * - Map 컬렉션 프레임워크를 이용하여 요청파라미터에 접근이 가능하다.
	 * 
	 * - 요청 파라미터의 name이름이 Map 컬렉션 프레임워크의 "KEY"로 바인딩되며
	 *   요청 파라미터의 name값이 Map 컬렉션 프레임워크의 "VALUE"로 바인딩된다.
	 * 
	 * - 웹 시스템을 개발할 경우 모델 형식(dto , pojo)으로 모든 데이터를 전달 받기 어려운 경우가 있는데(Dto + @의 데이터) 
	 *   Map을 사용하면 모든 값을 수용할 수 있다. 그러므로 주로 dto 형식으로 데이터를 모두 전달받을 수 없을 때 사용한다.
	 *
	 * - Map으로 전달되는 데이터가 정수,실수,글자등 다양한 데이터일 경우 다형성을 이용하여 Object타입으로 처리할 수 있다.
	 * 
	 */
	@RequestMapping(value="/transfer3" , method=RequestMethod.POST)
	public String transfer3(@RequestParam Map<String , Object> memberMap) {	
		
		System.out.println("\n transfer3 \n");
		System.out.println(memberMap);
		System.out.println("id : " + memberMap.get("id"));
		System.out.println("password : " + memberMap.get("password"));
		System.out.println("name : " + memberMap.get("name"));
		System.out.println("email : " + memberMap.get("email"));
		System.out.println("addData1 : " + memberMap.get("addData1"));
		System.out.println("addData2 : " + memberMap.get("addData2"));
		System.out.println("addData3 : " + memberMap.get("addData3"));
		System.out.println();
		
		return "home";
		
	}
	
	/* 
	 * 
	 *	예시 4) @RequestParam
	 *
	 *	- @RequestParam어노테이션을 사용하여 파라메타의 값에 접근 할 수 있다. 
	 *	  [ @RequestParam 어노테이션의 속성 ]	
	 *		name 		 : 파라메타의 이름을 지정한다. ( 다른 옵션을 사용하지 않을 경우 name 키워드생략가능)
	 *		required	 : 필수 여부를 지정한다. 기본값은 true이며 요청값이 없으면 익셉션이 발생한다.
	 *		defaultValue : 요청 파라메타의 값이 없을때 사용할 값을 지정한다.
	 *	
	 *	- @RequestParam을 생략하여 parameter에 직접 요청파라메타의 name값만 입력하여 데이터를 전달받을 수 있다.
	 *
	 */
	
	//@RequestMapping(value="/transfer4" , method=RequestMethod.POST)
	//public String transfer4(@RequestParam(name="id" , defaultValue = "anonymous") String id , @RequestParam(name="password" , defaultValue = "1111") String password) {	
		
	@RequestMapping(value="/transfer4" , method=RequestMethod.POST)
	public String transfer4(String id , String password) {	
		System.out.println("\n transfer4 \n");
		System.out.println("id : " + id);
		System.out.println("password : " + password);
		System.out.println();
		
		return "home";
		
	}
	
	/*
	 *  
	 *  예시 5) @PathVariable
	 *   
	 *  - Spring을 사용하다보면 클라이언트에서 URL에 파라메타를 같이 전달하는 경우가 생긴다.
	 *	- 아래와 같이 두 가지 형식으로 url이동과 함께 파라메타값들을 전달할 수 있다.
	 *
	 *		1) http://localhost:8080/vTOc/transfer5?isMember='yes'&isSession='no'
	 *		2) http://localhost:8080/vTOc/transfer5/yes/no
	 *	
	 *	- 1) 방법은 @RequestParam을 통해서 데이터에 접근하고 , 2) 방법은 @PathVariable을 통해서 데이터에 접근한다.
	 *  - 2) 방법은 {}로 패턴을 매칭하여 데이터에 접근 한다. 
	 *  
	 * */
	
	//@RequestMapping(value="/transfer5" , method=RequestMethod.GET)
	//public String transfer5(@RequestParam("isMember") String isMember , @RequestParam("isSession") String isSession) {	
		
	@RequestMapping(value="/transfer5/{isMember}/{isSession}" , method=RequestMethod.GET)
	public String transfer5(@PathVariable String isMember , @PathVariable String isSession ) {	
		
		System.out.println("\n transfer5 \n");
		System.out.println("isMember : " + isMember);
		System.out.println("isSession : " + isSession);
		System.out.println();
		
		return "home";
		
	}
}
