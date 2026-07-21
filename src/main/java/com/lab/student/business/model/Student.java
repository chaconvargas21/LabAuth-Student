package com.lab.student.business.model;

public class Student {

    private Long id;
    private String nombre;
    private Double nota;

    public Student() {
    }

    public Student(String nombre, Double nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    public Student(Long id, String nombre, Double nota) {
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
