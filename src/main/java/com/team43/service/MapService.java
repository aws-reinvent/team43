package com.team43.service;

import javax.inject.Singleton;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.stereotype.Service;

import com.team43.constants.Constants;
import com.team43.domain.MapData;

@Singleton
@Service
public class MapService {

    public MapData getMap() {
        MapData mapData = new MapData();

        Client client = ClientBuilder.newClient();

        Response response = client.target(Constants.BASE_URL).path("map").request().get();

        if (response != null && Status.OK.getStatusCode() == response.getStatus()) {
            mapData = response.readEntity(new GenericType<MapData>() {
            });
        }

        return mapData;
    }

}
