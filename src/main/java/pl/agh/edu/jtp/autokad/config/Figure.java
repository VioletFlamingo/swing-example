package pl.agh.edu.jtp.autokad.config;

import java.nio.file.Path;

/**
 * Created by Paulina on 23.05.2014.
 */
public class Figure {
    private final String name;
    private final String figureClass;
    private final String iconPath;
    private final String hint;

    public Figure(String name, String figureClass, String iconPath, String hint) {
        this.name=name;
        this.figureClass=figureClass;
        this.iconPath=iconPath;
        this.hint=hint;
    }

    public String getName() {
        return name;
    }

    public String getFigureClass() {
        return figureClass;
    }

    public String getIconPath() {
        return iconPath;
    }

    public String getHint() {
        return hint;
    }
}
