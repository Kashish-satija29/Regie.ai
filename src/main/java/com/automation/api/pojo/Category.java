package com.automation.api.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Category {

    @JsonProperty("usertype")
    private UserType usertype;

    @JsonProperty("category")
    private String category;

    // Getters and Setters
    public UserType getUsertype() {
        return usertype;
    }

    public void setUsertype(UserType usertype) {
        this.usertype = usertype;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
