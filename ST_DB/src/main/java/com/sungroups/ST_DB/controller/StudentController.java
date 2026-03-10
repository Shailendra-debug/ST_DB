package com.sungroups.ST_DB.controller;

import com.sungroups.ST_DB.Service.StudentService;
import com.sungroups.ST_DB.dto.StudentRequestDTO;
import com.sungroups.ST_DB.dto.StudentResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;

    @PostMapping
    public StudentResponseDTO create(@RequestBody StudentRequestDTO dto) {
        return service.createStudent(dto);
    }

    @GetMapping
    public List<StudentResponseDTO> getAll() {
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentResponseDTO getById(@PathVariable Long id) {
        return service.getStudentById(id);
    }

    @PutMapping("/{id}")
    public StudentResponseDTO update(@PathVariable Long id,
                                     @RequestBody StudentRequestDTO dto) {
        return service.updateStudent(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteStudent(id);
    }
}