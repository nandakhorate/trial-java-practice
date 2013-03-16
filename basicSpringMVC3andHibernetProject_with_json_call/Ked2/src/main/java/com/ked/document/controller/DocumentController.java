package com.ked.document.controller;




import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ked.document.services.DocumentService;
import com.ked.pojo.Document;


@Controller
@RequestMapping("/document")
public class DocumentController {
	
	@Autowired
	private DocumentService documentServie;
	
	@RequestMapping(value="/documentlist", method = RequestMethod.GET)
	public String listDocument(Map<String, Object> map) {
		
		map.put("documentlist", documentServie.listDocument());
		
		return "/document/documentlist";
	}

	
	@RequestMapping(value = "/adddocument", method = RequestMethod.POST)
	public String addDocumentlist(@ModelAttribute("document") Document document, BindingResult result, ModelMap model) {
		
			documentServie.addDocument(document);
			//model.addAttribute("ressite", site);
			return "redirect:/document/documentlist";
		
	}

	@RequestMapping("/deletedocument/{documentId}")
	public String deleteDocument(@PathVariable("documentId") Integer documentId) {
		
		documentServie.removeDocument(documentId);
		return "redirect:/document/documentlist";
		
	}
	
	@RequestMapping(value="/adddocument", method = RequestMethod.GET)
	public String actionViewDocument(Map<String, Object> map) {
		
		map.put("document", new Document());
		map.put("action","/Ked2/document/adddocument");
		return "/document/documentaction";
	}
	
	
	
	@RequestMapping(value="/viewdocument/{documentId}", method = RequestMethod.GET)
	public String viewDocument(Map<String, Object> map, @PathVariable("documentId") Integer documentId) {
		
		Document document = documentServie.getDocument(documentId);
		
		map.put("document", document);
		map.put("action","/Ked2/document/updatedocument");
		map.put("view", "view");
		
		return "/document/documentaction";
	}
	@RequestMapping(value = "/updatedocument", method = RequestMethod.POST)
	public String updateDocument(@ModelAttribute("document")
	Document document, BindingResult result,ModelMap model) {

			documentServie.updateDocument(document);
			//model.addAttribute("rescustomer", customer);
			return "redirect:/document/documentlist";
	}
	
	
	
}
