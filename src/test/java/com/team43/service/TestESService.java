package com.team43.service;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by jpk on 11/28/16.
 */
public class TestESService {
    @Test
    public void testFetch () {
        ESService service = new ESService();
        ESService.TweetArray array = service.getTweets();
        Assert.assertEquals(1, array.tweets.length);
        Assert.assertEquals("This is a tweet", array.tweets[0].text);
    }
}
