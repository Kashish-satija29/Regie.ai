package com.automation.api.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {

    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("price")
    private String price;

    @JsonProperty("brand")
    private String brand;

    @JsonProperty("category")
    private Category category;

    public String getName() {
        return name;
    }

}
