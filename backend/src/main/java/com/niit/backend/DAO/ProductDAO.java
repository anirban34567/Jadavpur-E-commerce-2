package com.niit.backend.DAO;

import java.util.List;

import com.niit.backend.model.Product;

public interface ProductDAO 
{
	public boolean insert(Product product);
	boolean update(Product product);
	Product getProduct(int p_id);
	List<Product> listProduct();
	List<Product> listActiveProducts();	
	List<Product> listActiveProductsByCategory(int categoryId);
	List<Product> topPurchasedProduct(); 

}
