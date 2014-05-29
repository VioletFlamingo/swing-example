package pl.agh.edu.jtp.autokad.ui.info;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Paulina on 01.05.2014.
 */
public class LoggerProblemReporter {
    public LoggerProblemReporter (String message) {
        final Component frame = new Frame();
        JOptionPane.showMessageDialog(frame, message);
    }
}
