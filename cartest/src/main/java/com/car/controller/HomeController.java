package com.carindrive.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.carindrive.service.RentService;
import com.carindrive.vo.CarVO;

@Controller
public class HomeController {
	
	@Autowired
	private RentService rentService;

	/*메인 페이지*/
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(CarVO cv) {
		ModelAndView mm = new ModelAndView();
		
		List<CarVO> ml = this.rentService.getCarList(cv);
		
		mm.addObject("ml", ml);
		mm.setViewName("main/index");
		
		return mm;
	}
	
	/* 에러 페이지*/
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String error() {
		return "main/error";
	}
	
}
