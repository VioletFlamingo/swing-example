package pl.agh.edu.jtp.autokad.ui.command;

import pl.agh.edu.jtp.autokad.ui.drawingutils.DrawingArea;

/**
 * Created by Paulina on 24.04.2014.
 */
public interface Command {

    void execute(DrawingArea area);

    void undo(DrawingArea area);
}
