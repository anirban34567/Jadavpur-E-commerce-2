package com.niit.frontend.handler;

import org.springframework.stereotype.Component;

import com.niit.backend.model.Address;
import com.niit.backend.model.User;
import com.niit.frontend.model.RegisterModel;

@Component("registerHandler")
public class RegisterHandler 
{

	public RegisterModel init()
	{
		return new RegisterModel(); 
	}
	
	public void addUser(RegisterModel registerModel, User user) 
	{
		registerModel.setUser(user);
	}

	public void addBilling(RegisterModel registerModel, Address billing) 
	{
		registerModel.setBilling(billing);
	}
}