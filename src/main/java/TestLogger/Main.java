package TestLogger;

import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {


       Logger consoleLogger = new ConsoleLogger();
       Logger fileLogger = new FileLogger();
       Logger consolFileLogger = new ConsolFileLogger();


        consoleLogger.log("Start Browser");
        consoleLogger.log("Open Website");
        consoleLogger.log("Login User");
        consoleLogger.log("Last Step");

        fileLogger.log("qqqqqq");
        fileLogger.log("Open Website");
        fileLogger.log("Login User");
        fileLogger.log("хохо");

        consolFileLogger.log("111");
        consolFileLogger.log("222");
        consolFileLogger.log("333");
        consolFileLogger.log("444");

    }


    }


