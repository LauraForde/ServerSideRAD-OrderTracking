package com.sales.controllers;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sales.models.Product;
import com.sales.services.ProductSer;

@Controller
public class ProductCon {
	@Autowired ProductSer productS;
	
	@RequestMapping (value = "/showProducts", method = RequestMethod.GET)
	public String showProduct(Model m) {

		ArrayList<Product> products = productS.getAll();

		for (Product p1 : products) {
			System.out.println("name=" + p1.getpId() );
		}

		m.addAttribute("products", products);

		return "dispProduct";
	}
	
	@RequestMapping(value="/addProduct", method=RequestMethod.GET)
	public String getProduct(@ModelAttribute("prod") Product product, BindingResult bind, HttpServletRequest req, Model m){
		System.out.println("Request = " + req.getMethod());
		return "addProduct";
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public String postProduct(@Valid @ModelAttribute("prod") Product product, BindingResult bind, HttpServletRequest req, Model m){


		System.out.println("HTTP Request = " + req.getMethod());

		productS.save(product);

		ArrayList<Product> products = productS.getAll();

		for (Product p1 : products) {
			System.out.println("name=" + p1.getpId());
		}

		m.addAttribute("products", products);

		return "dispProduct";
	}
}
