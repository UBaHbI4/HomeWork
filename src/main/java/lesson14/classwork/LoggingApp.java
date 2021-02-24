package lesson14.classwork;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/****
 Project HomeWork
 Package softing.UBaH4ukDev.Lesson14.ClassWork

 Created by Ivan Sheynmaer

 Подробнее про логгер https://logging.apache.org/log4j/2.x/

 2021.02.22
 v1.0
 */
public class LoggingApp {
    public static final Logger LOGGER = LogManager.getLogger(LoggingApp.class);

    public static void main(String[] args) {
        String s1 = "First placeholder";
        int i2 = 12;
        LOGGER.trace("Trace log");
        LOGGER.debug("Debug log");
        LOGGER.info("Info log {} {}", i2, s1);
        LOGGER.warn("Warn log");
        LOGGER.error("Error log");
        LOGGER.fatal("Fatal log");
        //tryError();
    }

    public static void tryError() {
        try {
            throw new RuntimeException("Some exception");
        } catch (RuntimeException e) {
            LOGGER.throwing(Level.ERROR, e);
        }
    }
}
