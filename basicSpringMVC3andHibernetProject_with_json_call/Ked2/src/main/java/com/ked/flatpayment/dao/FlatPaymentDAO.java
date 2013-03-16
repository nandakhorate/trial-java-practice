package com.ked.flatpayment.dao;

import java.util.List;

import com.ked.pojo.FlatPayment;
import com.ked.pojo.Site;


public interface FlatPaymentDAO {
	
	public void addFlatPayment(FlatPayment flatpayment);
	public List<FlatPayment> listFlatPayment();
	public void removeFlatPayment(long id);
	public FlatPayment getFlatPayment(long id);
	public void updateFlatPayment(FlatPayment flatpayment);
}
