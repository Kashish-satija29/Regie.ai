package com.automation.api.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductListResponse {

    @JsonProperty("responseCode")
    private int responseCode;

    @JsonProperty("products")
    private List<Product> products;
}
