package com.demo.util;

import com.ked.pojo.Building;

public class BuildingFixture {
	
	public static Building one = getBuildingOne();
	public static Building two = getBuildingTwo();
	
	private static  Building getBuildingOne(){
		one = new Building();
		one.setName("Bulding One");
		one.setSite(SiteFixture.pune);
		one.setAddress("group 1");
		//one.addFlat(FlatFixture._1001);
		//one.addFlat(FlatFixture._1002);
		return one;
	}
	
	private static  Building getBuildingTwo(){
		two = new Building();
		two.setName("Bulding Two");
		two.setSite(SiteFixture.mumbai);
		two.setAddress("group 2");
		//two.addFlat(FlatFixture._2001);
		//two.addFlat(FlatFixture._2002);
		return two;
	}

}
