package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.ClassAndGrade;
import com.example.demo.repository.ClassAndGradeRepository;


@Controller
@RequestMapping("/classAndGrade")
public class ClassAndGradeController {
	
	@Autowired 
	private ClassAndGradeRepository classAndGradeRepository;
	
	@RequestMapping("/")
	public String index(Model model) {
		ClassAndGrade classAndGrade = new ClassAndGrade();
		List<Integer> grade = List.of(1, 2, 3, 4, 5, 6);
		model.addAttribute("grades", grade);
		model.addAttribute("classAndGrade", classAndGrade);
		model.addAttribute("classAndGrades", classAndGradeRepository.findAll());
		return "classAndGrade.html";
	}
	
	@RequestMapping("/create")
	public String create(ClassAndGrade classAndGrade) {
		
		classAndGradeRepository.save(classAndGrade);
		return "redirect:/classAndGrade/";
	}
	
	@RequestMapping("/edit/{gid}")
	public String edit(@PathVariable("gid") Long gid, Model model) {
		ClassAndGrade classAndGrade = classAndGradeRepository.findById(gid).get();
		List<Integer> grade = List.of(1, 2, 3, 4, 5, 6);
		model.addAttribute("grades", grade);
		model.addAttribute("classAndGrade", classAndGrade);
		model.addAttribute("classAndGrades", classAndGradeRepository.findAll());
		return "classAndGrade.html";
	}
	
	@RequestMapping("/delete/{gid}")
	public String delete(@PathVariable("gid") Long id) {
		classAndGradeRepository.deleteById(id);
		return "redirect:/record/";
	}
	
}
