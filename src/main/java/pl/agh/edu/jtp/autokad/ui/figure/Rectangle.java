package pl.agh.edu.jtp.autokad.ui.figure;

import java.awt.*;
import java.io.Serializable;

/**
 * Created by Paulina on 24.04.2014.
 */
public class Rectangle implements Figure, Serializable {

    private final Color color;
    private final Point corner;
    private final Dimension dimension;

    public Rectangle(Color color, Point start, Point stop) {
        this.color=color;
        this.corner = new Point(Math.min(start.x, stop.x), Math.min(start.y, stop.y));
        this.dimension = new Dimension(Math.abs(start.x-stop.x), Math.abs(start.y-stop.y));
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillRect(corner.x, corner.y, dimension.width, dimension.height);
    }
}
