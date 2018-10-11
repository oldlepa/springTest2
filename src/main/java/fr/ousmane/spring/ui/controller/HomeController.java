package fr.ousmane.spring.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public @ResponseBody String getHomePage() {
		return "Home";
	}
	
	@RequestMapping(value="/contacts", method=RequestMethod.GET)
	public @ResponseBody String getContactPage(){
		
		return "contacts";
	}

}
