package com.team43.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.team43.service.ESService;
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
    public ESService.TweetArray getMap() {
        ESService.TweetArray array = new ESService.TweetArray();
        array.tweets = new ESService.Tweet[2];
        array.tweets[0] = new ESService.Tweet();
        array.tweets[0].text = "This is a tweet";
        array.tweets[1] = new ESService.Tweet();
        array.tweets[1].text = "This is also a tweet";
        return array;
    }
}
