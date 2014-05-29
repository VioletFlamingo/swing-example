package pl.agh.edu.jtp.autokad.ui.windows;

import pl.agh.edu.jtp.autokad.ui.drawingutils.DrawingController;
import pl.agh.edu.jtp.autokad.ui.figure.Line;
import pl.agh.edu.jtp.autokad.ui.figure.Oval;
import pl.agh.edu.jtp.autokad.ui.figure.RoundedRectangle;
import pl.agh.edu.jtp.autokad.ui.info.ErrorLogger;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by Paulina on 29.04.2014.
 */
public class FigureButton {
    public static JButton getRectangleButton (final DrawingController drawingController) {
        JButton rectangleButton = getSimpleRectangleButton();
        rectangleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawingController.setFigure(pl.agh.edu.jtp.autokad.ui.figure.Rectangle.class);
            }
        });
        return rectangleButton;
    }

    public static JButton getOvalButton (final DrawingController drawingController) {
        JButton ovalButton = getSimpleOvalButton();
        ovalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawingController.setFigure(Oval.class);
            }
        });
        return ovalButton;
    }

    public static JButton getRoundedRectangleButton (final DrawingController drawingController) {
        JButton roundedRectangleButton = getSimpleRoundedRectangleButton();
        roundedRectangleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawingController.setFigure(RoundedRectangle.class);
            }
        });
        return roundedRectangleButton;
    }

    public static JButton getLineButton(final DrawingController drawingController) {
        JButton lineButton = getSimpleLineButton();
        lineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawingController.setFigure(Line.class);
            }
        });
        return lineButton;
    }

    private static JButton getSimpleLineButton() {
        JButton lineButton = new JButton();
        lineButton.setSize(new Dimension(30, 30));
        try {
            lineButton.setIcon(new ImageIcon(ImageIO.read(ClassLoader.getSystemResource("Line.jpg"))));
        } catch (IOException e) {
            ErrorLogger.getInstance().log(e.getMessage());
            //e.printStackTrace();
            lineButton.setText("LINE");
        }  catch (IllegalArgumentException e) {
            ErrorLogger.getInstance().log(e.getMessage());
            //e.printStackTrace();
            lineButton.setText("LINE");
        }
        return lineButton;
    }

    private static JButton getSimpleOvalButton() {
        JButton ovalButton = new JButton();
        ovalButton.setSize(new Dimension(30, 30));
        try {
            ovalButton.setIcon(new ImageIcon(ImageIO.read(ClassLoader.getSystemResource("oval.jpg"))));
        } catch (IOException e) {
            ErrorLogger.getInstance().log(e.getMessage());
            //e.printStackTrace();
            ovalButton.setText("OVAL");
        } catch (IllegalArgumentException e) {
            ErrorLogger.getInstance().log(e.getMessage());
            //e.printStackTrace();
            ovalButton.setText("OVAL");
        }
        return ovalButton;
    }

    private static JButton getSimpleRectangleButton() {
        JButton rectangleButton = new JButton();
        rectangleButton.setSize(new Dimension(30, 30));
        try {
            rectangleButton.setIcon(new ImageIcon(ImageIO.read(ClassLoader.getSystemResource("rect.jpg"))));
        } catch (IOException e) {
            ErrorLogger.getInstance().log(e.getMessage());
            //e.printStackTrace();
            rectangleButton.setText("RECTANGLE");
        } catch (IllegalArgumentException e) {
            ErrorLogger.getInstance().log(e.getMessage());
            //e.printStackTrace();
            rectangleButton.setText("RECTANGLE");
        }
        return rectangleButton;
    }

    private static JButton getSimpleRoundedRectangleButton() {
        JButton roundedRectangleButton = new JButton();
        roundedRectangleButton.setSize(new Dimension(30, 30));
        try {
            roundedRectangleButton.setIcon(new ImageIcon(ImageIO.read(ClassLoader.getSystemResource("roundrect.jpg"))));
        } catch (IOException e) {
            ErrorLogger.getInstance().log(e.getMessage());
            //e.printStackTrace();
            roundedRectangleButton.setText("ROUNDED RECTANGLE");
        }  catch (IllegalArgumentException e) {
            ErrorLogger.getInstance().log(e.getMessage());
            //e.printStackTrace();
            roundedRectangleButton.setText("ROUNDED RECTANGLE");
        }
        return roundedRectangleButton;
    }
}
