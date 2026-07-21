package com.lab.common.mappers;

import com.lab.student.business.model.Student;
import com.lab.student.query.entity.StudentViewEntity;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class QueryMapper {

    public Student toStudentDomain(
            StudentViewEntity entity) {


        Student student = new Student();

        student.setId(entity.studentId);
        student.setNombre(entity.nombre);
        student.setNota(entity.nota);

        return student;
    }

    public StudentViewEntity toStudentViewEntity(Student student) {

        StudentViewEntity entity = new StudentViewEntity();

        entity.studentId = student.getId();
        entity.nombre = student.getNombre();
        entity.nota = student.getNota();

        return entity;
    }
}
