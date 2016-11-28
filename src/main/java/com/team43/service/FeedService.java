package com.team43.service;

import javax.inject.Singleton;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.stereotype.Service;

import com.team43.constants.Constants;
import com.team43.domain.FeedData;

@Singleton
@Service
public class FeedService {

    public FeedData getFeed() {
        FeedData feedData = new FeedData();

        Client client = ClientBuilder.newClient();

        Response response = client.target(Constants.BASE_URL).path("feed").request().get();

        if (response != null && Status.OK.getStatusCode() == response.getStatus()) {
            feedData = response.readEntity(new GenericType<FeedData>() {
            });
        }

        return feedData;
    }

}
