package com.niit.GreenZonBack.DAO;

import java.util.List;

import com.niit.GreenZonBack.Model.Customer;
import com.niit.GreenZonBack.Model.UserCredentials;

public interface CustomerDAO
{
	public boolean addCustomer(Customer customer);
	public boolean updateCustomer(Customer customer);
	public boolean deleteCustomer(String emailId);
	public Customer showcustomer(String emailId);
	public List<Customer> showallcustomer();
	public UserCredentials showcred(String email);
	public boolean saveorupdatepassword(UserCredentials uc);
}
