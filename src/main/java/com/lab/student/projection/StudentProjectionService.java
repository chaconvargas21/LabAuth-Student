package com.lab.student.projection;


import com.lab.common.mappers.CommandMapper;
import com.lab.common.mappers.QueryMapper;
import com.lab.student.command.entity.StudentCommandEntity;
import com.lab.student.command.repository.StudentJpaRepository;
import com.lab.student.query.entity.StudentViewEntity;
import com.lab.student.query.repository.StudentViewMongoRepository;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class StudentProjectionService {


    private final StudentJpaRepository commandRepository;
    private final StudentViewMongoRepository viewRepository;
    private final QueryMapper mapper;
    private final CommandMapper commandMapper;


    public StudentProjectionService(
            StudentJpaRepository commandRepository,
            StudentViewMongoRepository viewRepository,
            QueryMapper mapper, CommandMapper commandMapper) {

        this.commandRepository = commandRepository;
        this.viewRepository = viewRepository;
        this.mapper = mapper;
        this.commandMapper = commandMapper;
    }


    public void synchronize() {


        // Obtener todos los datos de la BBDD de escritura
        List<StudentCommandEntity> students =
                commandRepository.listAll();

        Log.info(String.format("Retrieved %d elements", students.size()));


        // Limpiar la proyección actual
        viewRepository.deleteAll();


        // Crear la nueva proyección en MongoDB
        students.forEach(commandEntity -> {

            StudentViewEntity viewEntity =
                    mapper.toStudentViewEntity(commandMapper.toStudentDomain(commandEntity));

            viewRepository.persist(viewEntity);
        });
    }
}