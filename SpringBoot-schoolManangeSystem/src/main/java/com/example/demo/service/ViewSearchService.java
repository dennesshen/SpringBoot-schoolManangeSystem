package com.example.demo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Record;
import com.example.demo.repository.RecordRepository;

@Controller
public class ViewSearchService {
	
	@Autowired
	RecordRepository recordRepository;
	
	public List<Record> searchRecords(String class_id, String startDate,String endDate) {
		
		Integer classID = Integer.parseInt(class_id);
		SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd");
		Date dateOfStart = new Date();
		Date dateOfEnd   = new Date();
		try {
			dateOfStart = dateParser.parse(startDate);
			dateOfEnd = dateParser.parse(endDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<Record> records = recordRepository.getRecord(classID, dateOfStart, dateOfEnd );

		return  records;
	}
}
