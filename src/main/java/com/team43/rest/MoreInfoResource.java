package com.team43.rest;

import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.team43.domain.MoreInfoData;
import com.team43.service.MoreInfoService;

@Path("/moreinfo")
@Component
public class MoreInfoResource {

    @Autowired
    private MoreInfoService moreInfoService;

    @GET
    @Path("{feedbackId}")
    @Produces({MediaType.APPLICATION_JSON})
    public MoreInfoData getMoreInfo(@PathParam("feedbackId") String feedbackId) {
        System.out.println("FeedbackId = " + feedbackId);
        return moreInfoService.getMoreInfo(feedbackId);
    }
}
