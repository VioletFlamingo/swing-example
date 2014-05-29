package pl.agh.edu.jtp.autokad.ui.windows;

import pl.agh.edu.jtp.autokad.Go;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

/**
 * Created by Paulina on 06.05.2014.
 */
public class LanguageChooser extends JFrame {
    JComboBox comboBox;

    public LanguageChooser (String title) {
        super(title);
        setSize(240, 75);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        getContentPane().setLayout(new BorderLayout());
        comboBox=createComboBox();
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (comboBox.getSelectedIndex()) {
                    case 0: Go.setLocale(new Locale("pl", "PL"));
                            closeWindow();
                            break;

                    case 1: Go.setLocale(new Locale("en", "US"));
                            closeWindow();
                            break;
                }
            }
        });
        this.add(comboBox);
    }


    private void closeWindow() {
        this.dispose();
    }

    private JComboBox createComboBox() {
        JComboBox box = new JComboBox();
        String pl_PL = "Polski (POLSKA)";
        String en_US = "English (USA)";
        box.addItem(pl_PL);
        box.addItem(en_US);
        return box;
    }
}
