package api;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import reports.ApiLogger;

import static io.restassured.RestAssured.*;

public class GetUserTest extends BaseApiTest {

    @Test
    public void getSingleUser() {

        ApiLogger.logRequest(extentTest.get(), "GET", "/api/users/2", null);

        Response response =
                given()
                    .header("Accept", "application/json")
                    .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/115.0.0.0 Safari/537.36")
                .when()
                    .get("/api/users/2")
                .then()
                    .extract().response();

        ApiLogger.logResponse(extentTest.get(), response.statusCode(), response.asPrettyString());

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("data.email"), "janet.weaver@reqres.in");
    }
}
