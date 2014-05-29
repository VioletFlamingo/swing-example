package pl.agh.edu.jtp.autokad.ui.windows;

import javax.swing.*;
import java.util.ResourceBundle;

/**
 * Created by Paulina on 07.05.2014.
 */
public class ComponentsText {
    public static void setText(ResourceBundle messages) {
        UIManager.put("FileChooser.openDialogTitleText", messages.getString("open"));
        UIManager.put("FileChooser.saveDialogTitleText", messages.getString("save"));
        UIManager.put("FileChooser.openButtonText", messages.getString("open"));
        UIManager.put("FileChooser.saveButtonText", messages.getString("save"));
        UIManager.put("FileChooser.cancelButtonText", messages.getString("cancel"));

        UIManager.put("ColorChooser.cancelText", messages.getString("cancel"));
        UIManager.put("ColorChooser.rgbBlueText", messages.getString("blue"));
        UIManager.put("ColorChooser.rgbGreenText", messages.getString("green"));
        UIManager.put("ColorChooser.rgbRedText", messages.getString("red"));
        UIManager.put("ColorChooser.swatchesNameText", messages.getString("swatches"));
        UIManager.put("ColorChooser.swatchesRecentText", messages.getString("recent"));
    }
}
