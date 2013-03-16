package com.ked.customer.services;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ked.customer.dao.CustomerDAO;
import com.ked.pojo.Customer;
import com.ked.pojo.Site;
import com.ked.site.dao.SiteDAO;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	
	@Transactional
	public void addCustomer(Customer customer) {
		customerDAO.addCustomer(customer);
	}

	@Transactional
	public List<Customer> listCustomer() {

		return customerDAO.listCustomer();
	}

	@Transactional
	public void removeCustomer(long id) {
		customerDAO.removeCustomer(id);
	}
	@Transactional
	public Customer getCustomer(long id) {
		return customerDAO.getCustomer(id);
	}
	@Transactional
	public void updateCustomer(Customer customer) {
		customerDAO.updateCustomer(customer);
		
	}

	
}
