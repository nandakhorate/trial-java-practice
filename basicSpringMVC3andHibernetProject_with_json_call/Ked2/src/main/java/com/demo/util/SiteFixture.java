package com.demo.util;

import com.ked.pojo.Site;

public class SiteFixture {
	
	public static Site pune = getPune();
	public static Site mumbai = getMumbai();
	
	
	
	private static Site getPune(){
		pune = new Site();
		pune.setName("Pune Site");
		pune.setAddress("Hiz wadi");
		pune.addBuilding(BuildingFixture.one);
		return pune;
	}
	
	private static Site getMumbai(){
		mumbai = new Site();
		mumbai.setName("MUmbai Site");
		mumbai.setAddress("vashi");
		mumbai.addBuilding(BuildingFixture.two);
		return mumbai;
	}
	
	

}
