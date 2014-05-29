package pl.agh.edu.jtp.autokad.ui.windows;

import pl.agh.edu.jtp.autokad.ui.drawingutils.DrawingController;
import pl.agh.edu.jtp.autokad.ui.figure.UserAwareFigureFactory;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/**
 * Created by Paulina on 26.04.2014.
 */
public class ColorChoiceWindow extends JDialog {

    private JColorChooser colorChooser;

    public ColorChoiceWindow(final DrawingController drawingController) {
        super();
        getContentPane().setLayout(new FlowLayout());

        colorChooser= new JColorChooser();

        Dimension frameDimension = new Dimension(colorChooser.getPreferredSize());
        frameDimension.setSize(frameDimension.getWidth(), frameDimension.getHeight());
        setSize(frameDimension);

        colorChooser.setPreviewPanel(new JPanel());
        colorChooser.getSelectionModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                setColor(drawingController);
            }
        });
        add(colorChooser, BorderLayout.CENTER);
    }

    public void setColor (DrawingController drawingController) {
        UserAwareFigureFactory.getInstance().setColor(colorChooser.getColor());
        drawingController.getDrawingStateBar().changeColor(colorChooser.getColor());
    }
}
