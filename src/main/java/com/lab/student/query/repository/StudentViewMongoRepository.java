package com.lab.student.query.repository;


import com.lab.student.query.entity.StudentViewEntity;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class StudentViewMongoRepository
        implements PanacheMongoRepository<StudentViewEntity> {

}