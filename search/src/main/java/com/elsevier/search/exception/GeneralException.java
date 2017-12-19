package com.elsevier.search.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class GeneralException extends WebApplicationException  {

    private static final long serialVersionUID = 8753811036438653477L;

    public GeneralException(String message) {
        super(Response.status(Response.Status.INTERNAL_SERVER_ERROR)
            .entity(message).type(MediaType.APPLICATION_JSON).build());
    }
}
