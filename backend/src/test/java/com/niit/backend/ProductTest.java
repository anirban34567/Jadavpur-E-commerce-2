package com.niit.backend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.DAO.ProductDAO;
import com.niit.backend.model.Product;

public class ProductTest 
{
	private static AnnotationConfigApplicationContext context;
	static Product product;
	static ProductDAO productDAO;	
	
	@BeforeClass
	public static void init() 
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.backend");
		context.refresh();
		
		productDAO = (ProductDAO)context.getBean("productDAO");
	}
	
	@Test
	public void testInsert()
	{
		product = new Product();
		//product.setId(18);
		product.setName("Noise Icon Buzz BT Calling ");
		product.setBrand("Noise");
		product.setDescription("1.69\" display , AI Voice Assistance, Built-In Games Smartwatch  (Black Strap, Regular)");
		product.setUnitPrice(1700.00);
		product.setActive(true);
		product.setCategoryId(6);
		product.setSupplierId(12);
		product.setQuantity(10);
		
		assertEquals("Error" , true , productDAO.insert(product));
	}
	
	//@Test
		public void testGetProduct()
		{
			product = productDAO.getProduct(1);
			
			assertEquals("Error" , "PRDf311b4016544", product.getCode());
		}
		
		//@Test
		public void testActiveProduct()
		{
			assertEquals("Error" ,3, productDAO.listActiveProducts().size());
		}
		
		@Test
		public void testActiveCategoryProduct()
		{
			assertEquals("Error" ,2, productDAO.listActiveProductsByCategory(5).size());
		}

}
