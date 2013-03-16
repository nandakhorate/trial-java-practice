package com.ked.flatpayment.controller;




import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ked.flatpayment.services.FlatPaymentService;
import com.ked.pojo.FlatPayment;


@Controller
@RequestMapping("/flatpayment")
public class FlatPaymentController {
	
	@Autowired
	private FlatPaymentService flatpaymentServie;
	
	@RequestMapping(value="/flatpaymentlist", method = RequestMethod.GET)
	public String listFlatPayment(Map<String, Object> map) {
		
		map.put("flatpaymentlist", flatpaymentServie.listFlatPayment());
		
		return "/flatpayment/flatpaymentlist";
	}

	
	@RequestMapping(value = "/addflatpayment", method = RequestMethod.POST)
	public String addFlatPaymentlist(@ModelAttribute("flatpayment") FlatPayment flatpayment, BindingResult result, ModelMap model) {
		
			flatpaymentServie.addFlatPayment(flatpayment);
			//model.addAttribute("ressite", site);
			return "redirect:/flatpayment/flatpaymentlist";
		
	}

	@RequestMapping("/deleteflatpayment/{flatpaymentId}")
	public String deleteFlatPayment(@PathVariable("flatpaymentId") Integer flatpaymentId) {
		
		flatpaymentServie.removeFlatPayment(flatpaymentId);
		return "redirect:/flatpayment/flatpaymentlist";
		
	}
	
	@RequestMapping(value="/addflatpayment", method = RequestMethod.GET)
	public String actionViewFlatPayment(Map<String, Object> map) {
		
		map.put("flatpayment", new FlatPayment());
		map.put("action","/Ked2/flatpayment/addflatpayment");
		return "/flatpayment/flatpaymentaction";
	}
	
	
	
	@RequestMapping(value="/viewflatpayment/{flatpaymentId}", method = RequestMethod.GET)
	public String viewFlatPayment(Map<String, Object> map, @PathVariable("flatpaymentId") Integer flatpaymentId) {
		
		FlatPayment flatpayment = flatpaymentServie.getFlatPayment(flatpaymentId);
		
		map.put("flatpayment", flatpayment);
		map.put("action","/Ked2/flatpayment/updateflatpayment");
		map.put("view", "view");
		
		return "/flatpayment/flatpaymentaction";
	}
	@RequestMapping(value = "/updateflatpayment", method = RequestMethod.POST)
	public String updateFlatPayment(@ModelAttribute("flatpayment")
	FlatPayment flatpayment, BindingResult result,ModelMap model) {

			flatpaymentServie.updateFlatPayment(flatpayment);
			//model.addAttribute("rescustomer", customer);
			return "redirect:/flatpayment/flatpaymentlist";
	}
	
	
	
}
