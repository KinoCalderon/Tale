package GameStates;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import npc.TavernShopKeeper;
import package01.Game;
import package01.InventoryHandler;
import package01.InventoryManager;
import package01.Player;
import package01.UI;
import package04.SuperConsumable;
import package04.SuperItem;


public class TavernState extends GameState implements ActionListener{
	
	private TavernShopKeeper tavernShopKeeper = new TavernShopKeeper();

	
	//private JButton shopButton1, shopButton2;
	//private JButton shopKeeperButton1, shopKeeperButton2;

	public TavernState(Game game, Player player, UI ui, InventoryHandler iHandler) {
		super(game, player, ui, iHandler);
	

		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		player.setCurrentState(this);
		System.out.println(player.getCurrentState());
		player.setShopStatus("open");
		
		System.out.println(player.getShopStatus());
		
		

		
		//inventoryManager.GivePlayerItem(player, player.potion);
		
		
		
	}

	@Override
	public void ui() {
		// TODO Auto-generated method stub

		ui.shopKeeperPanel.setVisible(true);
		iHandler.inventoryPanel.setVisible(true);
		iHandler.inventoryButton1.setText(player.inventoryItems[0].getName());
		iHandler.inventoryButton2.setText(player.inventoryItems[1].getName());
		iHandler.inventoryButton3.setText(player.inventoryItems[2].getName());
		iHandler.inventoryButton4.setText(player.inventoryItems[3].getName());
		iHandler.inventoryButton5.setText(player.inventoryItems[4].getName());
		
		ui.button4.setText("Exit");
		ui.button4.addActionListener(e -> {pushStateAndSetCurrent(game.townState);});
		
		ui.shopButtons[0].setText("Item1:" + tavernShopKeeper.getShopItems(0).getName());
		ui.shopButtons[0].addActionListener(this);
		ui.closeItemButton.addActionListener(this);
		

		
		
	}

	@Override
	void sound() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String yourChoice = e.getActionCommand();
		
		switch (yourChoice) {
		case "button1": 
			System.out.println("shop button 1 pressed");
			if(tavernShopKeeper.getShopItems(0).getName().equals("")) {	
				System.out.println("no item here sorry");
			}
			
			else if(tavernShopKeeper.getShopItems(0).getType().equals("Consumable")) {
			SuperConsumable consumableItem = (SuperConsumable) tavernShopKeeper.getShopItems(0);
			ui.itemLabel.setText("Item: " + consumableItem.getName());
			ui.itemPriceLabel.setText("Price: " + consumableItem.getPrice());
			ui.itemHealingValue.setText("Heals: " + consumableItem.getHealingValue());
			ui.itemHealingValue.setVisible(true);
			ui.itemPriceLabel.setVisible(true);
			ui.itemLabel.setVisible(true);
			ui.buyItemButton.setText("Buy:");
			ui.buyItemButton.setActionCommand("buyItem");
			ui.buyItemButton.addActionListener(this);
			ui.buyItemButton.setVisible(true);
			ui.closeItemButton.setVisible(true);
	        player.setPlayerItemIndex(0);  
	        System.out.println(player.getPlayerItemIndex());

			}	
					else if (tavernShopKeeper.getShopItems(0).getType().equals("Equipment")) {
					SuperItem superItem = (SuperItem) tavernShopKeeper.getShopItems(0);
					ui.itemLabel.setText("Item: " + superItem.getName());
					ui.itemPriceLabel.setText("Price: " + superItem.getPrice());
					if(superItem.getItemIndex() == 0) {
						ui.equipmentDamageOrArmorValue.setText("Damage: " + superItem.getDamageValue());
					} else if(superItem.getItemIndex() == 1) {
						ui.equipmentDamageOrArmorValue.setText("Armor: " + superItem.getArmorValue());
						
					}
					ui.itemPriceLabel.setVisible(true);
					ui.itemLabel.setVisible(true);
					ui.equipmentDamageOrArmorValue.setVisible(true);
					ui.buyItemButton.setText("Buy:");
					ui.buyItemButton.addActionListener(this);
					ui.buyItemButton.setActionCommand("buyItem");
					ui.buyItemButton.setVisible(true);
					ui.closeItemButton.setVisible(true);
					player.setPlayerItemIndex(0);  
				    player.setPlayerEquipmentIndex(superItem.getItemIndex());
					System.out.println(player.getPlayerItemIndex());
				
			}
			break;
			
		case "buyItem":
			System.out.println("check");
			InventoryManager inventoryManager = new InventoryManager();
			//check if player inventory is full
			if(!player.isInventoryFull()) {
			inventoryManager.SellPlayerItem(player, tavernShopKeeper.getShopItems(0));
			
			ui.goldLabel.setText(" Gold: " + player.getGold());
			System.out.println("-" + tavernShopKeeper.getShopItems(0).getPrice() + "gold");
			System.out.println(player.getGold());
			
			ui.infoPanel.setVisible(false);
			ui.sellMessagePanel.setVisible(true);
			
		   	iHandler.inventoryButton1.setText(player.inventoryItems[0].getName());
		   	iHandler.inventoryButton2.setText(player.inventoryItems[1].getName());
		   	iHandler.inventoryButton3.setText(player.inventoryItems[2].getName());
		   	iHandler.inventoryButton4.setText(player.inventoryItems[3].getName());
		   	iHandler.inventoryButton5.setText(player.inventoryItems[4].getName());
		   	
		   	ui.closeSellItemMessage.addActionListener(this);
		   	ui.sellMessagePanel.setVisible(true);
		   	ui.soldItemMessage.setText(tavernShopKeeper.sellMessage(tavernShopKeeper.getShopItems(0)));
			} else {System.out.println("inventory full");
			
			}
			
			break;
			
	       case "closeItem":
	    	   
	    	   ui.infoPanel.setVisible(true);
	    	   ui.itemHealingValue.setVisible(false);
	    	   ui.itemPriceLabel.setVisible(false);
	    	   ui.itemLabel.setVisible(false); // Hide item label after using the item
	    	   ui.equipmentDamageOrArmorValue.setVisible(false);
	    	   ui.buyItemButton.setVisible(false); // Hide useItemButton after using the item
	    	   ui.closeItemButton.setVisible(false);
	    	   ui.sellMessagePanel.setVisible(false);
	           player.setPlayerItemIndex(-1);
	           System.out.println(player.getPlayerItemIndex());
	    	   break;
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + yourChoice);
		}
		
	}

}
