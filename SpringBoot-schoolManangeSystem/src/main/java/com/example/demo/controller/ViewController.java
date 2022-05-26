package com.example.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.repository.ClassAndGradeRepository;
import com.example.demo.repository.RecordRepository;
import com.example.demo.service.ViewSearchService;

@Controller
@RequestMapping(value = {"/view", "/"})
public class ViewController {
	
	@Autowired 
	RecordRepository recordRepository;
	
	@Autowired
	ClassAndGradeRepository classAndGradeRepository;
	
	@Autowired
	ViewSearchService viewSearchService;
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("records",recordRepository.findAll());
		model.addAttribute("classes", classAndGradeRepository.findAll() );
		return "view.html";
	}
	
	@RequestMapping("/search")
	public String search(@RequestParam("class")String class_id, 
						 @RequestParam("startDate") String startDate,
						 @RequestParam("endDate") String endDate,
						 Model model) {
		System.out.println("test");
		model.addAttribute("records", viewSearchService.searchRecords(class_id, startDate, endDate));
		model.addAttribute("classes", classAndGradeRepository.findAll() );

		
		return "view.html";
	}

	
	@RequestMapping("/test")
	public String test() {
		return "test.html";
	}
}
