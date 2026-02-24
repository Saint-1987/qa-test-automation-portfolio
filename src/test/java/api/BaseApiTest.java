package api;

import base.BaseTest;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseApiTest extends BaseTest {

    @BeforeClass
    public void setupApi() {
        // Ensure config properties are loaded (BaseTest.loadProperties runs in @BeforeMethod,
        // but @BeforeClass can run earlier). Allow overriding via system property.
        try {
            utils.ConfigReader.loadProperties();
        } catch (Exception ignored) {
            // if properties already loaded or file not present, ignore
        }

        String base = System.getProperty("api.baseUri");
        if (base == null || base.isEmpty()) {
            String cfg = utils.ConfigReader.get("api.baseUri");
            if (cfg != null && !cfg.isEmpty()) {
                base = cfg;
            }
        }

        if (base == null || base.isEmpty()) {
            base = "https://reqres.in";
        }

        RestAssured.baseURI = base;
    }
}
