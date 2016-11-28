package com.team43.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FeedData {
    private String mockName;

    public FeedData() {
        super();
    }

    public FeedData(String mockName) {
        super();
        this.mockName = mockName;
    }

    public String getMockName() {
        return mockName;
    }

    public void setMockName(String mockName) {
        this.mockName = mockName;
    }
}
