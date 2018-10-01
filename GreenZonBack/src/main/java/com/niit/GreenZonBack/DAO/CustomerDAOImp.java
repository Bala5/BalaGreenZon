package com.niit.GreenZonBack.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.GreenZonBack.Model.Customer;
import com.niit.GreenZonBack.Model.UserCredentials;
@Repository("CustomerDAO")
@Transactional
public class CustomerDAOImp implements CustomerDAO
{
	@Autowired
	SessionFactory sf;
	
	public boolean addCustomer(Customer customer) {
		try
		{
			UserCredentials u=new UserCredentials();
			u.setEmailId(customer.getEmailid());
			u.setPassword(customer.getPassword());
			u.setRole("ROLE_USER");
			sf.getCurrentSession().saveOrUpdate(customer);
			sf.getCurrentSession().saveOrUpdate(u);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean updateCustomer(Customer customer) 
	{
		try
		{
			sf.getCurrentSession().saveOrUpdate(customer);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	
	}

	public boolean deleteCustomer(String emailId) 
	{
		try 
		{
			sf.getCurrentSession().delete(showcustomer(emailId));
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}

	public Customer showcustomer(String emailId) 
	{
		try
		{
			Customer customer=(Customer)sf.getCurrentSession().createQuery("from the customer EmailId= '"+emailId+"'").uniqueResult();
			return customer;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}

	public List<Customer> showallcustomer() 
	{ 
		try
		{
	
			ArrayList<Customer> customer=(ArrayList<Customer>)sf.getCurrentSession().createQuery("From the Customer").list();
			return customer;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	
	}

	public UserCredentials showcred(String email) 
	{
		try
		{
		UserCredentials customer=(UserCredentials) sf.getCurrentSession().createQuery("From UserCredentials where emailId= '"+email+ "'").uniqueResult();	
		return customer;
		}
		catch(Exception e)
		{
			return null;
		}

	}

	public boolean saveorupdatepassword(UserCredentials uc) 
	{
		 try
		 {
			 sf.getCurrentSession().saveOrUpdate(uc);
			 return true;
		 }
		 catch(Exception e)
		 {
			 return false;
		 }
	
	}

}
