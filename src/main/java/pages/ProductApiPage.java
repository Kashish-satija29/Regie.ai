package pages;

import com.automation.api.pojo.ProductListResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;

public class ProductApiPage {

    public Response getAllProductsRawResponse() {
        return RestAssured
                .given()
                .baseUri("https://automationexercise.com")
                .basePath("/api/productsList")
                .when()
                .get()
                .then()
                .log().all()
                .extract()
                .response();
    }


    public ProductListResponse getAllProductsAsPojo() {
        String rawJson = getAllProductsRawResponse().getBody().asString();


        int start = rawJson.indexOf("{");
        int end = rawJson.lastIndexOf("}") + 1;

        String pureJson = rawJson.substring(start, end);


        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(pureJson, ProductListResponse.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse JSON: " + e.getMessage());
        }
    }
}
