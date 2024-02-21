package com.vinay.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ServerController {
	
	@GetMapping("/")
    public ModelAndView home() 
	{
	    ModelAndView mview = new ModelAndView("index"); 
	    return mview;
    }
}
