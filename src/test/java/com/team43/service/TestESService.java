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
        Assert.assertEquals(10, array.tweets.length);

        ESService.Tweet tweet = array.tweets[0];
        Assert.assertNotNull(array.tweets[0].dateString);
    }
}
