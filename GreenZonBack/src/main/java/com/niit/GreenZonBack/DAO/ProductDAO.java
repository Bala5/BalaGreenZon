package com.niit.GreenZonBack.DAO;

import java.util.List;

import com.niit.GreenZonBack.Model.Product;

public interface ProductDAO
{
	public boolean addProduct(Product product);
	public boolean deleteProduct(int productid);
	public Product showProduct(int productid);
	public List<Product> showallProduct();
	public List<Product> searchCatogory(int catid);
}
