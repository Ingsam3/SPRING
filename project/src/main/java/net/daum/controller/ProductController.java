package net.daum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.daum.vo.ProductVO;

@Controller
public class ProductController {

	
	@RequestMapping("/product")
	public @ResponseBody ProductVO product () {
		ProductVO pd = new ProductVO("에어컨", 2500000);

		return pd;
	}
}
