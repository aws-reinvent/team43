package com.team43.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.team43.domain.FeedData;
import com.team43.service.FeedService;

@Path("/feed")
@Component
public class FeedResource {

    @Autowired
    private FeedService feedService;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public FeedData getMap() {
        return feedService.getFeed();
    }
}
