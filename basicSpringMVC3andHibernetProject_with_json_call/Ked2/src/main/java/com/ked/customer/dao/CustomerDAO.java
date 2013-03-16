package com.ked.customer.dao;

import java.util.List;
import com.ked.pojo.Customer;

public interface CustomerDAO {
	public void addCustomer(Customer customer);
	public List<Customer> listCustomer();
	public void removeCustomer(long id);
	public Customer getCustomer(long id);
	public void updateCustomer(Customer customer);
}
