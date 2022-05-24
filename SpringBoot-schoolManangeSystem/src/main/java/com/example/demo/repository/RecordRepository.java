package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Record;



@Repository
public interface RecordRepository extends JpaRepository<Record, Long>{
	
	@Query(value = "SELECT * FROM record  WHERE class_id=?1 AND date>=?2 AND date<=?3", nativeQuery = true)
	public List<Record> getRecord(@Param("class_id") Integer class_id, 
								  @Param("date") Date startDate,
								  @Param("date") Date endDate);

}
