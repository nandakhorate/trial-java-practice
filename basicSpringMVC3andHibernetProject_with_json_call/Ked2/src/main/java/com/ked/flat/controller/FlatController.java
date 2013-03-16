package com.ked.flat.controller;




import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ked.building.services.BuildingService;
import com.ked.flat.services.FlatService;
import com.ked.pojo.Building;
import com.ked.pojo.Flat;
import com.ked.pojo.JsonResponse;
import com.ked.pojo.Site;
import com.ked.site.services.SiteService;


@Controller
@RequestMapping("/flat")
public class FlatController {
	
	
	@Autowired
	private SiteService siteService;
	
	@Autowired
	private BuildingService buildingServie;
	
	@Autowired
	private FlatService flatServie;
	
/*	@RequestMapping(value="/CallBuilding",method=RequestMethod.GET)
	public String showForm(){
		return "/flat/flataction";
	}*/
	
	@RequestMapping(value="/CallBuilding",method=RequestMethod.POST)
	public @ResponseBody JsonResponse addUser(@ModelAttribute(value="flat") Flat flat, BindingResult result ){
		JsonResponse res = new JsonResponse();
		String message = "";
		if(flat.getSiteId()>0){
			Site site = siteService.getSite(flat.getSiteId());
			Set<Building> buildings = site.getBuildings();
			
			String temp ="";
			message+="<td>Building Site Name</td>" +
					"<td>" +
					"<select id=\"buildingId\" name=\"buildingId\">" +
					"<option value=\"0\" selected=\"selected\">--- Select ---</option>" ;
			
			for (Building building : buildings) {
				temp +="<option value=\""+building.getId()+"\">"+building.getName()+"</option>";
						
			}
			message +=temp+	"</select></td>";
		}
			res.setStatus("SUCCESS");
			
			res.setResult(message);

		
	
		
		return res;
	}
	@ModelAttribute("siteMap")
	public Map<Long, String> getSiteList() {
		 Map<Long, String> siteMap =  new HashMap<Long, String>();
			for (Site site : siteService.listSite()) {
				siteMap.put(site.getId(), site.getName());
			}
		return siteMap;
	}
	
	@ModelAttribute("buildingMap")
	public Map<Long, String> getBuildingList() {
		 Map<Long, String> buildingMap =  new HashMap<Long, String>();
			for (Building building : buildingServie.listBuilding()) {
				buildingMap.put(building.getId(), building.getName());
			}
		return buildingMap;
	}
	@RequestMapping(value="/flatlist", method = RequestMethod.GET)
	public String listflat(Map<String, Object> map) {
		map.put("flatlist", flatServie.listFlat());
		return "/flat/flatlist";
	}
	@RequestMapping(value = "/addflat", method = RequestMethod.POST)
	public String listBuilding(@ModelAttribute("flat") Flat flat, BindingResult result, ModelMap model) {
			flat.setSiteId(flat.getSiteId());
			long buildingId = flat.getBuildingId();
			Building building = buildingServie.getBuilding(buildingId);
			flat.setBuilding(building);
			flatServie.addFlat(flat);
			return "redirect:/flat/flatlist";
		
	}

	@RequestMapping("/deleteflat/{flatId}")
	public String deleteFlat(@PathVariable("flatId") Integer flatId) {
		
		flatServie.removeFlat(flatId);
		return "redirect:/flat/flatlist";
		
	}
	
	@RequestMapping(value="/addflat", method = RequestMethod.GET)
	public String addflat(Map<String, Object> map) {
		
		map.put("flat", new Flat());
		map.put("action","/Ked2/flat/addflat");
		return "/flat/flataction";
	}
	
	
	
	@RequestMapping(value="/viewflat/{flatId}", method = RequestMethod.GET)
	public String viewFlat(Map<String, Object> map, @PathVariable("flatId") Integer flatId) {
		
		Flat flat = flatServie.getFlat(flatId);
		flat.setBuildingId(flat.getBuilding().getId());
		flat.setSiteId(flat.getBuilding().getSite().getId());
		map.put("flat", flat);
		map.put("action","/Ked2/flat/updateflat");
		map.put("view", "view");
		
		return "/flat/flataction";
	}
	@RequestMapping(value = "/updateflat", method = RequestMethod.POST)
	public String updateFlat(@ModelAttribute("flat")
	Flat flat, BindingResult result,ModelMap model) {
			long buildingId = flat.getBuildingId();
			Building building = buildingServie.getBuilding(buildingId);
			flat.setBuilding(building);
			flatServie.updateFlat(flat);
			return "redirect:/flat/flatlist";
	}
	
	
	
}
