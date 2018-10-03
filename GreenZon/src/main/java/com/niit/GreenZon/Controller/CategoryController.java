package com.niit.GreenZon.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.GreenZonBack.DAO.CategoryDAO;
import com.niit.GreenZonBack.Model.Category;

@Controller
public class CategoryController 
{
	@Autowired
	CategoryDAO categoryadd;
	@RequestMapping(value = "addcategory")
	public String getaddcategorypage(Model M) 
	{
		M.addAttribute("errstatus",false);
		M.addAttribute("editmode",false);
		M.addAttribute("succstatus",false);
		M.addAttribute("addcategorypage", true);
		M.addAttribute("catlist",categoryadd.showAllCategory());
		M.addAttribute("category",new Category());
		return "index";			
	}
	
	@RequestMapping(value = "editcat")
	public String geteditcategorypage(Model M,@RequestParam("catid")int catid) 
	{
		M.addAttribute("errstatus",false);
		M.addAttribute("succstatus",false);
		M.addAttribute("editmode",true);
		M.addAttribute("addcategorypage", true);
		M.addAttribute("catlist",categoryadd.showAllCategory());
		M.addAttribute("category",categoryadd.showCategory(catid));
		return "index";			
	}
	
	@RequestMapping(value = "removecat")
	public String getremovetcategorypage(Model M,@RequestParam("catid")int catid) 
	{
		categoryadd.deleteCategory(catid);
		M.addAttribute("errstatus",false);
		M.addAttribute("succstatus",false);
		M.addAttribute("editmode",false );
		M.addAttribute("addcategorypage", true);
		M.addAttribute("catlist",categoryadd.showAllCategory());
		M.addAttribute("category",new Category());
		return "index";			
	}
	
	
	@RequestMapping(value = "categoryadd",method=RequestMethod.POST)
	public String postcategorypage(@Valid @ModelAttribute("category")Category newcategory,BindingResult result,Model M)
	{
		if(result.hasErrors())
		{
			M.addAttribute("category",newcategory);
			M.addAttribute("errstatus",true);
			M.addAttribute("succstatus",false);
			M.addAttribute("addcategorypage", true);
			M.addAttribute("catlist",categoryadd.showAllCategory());
			M.addAttribute("editmode",false);
		}
		else
		{
			categoryadd.addCategory(newcategory);
			M.addAttribute("category",new Category());
			M.addAttribute("errstatus",false);
			M.addAttribute("succstatus",true);
			M.addAttribute("addcategorypage", true);
			M.addAttribute("catlist",categoryadd.showAllCategory());
			M.addAttribute("editmode",false);
		}
		return "index";			
	}

}
