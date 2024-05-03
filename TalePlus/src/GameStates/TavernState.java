package GameStates;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import npc.TavernShopKeeper;
import package01.*;
import package04.SuperConsumable;
import package04.SuperItem;


public class TavernState extends GameState implements ActionListener{
	
	private final TavernShopKeeper tavernShopKeeper = new TavernShopKeeper();

	
	//private JButton shopButton1, shopButton2;
	//private JButton shopKeeperButton1, shopKeeperButton2;

	public TavernState(Game game, Player player, UI ui, InventoryUI invoUI) {
		super(game, player, ui, invoUI);
		setName("TavernState");
		ui.buyItemButton.addActionListener(this);
	

		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println(player.getCurrentState());
		player.setShopStatus("open");
		
		System.out.println("Player shop status* "+ player.getShopStatus());
		System.out.println(getGameStateStack() + " GAME STATE STACK INSIDE TAVERN STATE");
				
		//inventoryManager.GivePlayerItem(player, player.potion);
		
		
		
	}

	@Override
	public void ui() {
		//UPDATE THE PLAYERS LOCATION IN THE GAME OUTPUT AREA
		ui.updateGameTextOutputArea("Welcome to " + player.getCurrentState().getName());
		ui.shopKeeperPanel.setVisible(true);
		invoUI.inventoryPanel.setVisible(true);
		invoUI.inventoryButton1.setText(player.inventoryItems[0].getName());
		invoUI.inventoryButton2.setText(player.inventoryItems[1].getName());
		invoUI.inventoryButton3.setText(player.inventoryItems[2].getName());
		invoUI.inventoryButton4.setText(player.inventoryItems[3].getName());
		invoUI.inventoryButton5.setText(player.inventoryItems[4].getName());
		
		ui.button4.setVisible(true);
		ui.button4.setText("Exit");
		ui.button4.setActionCommand("closeTavern");
		ui.button4.removeActionListener(this);
		ui.button4.addActionListener(this);
		ui.button1.setVisible(false);
		//ui.button4.addActionListener(e -> {goBackToPreviousState(); ui.CloseItemUi();});
		
		
		ui.shopButtons[0].setText("Item1:" + tavernShopKeeper.getShopItems(0).getName());
		ui.shopButtons[0].addActionListener(this);
		
		ui.shopButtons[1].setText("Item2:" + tavernShopKeeper.getShopItems(1).getName());
		ui.shopButtons[1].addActionListener(this);
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
		case "button0": 
			ui.CloseItemUi();
			
			//ui.sellMessagePanel.setVisible(false);
			System.out.println("shop button 1 pressed");
			if(tavernShopKeeper.getShopItems(0).getName().isEmpty()) {
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
			ui.buyItemButton.setVisible(true);
			ui.closeItemButton.setVisible(true);
			ui.equipmentDamageOrArmorValue.setVisible(false);
			invoUI.CloseInventoryUI();
			ui.RemoveOutputTextPanelAddInfoPanel();
			
	        player.setPlayerItemIndex(0);  
	        System.out.println(player.getPlayerItemIndex());

			}	
					else if (tavernShopKeeper.getShopItems(0).getType().equals("Equipment")) {
					SuperItem superItem = tavernShopKeeper.getShopItems(0);
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
					ui.buyItemButton.setActionCommand("buyItem");
					ui.buyItemButton.setVisible(true);
					ui.closeItemButton.setVisible(true);
					ui.itemHealingValue.setVisible(false);
					invoUI.CloseInventoryUI();
					ui.RemoveOutputTextPanelAddInfoPanel();
					
					player.setPlayerItemIndex(0);  
				    player.setPlayerEquipmentIndex(superItem.getItemIndex());
					System.out.println(player.getPlayerItemIndex());
				
			}
			break;
			
		case "button1": 
			ui.CloseItemUi();
			
			//ui.sellMessagePanel.setVisible(false);
			System.out.println("shop button 1 pressed");
			if(tavernShopKeeper.getShopItems(1).getName().isEmpty()) {
				System.out.println("no item here sorry");
			}
			
			else if(tavernShopKeeper.getShopItems(1).getType().equals("Consumable")) {
			SuperConsumable consumableItem = (SuperConsumable) tavernShopKeeper.getShopItems(1);
			ui.itemLabel.setText("Item: " + consumableItem.getName());
			ui.itemPriceLabel.setText("Price: " + consumableItem.getPrice());
			ui.itemHealingValue.setText("Heals: " + consumableItem.getHealingValue());
			ui.itemHealingValue.setVisible(true);
			ui.itemPriceLabel.setVisible(true);
			ui.itemLabel.setVisible(true);
			ui.buyItemButton.setText("Buy:");
			ui.buyItemButton.setActionCommand("buyItem");
			ui.buyItemButton.setVisible(true);
			ui.closeItemButton.setVisible(true);
			ui.equipmentDamageOrArmorValue.setVisible(false);
			invoUI.CloseInventoryUI();
			ui.RemoveOutputTextPanelAddInfoPanel();
			
	        player.setPlayerItemIndex(1);  
	        System.out.println("player item index" + player.getPlayerItemIndex());

			}	
					else if (tavernShopKeeper.getShopItems(1).getType().equals("Equipment")) {
					SuperItem superItem = tavernShopKeeper.getShopItems(1);
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
					ui.buyItemButton.setActionCommand("buyItem");
					ui.buyItemButton.setVisible(true);
					ui.closeItemButton.setVisible(true);
					ui.itemHealingValue.setVisible(false);
					invoUI.CloseInventoryUI();
					ui.RemoveOutputTextPanelAddInfoPanel();
					
					
					player.setPlayerItemIndex(1);  
				    player.setPlayerEquipmentIndex(superItem.getItemIndex());
					System.out.println("player item index" + player.getPlayerItemIndex());
				
			}
			break;
			
		case "buyItem":

			System.out.println("check");
			for(int i = 0; i < player.inventoryItems.length; i++) {
			System.out.println(player.inventoryItems[i].getName());
			}
			InventoryManager inventoryManager = new InventoryManager();
			//check if player inventory is full
			
			if(inventoryManager.SellPlayerItem(player, tavernShopKeeper.getShopItems(player.getPlayerItemIndex()))) {
				System.out.println("attempting to sell player item..");

			ui.goldLabel.setText(" Gold: " + player.getGold());
			System.out.println("-" + tavernShopKeeper.getShopItems(player.getPlayerItemIndex()).getPrice() + "gold");
			System.out.println(player.getGold());


				invoUI.inventoryButton1.setText(player.inventoryItems[0].getName());
				invoUI.inventoryButton2.setText(player.inventoryItems[1].getName());
				invoUI.inventoryButton3.setText(player.inventoryItems[2].getName());
				invoUI.inventoryButton4.setText(player.inventoryItems[3].getName());
				invoUI.inventoryButton5.setText(player.inventoryItems[4].getName());
				ui.RemoveInfoPanelAddOutputTextPanel();
				ui.updateGameTextOutputArea("Item bought " + tavernShopKeeper.getShopItems(player.getPlayerItemIndex()).getName()
						+ " -" + tavernShopKeeper.getShopItems(player.getPlayerItemIndex()).getPrice() + "Gold.");

			} else {			
					ui.RemoveInfoPanelAddOutputTextPanel();
					ui.updateGameTextOutputArea("Can't buy item");
			System.out.println("out of gold or invo full*");
				
			}{System.out.println("end of buyItem case check");
			
			System.out.println("player item index" + player.getPlayerItemIndex());
			
			}
			
			break;
			
		case "closeItem":
			
			ui.CloseItemUi();
			invoUI.CloseInventoryUI();
			
			break;
			
			
		case "closeTavern":
			
			goBackToPreviousState(player);
			ui.button1.setVisible(true);
			player.setShopStatus("close");
			ui.button4.removeActionListener(this);
			
			
			break;
			
		case "":
			System.out.println("already in tavern");
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + yourChoice);
		}
		
	}

}
