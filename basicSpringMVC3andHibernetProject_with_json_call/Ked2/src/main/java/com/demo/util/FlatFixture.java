package com.demo.util;

import com.ked.pojo.Building;
import com.ked.pojo.Flat;

public class FlatFixture {
	public static Flat _1001 = get_1001();
	public static Flat _1002 = get_1002();
	
	public static Flat _2001 = get_2001();
	public static Flat _2002 = get_2002();
	
	
	
	private static  Flat get_1001(){
		_1001 = new Flat();
		_1001.setFlatNo(1001);
		/*_1001.setName("1001");
		_1001.setAddress("none");*/
		_1001.setBuilding(BuildingFixture.one);
		return _1001;
	}
	
	private static  Flat get_1002(){
		_1002 = new Flat();
		_1002.setFlatNo(1002);
		/*_1002.setName("1002");
		_1002.setAddress("none");*/
		_1002.setBuilding(BuildingFixture.one);
		return _1002;
	}
	
	
	private static  Flat get_2001(){
		_2001 = new Flat();
		_2001.setFlatNo(2001);
		/*_2001.setName("2001");
		_2001.setAddress("none");*/
		_2001.setBuilding(BuildingFixture.two);
		return _2001;
	}
	
	private static  Flat get_2002(){
		_2002 = new Flat();
		_2002.setFlatNo(2002);
		/*_2002.setName("2002");
		_2002.setAddress("none");*/
		_2002.setBuilding(BuildingFixture.two);
		return _2002;
	}
}
