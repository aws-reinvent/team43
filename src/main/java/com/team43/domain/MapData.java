package com.team43.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MapData {
    private String mockName;

    public MapData() {
        super();
    }

    public MapData(String mockName) {
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
