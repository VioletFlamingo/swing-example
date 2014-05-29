package pl.agh.edu.jtp.autokad.ui.drawingutils;

import pl.agh.edu.jtp.autokad.ui.info.InfoLogger;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Paulina on 24.04.2014.
 */
public class DrawingAreaMouseListener extends MouseAdapter {

    private static final Logger LOGGER = Logger.getLogger(DrawingAreaMouseListener.class.getName());
    private final DrawingController controller;
    private Point start;

    public DrawingAreaMouseListener(DrawingController drawingArea) {
        this.controller = drawingArea;
    }
    @Override
    public void mousePressed(MouseEvent e) {
        InfoLogger.getInstance().log(Level.INFO + "Presses {0}" + e.getPoint());
        start=e.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        InfoLogger.getInstance().log(Level.INFO + "Released {0}" + e.getPoint());
        controller.draw(start, e.getPoint());
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        controller.drawDraggedFigure(start, e.getPoint());
    }

}
