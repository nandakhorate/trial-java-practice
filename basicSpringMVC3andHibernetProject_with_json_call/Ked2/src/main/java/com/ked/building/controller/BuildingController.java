package com.ked.building.controller;




import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ked.building.services.BuildingService;
import com.ked.pojo.Building;
import com.ked.pojo.Site;
import com.ked.site.services.SiteService;

//@SessionAttributes({"siteMap"})
@Controller
@RequestMapping("/building")
public class BuildingController {
	
	@Autowired
	private SiteService siteService;
	@Autowired
	private BuildingService buildingServie;
	
	
	@ModelAttribute("siteMap")
	public Map<Long, String> getSiteList() {
		 Map<Long, String> siteMap =  new HashMap<Long, String>();
			for (Site site : siteService.listSite()) {
				siteMap.put(site.getId(), site.getName());
			}
		return siteMap;
	}
	
	@RequestMapping(value="/buildinglist", method = RequestMethod.GET)
	public String listBuilding(Map<String, Object> map) {
		map.put("buildinglist", buildingServie.listBuilding());
		return "/building/buildinglist";
	}

	
	@RequestMapping(value = "/addbuilding", method = RequestMethod.POST)
	public String addBuilding(@ModelAttribute("building") Building building, BindingResult result, ModelMap model) {
			long siteId = building.getSiteId();
			Site site = siteService.getSite(siteId);
			building.setSite(site);
			buildingServie.addBuilding(building);
			return "redirect:/building/buildinglist";
		
	}

	@RequestMapping("/deletebuilding/{buildingId}")
	public String deleteBuilding(@PathVariable("buildingId") Integer buildingId) {
		
		buildingServie.removeBuilding(buildingId);
		return "redirect:/building/buildinglist";
		
	}
	
	@RequestMapping(value="/addbuilding", method = RequestMethod.GET)
	public String actionViewBuilding(Map<String, Object> map) {
		
		map.put("building", new Building());
		map.put("action","/Ked2/building/addbuilding");
		return "/building/buildingaction";
	}
	
	@RequestMapping(value="/viewbuilding/{buildingId}", method = RequestMethod.GET)
	public String viewBuilding(Map<String, Object> map, @PathVariable("buildingId") Integer buildingId) {
		
		Building building = buildingServie.getBuilding(buildingId);
		building.setSiteId(building.getSite().getId());
		map.put("building", building);
		map.put("action","/Ked2/building/updatebuilding");
		map.put("view", "view");
		
		return "/building/buildingaction";
	}
	
	@RequestMapping(value = "/updatebuilding", method = RequestMethod.POST)
	public String updateBuilding(@ModelAttribute("building")
	Building building, BindingResult result,ModelMap model) {
			long siteId = building.getSiteId();
			Site site = siteService.getSite(siteId);
			building.setSite(site);
			buildingServie.updateBuilding(building);
			return "redirect:/building/buildinglist";
	}
}
