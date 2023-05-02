package com.niit.backend.DAO;

import java.util.List;

import com.niit.backend.model.Address;
import com.niit.backend.model.User;

public interface UserDAO 
{
	public boolean insert(User user);
	public User getUser(String email);
	public List<User> getSupplierList();
	public boolean insertAddress(Address address);
	public Address getBillingAddress(int id);
	public List<Address> getShippingAddress(int id);

}
