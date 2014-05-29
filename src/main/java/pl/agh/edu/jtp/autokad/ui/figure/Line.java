package pl.agh.edu.jtp.autokad.ui.figure;

import java.awt.*;
import java.io.Serializable;

/**
 * Created by Paulina on 27.04.2014.
 */
public class Line implements Figure, Serializable {
    private final Color color;
    private final Point start;
    private final Point end;


    public Line(Color color, Point start, Point end) {
        this.color=color;
        this.start=start;
        this.end=end;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(color);
        g.drawLine(start.x, start.y, end.x, end.y);
    }
}
