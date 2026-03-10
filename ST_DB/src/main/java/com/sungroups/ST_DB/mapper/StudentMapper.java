package com.sungroups.ST_DB.mapper;




import com.sungroups.ST_DB.dto.StudentRequestDTO;
import com.sungroups.ST_DB.dto.StudentResponseDTO;
import com.sungroups.ST_DB.entity.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    Student toEntity(StudentRequestDTO dto);

    StudentResponseDTO toResponse(Student student);

}