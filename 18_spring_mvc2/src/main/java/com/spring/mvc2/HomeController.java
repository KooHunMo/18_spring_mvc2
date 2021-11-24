package com.spring.mvc2;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	/*
	 * 	
	 *	- 전송방식을 지정해 GET과 POST 방식을 다른 메서드로 처리할 수 있다.
	 *	- 명시하지 않을 경우 GET과 POST방식을 모두 처리한다.
	 *	- @GetMapping("/경로") , @PostMapping("/경로")과 같이 어노테이션을 이용한 설정도 가능하다.
	 *  - value 속성에 접근 url을 작성하며 , method 속성에 요청 방법을 명시한다.
	 *  
	 */
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "dataTransfer/joinForm";
	}

	/*
	 *
	 *	- Spring Controller에서 메서드의 return타입은 view(jsp)를 명시할 String타입을 기본적으로 사용한다.
	 *  - servlet-context.xml 파일의 아래의 설정으로  바인딩되어 view(jsp)화면으로 포워딩 한다.
	 *		
	 *		<beans:bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
	 *			<beans:property name="prefix" value="/WEB-INF/views/" />
	 *			<beans:property name="suffix" value=".jsp" />
	 *	    </beans:bean>
	 *
	 *		예시)
	 *
	 *			return "home"		 		> /WEB-INF/views/home.jsp
	 *			return "goods/main"   		> /WEB-INF/views/goods/main.jsp
	 *			return "order/orderList"	> /WEB-INF/views/order/orderList.jsp
	 *
	 *  - 특정 페이지로 리다이렉트시키는 방법은 "redirect:경로" 와 같은 형태로 사용한다.
	 * 
	 * 		예시)
	 * 			return "redirect:/admin/memberMain.do"	> /admin/memberMain.do 
	 *  		return "redirect:/order/modifyOrder.do"	> /order/modifyOrder.do
	 *	
	 *  - view로 이동하는 방법과 controller로 리다이렉트하는 방법의 차이점을 인지하는 것은 중요하다.
	 *	 
	 *		jsp로 이동하는 경우 : 순수하게 페이지만 이동  
	 *		redirect하는 경우   : 해당 url에 프로그램 되어있는 모든 로직을 수행한후 페이지 이동
	 *
	 */
	
}
