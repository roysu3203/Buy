package com.roy.buy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首頁 Controller
 */
@Controller
public class HomeController {
	
	/**
	 * 首頁
	 */
	@RequestMapping(value = "/")
	public String home() {
		return "home";
	}
	
}
