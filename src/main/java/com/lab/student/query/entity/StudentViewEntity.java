package com.lab.student.query.entity;


import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;

@MongoEntity(collection = "students")
public class StudentViewEntity extends PanacheMongoEntity {

    public Long studentId;

    public String nombre;

    public Double nota;
}