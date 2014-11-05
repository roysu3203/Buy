package com.roy.buy.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.roy.buy.constant.View;
import com.roy.buy.exception.DataCheckException;
import com.roy.buy.form.RegisterForm;
import com.roy.buy.service.IUserService;
import com.roy.buy.service.impl.UserService;

/**
 * 註冊相關 Controller
 */
@Controller
@RequestMapping("/Register/*")
public class RegisterController {

	/** 自動注入 UserService */
	@Autowired
	private IUserService userService;

	/**
	 * 註冊View
	 */
	@RequestMapping(value = "View")
	public String view(Model model) {
		model.addAttribute("registerFrom", new RegisterForm());
		return View.REGISTER_FORM;
	}

	/**
	 * 使用者註冊
	 */
	@RequestMapping(value = "Save")
	public String save(Model model, RegisterForm form) {
		// 若驗證失敗, 返回註冊表單
		if(form.validateFail()) {
			model.addAttribute("errorMessage", form.getErrorMessage());
			model.addAttribute("registerFrom", form);
			return View.REGISTER_FORM;
		}
		
		try {
			userService.register(form.toUser());
		} catch(DataCheckException e) {
			model.addAttribute("errorMessage", Arrays.asList(e.getMessage()));
			model.addAttribute("registerFrom", form);
			return View.REGISTER_FORM;
		}
		
		model.addAttribute("name", form.getName());
		return View.REGISTER_SUCCESS;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
