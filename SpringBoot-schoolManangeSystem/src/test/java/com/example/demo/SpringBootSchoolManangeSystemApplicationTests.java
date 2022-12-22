package com.example.demo;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.ClassAndGrade;
import com.example.demo.entity.Record;
import com.example.demo.entity.UserLogin;
import com.example.demo.entity.Violation;
import com.example.demo.repository.ClassAndGradeRepository;
import com.example.demo.repository.RecordRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.ViolationRepository;


@SpringBootTest
class SpringBootSchoolManangeSystemApplicationTests {
	
	@Autowired
	private ClassAndGradeRepository gradeAndClassRepository;
	
	@Autowired
	private RecordRepository recordRepository;
	
	@Autowired 
	private ViolationRepository violationRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Test
	void contextLoads() {
		System.out.println("Test");
		UserLogin user = new UserLogin();
		user.setUsername("denn12");
		user.setPassword("0909224301");
		user.setRole("normal,ROLE_manager");
		userRepository.save(user);
		
//		ClassAndGrade c1 = new ClassAndGrade();
//		c1.setGrade(1);
//		c1.setIdOfClass("1班");
//		c1.setTeacher_name("李桂綾");
//		
//		gradeAndClassRepository.save(c1);
//		
//		Violation v1 = new Violation();
//		v1.setViolation_name("沒穿校服");
//		
//		violationRepository.save(v1);
//		
//		Record r1 = new Record(); 
//		r1.setStudent_name("謝宗元");
//		r1.setViolation(v1);
//		r1.setClassAndGrade(c1);
//		
//		recordRepository.save(r1);
		
		
		
	}
	
	

}
