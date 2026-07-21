package com.lab.student.business;

import com.lab.student.api.dto.StudentUpdateDTO;
import com.lab.student.business.exception.InvalidGradeException;
import com.lab.student.business.exception.StudentNotFoundException;
import com.lab.student.business.model.Student;
import com.lab.student.business.repository.StudentViewRepository;
import com.lab.student.business.repository.StudentWriteRepository;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class StudentService {


    private final StudentWriteRepository writeRepository;

    private final StudentViewRepository viewRepository;


    public StudentService(
            StudentWriteRepository writeRepository,
            StudentViewRepository viewRepository) {

        this.writeRepository = writeRepository;
        this.viewRepository = viewRepository;
    }


    public Student create(Student student) {

        initiateStudent(student);
        return writeRepository.save(student);
    }

    private void initiateStudent(Student student) {

        if(student.getNota() == null){
            student.setNota(-1.0);
        }

        if(student.getNota()!=-1.0 && (student.getNota()<0.0 || student.getNota()>20.0)){
            throw new InvalidGradeException("Nota invalida");
        }
    }


    public List<Student> findAll() {

        List<Student> result = viewRepository.findAll();
        Log.info(String.format("Student Service: %b se ha encontrado null",result==null));
        Log.info(String.format("Student Service: %d elementos encontrados",result.size()));
        return result;
    }


    public Student findById(Long id) {

        return viewRepository.findById(id)
                .orElseThrow(
                        () -> new StudentNotFoundException("No se ha hallado ningun estudiante.")
                );
    }

    public Student update(Long id, StudentUpdateDTO dto) {

        Student existingStudent = viewRepository.findById(id)
                .orElseThrow(
                        () -> new StudentNotFoundException(
                                "No se ha hallado ningun estudiante."
                        )
                );


        existingStudent.setNombre(dto.getNombre());
        existingStudent.setNota(dto.getNota());


        initiateStudent(existingStudent);


        return writeRepository.update(existingStudent);
    }
    public void delete(Long id) {

        Student student = viewRepository.findById(id)
                .orElseThrow(
                        () -> new StudentNotFoundException(
                                "No se ha hallado ningun estudiante."
                        )
                );


        writeRepository.delete(id);
    }
}