package pages;

import com.automation.api.pojo.GoRestUserRequest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GoRestUserApiPage;
import Utils.ApiBaseTest;

public class GoRestUserTest extends ApiBaseTest {

    @Test
    public void verifySuccessfulUserCreation() {
        GoRestUserApiPage api = new GoRestUserApiPage();

        GoRestUserRequest user = new GoRestUserRequest(
                "Kashish Automation",
                "kashish" + System.currentTimeMillis() + "@mail.com",
                "male",
                "active"
        );


        Response response = api.createUserRaw(user);

        Assert.assertEquals(response.statusCode(), 201);
        Assert.assertEquals(response.jsonPath().getString("name"), user.getName());

        test.info("Status Code: " + response.statusCode());
        test.info("ID: " + response.jsonPath().getInt("id"));
        test.info("Email: " + response.jsonPath().getString("email"));
        test.pass("User created successfully in GoRest!");
    }

    @Test
    public void verifyCreationFailsWithoutEmail() {
        GoRestUserApiPage api = new GoRestUserApiPage();

        GoRestUserRequest user = new GoRestUserRequest(
                "Kashish No Email",
                "",
                "female",
                "active"
        );

        Response response = api.createUserRaw(user);

        Assert.assertEquals(response.statusCode(), 422);
        String message = response.jsonPath().getString("[0].message");
        Assert.assertTrue(message.contains("can't be blank") || message.contains("is invalid"));

        test.pass("Email missing validation successful");

    }

    @Test
    public void verifyCreationFailsWithoutGender() {
        GoRestUserApiPage api = new GoRestUserApiPage();

        GoRestUserRequest user = new GoRestUserRequest(
                "Kashish No Email",
                "kaish@gmail.com",
                "",
                "active"
        );

        Response response = api.createUserRaw(user);

        Assert.assertEquals(response.statusCode(), 422);
        String message = response.jsonPath().getString("[0].message");
        Assert.assertTrue(message.contains("can't be blank") || message.contains("is invalid"));

        test.pass("Gender missing validation successful");

    }
    @Test
    public void verifyCreationFailsWithoutName() {
        GoRestUserApiPage api = new GoRestUserApiPage();

        GoRestUserRequest user = new GoRestUserRequest(
                "",
                "kaish@gmail.com",
                "Female",
                "active"
        );

        Response response = api.createUserRaw(user);

        Assert.assertEquals(response.statusCode(), 422);
        String message = response.jsonPath().getString("[0].message");
        Assert.assertTrue(message.contains("can't be blank") || message.contains("is invalid"));

        test.pass("Name missing validation successful");

    }
    @Test
    public void verifyCreationFailsWithoutStatus() {
        GoRestUserApiPage api = new GoRestUserApiPage();

        GoRestUserRequest user = new GoRestUserRequest(
                "",
                "kaish@gmail.com",
                "Female",
                ""
        );

        Response response = api.createUserRaw(user);

        Assert.assertEquals(response.statusCode(), 422);
        String message = response.jsonPath().getString("[0].message");
        Assert.assertTrue(message.contains("can't be blank") || message.contains("is invalid"));

        test.pass("Status missing validation successful");

    }
}

