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

@Controller
@RequestMapping("/site")
public class SiteController {
	String rootPath = "/pune";
	String path = "/site";
	
	@Autowired
	private SiteDAO<Long,Site> siteDAO;
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public String list(Map<String, Object> map) {
		map.put("list", siteDAO.findAll());
		return path + "/list";
	}

	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@ModelAttribute("site") Site site, BindingResult result, ModelMap model) {
			siteDAO.save(site);
			return "redirect:"+ path +"/list";
	}

	@RequestMapping("/deleteById/{siteId}")
	public String delete(@PathVariable("siteId") Long id) {
		Site site = siteDAO.get(id);
		siteDAO.delete(site);
		return "redirect:"+ path +"/list";
		
	}
	
	/*
	 * This method added new records.
	 */
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public String add(Map<String, Object> map) {
		
		map.put("site", new Site());
		map.put("action",rootPath + path +"/add");
		return path + "/action";
	}
	
	
	
	@RequestMapping(value="/find/{siteId}", method = RequestMethod.GET)
	public String find(Map<String, Object> map, @PathVariable("siteId") Long id) {
		
		Site site = siteDAO.get(id);
		map.put("site", site);
		map.put("action",rootPath + path +"/update");
		map.put("find", "find");
		return path +"/action";
	}
	
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("site")
	Site site, BindingResult result,ModelMap model) {
			siteDAO.saveOrUpdate(site);
			return "redirect:"+ path +"/list";
	}

}
