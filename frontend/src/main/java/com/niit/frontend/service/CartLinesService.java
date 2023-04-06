package com.niit.frontend.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.backend.DAO.CartLinesDAO;
import com.niit.backend.DAO.ProductDAO;
import com.niit.backend.model.Cart;
import com.niit.backend.model.CartLines;
import com.niit.backend.model.Product;
import com.niit.frontend.model.UserModel;

@Service()
public class CartLinesService 
{
	@Autowired
	private HttpSession session;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CartLinesDAO cartlinesDAO;
	
	private Cart getCart()
	{
		return ((UserModel)session.getAttribute("userModel")).getCart();
	}
	
	public String addCartLineProduct(int p_Id)
	{
		Cart cart = this.getCart();
		CartLines ct = cartlinesDAO.getByCartAndProduct(cart.getId(), p_Id);
		if (ct== null)
		{
			ct =new CartLines();
			Product p = productDAO.getProduct(p_Id);
		
			ct.setAvailable(true);
			ct.setBuyingPrice(p.getUnitPrice());
			ct.setCartId(cart.getId());
			ct.setProduct(p);
			ct.setProductCount(1);
			ct.setTotal(ct.getBuyingPrice() * ct.getProductCount());
		
			cartlinesDAO.add(ct);
		
			cart.setCartLines(cart.getCartLines() + 1);
			cart.setGrandTotal(cart.getGrandTotal() + ct.getTotal());
		
			cartlinesDAO.updateCart(cart);
		}
		else
		{
			ct.setProductCount(ct.getProductCount() + 1);
			ct.setTotal(ct.getBuyingPrice() + ct.getTotal());
			cart.setGrandTotal(cart.getGrandTotal() + ct.getBuyingPrice());
			cartlinesDAO.update(ct);
			cartlinesDAO.updateCart(cart);
		}
		
			return "result=added";
		
	}
	
	public List<CartLines> getCartLines()
	{
		Cart cart =  this.getCart();
		return cartlinesDAO.list(cart.getId());
	}

}
