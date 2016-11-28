package com.team43.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.team43.domain.MockData;
import com.team43.service.MockService;

@Path("/mocks")
@Component
public class MockResource {

    @Autowired
    private MockService mockService;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<MockData> getMocks() {
        return mockService.getMocks();
    }
}
