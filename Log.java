/*
 * Class Log is used to log events in the game
 * Class takes name of the object that is logging, text to log, type of log and format of log
 * Class has 4 formats of logs: PRODUCTION, DEBUG, ERROR and WARNING for type DEBUG
 * Class has 4 formats of logs: NARATOR, SPEECH, RESULT and PRODUCTION for type PRODUCTION
 * Class has 2 types of logs: PRODUCTION and DEBUG
 * @author:  JustAKuba
 */

import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {

    public static void log(String name, String text, LogType type, LogFormat format) {
        switch (type) {
            case PRODUCTION:
                switch (format) {
                    case NARATOR:
                        System.out.println(text);
                        break;
                    case SPEECH:
                        System.out.println("[" + name + "]: " + text);
                        break;
                    case RESULT:
                        System.out.println("[Production Result]: " + text);
                        break;

                }
                break;
            case DEBUG:
                switch (format) {
                    case ERROR:
                        write("[Error]: " + text);
                        break;
                    case WARNING:
                        write("[Warning]: " + text);
                        break;
                    case INFO:
                        write("[Info]: " + text);
                        break;
                    case DEBUG:
                        write("[Debug]: " + text);
                        break;
                }
                break;
        }
    }

    public static void write(String text) {
        //Write into file named after the date in directory logs
        try {
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = dateFormat.format(date);
            File logFile = new File("logs/" + dateString + ".log");
            logFile.getParentFile().mkdirs();
            FileWriter writer = new FileWriter(logFile, true);
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
            String timeString = timeFormat.format(date);
            writer.write("[" + timeString + "]" + text + System.lineSeparator());
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void debug(String text) {
        log("", text, LogType.DEBUG, LogFormat.DEBUG);
    }
}