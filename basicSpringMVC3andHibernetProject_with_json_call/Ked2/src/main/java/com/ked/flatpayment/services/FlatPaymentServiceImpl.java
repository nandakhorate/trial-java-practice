package com.ked.flatpayment.services;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ked.flatpayment.dao.FlatPaymentDAO;
import com.ked.pojo.FlatPayment;
import com.ked.pojo.Site;
import com.ked.site.dao.SiteDAO;

@Service
public class FlatPaymentServiceImpl implements FlatPaymentService {

	@Autowired
	private FlatPaymentDAO flatpaymentDAO;
	
	@Transactional
	public void addFlatPayment(FlatPayment flatpayment) {
		flatpaymentDAO.addFlatPayment(flatpayment);
	}

	@Transactional
	public List<FlatPayment> listFlatPayment() {

		return flatpaymentDAO.listFlatPayment();
	}

	@Transactional
	public void removeFlatPayment(long id) {
		flatpaymentDAO.removeFlatPayment(id);
	}
	@Transactional
	public FlatPayment getFlatPayment(long id) {
		return flatpaymentDAO.getFlatPayment(id);
	}
	@Transactional
	public void updateFlatPayment(FlatPayment flatpayment) {
		flatpaymentDAO.updateFlatPayment(flatpayment);
		
	}

	
}
