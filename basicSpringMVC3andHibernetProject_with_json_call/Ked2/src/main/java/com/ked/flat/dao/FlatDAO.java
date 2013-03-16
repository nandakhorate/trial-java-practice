package com.ked.flat.dao;

import java.util.List;

import com.ked.pojo.Flat;
import com.ked.pojo.Site;


public interface FlatDAO {
	
	public void addFlat(Flat flat);
	public List<Flat> listFlat();
	public void removeFlat(long id);
	public Flat getFlat(long id);
	public void updateFlat(Flat flat);
}
