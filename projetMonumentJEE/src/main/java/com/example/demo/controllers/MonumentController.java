package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Monument;
import com.example.demo.repositories.MonumentRepository;
import com.example.demo.services.MonumentService;

@Controller
public class MonumentController {
	
	
	@Autowired
	private MonumentRepository monumentRepository;
	
	/*private MonumentService monumService;
	
	@GetMapping(value="/monuments")
	public String listMonument(Model model,
			@RequestParam(name="page", defaultValue = "0") int p,
			@RequestParam(name="size", defaultValue = "7") int s,
			@RequestParam(name="mc", defaultValue = "") String mc) {
		model.addAttribute("Monument", monumService.getAllMonument());
		return "Monument";
		
	}*/
	
	
	@RequestMapping(value="/monuments")
	private String monuments(Model model,
			@RequestParam(name="page", defaultValue = "0") int p,
			@RequestParam(name="size", defaultValue = "7") int s,
			@RequestParam(name="mc", defaultValue = "") String mc) {
		Pageable pageable = PageRequest.of(p, s);
		//Page<Monument> pageMonuments = monumentRepository.findAll(pageable);
		Page<Monument> pageMonuments = monumentRepository.chercher("%"+mc+"%",pageable);
		model.addAttribute("listeMonuments", pageMonuments.getContent());
		int[] pages =new int[pageMonuments.getTotalPages()];
		model.addAttribute("pages",pages);
		model.addAttribute("size", s);
		model.addAttribute("pageCourante",p);
		model.addAttribute("mc",mc);
		return "monuments";    //monuments = nom de la vue
	}
	
	/*@RequestMapping(value="/supprimerMonument", method=RequestMethod.GET)
	public String deleteMonument(String nom, int page, int size, String mc) {
		Pageable pageable = PageRequest.of(page, size);
		monumentRepository.delete();
		return "redirect:/monuments?page="+page+"&size="+size+"&motCle="+mc;
	}*/
	
	@RequestMapping(value="/formMonum", method=RequestMethod.GET)
	public String formMonum(Model model) {
		model.addAttribute("monument", new Monument());	
		return "formMonum";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(Model model,@Valid Monument monument,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "formMonum";
		monumentRepository.save(monument);
		return "Confirmation";
	}
	
	/*@RequestMapping(value="/editMonum", method=RequestMethod.GET)
	public String updateMonument(Model model, String geohash) {
		Monument monum=monumentRepository.findOne(geohash);
		model.addAttribute("monument", new Monument());	
		return "test";
	}*/

}
