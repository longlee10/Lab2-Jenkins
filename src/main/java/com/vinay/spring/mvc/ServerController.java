package com.vinay.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import java.time.LocalTime;

@Controller
public class ServerController {
	
	@GetMapping("/")
    public ModelAndView home() 
	{
	    ModelAndView mview = new ModelAndView("index"); 
		mview.addObject("greeting", getGreeting());
	    return mview;
    }

	private String getGreeting() {
        LocalTime currentTime = LocalTime.now();
        if (currentTime.isBefore(LocalTime.NOON)) {
            return "Good morning Hoang";
        } else {
            return "Good afternoon Hoang";
        }
    }
}
