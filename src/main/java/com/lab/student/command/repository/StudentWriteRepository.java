package com.lab.student.command.repository;

import com.lab.student.business.model.Student;

public interface StudentWriteRepository {

    Student save(Student student);

    Student update(Student student);

    void delete(Long id);
}
