package shop.util;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    private static volatile Logger instance;
    private PrintWriter logFile;

    private Logger() {
        try {
            logFile = new PrintWriter(new FileWriter("system.log", true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }
    public void log(String message) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = dateFormat.format(new Date());
        String logMessage = "[" + formattedDate + "] " + message;
        logFile.println(logMessage);
        System.out.println(logMessage);
        logFile.flush();
    }
    public void close() {
        logFile.close();
    }
}
