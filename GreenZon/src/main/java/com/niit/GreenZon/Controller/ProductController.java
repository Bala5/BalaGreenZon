package com.niit.GreenZon.Controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.niit.GreenZonBack.DAO.CategoryDAO;
import com.niit.GreenZonBack.DAO.ProductDAO;
import com.niit.GreenZonBack.Model.Product;

@Controller
public class ProductController {
	@Autowired
	ProductDAO productadd;

	@Autowired
	CategoryDAO catedao;

	@RequestMapping(value = "/addproduct")
	public String getaddproductpage(Model M) {
		M.addAttribute("errstatus", false);
		M.addAttribute("succstatus", false);
		M.addAttribute("editmode", false);
		M.addAttribute("addproductpage", true);
		M.addAttribute("catlist", catedao.showAllCategory());
		M.addAttribute("product", new Product());
		M.addAttribute("productlist", productadd.showallProduct());
		return "index";
	}

	@RequestMapping(value = "/productdisp")
	public String showallproductpage(Model M) {
		M.addAttribute("productlist", productadd.showallProduct());
		M.addAttribute("ProductDisp", true);
		return "index";
	}
	

	@RequestMapping(value = "/oneproductdisp")
	public String showoneproductpage(Model M, @RequestParam("productid") int productid) {
		M.addAttribute("product", productadd.showProduct(productid));
		M.addAttribute("OneProductDisp", true);
		return "index";
	}

	@RequestMapping(value = "/editproduct")
	public String geteditproductpage(Model M, @RequestParam("productid") int productid) {
		M.addAttribute("errstatus", false);
		M.addAttribute("succstatus", false);
		M.addAttribute("editmode", true);
		M.addAttribute("addproductpage", true);
		M.addAttribute("catlist", catedao.showAllCategory());
		M.addAttribute("productlist", productadd.showallProduct());
		M.addAttribute("product", productadd.showProduct(productid));
		return "index";
	}

	@RequestMapping(value = "/removeproduct")
	public String getremoveproductpage(Model M, @RequestParam("productid") int productid) {
		productadd.deleteProduct(productid);
		M.addAttribute("errstatus", false);
		M.addAttribute("succstatus", false);
		M.addAttribute("editmode", false);
		M.addAttribute("addproductpage", true);
		M.addAttribute("catlist", catedao.showAllCategory());
		M.addAttribute("productlist", productadd.showallProduct());
		M.addAttribute("product", new Product());
		return "index";
	}

	@RequestMapping(value = "/productadd", method = RequestMethod.POST)
	public String postproductpage(@Valid @ModelAttribute("product") Product newproduct, BindingResult result, Model M) {
		try {
			if (result.hasErrors()) {
				M.addAttribute("product", newproduct);
				M.addAttribute("errstatus", true);
				M.addAttribute("succstatus", false);
				M.addAttribute("editmode", false);
				M.addAttribute("addproductpage", true);
				M.addAttribute("catlist", catedao.showAllCategory());
				M.addAttribute("productlist", productadd.showallProduct());
			} else {
				productadd.addProduct(newproduct);
				String path = "E:\\Eclipse-EclipseWorkspace\\GreenZon\\src\\main\\webapp\\resources\\productimages\\";
				path = path + String.valueOf(newproduct.getProductid() + ".jpg");
				MultipartFile f = newproduct.getImage();
				if (!f.isEmpty()) {
					byte b[] = f.getBytes();
					File imgfile = new File(path);
					BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(path)));
					if (imgfile.exists()) {
						imgfile.delete();
						bos.write(b);
						bos.close();
					} else {
						bos.write(b);
						bos.close();
					}
					Thread.sleep(3000);
				} else {

				}
				M.addAttribute("product", new Product());
				M.addAttribute("errstatus", false);
				M.addAttribute("succstatus", true);
				M.addAttribute("editmode", false);
				M.addAttribute("addproductpage", true);
				M.addAttribute("catlist", catedao.showAllCategory());
				M.addAttribute("productlist", productadd.showallProduct());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "index";
	}
}
