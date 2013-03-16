package com.ked.site.main;




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
@RequestMapping("/main")
public class mainController {

	@RequestMapping(value="/home", method = RequestMethod.GET)
	public String showIndex() {
		return "/main/index";
	}
	@RequestMapping(value="/site", method = RequestMethod.GET)
	public String showSite() {
		
		
		return "redirect:/site/sitelist";
	}
	
	

}
