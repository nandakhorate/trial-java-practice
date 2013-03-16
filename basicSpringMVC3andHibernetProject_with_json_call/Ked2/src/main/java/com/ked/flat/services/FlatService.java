package com.ked.flat.services;

import java.util.List;

import com.ked.pojo.Flat;
import com.ked.pojo.Site;


public interface FlatService {
	
	public void addFlat(Flat flat);
	public List<Flat> listFlat();
	public void removeFlat(long id);
	public Flat getFlat(long id);
	public void updateFlat(Flat flat);
}
