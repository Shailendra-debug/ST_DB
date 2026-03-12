package com.sungroups.ST_DB.controller;


import com.sungroups.ST_DB.Service.StudentService;
import com.sungroups.ST_DB.dto.StudentRequestDTO;
import com.sungroups.ST_DB.dto.StudentResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public/students")
@AllArgsConstructor
public class StudentPublicController {
    private final StudentService studentService;

    @GetMapping
    public List<StudentResponseDTO> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentResponseDTO getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping
    public StudentResponseDTO createStudent(@RequestBody StudentRequestDTO dto) {
        return studentService.createStudent(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}