package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ClassAndGrade;


@Repository
public interface ClassAndGradeRepository extends JpaRepository<ClassAndGrade, Long>{

}
