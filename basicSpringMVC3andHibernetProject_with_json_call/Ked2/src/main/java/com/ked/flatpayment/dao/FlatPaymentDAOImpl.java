package com.ked.flatpayment.dao;

import java.util.List;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ked.pojo.FlatPayment;
import com.ked.pojo.Site;

@Repository
public class FlatPaymentDAOImpl implements FlatPaymentDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addFlatPayment(FlatPayment flatpayment) {
		sessionFactory.getCurrentSession().save(flatpayment);
	}

	public List<FlatPayment> listFlatPayment() {

		return sessionFactory.getCurrentSession().createQuery("from FlatPayment").list();
	}

	public void removeFlatPayment(long id) {
		FlatPayment flatpayment = (FlatPayment) sessionFactory.getCurrentSession().get(
				FlatPayment.class, id);
		if (null != flatpayment) {
			sessionFactory.getCurrentSession().delete(flatpayment);
		}

	}

	public FlatPayment getFlatPayment(long id) {
		//if you write load then null value pass (lazy loading happed) so i used get method.
		FlatPayment flatpayment = (FlatPayment) sessionFactory.getCurrentSession().get(FlatPayment.class, id);
		return flatpayment;
	}

	public void updateFlatPayment(FlatPayment flatpayment) {
		sessionFactory.getCurrentSession().update(flatpayment);
		
	}

}
