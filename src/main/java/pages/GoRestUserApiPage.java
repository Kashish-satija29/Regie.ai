package pages;

import com.automation.api.pojo.GoRestUserRequest;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GoRestUserApiPage {

    private static final String BASE_URI = "https://gorest.co.in";
    private static final String TOKEN = "Bearer 450057eeaf02eb1f8338fd180892eea20a3129e6effe49143b15a18484e23860";

    public Response createUserRaw(GoRestUserRequest userRequest) {
        return given()
                .baseUri(BASE_URI)
                .basePath("/public/v2/users")
                .header("Authorization", TOKEN)
                .header("Content-Type", "application/json")
                .body(userRequest)
                .when()
                .post()
                .then()
                .log().all()
                .extract().response();
    }
}
