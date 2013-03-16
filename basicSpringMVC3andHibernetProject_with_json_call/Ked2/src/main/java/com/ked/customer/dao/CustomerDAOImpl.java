package com.ked.customer.dao;

import java.util.List;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ked.pojo.Customer;
import com.ked.pojo.Site;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addCustomer(Customer customer) {
		sessionFactory.getCurrentSession().save(customer);
	}

	public List<Customer> listCustomer() {

		return sessionFactory.getCurrentSession().createQuery("from Customer").list();
	}

	public void removeCustomer(long id) {
		Customer customer = (Customer) sessionFactory.getCurrentSession().get(
				Customer.class, id);
		if (null != customer) {
			sessionFactory.getCurrentSession().delete(customer);
		}

	}

	public Customer getCustomer(long id) {
		//if you write load then null value pass (lazy loading happed) so i used get method.
		Customer customer = (Customer) sessionFactory.getCurrentSession().get(Customer.class, id);
		return customer;
	}

	public void updateCustomer(Customer customer) {
		sessionFactory.getCurrentSession().update(customer);
		
	}

}
