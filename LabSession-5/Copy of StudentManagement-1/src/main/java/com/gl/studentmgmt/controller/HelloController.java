package com.gl.studentmgmt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")

public class HelloController {
	
	@RequestMapping("/hello")
	public String showMainMenu()
	{
		return "MainMenu";
	}
//New Changes
}
