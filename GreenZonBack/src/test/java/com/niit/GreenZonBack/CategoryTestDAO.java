//package com.niit.GreenZonBack;
//
//
//import static org.junit.Assert.assertTrue;
//
//import java.util.List;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.niit.GreenZonBack.DAO.CategoryDAO;
//import com.niit.GreenZonBack.Model.Category;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes=DBconfig.class)
//public class CategoryTestDAO 
//{
//	@Autowired
//	CategoryDAO cd;
//	Category category= new Category();
//	
//	@Before
//	public void setUp() throws Exception 
//	{
//		category.setCategoryName("Freshvegetables");
//	}
//
//	@After
//	public void tearDown() throws Exception
//	{
//	//	cd.deleteCategory("Freshvegetables");
//	}
//
//	@Test
//	public void test() 
//	{
//		cd.addCategory(category);
//	//	category=cd.showCategory("Freshvegetables");
//		List<Category> list=cd.showAllCategory();
//		assertTrue("success",list.size()>0);
//		
//	}
//
//}
