package com.sungroups.ST_DB.dto;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentResponseDTO {

    private Long id;
    private String name;
    private String email;
    private String course;
    private Integer age;
}