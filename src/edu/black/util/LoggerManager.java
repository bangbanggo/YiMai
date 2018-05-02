package edu.black.util;

public class LoggerManager {
    private static Logger logger = null;
    public static Logger getLogger(Class clazz){
        logger = new LoggerConsole();
        return logger;
    }
}
