package pl.agh.edu.jtp.autokad.ui.figure;

import java.awt.*;
import java.io.Serializable;

/**
 * Created by Paulina on 27.04.2014.
 */
public class Oval implements Figure, Serializable {

    private final Color color;
    private final Point start;
    private final Dimension dimension;


    public Oval(Color color, Point start, Point stop) {
        this.color=color;
        this.start = new Point(Math.min(start.x, stop.x), Math.min(start.y, stop.y));
        this.dimension = new Dimension(Math.abs(start.x-stop.x), Math.abs(start.y-stop.y));
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillOval(start.x, start.y, dimension.width, dimension.height);
    }
}
