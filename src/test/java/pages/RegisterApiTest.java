package pages;

import Utils.ApiBaseTest;
import com.automation.api.pojo.RegisterRequest;
import com.automation.api.pojo.RegisterResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterApiTest extends ApiBaseTest {

    @Test
    public void verifySuccessfulRegistration() {
        RegisterApiPage api = new RegisterApiPage();

        RegisterRequest request = new RegisterRequest("eve.holt@reqres.in", "pistol");

        Response rawResponse = api.registerUserRaw(request);
        RegisterResponse response = rawResponse.as(RegisterResponse.class);


        Assert.assertEquals(rawResponse.statusCode(), 200);
        Assert.assertNotNull(response.getId(), "ID should not be null");
        Assert.assertNotNull(response.getToken(), "Token should not be null");


        test.info(" Request: Email = " + request.getEmail() + ", Password = " + request.getPassword());
        test.info(" Header: x-api-key=reqres-free-v1");
        test.info(" Status Code: " + rawResponse.statusCode());
        test.info(" ID: " + response.getId());
        test.info(" Token: " + response.getToken());
        test.pass(" Successful registration verified!");
    }

    @Test
    public void verifyRegistrationFailsWithoutEmail() {
        RegisterApiPage api = new RegisterApiPage();

        RegisterRequest request = new RegisterRequest();
        request.setPassword("pistol");

        Response response = api.registerUserRaw(request);


        Assert.assertEquals(response.statusCode(), 400);
        String error = response.jsonPath().getString("error");
        Assert.assertEquals(error, "Missing email or username");


        test.info(" Request Body Sent (Without Email): Password = " + request.getPassword());
        test.info(" Header: x-api-key=reqres-free-v1");
        test.info(" Status Code: " + response.statusCode());
        test.info(" Error Message: " + error);
        test.pass(" Negative test for missing email validated successfully!");
    }
    @Test
    public void verifyRegistrationFailsWithoutPassword() {
        RegisterApiPage api = new RegisterApiPage();


        RegisterRequest request = new RegisterRequest();
        request.setEmail("eve.holt@reqres.in");

        Response response = api.registerUserRaw(request);


        Assert.assertEquals(response.statusCode(), 400);
        String error = response.jsonPath().getString("error");
        Assert.assertEquals(error, "Missing password");


        test.info(" Request Body Sent (Without Password): Email = " + request.getEmail());
        test.info(" Header: x-api-key=reqres-free-v1");
        test.info(" Status Code: " + response.statusCode());
        test.info(" Error Message: " + error);
        test.pass("  Negative test for missing password validated successfully!");
    }

}
