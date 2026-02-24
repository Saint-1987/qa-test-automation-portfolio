package utils;

import java.util.logging.Level;

// Simple wrapper using java.util.logging
public class Logger {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Logger.class.getName());

    public static void info(String msg) {
        logger.log(Level.INFO, msg);
    }

    public static void error(String msg, Throwable t) {
        logger.log(Level.SEVERE, msg, t);
    }
}
