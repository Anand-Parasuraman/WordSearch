package com.elsevier.search.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class BadRequestException extends WebApplicationException{

    private static final long serialVersionUID = 1L;

    public BadRequestException(String message) {
        super(Response.status(Response.Status.BAD_REQUEST)
            .entity(message).type(MediaType.APPLICATION_JSON).build());
    }

}
