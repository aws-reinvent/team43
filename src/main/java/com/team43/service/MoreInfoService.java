package com.team43.service;

import javax.inject.Singleton;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.stereotype.Service;

import com.team43.domain.MoreInfoData;

@Singleton
@Service
public class MoreInfoService {

    public MoreInfoData getMoreInfo(String feedBackId) {

        Client client = ClientBuilder.newClient();
        // https://mmih9traja.execute-api.us-west-2.amazonaws.com/dev/tweet?feedbackID=583cf2e8a34a440001abc3dd

        System.out.println("FeedbackId = " + feedBackId);

        Response response = client.target("https://mmih9traja.execute-api.us-west-2.amazonaws.com/dev/tweet")
                .queryParam("feedbackID", feedBackId).request().get();
        MoreInfoData embedURL = null;
        if (response != null && Status.OK.getStatusCode() == response.getStatus()) {
            embedURL = response.readEntity(new GenericType<MoreInfoData>() {
            });
        }

        return embedURL;
    }

}