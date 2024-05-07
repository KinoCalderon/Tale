package gameNPC;

import main.Game;
import main.Player;
import gameUI.UI;
import gameEquipment.Weapon_Dagger;
import gameItems.Item_Orange;
import gameItems.Item_Potion;

import javax.swing.*;
import java.awt.*;

public class TavernShopKeeperObject extends SuperShopKeeperObject {

	private Item_Potion potion = new Item_Potion();
	private Weapon_Dagger dagger = new Weapon_Dagger();
	private Item_Orange orange = new Item_Orange();
	
	
	
	public TavernShopKeeperObject(Game game, Player player, UI ui) {
        super(game,player,ui);

        setShopKeeperName("tavernShop");

		AddItemToShop(0,potion);
		AddItemToShop(1,dagger);
		AddItemToShop(2,potion);
		AddItemToShop(3,potion);
		AddItemToShop(4,potion);

		setShopKeeperX(580);
		setShopKeeperY(340);
		setHeight(35);
		setWidth(25);

		shopKeeperButton = new JButton();
		shopKeeperButton.setSize(getWidth(),getHeight());
		shopKeeperButton.setLocation(getShopKeeperX(),getShopKeeperY());
		shopKeeperButton.setBackground(Color.pink);
		shopKeeperButton.setOpaque(true);
		shopKeeperButton.setVisible(true);
		shopKeeperButton.setFocusable(true);
		ui.mainGraphicsPane.add(shopKeeperButton, JLayeredPane.PALETTE_LAYER);
		
	}
	



}
