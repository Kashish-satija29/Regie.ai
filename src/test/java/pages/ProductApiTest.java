package pages;

import Utils.ApiBaseTest;
import com.automation.api.pojo.RegisterRequest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import pages.ProductApiPage;
import com.automation.api.pojo.ProductListResponse;
import com.automation.api.pojo.Product;
import org.testng.Assert;
import org.testng.annotations.Test;
import Utils.BaseTest;

import java.util.List;
public class ProductApiTest extends ApiBaseTest {
    @Test
    public void verifyAllProductsApi() {
        ProductApiPage api = new ProductApiPage();
        ProductListResponse response = api.getAllProductsAsPojo();
        String baseUri = "https://automationexercise.com";
        String basePath = "/api/productsList";

        Assert.assertEquals(response.getResponseCode(), 200, "Response Code should be 200");

        List<Product> products = response.getProducts();
        Assert.assertFalse(products.isEmpty(), "Product list should not be empty");


        System.out.println("Total Products: " + products.size());
        System.out.println("First Product Name: " + products.get(0).getName());
        test.info("Request URL: `" + baseUri + basePath + "`");

        test.info("Total Products: " + products.size());
        test.info("First Product: " + products.get(0).getName());
        test.info("Response Code (from POJO): " + response.getResponseCode());

        test.pass("Product API validated successfully!");


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


        test.info(" Request Body Sent (Without Email): " + request.getPassword());
        test.info(" Header: x-api-key=reqres-free-v1");
        test.info(" Status Code: " + response.statusCode());
        test.info(" Error Message: " + error);
        test.pass(" Negative test for missing email validated successfully!");
    }




}


