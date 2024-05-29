
package gameObjects;

import main.Game;
import main.Player;
import gameUI.UI;

import javax.swing.*;
import java.awt.*;

public class SuperGameObject {

    private String name;
    private int hp;
    private int gameObjectX;
    private int gameObjectY;
    private int width;
    private int height;
    protected JLabel gameObjectLabel;
    protected Player player;
    protected UI ui;
    protected Game game;

    public SuperGameObject(Game game, Player player, UI ui){
        this.game = game;
        this.player = player;
        this.ui = ui;

    }

    public boolean PlatformCollidesWithPlayer(Player player, int customPlayerX, int customPlayerY) {
        Rectangle gameObjectBounds = new Rectangle(gameObjectX, gameObjectY, width, height);
        Rectangle playerBounds = new Rectangle(customPlayerX, customPlayerY, player.getPLAYER_WIDTH_X(), player.getPLAYER_HEIGHT_Y());

        // Calculate the player's feet position (bottom Y-axis)
        int playerFeetY = playerBounds.y + playerBounds.height;

        // Calculate the platform's top surface (Y-axis)
        int platformTopY = gameObjectBounds.y;

        // Calculate the platform's bottom surface (Y-axis)
        int platformBottomY = gameObjectBounds.y + gameObjectBounds.height;

        // Check if the player's feet are above the platform and if they are intersecting on the X-axis
        boolean isIntersectingY = playerFeetY >= platformTopY && playerFeetY <= platformBottomY;

        // Check if the player's X-axis position is within the bounds of the platform
        boolean isIntersectingX = playerBounds.x + 30 >= gameObjectBounds.x && playerBounds.x <= gameObjectBounds.x + gameObjectBounds.width;

        // Check if both conditions are met for collision
        return isIntersectingY && isIntersectingX;
    }


    public boolean RopeCollidesWithPlayer(Player player) {


        Rectangle gameObjectBounds = new Rectangle(gameObjectX+(width/2), gameObjectY, width, height);
        Rectangle playerBounds = new Rectangle(player.getPlayerX()+(player.getPLAYER_WIDTH_X()/2), player.getPlayerY(), player.getPLAYER_WIDTH_X()/2, player.getPLAYER_HEIGHT_Y());


        // Check if the player's X-axis position intersects with the GameObject's bounds
        boolean isIntersectingX = playerBounds.intersects(gameObjectBounds) && player.isCheckIfOnRope();

        return isIntersectingX;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }


    public int getGameObjectX() {
        return gameObjectX;
    }

    public void setGameObjectX(int gameObjectX) {
        this.gameObjectX = gameObjectX;
    }

    public int getGameObjectY() {
        return gameObjectY;
    }

    public void setGameObjectY(int gameObjectY) {
        this.gameObjectY = gameObjectY;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public JLabel getGameObjectLabel() {
        return gameObjectLabel;
    }

    public void setGameObjectLabel(JLabel gameObjectLabel) {
        this.gameObjectLabel = gameObjectLabel;
    }


}
