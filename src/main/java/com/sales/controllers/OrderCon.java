package com.sales.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sales.models.Order;
import com.sales.services.OrderSer;

@Controller
public class OrderCon {
	
@Autowired OrderSer orderS;
	
	@RequestMapping (value = "/showOrders", method = RequestMethod.GET)
	public String showOrder(Model m) {

		ArrayList<Order> orders = orderS.getAll();

		for (Order o1 : orders) {
			System.out.println("name=" + o1.getoId() );
		}

		m.addAttribute("orders", orders);

		return "dispOrder";
	}

}
