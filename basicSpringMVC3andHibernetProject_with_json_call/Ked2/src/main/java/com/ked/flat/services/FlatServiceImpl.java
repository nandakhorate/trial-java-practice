package com.ked.flat.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ked.flat.dao.FlatDAO;
import com.ked.pojo.Flat;

@Service
public class FlatServiceImpl implements FlatService {

	@Autowired
	private FlatDAO flatDAO;
	
	@Transactional
	public void addFlat(Flat flat) {
		flatDAO.addFlat(flat);
	}

	@Transactional
	public List<Flat> listFlat() {

		return flatDAO.listFlat();
	}

	@Transactional
	public void removeFlat(long id) {
		flatDAO.removeFlat(id);
	}
	@Transactional
	public Flat getFlat(long id) {
		return flatDAO.getFlat(id);
	}
	@Transactional
	public void updateFlat(Flat flat) {
		flatDAO.updateFlat(flat);
		
	}

	
}
