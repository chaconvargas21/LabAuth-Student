package com.lab.student.command.repository;


import com.lab.student.command.entity.StudentCommandEntity;
import jakarta.enterprise.context.ApplicationScoped;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class StudentJpaRepository
        implements PanacheRepository<StudentCommandEntity> {

}