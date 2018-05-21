package com.example.Bond.controller;

import java.util.List;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Bond.pojo.BondService;
import com.example.Bond.pojo.Bondd;

@RestController
public class BondController {

	@Autowired
	private BondService bondservice;

	@RequestMapping("/Hi")
	public String sayHi() {
		return "Hi";
	}

	@RequestMapping("/login")
	public List<Bondd> getList() {
		return Arrays.asList(new Bondd("daniel", "Audi", 6), new Bondd("sean", "mercedes", 2),
				new Bondd("roger", "bmw", 3));
	}

	@RequestMapping("/list/{name}")
	public Bondd getNname(@PathVariable String name) {
		return bondservice.getBond(name);
	}
//	@RequestMapping(value="/login/{username}", method=RequestMethod.GET)

	@RequestMapping("/loginb")
	public String login(@PathVariable("username") String name, int password, @RequestBody Bondd bondlogin) {

		List<Bondd> result = null;
		if (name.equals(bondlogin.getName())) {
			result = getList();

		//} else if (name == "bond" && password == 004) {
		//	result = getList();

		}

		return "result";

	}
	
	/*
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
		@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;

	}

	*/
	
	
}