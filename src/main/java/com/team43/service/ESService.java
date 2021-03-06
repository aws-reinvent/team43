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
        String url = "https://mmih9traja.execute-api.us-west-2.amazonaws.com/dev/query";
        RestTemplate restTemplate = new RestTemplate();
        TweetArray array = restTemplate.getForObject(url, TweetArray.class);
//        ESService.TweetArray array = new ESService.TweetArray();
//        array.tweets = new ESService.Tweet[3];
//        array.tweets[0] = newTweet("This is a tweet");
//        array.tweets[1] = newTweet("This is a tweet also");
//        array.tweets[2] = newTweet("This is another tweet");
//
//        array.tweets[2].entities = new Entities();
//        array.tweets[2].entities.media = new Media[1];
//        array.tweets[2].entities.media[0] = new Media();
//        array.tweets[2].entities.media[0].media_url = "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcSerqVCwvA5BMXYCh8-5pYnXUp_yT8OxzJBjhWczHtLqU42mkWjsg";


        for (Tweet tweet : array.tweets) {
            if (tweet.timestamp_ms > 0) {
                tweet.dateString = new Date(tweet.timestamp_ms).toString();
            }
        }
        return array;
    }

    public Tweet getTweet (String feedbackID) {
        //String url = "https://search-hackathon43-hh6di4idan2fs35uldydhyhnyy.us-west-2.es.amazonaws.com/_search";
        String url = "https://mmih9traja.execute-api.us-west-2.amazonaws.com/dev/tweet?feedbackID=" + feedbackID;

        RestTemplate restTemplate = new RestTemplate();
        FeedbackTuple tuple = restTemplate.getForObject(url, FeedbackTuple.class);

        System.out.println("Tuple: " + tuple.tweetId);

        String twitterUrl = "https://api.twitter.com/1.1/statuses/show.json?id=" + tuple.tweetId;
        RestTemplate twitterTemplate = new RestTemplate();
        Tweet tweet = twitterTemplate.getForObject(twitterUrl, Tweet.class);

        return tweet;
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
        public Entities entities;
        public User user;
        public long timestamp_ms;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Entities {
        public Media [] media = null;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Media {
        public String media_url;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class User {
        public String name;
    }

    public static class FeedbackTuple {
        public String tweetId;
    }
}
