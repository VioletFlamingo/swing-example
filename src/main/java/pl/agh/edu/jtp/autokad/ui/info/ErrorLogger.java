package pl.agh.edu.jtp.autokad.ui.info;

import java.io.*;

/**
 * Created by Paulina on 30.04.2014.
 */
public class ErrorLogger {
    private File error;
    private boolean loggingToFile =true;

    private static ErrorLogger singleton;

    public static ErrorLogger getInstance(){
        if(singleton == null) {
            singleton = new ErrorLogger();
        }
        return singleton;
    }

    private ErrorLogger () {
        File dir = new File ("logs");
        if (!dir.exists()) {
            dir.mkdir();
        }
        error = new File("logs/error.log");
        try {
            error.createNewFile();
            if (error.exists()) {
                PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(error, false)));
            }
        } catch (IOException e) {
            e.printStackTrace();
            LoggerProblemReporter loggerProblem = new LoggerProblemReporter("Problem with error logger occurred");
            loggingToFile =false;
        }
    }


    public void log (String message) {
        if (loggingToFile) {
            logToFile(message);
        } else {
            logToLogger(message);
        }
    }

    private void logToFile (String message) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(error, true)))) {
            out.println(message);
        } catch (IOException e) {
            LoggerProblemReporter loggerProblem = new LoggerProblemReporter("Problem with error logger occurred");
            loggingToFile =false;
        }
    }

    private void logToLogger (String message) {
        System.out.println(message+"\n");
    }
}
