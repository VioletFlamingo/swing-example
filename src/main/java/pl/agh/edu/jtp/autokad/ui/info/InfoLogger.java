package pl.agh.edu.jtp.autokad.ui.info;

import java.io.*;

/**
 * Created by Paulina on 01.05.2014.
 */
public class InfoLogger {
    private File info;
    private boolean loggingToFile =true;


    private static InfoLogger singleton;

    public static InfoLogger getInstance(){
        if(singleton == null) {
            singleton = new InfoLogger();
        }
        return singleton;
    }

    private InfoLogger () {
        File dir = new File ("logs");
        if (!dir.exists()) {
            dir.mkdir();
        }
        info = new File("logs/application.log");
        try {
            info.createNewFile();
            if (info.exists()) {
                PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(info, false)));
            }
        } catch (IOException e) {
            e.printStackTrace();
            LoggerProblemReporter loggerProblem = new LoggerProblemReporter("Problem with info logger occurred");
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
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(info, true)))) {
            out.println(message);
        } catch (IOException e) {
            LoggerProblemReporter loggerProblem = new LoggerProblemReporter("Problem with info logger occurred");
            loggingToFile =false;
        }
    }

    private void logToLogger (String message) {
        System.out.println(message+"\n");
    }
}
