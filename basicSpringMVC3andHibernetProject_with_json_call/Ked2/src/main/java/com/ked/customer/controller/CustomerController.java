package com.ked.customer.controller;




import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ked.customer.services.CustomerService;
import com.ked.pojo.Customer;


@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerServie;
	
	@RequestMapping(value="/customerlist", method = RequestMethod.GET)
	public String listCustomer(Map<String, Object> map) {
		
		map.put("customerlist", customerServie.listCustomer());
		
		return "/customer/customerlist";
	}

	
	@RequestMapping(value = "/addcustomer", method = RequestMethod.POST)
	public String addCustomerlist(@ModelAttribute("customer") Customer customer, BindingResult result, ModelMap model) {
		
			customerServie.addCustomer(customer);
			//model.addAttribute("ressite", site);
			return "redirect:/customer/customerlist";
		
	}

	@RequestMapping("/deletecustomer/{customerId}")
	public String deleteCustomer(@PathVariable("customerId") Integer customerId) {
		
		customerServie.removeCustomer(customerId);
		return "redirect:/customer/customerlist";
		
	}
	
	@RequestMapping(value="/addcustomer", method = RequestMethod.GET)
	public String actionViewCustomer(Map<String, Object> map) {
		
		map.put("customer", new Customer());
		map.put("action","/Ked2/customer/addcustomer");
		return "/customer/customeraction";
	}
	
	
	
	@RequestMapping(value="/viewcustomer/{customerId}", method = RequestMethod.GET)
	public String viewCustomer(Map<String, Object> map, @PathVariable("customerId") Integer customerId) {
		
		Customer customer = customerServie.getCustomer(customerId);
		
		map.put("customer", customer);
		map.put("action","/Ked2/customer/updatecustomer");
		map.put("view", "view");
		
		return "/customer/customeraction";
	}
	@RequestMapping(value = "/updatecustomer", method = RequestMethod.POST)
	public String updateCustomer(@ModelAttribute("customer")
	Customer customer, BindingResult result,ModelMap model) {

			customerServie.updateCustomer(customer);
			//model.addAttribute("rescustomer", customer);
			return "redirect:/customer/customerlist";
	}
	
	
	
}
