package com.sungroups.ST_DB.repository;



import com.sungroups.ST_DB.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}