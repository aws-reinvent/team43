package com.team43.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.stereotype.Service;

import com.team43.constants.Constants;
import com.team43.domain.MockData;

@Singleton
@Service
public class MockService {

    public List<MockData> getMocks() {
        List<MockData> mockData = new ArrayList<MockData>();

        Client client = ClientBuilder.newClient();

        Response response = client.target(Constants.BASE_URL).path("beers").request().get();

        if (response != null && Status.OK.getStatusCode() == response.getStatus()) {
            mockData = response.readEntity(new GenericType<List<MockData>>() {
            });
        }

        return mockData;
    }

}
