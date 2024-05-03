package package01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import GameStates.GameState;
import package04.SuperConsumable;
import package04.SuperItem;

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
	invoUI.inventoryButton1.addActionListener(this);
	invoUI.inventoryButton1.addMouseListener(this);
	invoUI.inventoryButton2.addActionListener(this);
	invoUI.inventoryButton3.addActionListener(this);
	invoUI.inventoryButton4.addActionListener(this);
	invoUI.inventoryButton5.addActionListener(this);
	invoUI.inventoryButton5.addMouseListener(this);
	invoUI.useItemButton.addActionListener(this);
	invoUI.closeItemButton.addActionListener(this);
	invoUI.equipmentButtons[0].addActionListener(this);
	invoUI.equipmentButtons[1].addActionListener(this);
	ui.button4.addActionListener(this);
	//INVENTORY BUTTON


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

				invoUI.inventoryButton1.setText(player.inventoryItems[0].getName());
				invoUI.inventoryButton2.setText(player.inventoryItems[1].getName());
				invoUI.inventoryButton3.setText(player.inventoryItems[2].getName());
				invoUI.inventoryButton4.setText(player.inventoryItems[3].getName());
				invoUI.inventoryButton5.setText(player.inventoryItems[4].getName());
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
			if(player.inventoryItems[0].getName().isEmpty()) {
				System.out.println("no item here sorry");
			}
			
			else if(player.inventoryItems[0].getType().equals("Consumable")) {
			SuperConsumable consumableItem = (SuperConsumable) player.inventoryItems[0];
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
	        player.setPlayerItemIndex(0);  
	        System.out.println(player.getPlayerItemIndex() + "*");

			}	
					else if (player.inventoryItems[0].getType().equals("Equipment")) {
					SuperItem superItem = player.inventoryItems[0];
					invoUI.itemLabel.setText("Item:" + superItem.getName());
					invoUI.itemPriceLabel.setText("Price:" + superItem.getPrice());
					if(superItem.getItemIndex() == 0) {
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
					player.setPlayerItemIndex(0);  
				    player.setPlayerEquipmentIndex(superItem.getItemIndex());
				    System.out.println(player.getPlayerItemIndex() + "*");
				    System.out.println(player.getPlayerEquipmentIndex() + "*");
				
			}
			break;
			
		case "item2":
			player.setPlayerInventoryIndex(1);
			if(player.inventoryItems[1].getName().isEmpty()) {
				System.out.println("no item here sorry");
			}
			
			else if(player.inventoryItems[1].getType().equals("Consumable")) {
			SuperConsumable consumableItem = (SuperConsumable) player.inventoryItems[1];
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
	        player.setPlayerItemIndex(1);  
	        System.out.println(player.getPlayerItemIndex() + "*");

			}	
					else if (player.inventoryItems[1].getType().equals("Equipment")) {
					SuperItem superItem = player.inventoryItems[1];
					invoUI.itemLabel.setText("Item:" + superItem.getName());
					invoUI.itemPriceLabel.setText("Price:" + superItem.getPrice());
					if(superItem.getItemIndex() == 0) {
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
				    player.setPlayerItemIndex(1);  
				    player.setPlayerEquipmentIndex(superItem.getItemIndex());
				    System.out.println(player.getPlayerItemIndex() + "*");
				    System.out.println(player.getPlayerEquipmentIndex() + "*");
				
			}
			break;
			
		case "item3":
			player.setPlayerInventoryIndex(2);
			if(player.inventoryItems[2].getName().isEmpty()) {
				System.out.println("no item here sorry");
			}
			else if(player.inventoryItems[2].getType().equals("Consumable")) {
			SuperConsumable consumableItem = (SuperConsumable) player.inventoryItems[2];
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
	        player.setPlayerItemIndex(2);  
	        System.out.println(player.getPlayerItemIndex() + "*");
	        
			}	
					else if (player.inventoryItems[2].getType().equals("Equipment")) {
					SuperItem superItem = player.inventoryItems[2];
					invoUI.itemLabel.setText("Item:" + superItem.getName());
					invoUI.itemPriceLabel.setText("Price:" + superItem.getPrice());
					if(superItem.getItemIndex() == 0) {
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
				    player.setPlayerItemIndex(2);  
				    player.setPlayerEquipmentIndex(superItem.getItemIndex());
				    System.out.println(player.getPlayerItemIndex() + "*");
				    System.out.println(player.getPlayerEquipmentIndex() + "*");
				
			}	
			break;
			
		case "item4":
			player.setPlayerInventoryIndex(3);
			if(player.inventoryItems[3].getName().isEmpty()) {
				System.out.println("no item here sorry");
			}
			
			else if(player.inventoryItems[3].getType().equals("Consumable")) {
			SuperConsumable consumableItem = (SuperConsumable) player.inventoryItems[3];
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
	        player.setPlayerItemIndex(3);  
	        System.out.println(player.getPlayerItemIndex() + "*");

			}	
					else if (player.inventoryItems[3].getType().equals("Equipment")) {
					SuperItem superItem = player.inventoryItems[3];
					invoUI.itemLabel.setText("Item:" + superItem.getName());
					invoUI.itemPriceLabel.setText("Price:" + superItem.getPrice());
					if(superItem.getItemIndex() == 0) {
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
				    player.setPlayerItemIndex(3);  
				    player.setPlayerEquipmentIndex(superItem.getItemIndex());
				    System.out.println(player.getPlayerItemIndex() + "*");
				    System.out.println(player.getPlayerEquipmentIndex() + "*");
						
			}
			
			break;
			
		case "item5":
			player.setPlayerInventoryIndex(4);
			if(player.inventoryItems[4].getName().isEmpty()) {
				System.out.println("no item here sorry");
			}
			
			else if(player.inventoryItems[4].getType().equals("Consumable")) {
			SuperConsumable consumableItem = (SuperConsumable) player.inventoryItems[4];
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
	        player.setPlayerItemIndex(4);  
	        System.out.println(player.getPlayerItemIndex() + "*");

			}
					else if (player.inventoryItems[4].getType().equals("Equipment")) {
					SuperItem superItem = player.inventoryItems[4];
					invoUI.itemLabel.setText("Item:" + superItem.getName());
					invoUI.itemPriceLabel.setText("Price:" + superItem.getPrice());
					if(superItem.getItemIndex() == 0) {
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
				    player.setPlayerItemIndex(4);  
				    player.setPlayerEquipmentIndex(superItem.getItemIndex());
				    System.out.println(player.getPlayerItemIndex() + "*");
				    System.out.println(player.getPlayerEquipmentIndex() + "*");
						
			}
			break;
			
		case "sellItem":
			ui.updateGameTextOutputArea("Sold a "+ player.inventoryItems[player.getPlayerInventoryIndex()].getName() + " for " +
			player.inventoryItems[player.getPlayerInventoryIndex()].getPrice() + "Gold.");
			System.out.println("inside sellitem case check*");
			
			for(int i = 0; i < player.inventoryItems.length; i++) {
			System.out.println(player.inventoryItems[i].getName());
			}
			
			//check if player inventory is full
			if(inventoryManager.SellItemToShop(player, player.inventoryItems[player.getPlayerInventoryIndex()])) {
				System.out.println("player sold item to shop* at the inventory index:" + player.getPlayerInventoryIndex());

			ui.goldLabel.setText(" Gold: " + player.getGold());
			
			System.out.println("Player gold:" + player.getGold() + "*");
			
			ui.infoPanel.setVisible(false);

				invoUI.inventoryButton1.setText(player.inventoryItems[0].getName());
				invoUI.inventoryButton2.setText(player.inventoryItems[1].getName());
				invoUI.inventoryButton3.setText(player.inventoryItems[2].getName());
				invoUI.inventoryButton4.setText(player.inventoryItems[3].getName());
				invoUI.inventoryButton5.setText(player.inventoryItems[4].getName());
		   	
		   	ui.RemoveInfoPanelAddOutputTextPanel();
		   	
		   	
		   	
			} else {			
					ui.infoPanel.setVisible(false);
					ui.sellMessagePanel.setVisible(true);
					
					
					ui.sellMessagePanel.setVisible(true);
					ui.soldItemMessage.setText(inventoryManager.OutOfGoldMessage());
			System.out.println("didnt sell item to shop*");
				
			}{System.out.println("end of sellItem case check*");
			
			System.out.println("player item index*" + player.getPlayerItemIndex());
			
			}
			
			break;

			case "useItem":
				// Print a message to check if the "useItem" case is being triggered
				System.out.println("Attempting to use item...");
				// Check if index is valid
				if (player.getPlayerItemIndex() != -1) {// Call itemUsed only if index is valid

					System.out.println("Item index:*" + player.getPlayerItemIndex()); // Print index for debugging
					inventoryManager.itemUsed(player.getPlayerItemIndex(),player,ui,invoUI);// Use the item at this index
					invoUI.CloseInventoryUI(); // Hide closeItemButton after using the item

				}
				else {
					System.out.println("No item selected."); // Print a message if no item is selected
				}
				player.setPlayerItemIndex(-1);
				System.err.println(player.getPlayerItemIndex());
				break;
            
        case "equipItem":
        	//debug equip
        	System.out.println("Attempting to equip item...");
        	//check if index is valid
        	if (player.getPlayerEquipmentIndex() != -1) {// Call itemEquip only if index is valid
        		
                System.out.println("Item index:*" + player.getPlayerEquipmentIndex()); // Print index for debugging
				ui.updateGameTextOutputArea("Player equipped item: " + player.inventoryItems[player.getPlayerInventoryIndex()].getName());
				ui.RemoveInfoPanelAddOutputTextPanel();

				// Use the item at this index
                inventoryManager.equipItem(player.getPlayerEquipmentIndex(),player);


				invoUI.inventoryButton1.setText(player.inventoryItems[0].getName());
				invoUI.inventoryButton2.setText(player.inventoryItems[1].getName());
				invoUI.inventoryButton3.setText(player.inventoryItems[2].getName());
				invoUI.inventoryButton4.setText(player.inventoryItems[3].getName());
				invoUI.inventoryButton5.setText(player.inventoryItems[4].getName());
				invoUI.equipmentButtons[0].setText("Weapon: " + player.getCurrentWeapon().getName());
				invoUI.equipmentButtons[1].setText("Armor: " + player.getCurrentWeapon().getName());

				invoUI.damageLabel.setText("Damage:" + player.getCurrentWeapon().getDamageValue());
				invoUI.armorLabel.setText("Armor:" + player.getCurrentArmor().getArmorValue());

				invoUI.CloseInventoryUI();


                System.out.println(player.equippedItems[0].getName()+"!");
                
            } else {
                System.out.println("No item selected."); // Print a message if no item is selected
            }
        	
        	System.out.println("Equipped item @ inventory index" + player.getPlayerItemIndex() + "*");
		    System.out.println("Player equipment index equipped @" + player.getPlayerEquipmentIndex() + "*");
        	break;

        case "unEquipItem":
        	//debug equip
        	System.out.println("Attempting to enter unEquip item phase...");
        	//check if index is valid
        	if (player.getPlayerEquipmentIndex() != -1) {// Call itemUsed only if index is valid

				System.out.println("Item index: " + player.getPlayerEquipmentIndex()); // Print index for debugging
				ui.updateGameTextOutputArea("Player unequipped item: " + player.equippedItems[player.getPlayerEquipmentIndex()].getName());
				ui.RemoveInfoPanelAddOutputTextPanel();
				// Use the item at this index
                inventoryManager.UnEquipItem(player, player.equippedItems[player.getPlayerEquipmentIndex()]);
                player.setPlayerEquipmentIndex(-1);

				invoUI.inventoryButton1.setText(player.inventoryItems[0].getName());
				invoUI.inventoryButton2.setText(player.inventoryItems[1].getName());
				invoUI.inventoryButton3.setText(player.inventoryItems[2].getName());
				invoUI.inventoryButton4.setText(player.inventoryItems[3].getName());
				invoUI.inventoryButton5.setText(player.inventoryItems[4].getName());


				invoUI.damageLabel.setText("Damage:" + player.getCurrentWeapon().getDamageValue());
				invoUI.armorLabel.setText("Armor:" + player.getCurrentArmor().getArmorValue());


				invoUI.equipmentButtons[0].setText("Weapon:" + player.equippedItems[0].getName());
				invoUI.equipmentButtons[1].setText("Armor:" + player.equippedItems[1].getName());

				invoUI.CloseInventoryUI(); // Hide closeItemButton after using the ite
                
        		for(int i = 0; i < player.equippedItems.length; i++) {
        			System.out.println("Equipment" + i + ":" + player.equippedItems[i].getName());
        		}
                
            } else {
                System.out.println("No item selected."); // Print a message if no item is selected
            }
        	System.out.println(player.getPlayerEquipmentIndex());
            player.setPlayerItemIndex(-1);
            System.err.println(player.getPlayerItemIndex());
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
 	        
 	        System.out.println(player.getPlayerEquipmentIndex());
 	        System.out.println("item found" + player.equippedItems[0].getName());
  
    	   }else if(player.equippedItems[0].getName().isEmpty()){
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
 	        //DEBUG
 	        System.out.println(player.getPlayerEquipmentIndex());
 	        System.out.println("item found*" + player.equippedItems[1].getName());
  
    	   }else if(player.equippedItems[1].getName().isEmpty()){
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
		System.out.println("hello");
	}



	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

		if (e.getSource() == invoUI.inventoryButton5) {
			//System.out.println("goodbye");
			invoUI.equipmentInfoPopUpBoxPanel.setVisible(true);
		}
		else if (e.getSource() == invoUI.inventoryButton1){
			//System.out.println("mwaaaa");
		}

	}

	@Override
	public void mouseExited(MouseEvent e) {

		if (e.getSource() == invoUI.inventoryButton5) {
			//System.out.println("goodbye");
			invoUI.equipmentInfoPopUpBoxPanel.setVisible(false);
		}
		else if (e.getSource() == invoUI.inventoryButton1){
			//System.out.println("mwaaaa");
		}

	}

}





