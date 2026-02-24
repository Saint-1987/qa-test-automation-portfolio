package utils;

public class TestUtils {
    public static String resourcePath(String relative) {
        return System.getProperty("user.dir") + "/src/main/resources/" + relative;
    }
}
