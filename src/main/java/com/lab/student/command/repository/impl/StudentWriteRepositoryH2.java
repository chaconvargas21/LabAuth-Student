package com.lab.student.command.repository.impl;

import com.lab.student.business.exception.StudentNotFoundException;
import com.lab.student.business.model.Student;
import com.lab.student.business.repository.StudentWriteRepository;
import com.lab.student.command.entity.StudentCommandEntity;
import com.lab.common.mappers.CommandMapper;
import com.lab.student.command.repository.StudentJpaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class StudentWriteRepositoryH2
        implements StudentWriteRepository {


    @Inject
    private StudentJpaRepository repository;

    @Inject
    private CommandMapper mapper;




    @Override
    @Transactional
    public Student save(Student student) {

        StudentCommandEntity entity =
                mapper.toStudentEntity(student);

        repository.persist(entity);

        return mapper.toStudentDomain(entity);
    }


    @Override
    @Transactional
    public Student update(Student student) {

        StudentCommandEntity entity =
                repository.findById(student.getId());


        if(entity == null) {
            throw new StudentNotFoundException(
                    "Student Not Found"
            );
        }


        entity.setNombre(student.getNombre());
        entity.setNota(student.getNota());


        return mapper.toStudentDomain(entity);
    }


    @Override
    @Transactional
    public void delete(Long id) {

        repository.deleteById(id);
    }
}