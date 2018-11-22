package com.fsd.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fsd.entity.User;

/*import com.fsd.entity.User;*/

@Controller
public class HomeController {

	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home1() {
		return "home";
	}
	
	@RequestMapping(value = "/addBook", method = RequestMethod.GET)
	public String addBook() {
		return "addBook";
	}
	@RequestMapping(value = "/deleteSubject", method = RequestMethod.GET)
	public String deleteSubject() {
		return "deleteSubject";
	}
	@RequestMapping(value = "/deleteBook", method = RequestMethod.GET)
	public String deleteBook() {
		return "deleteBook";
	}
	@RequestMapping(value = "/searchBook", method = RequestMethod.GET)
	public String searchBook() {
		return "searchBook";
	}
	@RequestMapping(value = "/searchSubject", method = RequestMethod.GET)
	public String searchSubject() {
		return "searchSubject";
	}
	
	@RequestMapping(value = "/exit", method = RequestMethod.GET)
	public String exit() {
		return "exit";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String user(@Validated User user, Model model) {
		System.out.println("User Page Requested");
		model.addAttribute("userName", user.getUserName());
		return "user";
	}
	
	
	

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		System.out.println("Home Page Requested, locale = " + locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}
}