package package03;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import GameStates.GameState;
import package01.*;
import package02.InventoryUI;
import package02.UI;
import package05.SuperConsumable;
import package05.SuperItem;

public class InventoryHandler implements ActionListener, MouseListener {
	public Player player;
	public InventoryUI invoUI;
	public UI ui;
	public Game game;
	InventoryManager inventoryManager = new InventoryManager();



	
	public InventoryHandler(Player player, UI ui, Game game, InventoryUI invoUI) {
	this.player = player;
	this.ui = ui;
	this.game = game;
	this.invoUI = invoUI;

	invoUI.inventoryButton.addActionListener(this);
	invoUI.inventoryButtons[0].addActionListener(this);
	invoUI.inventoryButtons[1].addActionListener(this);
	invoUI.inventoryButtons[2].addActionListener(this);
	invoUI.inventoryButtons[3].addActionListener(this);
	invoUI.inventoryButtons[4].addActionListener(this);
	invoUI.inventoryButtons[4].addMouseListener(this);
	invoUI.useItemButton.addActionListener(this);
	invoUI.closeItemButton.addActionListener(this);
	invoUI.equipmentButtons[0].addActionListener(this);
	invoUI.equipmentButtons[1].addActionListener(this);
	ui.button4.addActionListener(this);

	}

