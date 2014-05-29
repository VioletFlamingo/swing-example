package pl.agh.edu.jtp.autokad.ui.figure;

import pl.agh.edu.jtp.autokad.ui.command.Command;
import pl.agh.edu.jtp.autokad.ui.command.PaintCommand;
import pl.agh.edu.jtp.autokad.ui.drawingutils.DrawingArea;
import pl.agh.edu.jtp.autokad.ui.drawingutils.DrawingController;
import pl.agh.edu.jtp.autokad.ui.windows.StateBar;

import java.awt.*;
import java.util.*;

/**
 * Created by Paulina on 24.04.2014.
 */
public class DefaultDrawingController implements DrawingController {

    private FigureFactory figureFactory;

    private DrawingArea drawingArea;
    private final Deque<Command> commands = new LinkedList<Command>();

    private Figure currentlyDrawn;

    ResourceBundle messages;

    private StateBar stateBar;

    public DefaultDrawingController(DrawingArea drawingArea, ResourceBundle messages) {
        this.messages=messages;
        stateBar = new StateBar(Line.class, Color.MAGENTA, messages);
        this.drawingArea= drawingArea;
        figureFactory = UserAwareFigureFactory.getInstance();
    }

    @Override
    public void draw (Point start, Point end) {
        currentlyDrawn=null;
        final Figure figure = figureFactory.createFigure(start, end);
        final PaintCommand paintCommand = new PaintCommand(figure);
        paintCommand.execute(drawingArea);
        commands.addLast(paintCommand);
        updateNumberOfFigures();

        if(currentlyDrawn != null) {
            drawingArea.removeFigure(currentlyDrawn);
            currentlyDrawn = null;
        }
    }

    @Override
    public void undoLastCommand() {
        if (!commands.isEmpty()) {
            final Command command = commands.removeLast();
            command.undo(drawingArea);
            updateNumberOfFigures();
        }

    }

    @Override
    public void setFigure(Class figureClass) {
        figureFactory.setFigure(figureClass);
        stateBar.changeFigure(figureClass);
    }

    public StateBar getDrawingStateBar () {
        return stateBar;
    }

    @Override
    public void setDrawingArea(DrawingArea comp) {
        this.drawingArea=comp;
    }

    @Override
    public void updateNumberOfFigures() {
        stateBar.changeNumberOfFigures(drawingArea.getNumberOfFigures());
    }

    @Override
    public void drawDraggedFigure(Point start, Point current) {
        Figure figure = figureFactory.createFigure(start, current);
        if(currentlyDrawn != null) {
            drawingArea.removeFigure(currentlyDrawn);
        }
        currentlyDrawn = figure;
        drawingArea.addFigure(figure);
        drawingArea.repaint();
        drawingArea.validate();
    }
}
