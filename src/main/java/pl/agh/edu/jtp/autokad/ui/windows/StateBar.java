package pl.agh.edu.jtp.autokad.ui.windows;

import pl.agh.edu.jtp.autokad.ui.figure.Oval;
import pl.agh.edu.jtp.autokad.ui.figure.Rectangle;
import pl.agh.edu.jtp.autokad.ui.figure.RoundedRectangle;
import pl.agh.edu.jtp.autokad.ui.info.ErrorLogger;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ResourceBundle;

/**
 * Created by Paulina on 02.05.2014.
 */
public class StateBar extends JPanel {
    private final ResourceBundle messages;
    private JPanel chosenFigure;
    private JPanel chosenColor;
    private JLabel savedState;
    private JLabel numberOfFigures;

    private boolean allInitialized = false;

    public StateBar(Class figure, Color color, ResourceBundle messages) {
        this.messages = messages;
        changeFigure(figure);
        changeSaved(false);
        changeColor(color);
        changeNumberOfFigures(0);
        this.setLayout(new FlowLayout(FlowLayout.TRAILING));
        allInitialized=true;
        addIcons();
    }

    public void changeFigure(Class figure) {
        this.removeAll();
        JPanel figurePanel = new JPanel();
        figurePanel.setOpaque(true);
        getImage(figurePanel, figure);
        this.chosenFigure = figurePanel;
        if (allInitialized) {
            addIcons();
        }
        this.validate();
        this.repaint();
    }

    private void addIcons() {
        this.add(savedState);
        this.add(chosenFigure);
        this.add(chosenColor);
        this.add(numberOfFigures);
    }

    public void changeColor(Color color) {
        this.removeAll();
        JPanel colorPanel = new JPanel();
        colorPanel.setPreferredSize(new Dimension(30, 30));
        colorPanel.setBackground(color);
        colorPanel.setOpaque(true);
        this.chosenColor = colorPanel;
        if (allInitialized) {
            addIcons();
        }
        this.validate();
        this.repaint();
    }

    public void changeSaved(boolean saved) {
        this.removeAll();
        JLabel savedLabel = new JLabel();
        if (saved) {
            savedLabel.setText(messages.getString("changed"));
        } else {
            savedLabel.setText(messages.getString("saved"));
        }
        this.savedState = savedLabel;
        if (allInitialized) {
            addIcons();
        }
        this.validate();
        this.repaint();
    }


    public void changeNumberOfFigures (int amountOfFigures) {
        this.removeAll();
        JLabel numberLabel = new JLabel();
        numberLabel.setText(amountOfFigures+" "+messages.getString("figures"));
        this.numberOfFigures = numberLabel;
        if (allInitialized) {
            addIcons();
        }
        this.validate();
        this.repaint();
    }


    private void getImage(JPanel panel, Class figure) {
        if (figure==Oval.class) {
            try {
                JLabel label = new JLabel(new ImageIcon(ImageIO.read(ClassLoader.getSystemResource("oval.jpg"))));
                panel.add(label);
            } catch (IOException | IllegalArgumentException e) {
                ErrorLogger.getInstance().log(e.getMessage());
                //e.printStackTrace();
                JLabel label = new JLabel("OVAL");
                panel.add(label);
            }
        } else if (figure==Rectangle.class) {
            try {
                JLabel label = new JLabel(new ImageIcon(ImageIO.read(ClassLoader.getSystemResource("rect.jpg"))));
                panel.add(label);
            } catch (IOException | IllegalArgumentException e) {
                ErrorLogger.getInstance().log(e.getMessage());
                //e.printStackTrace();
                JLabel label = new JLabel("RECTANGLE");
                panel.add(label);
            }
        } else if (figure==RoundedRectangle.class) {
            try {
                JLabel label = new JLabel(new ImageIcon(ImageIO.read(ClassLoader.getSystemResource("roundrect.jpg"))));
                panel.add(label);
            } catch (IOException | IllegalArgumentException e) {
                ErrorLogger.getInstance().log(e.getMessage());
                //e.printStackTrace();
                JLabel label = new JLabel("ROUNDED RECTANGLE");
                panel.add(label);
            }
        } else {
            try {
                JLabel label = new JLabel(new ImageIcon(ImageIO.read(ClassLoader.getSystemResource("Line.jpg"))));
                panel.add(label);
            } catch (IOException | IllegalArgumentException e) {
                ErrorLogger.getInstance().log(e.getMessage());
                //e.printStackTrace();
                JLabel label = new JLabel("LINE");
                panel.add(label);
            }
        }
    }
}