	public void getInventoryItemType(int index){
		if(player.inventoryItems[index].getName().isEmpty()) {
			System.out.println("no item here sorry");
		}

		else if(player.inventoryItems[index].getType().equals("Consumable")) {
			SuperConsumable consumableItem = (SuperConsumable) player.inventoryItems[index];
			invoUI.itemLabel.setText("Item:" + consumableItem.getName());
			invoUI.itemPriceLabel.setText("Price:" + consumableItem.getPrice());
			invoUI.itemHealingValue.setText("Heals:" + consumableItem.getHealingValue());
			invoUI.itemHealingValue.setVisible(true);
			invoUI.itemPriceLabel.setVisible(true);
			invoUI.itemLabel.setVisible(true);
			invoUI.equipmentDamageOrArmorValue.setVisible(false);
			ui.RemoveOutputTextPanelAddInfoPanel();
			ui.CloseItemUi();

			if(player.getShopStatus().equals("open")) {
				invoUI.useItemButton.setText("Sell");
				invoUI.useItemButton.setActionCommand("sellItem");
			}else if(player.getShopStatus().equals("close")) {
				invoUI.useItemButton.setText("Use:");
				invoUI.useItemButton.setActionCommand("useItem");
			}

			invoUI.useItemButton.setVisible(true);
			invoUI.closeItemButton.setVisible(true);
			player.setPlayerItemIndex(index);
			System.out.println("Player selected inventory index: " + player.getPlayerItemIndex());

		}
		else if (player.inventoryItems[index].getType().equals("Equipment")) {
			SuperItem superItem = player.inventoryItems[index];
			invoUI.itemLabel.setText("Item:" + superItem.getName());
			invoUI.itemPriceLabel.setText("Price:" + superItem.getPrice());
			if(superItem.getItemIndex() == index) {
				invoUI.equipmentDamageOrArmorValue.setText("Damage:" + superItem.getDamageValue());
			} else if(superItem.getItemIndex() == 1) {
				invoUI.equipmentDamageOrArmorValue.setText("Armor:" + superItem.getArmorValue());

			}
			invoUI.itemPriceLabel.setVisible(true);
			invoUI.itemLabel.setVisible(true);
			invoUI.equipmentDamageOrArmorValue.setVisible(true);
			invoUI.itemHealingValue.setVisible(false);
			ui.RemoveOutputTextPanelAddInfoPanel();
			ui.CloseItemUi();

			if(player.getShopStatus().equals("open")) {
				invoUI.useItemButton.setText("Sell");
				invoUI.useItemButton.setActionCommand("sellItem");
			}else if(player.getShopStatus().equals("close")) {
				invoUI.useItemButton.setText("Equip:");
				invoUI.useItemButton.setActionCommand("equipItem");
			}
			invoUI.useItemButton.setVisible(true);
			invoUI.closeItemButton.setVisible(true);
			player.setPlayerItemIndex(index);
			player.setPlayerEquipmentIndex(superItem.getItemIndex());

			System.out.println("Player selected inventory index: " + player.getPlayerItemIndex());
			System.out.println("Selected item equipment index: " + player.getPlayerEquipmentIndex());

		}

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String yourChoice = e.getActionCommand();
		
		switch(yourChoice) {
		case "inventoryButton":
		    System.out.println("attempting to access inventory*");
		    System.out.println(player.getInventoryStatus() + "*" + player.getShopStatus());
		    if (player.getInventoryStatus().equals("close") && player.getShopStatus().equals("close")) {
		        // Disable the inventory button to prevent multiple clicks
				invoUI.inventoryButton.setEnabled(false);

		        // Perform the action associated with the button
				invoUI.inventoryButton.addActionListener(null);
				invoUI.inventoryButton.setActionCommand("i");
		        System.out.println("made it into inventory*");
		        GameState.pushStateAndSetCurrent(game.playerInventoryState, player);

				invoUI.inventoryPanel.setVisible(true);
				invoUI.equipmentPanel.setVisible(true);
				invoUI.equipmentStatsPanel.setVisible(true);
				invoUI.refreshInventoryButtons();

		        player.setInventoryStatus("open");
		        //System.out.println(GameState.getGameStateStack() + " GAME STATE STACK IN SWITCH CASEI HANDLER*");

		        // Re-enable the inventory button after the action is completed
				invoUI.inventoryButton.setEnabled(true);
		    } else if (player.getInventoryStatus().equals("open")) {
		        System.out.println("inventory already open*");
		    }
		    break;

			
		case "exitInventory":
			System.out.println("exiting inventory");
			invoUI.inventoryButton.setActionCommand("inventoryButton");
			invoUI.CloseInventoryUIAbsolute();
	        
			ui.buttonPanel.setVisible(true);
			player.setInventoryStatus("close");
			ui.button4.setVisible(false);
			
			
			GameState.goBackToPreviousState(player);
			System.out.println("Exited inventory case*");
			
			break;
			
		case "item1":
			player.setPlayerInventoryIndex(0);
			getInventoryItemType(0);

			break;
			
		case "item2":
			player.setPlayerInventoryIndex(1);
			getInventoryItemType(1);
			break;
			
		case "item3":
			player.setPlayerInventoryIndex(2);
			getInventoryItemType(2);
			break;
			
		case "item4":
			player.setPlayerInventoryIndex(3);
			getInventoryItemType(3);
			
			break;
			
		case "item5":
			player.setPlayerInventoryIndex(4);
			getInventoryItemType(4);
			break;
			
		case "sellItem":
			System.out.println("Attemping to sell item to shop...");
			ui.updateGameTextOutputArea("Sold a "+ player.inventoryItems[player.getPlayerInventoryIndex()].getName() + " for " + player.inventoryItems[player.getPlayerInventoryIndex()].getPrice() + "Gold.");

			if(inventoryManager.SellItemToShop(player, player.inventoryItems[player.getPlayerInventoryIndex()])) {

				System.out.println("Sold item from inventory index: " + player.getPlayerInventoryIndex());
				ui.goldLabel.setText(" Gold: " + player.getGold());
				System.out.println("Player gold: " + player.getGold());
			
			ui.infoPanel.setVisible(false);
			invoUI.refreshInventoryButtons(); //always refresh inventory items after updating the players inventory
		   	ui.RemoveInfoPanelAddOutputTextPanel();
			}
			else {
					ui.infoPanel.setVisible(false);
					ui.sellMessagePanel.setVisible(true);
					ui.sellMessagePanel.setVisible(true);
					ui.soldItemMessage.setText(inventoryManager.OutOfGoldMessage());
			System.out.println("didnt sell item to shop");
				
			}
			
			break;

			case "useItem":
				// Print a message to check if the "useItem" case is being triggered
				System.out.println("Attempting to use item...");
				// Check if index is valid
				if (player.getPlayerItemIndex() != -1) {// Call itemUsed only if index is valid
					if (player.inventoryItems[player.getPlayerItemIndex()] instanceof SuperConsumable consumableItem && consumableItem.getHealingValue() > 0){

						ui.updateGameTextOutputArea("Player used: " + consumableItem.getName() + " +"
													+ consumableItem.getHealingValue() + consumableItem.getConsumableType());
						ui.RemoveInfoPanelAddOutputTextPanel();
					}
					else if (player.inventoryItems[player.getPlayerItemIndex()] instanceof SuperConsumable consumableItem && consumableItem.getHealingValue() < 0) {

						ui.updateGameTextOutputArea("Player used: " + consumableItem.getName() +" "
													+ consumableItem.getHealingValue() + consumableItem.getConsumableType());
						ui.RemoveInfoPanelAddOutputTextPanel();
					}
					System.out.println("Player used item from inventory index: " + player.getPlayerItemIndex()); // Print index for debugging
					inventoryManager.itemUsed(player.getPlayerItemIndex(),player);// Use the item at this index
					invoUI.CloseInventoryUI(); // Hide closeItemButton after using the item

				}
				else {
					System.out.println("No item selected."); // Print a message if no item is selected
				}

				ui.hpLabel.setText(" HP: " + player.getCurrentHp() + "/" + player.getMaxHp());
				invoUI.refreshInventoryButtons();//always refresh inventory buttons after updating inventory
				player.setPlayerItemIndex(-1);

				break;
            
        case "equipItem":
        	//debug equip
        	System.out.println("Attempting to equip item...");
        	//check if index is valid
        	if (player.getPlayerEquipmentIndex() != -1) {// Call itemEquip only if index is valid
        		
                System.out.println("Equipment index: " + player.getPlayerEquipmentIndex()); // Print index for debugging
				ui.updateGameTextOutputArea("Player equipped item: " + player.inventoryItems[player.getPlayerInventoryIndex()].getName());
				ui.RemoveInfoPanelAddOutputTextPanel();
				// Use the item at this index
                inventoryManager.equipItem(player.getPlayerEquipmentIndex(),player);

				invoUI.refreshInventoryButtons();//always refresh inventory buttons
				invoUI.equipmentButtons[0].setText("Weapon: " + player.getCurrentWeapon().getName());
				invoUI.equipmentButtons[1].setText("Armor: " + player.getCurrentArmor().getName());
				invoUI.damageLabel.setText("Damage:" + player.getCurrentWeapon().getDamageValue());
				invoUI.armorLabel.setText("Armor:" + player.getCurrentArmor().getArmorValue());
				invoUI.CloseInventoryUI();

                System.out.println("Player Equipped item: " + player.equippedItems[0].getName()+"!");
                
            }
			else {
                System.out.println("No item selected."); // Print a message if no item is selected
            }
        	
        	System.out.println("Equipped item from inventory index: " + player.getPlayerItemIndex());
		    System.out.println("Equipped item to equipment index: " + player.getPlayerEquipmentIndex());
        	break;

        case "unEquipItem":
        	//debug equip
        	System.out.println("Attempting to enter unEquip item phase...");
        	//check if index is valid
        	if (player.getPlayerEquipmentIndex() != -1) {// Call itemUsed only if index is valid
				//debug
				System.out.println("Player selected equipment index: " + player.getPlayerEquipmentIndex());
				System.out.println("Player unequipped equipment: " + player.equippedItems[player.getPlayerEquipmentIndex()].getName());// Print index for debugging
				ui.updateGameTextOutputArea("Player unequipped item: " + player.equippedItems[player.getPlayerEquipmentIndex()].getName());
				ui.RemoveInfoPanelAddOutputTextPanel();

                inventoryManager.UnEquipItem(player, player.equippedItems[player.getPlayerEquipmentIndex()]);
                player.setPlayerEquipmentIndex(-1);//always

				invoUI.refreshInventoryButtons();//always!!!
				invoUI.damageLabel.setText("Damage:" + player.getCurrentWeapon().getDamageValue());
				invoUI.armorLabel.setText("Armor:" + player.getCurrentArmor().getArmorValue());
				invoUI.equipmentButtons[0].setText("Weapon:" + player.equippedItems[0].getName());
				invoUI.equipmentButtons[1].setText("Armor:" + player.equippedItems[1].getName());

				invoUI.CloseInventoryUI(); // Hide closeItemButton after using the ite
                
            }
			else {
                System.out.println("No item selected."); // Print a message if no item is selected
            }
        	System.out.println("Player equipment index: " + player.getPlayerEquipmentIndex());

        	break;
        	
       case "inspectWeapon":
    	   
    	   System.out.println("Attempting to inspect weapon...");
    	  		   
    	   if (player.equippedItems[0].getEquipmentType().equals("Weapon")){

			   ui.RemoveOutputTextPanelAddInfoPanel();

			   invoUI.itemLabel.setText("Item:" + player.equippedItems[0].getName());
			   invoUI.itemPriceLabel.setText("Price:" + player.equippedItems[0].getPrice());
			   invoUI.equipmentDamageOrArmorValue.setVisible(true);
			   invoUI.equipmentDamageOrArmorValue.setText("Damage:" + player.equippedItems[0].getDamageValue());

			   invoUI.itemPriceLabel.setVisible(true);
			   invoUI.itemLabel.setVisible(true);
			   invoUI.itemHealingValue.setVisible(false);
			   invoUI.useItemButton.setText("Unequip:");
			   invoUI.useItemButton.setActionCommand("unEquipItem");
			   invoUI.useItemButton.setVisible(true);
			   invoUI.closeItemButton.setVisible(true);
			   player.setPlayerEquipmentIndex(player.equippedItems[0].getItemIndex());
 	        
			   System.out.println("Item found at equipment index: " + player.getPlayerEquipmentIndex());
			   System.out.println("item found: " + player.equippedItems[0].getName());
  
    	   }
		   else if(player.equippedItems[0].getName().isEmpty()){
    		    ui.RemoveInfoPanelAddOutputTextPanel();
       			ui.updateGameTextOutputArea("No item to select");
       			System.out.println("no item selected");
		}

	        	
			break;
			
       case "inspectArmor":
    	   
    	   System.out.println("Attempting to inspect armor...");
    	  		   
    	   if (player.equippedItems[1].getEquipmentType().equals("Armor")){
    		ui.RemoveOutputTextPanelAddInfoPanel();

			   invoUI.itemLabel.setText("Item:" + player.equippedItems[1].getName());
			   invoUI.itemPriceLabel.setText("Price:" + player.equippedItems[1].getPrice());

			   invoUI.equipmentDamageOrArmorValue.setVisible(true);
			   invoUI.equipmentDamageOrArmorValue.setText("Armor:" + player.equippedItems[1].getArmorValue());
			   invoUI.itemPriceLabel.setVisible(true);
			   invoUI.itemLabel.setVisible(true);
			   invoUI.itemHealingValue.setVisible(false);
			   invoUI.useItemButton.setText("Unequip:");
			   invoUI.useItemButton.setActionCommand("unEquipItem");
			   invoUI.useItemButton.setVisible(true);
			   invoUI.closeItemButton.setVisible(true);
			   player.setPlayerEquipmentIndex(player.equippedItems[1].getItemIndex());

			   System.out.println(player.getPlayerEquipmentIndex());
			   System.out.println("item found*" + player.equippedItems[1].getName());
  
    	   }
		   else if(player.equippedItems[1].getName().isEmpty()){
    		   ui.RemoveInfoPanelAddOutputTextPanel();
    		   ui.updateGameTextOutputArea("No item to select");
    		   System.out.println("no item selected");
		}

			break;
    	   
            
       case "closeItem":
    	   ui.RemoveInfoPanelAddOutputTextPanel();
    	   ui.updateGameTextOutputArea("closed item");
    	   ui.infoPanel.setVisible(true);
    	   invoUI.CloseInventoryUI();
           player.setPlayerItemIndex(-1);
           System.out.println(player.getPlayerItemIndex() + "*");
    	   break;
			
		}
		
	}



	@Override
	public void mouseClicked(MouseEvent e) {

	}



	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

		if (e.getSource() == invoUI.inventoryButtons[4]) {
			//System.out.println("goodbye");
			invoUI.equipmentInfoPopUpBoxPanel.setVisible(true);
		}
		else if (e.getSource() == invoUI.inventoryButtons[4]){
			//System.out.println("mwaaaa");
		}

	}

	@Override
	public void mouseExited(MouseEvent e) {

		if (e.getSource() == invoUI.inventoryButtons[4]) {
			//System.out.println("goodbye");
			invoUI.equipmentInfoPopUpBoxPanel.setVisible(false);
		}
		else if (e.getSource() == invoUI.inventoryButtons[4]){
			//System.out.println("mwaaaa");
		}

	}

}





