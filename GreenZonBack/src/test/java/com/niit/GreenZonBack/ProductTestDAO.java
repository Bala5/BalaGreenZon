package com.niit.GreenZonBack;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.niit.GreenZonBack.DAO.ProductDAO;
import com.niit.GreenZonBack.Model.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=DBconfig.class)
public class ProductTestDAO 
{
	@Autowired
	ProductDAO productDAO;
	Product product=new Product();

	@Before
	public void setUp() throws Exception
	{
		product.setName("Carrot2");
		product.setDescription("Fresh and healthy");
		product.setPrice(55);
		product.setQuantity(5);
	}
	
	@After
	public void tearDown() throws Exception
	{
		//productDAO.deleteProduct("Carrot");
	}

	@Test
	public void test() 
	{
		productDAO.addProduct(product);
		//product=productDAO.showProduct("Carrot2");
		List<Product> list=productDAO.showallProduct();
		assertTrue("success",list.size()>0);
	}

}
