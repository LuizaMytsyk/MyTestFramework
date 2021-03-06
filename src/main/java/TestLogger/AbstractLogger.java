package TestLogger;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class AbstractLogger implements Logger {

    private int counter = 1;
    private SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss.SSS");



    @Override
    public void log(String textToLog) {



            Date date = new Date();

            String dateFormatted = format.format(date);

            String methodName = Thread.currentThread().getName();

            String stringToLog = counter + ")" + dateFormatted + "[" + methodName + "]" + " " + textToLog;

            doLogging(stringToLog);
            counter++;


    }

    protected abstract void doLogging(String stringToLog);
}
