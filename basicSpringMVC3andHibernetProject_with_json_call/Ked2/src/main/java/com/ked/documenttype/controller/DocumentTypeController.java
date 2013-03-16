package com.ked.documenttype.controller;




import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ked.documenttype.services.DocumentTypeService;
import com.ked.pojo.DocumentType;


@Controller
@RequestMapping("/documenttype")
public class DocumentTypeController {
	
	@Autowired
	private DocumentTypeService documenttypeServie;
	
	@RequestMapping(value="/documenttypelist", method = RequestMethod.GET)
	public String listDocumentType(Map<String, Object> map) {
		
		map.put("documenttypelist", documenttypeServie.listDocumentType());
		
		return "/documenttype/documenttypelist";
	}

	
	@RequestMapping(value = "/adddocumenttype", method = RequestMethod.POST)
	public String addDocumentTypelist(@ModelAttribute("documenttype") DocumentType documenttype, BindingResult result, ModelMap model) {
		
			documenttypeServie.addDocumentType(documenttype);
			//model.addAttribute("ressite", site);
			return "redirect:/documenttype/documenttypelist";
		
	}

	@RequestMapping("/deletedocumenttype/{documenttypeId}")
	public String deleteDocumentType(@PathVariable("documenttypeId") Integer documenttypeId) {
		
		documenttypeServie.removeDocumentType(documenttypeId);
		return "redirect:/documenttype/documenttypelist";
		
	}
	
	@RequestMapping(value="/adddocumenttype", method = RequestMethod.GET)
	public String actionViewDocumentType(Map<String, Object> map) {
		
		map.put("documenttype", new DocumentType());
		map.put("action","/Ked2/documenttype/adddocumenttype");
		return "/documenttype/documenttypeaction";
	}
	
	
	
	@RequestMapping(value="/viewdocumenttype/{documenttypeId}", method = RequestMethod.GET)
	public String viewDocumentType(Map<String, Object> map, @PathVariable("documenttypeId") Integer documenttypeId) {
		
		DocumentType documenttype = documenttypeServie.getDocumentType(documenttypeId);
		
		map.put("documenttype", documenttype);
		map.put("action","/Ked2/documenttype/updatedocumenttype");
		map.put("view", "view");
		
		return "/documenttype/documenttypeaction";
	}
	@RequestMapping(value = "/updatedocumenttype", method = RequestMethod.POST)
	public String updateDocumentType(@ModelAttribute("documenttype")
	DocumentType documenttype, BindingResult result,ModelMap model) {

			documenttypeServie.updateDocumentType(documenttype);
			//model.addAttribute("rescustomer", customer);
			return "redirect:/documenttype/documenttypelist";
	}
	
	
	
}
