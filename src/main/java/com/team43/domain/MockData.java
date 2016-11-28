package com.team43.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MockData {
    private String mockName;

    public MockData() {
        super();
    }

    public MockData(String mockName) {
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
