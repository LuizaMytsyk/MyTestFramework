package TestLogger;

import java.io.FileWriter;
import java.io.IOException;

public class FileLogger extends AbstractLogger {


    public void doLogging(String stringToLog)  {


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
            fr.write ("\n");
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
