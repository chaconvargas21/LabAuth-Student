package com.lab.student.api;

import com.lab.common.mappers.DTOMapper;
import com.lab.student.api.dto.StudentCreateDTO;
import com.lab.student.api.dto.StudentResponseDTO;
import com.lab.student.api.dto.StudentUpdateDTO;
import com.lab.student.projection.StudentProjectionService;
import com.lab.student.business.StudentService;
import com.lab.student.business.model.Student;
import io.quarkus.logging.Log;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/students")
public class StudentResource {
    @Inject
    StudentService service;
    @Inject
    StudentProjectionService projectionService;
    @Inject
    DTOMapper dtoMapper;

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Quarkus REST";
    }

    @GET
    @Path("/sync")
    @Produces(MediaType.TEXT_PLAIN)
    public String sync() {
        projectionService.synchronize();
        return "Synchronized";
    }

    @PUT
    @Path("/{id}")
    public Response update(
            @PathParam("id") Long id,
            StudentUpdateDTO dto) {

        Student student = service.update(id, dto);
        return Response.ok(student).build();

    }

    @POST
    @Path("/create")
    public Response create(StudentCreateDTO dto) {

        Student student = service.create(dtoMapper.toStudentEntity(dto));


        return Response
                .status(Response.Status.CREATED)
                .entity(dtoMapper.toStudentDTO(student))
                .build();


    }

    @GET
    @Path("/getAll")
    public Response findAll() {

        List<StudentResponseDTO> result = dtoMapper.toStudentDTOList(service.findAll());
        Log.info(String.format("Student Resource: %d elementos encontrados",result.size()));

        return Response
                .ok(result)
                .build();



    }

    @GET
    @Path("/{id}")
    public Response findById(
            @PathParam("id") Long id) {


        return Response
                .ok(dtoMapper.toStudentDTO(service.findById(id)))
                .build();


    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {

        service.delete(id);

        return Response
                .status(Response.Status.NO_CONTENT)
                .build();
    }
}
