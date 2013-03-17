package com.ked.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ked.idao.SiteDAO;
import com.ked.pojo.Site;
import com.ked.util.Constant;

@Controller
@RequestMapping("/site")
public class SiteController {


	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Map<String, Object> map) {
		map.put("list", dao.findAll());
		return PATH + Constant.LIST;
	}

	@RequestMapping("/deleteById/{id}")
	public String delete(@PathVariable("id") Long id) {
		frmObject = getFromObject();
		frmObject = dao.load(id);
		dao.delete(frmObject);
		return Constant.REDIRECT + PATH + Constant.LIST;
	}

	/*
	 * This method added new records.
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Map<String, Object> map) {
		frmObject = getFromObject();
		map.put("frmObject", frmObject);
		map.put("action", Constant.ROOTPATH + PATH + Constant.ADD);
		return PATH + Constant.ACTION;
	}

	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
	public String find(Map<String, Object> map, @PathVariable("id") Long id) {
		frmObject = getFromObject();
		frmObject = dao.get(id);
		map.put("frmObject", frmObject);
		map.put("action", Constant.ROOTPATH + PATH + Constant.UPDATE);
		map.put("find", "find");
		return PATH + Constant.ACTION;
	}

	// BELOW CODE CHAGE IN EACH MODLE


	@Autowired
	private SiteDAO<Long, Site> dao;
	
	String PATH = "/site";
	Site frmObject = null;

	Site getFromObject() {
		return new Site();
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("frmObject") Site frmObject,
			BindingResult result, ModelMap model) {
		dao.saveOrUpdate(frmObject);
		return Constant.REDIRECT + PATH + Constant.LIST;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@ModelAttribute("frmObject") Site frmObject,
			BindingResult result, ModelMap model) {
		dao.save(frmObject);
		return Constant.REDIRECT + PATH + Constant.LIST;
	}

}
