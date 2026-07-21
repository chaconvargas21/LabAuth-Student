package com.lab.common.mappers;


import com.lab.student.api.dto.StudentCreateDTO;
import com.lab.student.api.dto.StudentResponseDTO;
import com.lab.student.business.model.Student;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class DTOMapper {


    public Student toStudentEntity(StudentCreateDTO dto) {

        if (dto == null) {
            return null;
        }

        return new Student(
                dto.getNombre(),
                dto.getNota()
        );
    }


    public StudentResponseDTO toStudentDTO(Student student) {

        if (student == null) {
            return null;
        }

        return new StudentResponseDTO(
                student.getId(),
                student.getNombre(),
                student.getNota()
        );
    }

    public List<StudentResponseDTO> toStudentDTOList(List<Student> students) {

        if (students == null) {
            return null;
        }

        return students.stream()
                .map(this::toStudentDTO)
                .toList();
    }
}