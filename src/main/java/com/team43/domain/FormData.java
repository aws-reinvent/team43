package com.team43.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FormData {
    private String mockName;

    public FormData() {
        super();
    }

    public FormData(String mockName) {
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
