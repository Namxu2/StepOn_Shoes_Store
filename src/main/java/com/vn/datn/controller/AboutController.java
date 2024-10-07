package com.vn.datn.controller;

import com.vn.datn.commom.CommonDataService;
import com.vn.datn.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class AboutController extends CommomController {

	@Autowired
	CommonDataService commomDataService;

	@GetMapping(value = "/aboutUs")
	public String about(Model model, User user) {

		commomDataService.commonData(model, user);
		return "web/about";
	}
}
