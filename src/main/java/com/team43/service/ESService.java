package com.team43.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.inject.Singleton;

/**
 * Created by jpk on 11/28/16.
 */
@Singleton
@Service
public class ESService {
    public TweetArray getTweets () {
        //String url = "https://search-hackathon43-hh6di4idan2fs35uldydhyhnyy.us-west-2.es.amazonaws.com/_search";
        String url = "https://mmih9traja.execute-api.us-west-2.amazonaws.com/dev/query";
        RestTemplate restTemplate = new RestTemplate();
        TweetArray array = restTemplate.getForObject(url, TweetArray.class);
        return array;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class TweetArray {
        public Tweet [] tweets;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Tweet {
        public String text;
    }
}
