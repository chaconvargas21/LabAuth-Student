package com.lab.student.business.repository;

import com.lab.student.business.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentViewRepository {

    Optional<Student> findById(Long id);

    List<Student> findAll();
}