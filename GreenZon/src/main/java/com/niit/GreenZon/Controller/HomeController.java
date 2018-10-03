package com.niit.GreenZon.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController 
{
	@RequestMapping(value = {"/","/home"})
	public String index(Model M) 
	{
		M.addAttribute("homepage", true);
		return "index";			
	}
	@RequestMapping(value ="/aboutus")
	public String aboutus(Model M) 
	{
		M.addAttribute("aboutuspage", true);
		return "index";			
	}
	@RequestMapping(value ="/contactus")
	public String contactus(Model M) 
	{
		M.addAttribute("contactuspage", true);
		return "index";			
	}
	
	
	


}
