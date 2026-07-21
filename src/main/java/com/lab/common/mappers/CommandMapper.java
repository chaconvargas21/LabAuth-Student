package com.lab.common.mappers;

import com.lab.student.business.model.Student;
import com.lab.student.command.entity.StudentCommandEntity;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CommandMapper {

    public StudentCommandEntity toStudentEntity(Student student) {

        if (student == null) {
            return null;
        }

        return new StudentCommandEntity(
                student.getId(),
                student.getNombre(),
                student.getNota()
        );
    }


    public Student toStudentDomain(StudentCommandEntity entity) {

        if (entity == null) {
            return null;
        }

        return new Student(
                entity.getId(),
                entity.getNombre(),
                entity.getNota()
        );
    }
}