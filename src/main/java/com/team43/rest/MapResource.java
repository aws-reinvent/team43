package com.team43.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.team43.domain.MapData;
import com.team43.service.MapService;

@Path("/map")
@Component
public class MapResource {

    @Autowired
    private MapService mapService;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public MapData getMap() {
        return mapService.getMap();
    }
}
