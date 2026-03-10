package com.sungroups.ST_DB.Service;

import com.sungroups.ST_DB.dto.StudentRequestDTO;
import com.sungroups.ST_DB.dto.StudentResponseDTO;
import com.sungroups.ST_DB.entity.Student;
import com.sungroups.ST_DB.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public StudentResponseDTO createStudent(StudentRequestDTO dto) {

        Student student = new Student();
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setCourse(dto.getCourse());
        student.setAge(dto.getAge());

        Student saved = repository.save(student);

        return mapToResponse(saved);
    }

    @Override
    public List<StudentResponseDTO> getAllStudents() {

        return repository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public StudentResponseDTO getStudentById(Long id) {

        Student student = repository.findById(id).orElseThrow();

        return mapToResponse(student);
    }

    @Override
    public StudentResponseDTO updateStudent(Long id, StudentRequestDTO dto) {

        Student student = repository.findById(id).orElseThrow();

        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setCourse(dto.getCourse());
        student.setAge(dto.getAge());

        Student updated = repository.save(student);

        return mapToResponse(updated);
    }

    @Override
    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }

    private StudentResponseDTO mapToResponse(Student student) {

        StudentResponseDTO dto = new StudentResponseDTO();

        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setEmail(student.getEmail());
        dto.setCourse(student.getCourse());
        dto.setAge(student.getAge());

        return dto;
    }
}