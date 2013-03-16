package com.ked.site.controller;




import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.util.FlatFixture;
import com.demo.util.HibernateAnnotationUtil;
import com.demo.util.SiteFixture;
import com.ked.pojo.Building;
import com.ked.pojo.Site;
import com.ked.site.services.SiteService;


@Controller
@RequestMapping("/site")
public class SiteController {
	
	@Autowired
	private SiteService siteService;
	
	@RequestMapping(value="/sitelist", method = RequestMethod.GET)
	public String listSite(Map<String, Object> map) {
		
		map.put("sitelist", siteService.listSite());
		
		return "/site/sitelist";
	}

	
	@RequestMapping(value = "/addsite", method = RequestMethod.POST)
	public String addSite(@ModelAttribute("site") Site site, BindingResult result, ModelMap model) {
		
			siteService.addSite(site);
			return "redirect:/site/sitelist";
		
	}

	@RequestMapping("/deletesite/{siteId}")
	public String deleteSite(@PathVariable("siteId") Integer siteId) {
		
		siteService.removeSite(siteId);
		return "redirect:/site/sitelist";
		
	}
	
	@RequestMapping(value="/addsite", method = RequestMethod.GET)
	public String actionViewSite(Map<String, Object> map) {
		
		map.put("site", new Site());
		map.put("action","/Ked2/site/addsite");
		return "/site/siteaction";
	}
	
	
	
	@RequestMapping(value="/viewsite/{siteId}", method = RequestMethod.GET)
	public String viewCustomer(Map<String, Object> map, @PathVariable("siteId") Integer siteId) {
		
		Site site = siteService.getSite(siteId);
		
		
		map.put("site", site);
		map.put("action","/Ked2/site/updatesite");
		map.put("view", "view");
		
		return "/site/siteaction";
	}
	@RequestMapping(value = "/updatesite", method = RequestMethod.POST)
	public String updateSite(@ModelAttribute("site")
	Site site, BindingResult result,ModelMap model) {

			siteService.updateSite(site);
			return "redirect:/site/sitelist";
	}
	
		
	

	
	/*public static void main(String sa[]){
		//Persisting the User and Account
		
		Site pune = new Site();
		pune.setName("Pune Site");
		pune.setAddress("Hiz wadi");
		
		Site mumbai = new Site();
		mumbai.setName("mumbai Site");
		mumbai.setAddress("vashi");
		
		
		Session session = HibernateAnnotationUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(pune);
		session.save(mumbai);
		session.flush();
		tx.commit();
		session.close();
		
		Building one = new Building();
		one.setName("Bulding One");
		one.setSite(pune);
		one.setAddress("group 1");
		
		Building two = new Building();
		two.setName("Bulding two");
		two.setSite(mumbai);
		two.setAddress("group 2");
		
		session = HibernateAnnotationUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
		
		
		
		session.save(one);
		session.save(two);
		
		
		session.flush();
		tx.commit();
		session.close();
		
		
		
		
		session = HibernateAnnotationUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
			Building building  = (Building) session.get(Building.class, 1L);
			Site site  = (Site) session.get(Site.class, building.getSite().getId());
			site.getBuildings().remove(building);
			session.delete(building);
		session.flush();
		tx.commit();
		session.close(); 
		
		session = HibernateAnnotationUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
			Building building  = (Building) session.get(Building.class, 1L);
			//Site site  = (Site) session.get(Site.class, building.getSite().getId());
			//site.getBuildings().remove(building);
			session.delete(building);
		session.flush();
		tx.commit();
		session.close(); 
		
		
		session = HibernateAnnotationUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
			Building building4  = (Building) session.get(Building.class, 1L);
			
			System.out.println("Before Setting Value : "+building4.getAddress());
			building4.setAddress("new Addersss");
			System.out.println("After Setting Value : "+building4.getAddress());
			//session.delete(building4);
		//session.flush();
		tx.commit();
		session.close();
		
		session = HibernateAnnotationUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
			Building building1  = (Building) session.get(Building.class, 1L);
			//Site site  = (Site) session.get(Site.class, building.getSite().getId());
			//site.getBuildings().remove(building);
			session.delete(building1);
		session.flush();
		tx.commit();
		session.close();
		
		session = HibernateAnnotationUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
			
			Site site  = (Site) session.get(Site.class, 2L);
			//site.getBuildings().remove(building);
			session.delete(site);
		session.flush();
		tx.commit();
		session.close();
		
	}
	
	*/
}
