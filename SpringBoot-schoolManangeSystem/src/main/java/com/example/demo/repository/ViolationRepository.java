package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Violation;


@Repository
public interface ViolationRepository extends JpaRepository<Violation, Long>{
	
	@Query(nativeQuery = true, value = "select * from violation where violation_name = ?1")
	Violation findByViolation_name(String violation_name);
}
