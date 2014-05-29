package pl.agh.edu.jtp.autokad.ui.command;

import pl.agh.edu.jtp.autokad.ui.drawingutils.DrawingArea;
import pl.agh.edu.jtp.autokad.ui.figure.Figure;

/**
 * Created by Paulina on 24.04.2014.
 */
public class PaintCommand implements Command {

    private Figure figure;

    public PaintCommand(Figure figure) {
        this.figure=figure;
    }

    @Override
    public void execute(DrawingArea area) {
        area.addFigure(figure);
    }

    @Override
    public void undo(DrawingArea area) {
        area.removeFigure(figure);
    }
}
