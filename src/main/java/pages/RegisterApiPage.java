package pages;

import com.automation.api.pojo.RegisterRequest;
import com.automation.api.pojo.RegisterResponse;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class RegisterApiPage {

    private static final String BASE_URI = "https://reqres.in";

    public Response registerUserRaw(RegisterRequest request) {
        return given()
                .baseUri(BASE_URI)
                .basePath("/api/register")
                .header("Content-Type", "application/json")
                .header("x-api-key", "reqres-free-v1")
                .body(request)
                .when()
                .post();
    }

    public RegisterResponse registerUserPojo(RegisterRequest request) {
        return registerUserRaw(request).as(RegisterResponse.class);
    }
}
