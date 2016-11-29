package com.team43.rest;

import com.team43.service.ESService;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by jpk on 11/28/16.
 */
@Path("/tweet")
@Component
public class TweetResource {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public ESService.Tweet getMap(@PathParam("feedbackID") String feedbackID) {
        //return new ESService().getTweet();

        ESService.Tweet tweet = new ESService.Tweet();
        tweet.text = "THis is a tweet";
        tweet.user.name = "JPK";
        return tweet;
    }
}
