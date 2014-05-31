package pl.agh.edu.jtp.autokad.ui.windows;


import pl.agh.edu.jtp.autokad.ui.drawingutils.DrawingArea;
import pl.agh.edu.jtp.autokad.ui.drawingutils.DrawingAreaMouseListener;
import pl.agh.edu.jtp.autokad.ui.figure.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ResourceBundle;

/**
 * Created by Paulina on 24.04.2014.
 */
public class AutoKadWindow extends JFrame{

    private JToolBar toolBar;
    private final ResourceBundle messages;
    private DrawingArea comp;
    private final DefaultDrawingController drawingController;

    public AutoKadWindow(String title, ResourceBundle messages) {
        super(title);
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        this.messages = messages;

        comp = new DrawingArea();
        drawingController = new DefaultDrawingController(comp, messages);
        comp.addMouseListener(new DrawingAreaMouseListener(drawingController));
        add(comp, BorderLayout.CENTER);

        JMenuBar menuBar = createMenuBar();
        add(menuBar, BorderLayout.PAGE_START);

        JToolBar figureToolBar = createFigureToolbar();
        add(figureToolBar, BorderLayout.WEST);

        add(drawingController.getDrawingStateBar(), BorderLayout.SOUTH);

    }


    private JMenuBar createMenuBar() {
        final JMenuBar menuBar = new JMenuBar();
        menuBar.add(createFileMenu());
        menuBar.add(createEditMenu());
        return menuBar;
    }

    private Component createEditMenu() {
        final JMenu edit = new JMenu(messages.getString("edit"));
        edit.add(createColorMenuItem());
        edit.add(createUndoMenuItem());
        edit.add(loadToolBarFromFile());
        return edit;
    }

    private Component loadToolBarFromFile() {
        final JMenuItem load = new JMenuItem(messages.getString("loadtoolbar"));
        load.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                changeToNewToolBar();
            }
        });
        return load;
    }

    private void changeToNewToolBar() {
        toolBar.removeAll();
        ToolbarBuilder.getToolbar(toolBar);
        toolBar.revalidate();
        toolBar.repaint();
    }


    private Component createFileMenu() {
        final JMenu file = new JMenu(messages.getString("file"));
        file.add(createOpenMenuItem());
        file.add(createSaveMenuItem());
        return file;
    }

    private JToolBar createFigureToolbar () {
        toolBar = new JToolBar();
        addFigureToolBarButtons(toolBar);
        return toolBar;
    }

    private void addFigureToolBarButtons(JToolBar figureToolBar) {
        figureToolBar.setLayout(new BoxLayout(figureToolBar, BoxLayout.PAGE_AXIS));

        JButton rectangleButton = FigureButton.getRectangleButton(drawingController);
        figureToolBar.add(rectangleButton);

        JButton ovalButton = FigureButton.getOvalButton(drawingController);
        figureToolBar.add(ovalButton);

        JButton lineButton = FigureButton.getLineButton(drawingController);
        figureToolBar.add(lineButton);

        JButton roundedRectangleButton = FigureButton.getRoundedRectangleButton(drawingController);
        figureToolBar.add(roundedRectangleButton);

    }

    private JMenuItem createColorMenuItem() {
        final JMenuItem setColor = new JMenuItem(messages.getString("color"));
        setColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeColor();
            }
        });

        //ctrl+c changes color
        final KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK);

        setColor.setAccelerator(keyStroke);

        return setColor;
    }

    private void changeColor() {
        ColorChoiceWindow colorChoiceWindow = new ColorChoiceWindow(drawingController);
        colorChoiceWindow.setVisible(true);
    }


    private JMenuItem createOpenMenuItem() {
        final JMenuItem open = new JMenuItem(messages.getString("open"));
        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(comp);
                comp= FileManager.openFile(messages);
                drawingController.setDrawingArea(comp);
                comp.addMouseListener(new DrawingAreaMouseListener(drawingController));
                add(comp, BorderLayout.CENTER);
                comp.revalidate();
                comp.repaint();
                drawingController.updateNumberOfFigures();

            }
        });

        //ctrl+o opens picture
        final KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK);

        open.setAccelerator(keyStroke);

        return open;

    }



    private JMenuItem createSaveMenuItem() {
        final JMenuItem save = new JMenuItem(messages.getString("save"));
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileManager.saveFile(comp, messages);
            }
        });

        //ctrl+s saves picture
        final KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK);

        save.setAccelerator(keyStroke);

        return save;
    }

    private JMenuItem createUndoMenuItem() {
        final JMenuItem undo = new JMenuItem(messages.getString("undo"));
        undo.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawingController.undoLastCommand();
            }
        });

        //ctrl+Z removes last figure
        final KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_DOWN_MASK);

        undo.setAccelerator(keyStroke);

        return undo;
    }

}
