package com.niit.GreenZonBack.DAO;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.GreenZonBack.Model.Product;


@Repository("productDAO")
@Transactional
public class ProductDAOImp implements ProductDAO 

{
	@Autowired
	SessionFactory sf;

	public boolean addProduct(Product product)
	{
		try
		{
			sf.getCurrentSession().saveOrUpdate(product);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean deleteProduct(int productid)
	{
		try
		{
		sf.getCurrentSession().delete(showProduct(productid));
		return true;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	
	}

	public Product showProduct(int productid) 
	{
		try
		{
			Product product=(Product)sf.getCurrentSession().createQuery("From Product where productid="+productid).uniqueResult();
			return product;
		}
		catch(Exception e)
		{
			return null;
		}

	}

	public List<Product> showallProduct() 
	{
		try
		{
			@SuppressWarnings("unchecked")
			ArrayList<Product> product=(ArrayList<Product>)sf.getCurrentSession().createQuery("from Product").list();
			System.out.println(product.isEmpty() );
			return product;
		}
		catch(Exception e)
		{
		return null;	
		}
	}

	public List<Product> searchCatogory(int catid)
	{ 
		try
		{
			ArrayList<Product> product=(ArrayList<Product>)sf.getCurrentSession().createQuery("From Product where catid= '"+catid+ "'").list();
			return product;
		}
		catch(Exception e)
		{
			return null;
		}

	}

	
}
