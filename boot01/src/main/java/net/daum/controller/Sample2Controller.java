package net.daum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.daum.vo.Sample2VO;

@Controller
public class Sample2Controller {

	@RequestMapping("/view_test") //view_test 매핑주소 등록
	public ModelAndView view_test() {
		ModelAndView wm=new ModelAndView();
		wm.addObject("name","홍길동");
		wm.setViewName("test_view");// 뷰리졸브 경로 -> /WEB-INF/views/test_view.jsp
		return wm;
	}
	
	//일반 @Controller 애노테이션에서 json(키,값 사전적인 자료구조) 데이터 만들기
	@RequestMapping(value="/json_test",produces="application/json")
	public @ResponseBody Sample2VO json_test() {
		/* @ResponseBody 애노테이션을 메서드 리턴타입 앞에 사용하면 jsp파일을 만들지 않고 브라우저에 키,값
		 * 쌍의 JSON데이터를 만들 수 있다. 리턴타입이 Sample2VO빈타입이면 해당 클래스의 변수명이 json데이터의
		 * 키이름이 된다.
		 */
		Sample2VO sample=new Sample2VO();
		sample.setVal01("val01이다");
		sample.setVal02("val02이다");
		sample.setVal03("val03이다");
		
		return sample;
	}
}




