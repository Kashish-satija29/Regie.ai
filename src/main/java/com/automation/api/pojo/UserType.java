package com.automation.api.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserType {

    @JsonProperty("usertype")
    private String usertype;


    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }
}
