package com.xzw.crud.controller;

import java.lang.reflect.Method;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xzw.crud.mapper.UserMapper;
import com.xzw.crud.pojo.User;
import com.xzw.crud.service.UserService;

@Controller
public class loginController {

	@Autowired
	private UserService userService;

	/*
	 * @RequestMapping("index") public String start() { return "index"; }试试看有没有更新
	 */

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password, Model model) {

		User user = userService.login(username, password);
		if (user == null) {
			return "index";
		}
		model.addAttribute("user", user);
		List<User> list = userService.findAll();
		model.addAttribute("list", list);
		return "welcome";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(Model model) {
		User user=null;
		model.addAttribute("user",user);
		return "register";
	}
	
	@RequestMapping(value = "/register1", method = RequestMethod.POST)
	public String register1(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password, Model model) {

		userService.register(username, password);

		User user = userService.login(username, password);
		model.addAttribute("user", user);
		List<User> list = userService.findAll();
		model.addAttribute("list", list);
		return "welcome";
	}
	
	
	@RequestMapping(value = "/update/q/w/e/r/{id}", method = RequestMethod.GET)
	public String updateById(@PathVariable("id") Integer id, Model model) {
		
		User user=userService.findById(id);
		model.addAttribute("user", user);
		return "update";
	}
	
	@RequestMapping(value = "/update1", method = RequestMethod.POST)
	public String updateByid1(@RequestParam("id") Integer id,
			@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password,Model model) {
		
	    userService.updateById(id,username,password);
	    User user=userService.findById(id);
	    model.addAttribute("user", user);
		model.addAttribute("list", userService.findAll());
		return "welcome";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteById(@PathVariable("id") Integer id, Model model) {
		
		userService.deleteById(id);
		model.addAttribute("list", userService.findAll());
		return "welcome";
	}	
	

}
