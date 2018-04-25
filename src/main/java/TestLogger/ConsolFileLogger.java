package TestLogger;

import java.io.FileWriter;
import java.io.IOException;

public class ConsolFileLogger extends AbstractLogger {

    public void doLogging(String stringToLog) {
        System.out.println(stringToLog);

        FileWriter fr = null;
        try {
            fr = new FileWriter("Logger.txt", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fr.write(stringToLog);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
