package pl.agh.edu.jtp.autokad.ui.windows;

import pl.agh.edu.jtp.autokad.config.DOMObjectGetter;
import pl.agh.edu.jtp.autokad.config.Figure;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ToolbarBuilder {
    public static JToolBar getToolbar(JToolBar toolBar) {
        toolBar.setLayout(new BoxLayout(toolBar, BoxLayout.PAGE_AXIS));
        parseXML(toolBar);
        return toolBar;
    }

    private static void parseXML(JToolBar toolBar) {
        DOMObjectGetter objectGetter = new DOMObjectGetter();
        objectGetter.parseXML("resources" + File.separator+"configuration.xml");
        List<Figure> figureList =  objectGetter.getList();

        for (Figure f : figureList) {
            toolBar.add(getButton(f));
        }
    }

    private static JButton getButton (Figure figure) {
        JButton button = new JButton();
        button.setToolTipText(figure.getHint());
        try {
            button.setIcon(new ImageIcon(ImageIO.read(ClassLoader.getSystemResource(figure.getIconPath()))));
        } catch (IOException e) {
            e.printStackTrace();
        } return button;
    }
}
