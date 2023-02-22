package com.niit.frontend.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import com.niit.backend.DAO.UserDAO;
import com.niit.backend.model.Address;
import com.niit.backend.model.Cart;
import com.niit.backend.model.User;
import com.niit.frontend.model.RegisterModel;

@Component("registerHandler")
public class RegisterHandler 
{
	@Autowired
	UserDAO userDAO;
	
	public RegisterModel init()
	{
		return new RegisterModel();
	}
	
	public void addUser(RegisterModel registerModel, User user) {
		registerModel.setUser(user);
	}

	public void addBilling(RegisterModel registerModel, Address billing) {
		registerModel.setBilling(billing);
	}
	
	public String saveAll(RegisterModel registerModel) 
	{
		User user = registerModel.getUser();
		
		if (user.getRole().equals("USER")) 
		{
			Cart cart = new Cart();
			cart.setUser(user);
			user.setCart(cart);
		}
		
		userDAO.insert(user);
		
		
		Address billing = registerModel.getBilling();
		billing.setUserId(user.getId());
		billing.setBilling(true);
		
		
		userDAO.insertAddress(billing);
		
		return "success";
		
	}
	
	public String validate(User user , MessageContext error)
	{
		if(!(user.getPassword().equals(user.getConfirmPassword())))
		{
			error.addMessage(new MessageBuilder()
					.error()
					.source("confirmPassword")
					.defaultText("Password does not match confirm password!")
					.build());
			return "error";
		}
		
		return "billing";
		
	}
	
}