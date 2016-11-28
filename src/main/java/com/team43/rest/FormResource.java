package com.team43.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.team43.domain.FormData;
import com.team43.service.FormService;

@Path("/form")
@Component
public class FormResource {

    @Autowired
    private FormService formService;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public FormData getMap() {
        return formService.getForm();
    }
}
