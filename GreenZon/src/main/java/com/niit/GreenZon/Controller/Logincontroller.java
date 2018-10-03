package com.niit.GreenZon.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.GreenZonBack.DAO.CustomerDAO;
import com.niit.GreenZonBack.Model.Customer;
import com.niit.GreenZonBack.Model.UserCredentials;

@Controller
public class Logincontroller {
	@Autowired
	CustomerDAO custdao;

	@RequestMapping(value = "/register")
	public String getregisterpage(Model M) {
		M.addAttribute("registerpage", true);
		M.addAttribute("errstatus", false);
		M.addAttribute("succstatus", false);
		M.addAttribute("customer", new Customer());
		return "index";
	}

	@RequestMapping(value = "/registeruser", method = RequestMethod.POST)
	public String postregisterpage(@Valid @ModelAttribute("customer") Customer newcoustomer, BindingResult result,
			Model M) {
		if (result.hasErrors()) {
			M.addAttribute("customer", newcoustomer);
			M.addAttribute("errstatus", true);
			M.addAttribute("succstatus", false);
			M.addAttribute("registerpage", true);

		} else {
			custdao.addCustomer(newcoustomer);
			M.addAttribute("customer", new Customer());
			M.addAttribute("errstatus", false);
			M.addAttribute("succstatus", true);
			M.addAttribute("registerpage", true);
		}
		return "index";
	}

	@RequestMapping(value = "/ulogin")
	public String ulogin(Model M,@RequestParam(value = "logout",required = false) String logout,HttpServletRequest request) {
		if(logout != null)
		{
			HttpSession session=request.getSession();
			if(session!=null)
			{
				System.out.println(session.getLastAccessedTime());
				session=null;
			}
			SecurityContextHolder.clearContext();
			M.addAttribute("lerrstatus", false);
			M.addAttribute("ulogin", true);
			M.addAttribute("logoutstate",true);	
		}
		else
		{
			M.addAttribute("logoutstate",false);
			M.addAttribute("lerrstatus", false);
			M.addAttribute("ulogin", true);
		}
		
		return "index";
	}

	@RequestMapping(value = "/flogin")
	public String failedlogin(Model M) {
		M.addAttribute("lerrstatus", true);
		M.addAttribute("ulogin", true);
		return "index";
	}

	@RequestMapping(value = "/loginsucess")
	public String loginsuccess(Model M, HttpSession session) {

		String useremail = SecurityContextHolder.getContext().getAuthentication().getName();
		UserCredentials credentials = custdao.showcred(useremail);
		if (credentials.getRole().equals("ROLE_USER"))
		{
			Customer customer = custdao.showcustomer(useremail);
			session.setAttribute("username", customer.getName());
			session.setAttribute("useremail", customer.getEmailid());
			session.setAttribute("usercartid", customer.getCartid());
			session.setAttribute("Userlogin", true);
			return "redirect:/productdisp";

		} else {
			session.setAttribute("username", "Administrator");
			session.setAttribute("Userlogin", false);
			return "redirect:/";

		}
	}	
	
}
