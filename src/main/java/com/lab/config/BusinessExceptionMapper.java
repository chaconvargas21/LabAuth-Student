package com.lab.config;

import com.lab.student.business.exception.BusinessException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.Map;

@Provider
public class BusinessExceptionMapper
        implements ExceptionMapper<BusinessException> {


    @Override
    public Response toResponse(
            BusinessException exception) {

        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity(
                        Map.of(
                                "error",
                                exception.getMessage()
                        )
                )
                .build();
    }
}