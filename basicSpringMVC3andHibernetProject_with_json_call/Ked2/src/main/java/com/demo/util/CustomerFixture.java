package com.demo.util;

import com.ked.pojo.Customer;

public class CustomerFixture {
	public static Customer santosh = getSantosh();
	public static Customer nitn = getNitin();
	
	
	
	private static Customer getSantosh(){
		santosh = new Customer();
		santosh.setName("santosh");
		santosh.addCustomerFlat(FlatFixture._1001);
		santosh.addCustomerFlat(FlatFixture._2001);
		return santosh;
	}
	
	private static Customer getNitin(){
		nitn = new Customer();
		nitn.setName("nitin");
		nitn.addCustomerFlat(FlatFixture._1002);
		nitn.addCustomerFlat(FlatFixture._2002);
		return nitn;
	}
}
