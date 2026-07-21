package com.lab.student.query.repository.impl;



import com.lab.student.business.model.Student;
import com.lab.student.business.repository.StudentViewRepository;
import com.lab.student.query.entity.StudentViewEntity;
import com.lab.student.query.repository.StudentViewMongoRepository;
import com.lab.common.mappers.QueryMapper;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;


@ApplicationScoped
public class StudentViewRepositoryMongo
        implements StudentViewRepository {


    private final StudentViewMongoRepository repository;
    private final QueryMapper mapper;


    @Inject
    public StudentViewRepositoryMongo(
            StudentViewMongoRepository repository,
            QueryMapper mapper) {

        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public List<Student> findAll() {


        return repository.listAll()
                .stream()
                .map(mapper::toStudentDomain)
                .toList();


    }


    @Override
    public Optional<Student> findById(Long id) {


        StudentViewEntity entity =
                repository.find(
                        "studentId",
                        id
                ).firstResult();


        if(entity == null){
            return Optional.empty();
        }



        return Optional.of(
                mapper.toStudentDomain(entity)
        );


    }
}