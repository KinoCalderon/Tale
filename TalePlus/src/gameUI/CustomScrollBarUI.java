package gameUI;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class CustomScrollBarUI extends BasicScrollBarUI {

    // Customize scrollbar color
    @Override
    protected void configureScrollBarColors() {
        thumbColor = Color.gray;
        trackColor = Color.darkGray;
    }

    // Customize scrollbar size
    @Override
    protected Dimension getMinimumThumbSize() {
        return new Dimension(10, 10);
    }

    // Customize scrollbar button size
    @Override
    protected JButton createDecreaseButton(int orientation) {
        return createZeroButton();
    }

    @Override
    protected JButton createIncreaseButton(int orientation) {
        return createZeroButton();
    }

    // Create button with zero size (to remove the buttons)
    private JButton createZeroButton() {
        JButton button = new JButton();
        button.setPreferredSize(new Dimension(0, 0));
        button.setMinimumSize(new Dimension(0, 0));
        button.setMaximumSize(new Dimension(0, 0));
        return button;
    }
}
