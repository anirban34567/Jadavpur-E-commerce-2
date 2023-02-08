package com.niit.backend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.DAO.UserDAO;
import com.niit.backend.model.User;

public class UserTest 
{
	private static AnnotationConfigApplicationContext context;
	static User user;
	static UserDAO userDAO;	
	
	@BeforeClass
	public static void init() 
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.backend");
		context.refresh();
		
		userDAO = (UserDAO)context.getBean("userDAO");
	}
	
	@Test
	public void testInsert()
	{
		user = new User();
		/*
		user.setContactNumber("1234567890");
		user.setEmail("rohan@gmail.com");
		user.setEnabled(true);
		user.setFirstName("Rohan");
		user.setId(1);
		user.setLastName("Mishra");
		user.setPassword("user12345");
		user.setRole("USER");
		*/
		
		user.setContactNumber("7003836940");
		user.setEmail("anirban.mitra.sp@gmail.com");
		user.setEnabled(true);
		user.setFirstName("Anirban");
		//user.setId(2);
		user.setLastName("Mitra");
		user.setPassword("supplier12345");
		user.setRole("SUPPLIER");
		
		
		assertEquals("Error inserting user" ,  true , userDAO.insert(user));
	}
	
	@Test
	public void testGetUser()
	{
		user = userDAO.getUser("rohan@gmail.com");
		assertEquals("Error fetching user" , "Rohan" , user.getFirstName());
	}
	
	//@Test
		public void testSupplierList()
		{
				
				assertEquals("Error fetching user" , 2 , userDAO.getSupplierList().size());
		}

}
