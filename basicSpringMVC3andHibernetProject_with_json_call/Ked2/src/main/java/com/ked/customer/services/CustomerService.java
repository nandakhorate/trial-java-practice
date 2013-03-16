package com.ked.customer.services;

import java.util.List;

import com.ked.pojo.Customer;
import com.ked.pojo.Site;


public interface CustomerService {
	
	public void addCustomer(Customer customer);
	public List<Customer> listCustomer();
	public void removeCustomer(long id);
	public Customer getCustomer(long id);
	public void updateCustomer(Customer customer);
}
