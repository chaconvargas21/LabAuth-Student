package com.lab.student.command.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class StudentCommandEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Double nota;


    public StudentCommandEntity() {
        // Constructor requerido por JPA
    }


    public StudentCommandEntity(
            Long id,
            String nombre,
            Double nota) {

        this.id = id;
        this.nombre = nombre;
        this.nota = nota;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public Double getNota() {
        return nota;
    }


    public void setNota(Double nota) {
        this.nota = nota;
    }
}