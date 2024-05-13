package gameObjects;

import main.Game;
import main.Player;
import gameUI.UI;


import javax.swing.*;
import java.awt.*;

public class PlatformObject extends SuperGameObject {
    ImageIcon platformImage = new ImageIcon(".//media//platformImage.png");


    public PlatformObject(Game game, Player player, UI ui, int x, int y, int width, int height) {
        super(game, player, ui);

        setName("Platform"); // Change the name if needed
        setHp(10); // Set the health points if applicable
        setGameObjectX(x); // Set the x-coordinate
        setGameObjectY(y); // Set the y-coordinate
        setHeight(height); // Set the height
        setWidth(width); // Set the width

        gameObjectLabel = new JLabel();
        gameObjectLabel.setLocation(getGameObjectX(), getGameObjectY());
        gameObjectLabel.setSize(getWidth(), getHeight());
        gameObjectLabel.setBackground(Color.blue); // Set the color as needed
        gameObjectLabel.setIcon(platformImage);
        gameObjectLabel.setVisible(true);
        ui.mainGraphicsPane.add(gameObjectLabel, JLayeredPane.PALETTE_LAYER);
    }
}
