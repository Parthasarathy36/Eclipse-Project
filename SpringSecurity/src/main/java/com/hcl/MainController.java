package com.hcl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView visitHome() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("welcome");
		return modelAndView;
	}

	@RequestMapping(value = "/success", method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("success");
		return modelAndView;
	}

	@RequestMapping(value = "/failure", method = RequestMethod.GET)
	public ModelAndView actor() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("failure");
		return modelAndView;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginPage(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout,
			@RequestParam(value = "role", required = false) String role) {
		System.out.println(role);
		ModelAndView modelAndView = new ModelAndView();
		if (error != null) {
			modelAndView.addObject("error", "Invlaid Credentials");
			modelAndView.setViewName("loginpage");
			return modelAndView;

		} else if (logout != null) {
			modelAndView.addObject("message", "Logged out Successfully");
			modelAndView.setViewName("loginpage");
			return modelAndView;

		} else if (logout == null && error == null) {
			return new ModelAndView("loginpage");

		}
		return new ModelAndView("success");

	}

}
