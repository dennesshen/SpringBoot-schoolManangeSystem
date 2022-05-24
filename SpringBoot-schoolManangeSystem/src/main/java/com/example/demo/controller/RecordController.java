package com.example.demo.controller;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Record;
import com.example.demo.entity.Violation;
import com.example.demo.repository.ClassAndGradeRepository;
import com.example.demo.repository.RecordRepository;
import com.example.demo.repository.ViolationRepository;

@Controller
@RequestMapping("/record")
public class RecordController {
	
	@Autowired 
	private RecordRepository recordRepository;
	
	@Autowired
	private ClassAndGradeRepository classAndGradeRepository;
	
	@Autowired
	private ViolationRepository violationRepository;
	
	
	@RequestMapping("/")
	public String index(Model model) {
		Record record = new Record();
		model.addAttribute("record", record);
		model.addAttribute("records", recordRepository.findAll());
		model.addAttribute("classes", classAndGradeRepository.findAll());
		model.addAttribute("violations", violationRepository.findAll());
		return "record.html";
	}
	
	@RequestMapping("/create")
	public String create(Record record) {
		
		Long violationID = record.getViolation().getId();
		if( violationID == 0) {
			String violationName = record.getViolation().getViolation_name();
			Violation violation = record.getViolation();
			violationRepository.save(violation);
			record.setViolation(violationRepository.findByViolation_name(violationName));
		}
		recordRepository.save(record);
		
		
		
		return "redirect:/record/";
	}
	
	@RequestMapping("/edit/{record_id}")
	public String edit(@PathVariable("record_id") Long id, Model model) {
		Record record = recordRepository.getById(id);
		model.addAttribute("record", record);
		model.addAttribute("records", recordRepository.findAll());
		model.addAttribute("classes", classAndGradeRepository.findAll());
		model.addAttribute("violations", violationRepository.findAll());
		
		return "record.html";
	}
	
	@RequestMapping("/delete/{record_id}")
	public String delete(@PathVariable("record_id") Long id) {
		recordRepository.deleteById(id);
		return "redirect:/record/";
	}
	
}
