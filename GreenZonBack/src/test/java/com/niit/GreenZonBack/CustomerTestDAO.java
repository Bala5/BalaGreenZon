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

import com.niit.GreenZonBack.DAO.CustomerDAO;
import com.niit.GreenZonBack.Model.Customer;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=DBconfig.class)
public class CustomerTestDAO 
{
	@Autowired
	CustomerDAO customerdao1;
	Customer customer1=new Customer();

	@Before
	public void setUp() throws Exception
	{
		customer1.setEmailid("sri1@gmail.com");
		customer1.setName("Sri1");
		customer1.setPhoneNo("9659628775");
		customer1.setPassword("564582626");
	}

	@After
	public void tearDown() throws Exception 
	{
		customerdao1.deleteCustomer("sri1@gmail.com");
	}

	@Test
	public void test()
	{
		customerdao1.addCustomer(customer1);
		customer1=customerdao1.showcustomer("sri1@gmail.com");
		List<Customer> list=customerdao1.showallcustomer();
		assertTrue("success",list.size()>0);
		
		
	}

}
