package com.team43.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MoreInfoData {
    private String tweetId;

    private String userId;

    private String embedHtml;

    public MoreInfoData() {
        super();
    }

    public String getTweetId() {
        return tweetId;
    }

    public void setTweetId(String tweetId) {
        this.tweetId = tweetId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmbedHtml() {
        return embedHtml;
    }

    public void setEmbedHtml(String embedHtml) {
        this.embedHtml = embedHtml;
    }

}
