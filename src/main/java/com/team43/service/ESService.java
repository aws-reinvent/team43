package com.team43.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.inject.Singleton;
import java.util.Date;

/**
 * Created by jpk on 11/28/16.
 */
@Singleton
@Service
public class ESService {
    public TweetArray getTweets () {
        //String url = "https://search-hackathon43-hh6di4idan2fs35uldydhyhnyy.us-west-2.es.amazonaws.com/_search";
//        String url = "https://mmih9traja.execute-api.us-west-2.amazonaws.com/dev/query";
//        RestTemplate restTemplate = new RestTemplate();
//        TweetArray array = restTemplate.getForObject(url, TweetArray.class);
        ESService.TweetArray array = new ESService.TweetArray();
        array.tweets = new ESService.Tweet[3];
        array.tweets[0] = newTweet("This is a tweet");
        array.tweets[1] = newTweet("This is a tweet also");
        array.tweets[2] = newTweet("This is another tweet");

        for (Tweet tweet : array.tweets) {
            if (tweet.date != null) {
                tweet.dateString = tweet.date.toString();
            }
        }
        return array;
    }

    public Tweet newTweet (String text) {
        Tweet tweet = new ESService.Tweet();
        tweet.text = text;
        tweet.date = new Date();
        tweet.username = "JPK";
        return tweet;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class TweetArray {
        public Tweet [] tweets;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Tweet {
        public String text;
        public String username;
        public Date date;
        public String dateString;
    }
}