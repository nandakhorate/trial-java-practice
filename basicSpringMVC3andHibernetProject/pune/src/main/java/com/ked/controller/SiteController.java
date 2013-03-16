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
	
	@Autowired
	private SiteDAO<Long,Site> siteDAO;
	
	@RequestMapping(value="/sitelist", method = RequestMethod.GET)
	public String listSite(Map<String, Object> map) {
		map.put("sitelist", siteDAO.findAll());
		return "/site/sitelist";
	}

	
	@RequestMapping(value = "/addsite", method = RequestMethod.POST)
	public String addSite(@ModelAttribute("site") Site site, BindingResult result, ModelMap model) {
			siteDAO.persist(site);
			return "redirect:/site/sitelist";
	}

	@RequestMapping("/deletesite/{siteId}")
	public String deleteSite(@PathVariable("siteId") Long siteId) {
		Site site = siteDAO.findById(siteId);
		siteDAO.delete(site);
		return "redirect:/site/sitelist";
		
	}
	
	@RequestMapping(value="/addsite", method = RequestMethod.GET)
	public String actionViewSite(Map<String, Object> map) {
		
		map.put("site", new Site());
		map.put("action","/pune/site/addsite");
		return "/site/siteaction";
	}
	
	
	
	@RequestMapping(value="/viewsite/{siteId}", method = RequestMethod.GET)
	public String viewCustomer(Map<String, Object> map, @PathVariable("siteId") Long siteId) {
		
		Site site = siteDAO.findById(siteId);
		map.put("site", site);
		map.put("action","/pune/site/updatesite");
		map.put("view", "view");
		return "/site/siteaction";
	}
	@RequestMapping(value = "/updatesite", method = RequestMethod.POST)
	public String updateSite(@ModelAttribute("site")
	Site site, BindingResult result,ModelMap model) {

			siteDAO.merge(site);
			return "redirect:/site/sitelist";
	}

}
