package gameNPC;

import main.Game;
import main.Player;
import gameUI.UI;
import gameItems.SuperItem;

import javax.swing.*;

public class SuperShopKeeperObject {
    private SuperItem[] shopItems = new SuperItem[5];
    private int shopKeeperX;
    private int shopKeeperY;
    private int width;
    private int height;
    public JButton shopKeeperButton;
    private String shopKeeperName;

    protected Player player;
    protected UI ui;
    protected Game game;

    public SuperShopKeeperObject(Game game, Player player, UI ui) {
        this.game = game;
        this.player = player;
        this.ui = ui;
    }



    public void AddItemToShop(int index, SuperItem item) {
        if (index >= 0 && index < shopItems.length) {
            shopItems[index] = item;
        } else {
            // Handle index out of bounds error
            System.out.println("Index out of bounds");
        }
    }

    public String SellMessage(SuperItem item) {
        String string = "Item Bought: " + item.getName() + " -" + item.getPrice() + "gold";
        return string;
    }

    public SuperItem getShopItems(int i) {
        return shopItems[i];
    }

    public void setShopItems(SuperItem[] shopItems) {
        this.shopItems = shopItems;
    }

    public int getShopKeeperX() {
        return shopKeeperX;
    }

    public void setShopKeeperX(int shopKeeperX) {
        this.shopKeeperX = shopKeeperX;
    }

    public int getShopKeeperY() {
        return shopKeeperY;
    }

    public void setShopKeeperY(int shopKeeperY) {
        this.shopKeeperY = shopKeeperY;
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

    public String getShopKeeperName() {
        return shopKeeperName;
    }

    public void setShopKeeperName(String shopKeeperName) {
        this.shopKeeperName = shopKeeperName;
    }
}
