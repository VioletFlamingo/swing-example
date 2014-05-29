package pl.agh.edu.jtp.autokad.ui.windows;

import javax.swing.*;

public class ToolbarBuilder {
    public static JToolBar getToolbar() {
        JToolBar toolBar = new JToolBar();
        parseXML(toolBar);
        return toolBar;
    }

    private static void parseXML(JToolBar toolBar) {

    }
}
