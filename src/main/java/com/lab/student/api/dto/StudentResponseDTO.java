package com.lab.student.api.dto;

import io.quarkus.arc.All;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentResponseDTO {

    private Long id;

    private String nombre;

    private Double nota;
}
