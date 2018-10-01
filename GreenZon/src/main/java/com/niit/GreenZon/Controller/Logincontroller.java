package com.niit.GreenZon.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.GreenZonBack.DAO.CustomerDAO;
import com.niit.GreenZonBack.Model.Customer;

@Controller
public class Logincontroller 
{
	@Autowired
	CustomerDAO custdao;
	
	@RequestMapping(value = "/register")
	public String getregisterpage(Model M) 
	{
		M.addAttribute("registerpage", true);
		M.addAttribute("errstatus",false);
		M.addAttribute("succstatus",false);
		M.addAttribute("customer",new Customer());
		return "index";			
	}
	
	
	@RequestMapping(value = "/registeruser",method=RequestMethod.POST)
	public String postregisterpage(@Valid @ModelAttribute("customer")Customer newcoustomer,BindingResult result,Model M)
	{
		if(result.hasErrors())
		{
			M.addAttribute("customer",newcoustomer);
			M.addAttribute("errstatus",true);
			M.addAttribute("succstatus",false);
			M.addAttribute("registerpage", true);
			
		}
		else
		{
			custdao.addCustomer(newcoustomer);
			M.addAttribute("customer",new Customer());
			M.addAttribute("errstatus",false);
			M.addAttribute("succstatus",true);
			M.addAttribute("registerpage", true);
		}
		return "index";			
	}
	

}
