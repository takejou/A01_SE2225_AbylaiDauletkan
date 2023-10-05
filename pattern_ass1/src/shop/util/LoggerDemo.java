package shop.util;

public class LoggerDemo {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("System started.");

        logger.log("System ended.");
        logger.close();
    }
}
