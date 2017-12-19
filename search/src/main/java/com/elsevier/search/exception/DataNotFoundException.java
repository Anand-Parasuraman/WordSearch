package com.elsevier.search.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class DataNotFoundException extends WebApplicationException {
   
    private static final long serialVersionUID = 1L;

    public DataNotFoundException(String message) {
        super(Response.status(Response.Status.NOT_FOUND)
            .entity(message).type(MediaType.APPLICATION_JSON).build());
    }

}
