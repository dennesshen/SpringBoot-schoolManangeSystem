package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Violation;
import com.example.demo.repository.ViolationRepository;

@Controller
@RequestMapping("/violation")
public class ViolationController {
	
	@Autowired 
	private ViolationRepository violationRepository;
	
	@RequestMapping("/")
	public String index(Model model) {
		Violation violation = new Violation();
		model.addAttribute("violation", violation);
		model.addAttribute("violations", violationRepository.findAll());
		return "violation.html";
	}
	
	@RequestMapping("/create")
	public String create(Violation violation) {
		violationRepository.save(violation);
		
		return "redirect:/violation/";
	}
	
	@RequestMapping("/update/{vid}")
	public String update(Model model, @PathVariable("vid") String vid ) {
		Violation violation = violationRepository.findById(Long.parseLong(vid)).get();
		model.addAttribute("violation", violation);
		model.addAttribute("violations", violationRepository.findAll());
		return "violation.html";
	}
	
	
	@RequestMapping("/delete/{vid}")
	public String delete(@PathVariable("vid") String vid) {
		
		violationRepository.deleteById(Long.parseLong(vid));
		
		return "redirect:/violation/";
	}
	
	
	
}
