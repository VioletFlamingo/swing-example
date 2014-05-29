package pl.agh.edu.jtp.autokad.ui.drawingutils;

import pl.agh.edu.jtp.autokad.ui.figure.Figure;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Paulina on 24.04.2014.
 */
public class DrawingArea extends JPanel implements Externalizable{

    private Collection<Figure> figures = new ArrayList<Figure>();

    public DrawingArea() {
        super();
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Figure figure : figures) {
            figure.paint(g);
        }
    }

    public void addFigure(Figure figure) {
        figures.add(figure);
        repaint();
    }

    public void removeFigure(Figure figure) {
        figures.remove(figure);
        repaint();
    }

    public int getNumberOfFigures() {
        return figures.size();
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        int size = figures.size();
        out.writeInt(size);
        for(Figure f : figures){
            out.writeObject(f);
        }
        figures.removeAll(figures);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        int size = in.readInt();
        for(int i = 0; i < size; i++) {
            addFigure((Figure) in.readObject());
        }
    }
}
