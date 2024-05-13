package gameObjects;

import gameUI.UI;
import main.Game;
import main.Player;

import javax.swing.*;
import java.awt.*;

public class RopeObject extends SuperGameObject{
    public RopeObject(Game game, Player player, UI ui, int x, int y, int width, int height) {
        super(game, player, ui);

        setName("Rope");
        setHp(10);
        setGameObjectX(x);
        setGameObjectY(y);
        setHeight(height);
        setWidth(width);

        gameObjectLabel = new JLabel();
        gameObjectLabel.setLocation(getGameObjectX(),getGameObjectY());
        gameObjectLabel.setSize(getWidth(),getHeight());
        //gameObjectLabel.setIcon();
        gameObjectLabel.setVisible(true);
        gameObjectLabel.setBackground(Color.lightGray);
        gameObjectLabel.setOpaque(true);
        ui.mainGraphicsPane.add(gameObjectLabel, JLayeredPane.MODAL_LAYER);


    }
}
