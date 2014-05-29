package pl.agh.edu.jtp.autokad.ui.drawingutils;

import pl.agh.edu.jtp.autokad.ui.drawingutils.DrawingArea;
import pl.agh.edu.jtp.autokad.ui.windows.StateBar;

import java.awt.*;

/**
 * Created by Paulina on 24.04.2014.
 */
public interface DrawingController {

    void draw (Point start, Point end);

    void undoLastCommand();

    void setFigure(Class figureClass);

    StateBar getDrawingStateBar();

    void setDrawingArea(DrawingArea comp);

    void updateNumberOfFigures();

    void drawDraggedFigure(Point start, Point current);
}
