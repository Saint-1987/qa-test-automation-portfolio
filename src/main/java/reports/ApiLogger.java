package reports;

import com.aventstack.extentreports.ExtentTest;

public class ApiLogger {

    public static void logRequest(ExtentTest test, String method, String endpoint, String body) {
        test.info("API Request:");
        test.info("Method: " + method);
        test.info("Endpoint: " + endpoint);

        if (body != null && !body.isEmpty()) {
            test.info("Request Body:<br><pre>" + body + "</pre>");
        }
        // Also print to console for build/test logs
        System.out.println("API Request: " + method + " " + endpoint);
        if (body != null && !body.isEmpty()) {
            System.out.println("Request Body: " + body);
        }
    }

    public static void logResponse(ExtentTest test, int statusCode, String responseBody) {
        test.info("API Response:");
        test.info("Status Code: " + statusCode);
        test.info("Response Body:<br><pre>" + responseBody + "</pre>");
        // Also print to console for build/test logs
        System.out.println("API Response (status=" + statusCode + "): ");
        System.out.println(responseBody);
    }
}
