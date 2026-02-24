package api;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import reports.ApiLogger;

import static io.restassured.RestAssured.*;

public class CreateUserTest extends BaseApiTest {

    @Test
    public void createUser() {

    String requestBody = "{\n" +
        "  \"name\": \"John Doe\",\n" +
        "  \"job\": \"QA Engineer\"\n" +
        "}";

        ApiLogger.logRequest(extentTest.get(), "POST", "/api/users", requestBody);

        Response response =
                given()
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/115.0.0.0 Safari/537.36")
                    .body(requestBody)
                .when()
                    .post("/api/users")
                .then()
                    .extract().response();

        ApiLogger.logResponse(extentTest.get(), response.statusCode(), response.asPrettyString());

        Assert.assertEquals(response.statusCode(), 201);
        Assert.assertEquals(response.jsonPath().getString("name"), "John Doe");
    }
}
