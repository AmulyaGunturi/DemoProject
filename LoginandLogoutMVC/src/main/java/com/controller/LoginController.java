package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
  @RequestMapping(value = "/page",method = RequestMethod.GET)
  public String login(Model model) {
    return "loginpage";  
}
  

  @RequestMapping(method = RequestMethod.POST)
  public String submit(Model model, @ModelAttribute("login") Login login) {
	String str="";		  
	if(login.getUsername() != str && login.getPassword() != str)
    {
      if (login.getUsername().equals("John") && login.getPassword().equals("123"))
      {
        model.addAttribute("msg", login.getUsername());
        return "success";
      } 
      else 
      {
        model.addAttribute("error", "Invalid Details!!");
        return "error";
      }
    }
    else {
      model.addAttribute("error", "Please enter all the details!");
      return "error";
    }
     
  }
}
