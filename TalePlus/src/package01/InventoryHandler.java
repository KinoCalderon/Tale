package package01;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import GameStates.GameState;
import package04.SuperConsumable;
import package04.SuperItem;

public class InventoryHandler implements ActionListener{
	public Player player;
	public UI ui;
	public Game game;
	public JButton[] equipmentButtons = new JButton[2];
	public JButton inventoryButton, inventoryButton1, inventoryButton2, inventoryButton3, inventoryButton4, inventoryButton5;
    public JButton useItemButton;
    public JButton closeItemButton;
	public JPanel inventoryPanel;
	public ImageIcon playerBagIcon;
	public JLabel itemLabel;
	public JLabel itemPriceLabel;
	public JLabel itemHealingValue;
	public JLabel equipmentDamageOrArmorValue;
	public JLabel damageLabel, armorLabel;
	public JLabel equipmentStatsLabel, equipmentLabel, inventoryLabel;
	public JPanel equipmentPanel;
	public JPanel equipmentStatsPanel;

	
	public InventoryHandler(Player player, UI ui, Game game) {	
	this.player = player;
	this.ui = ui;
	this.game = game;
	
	//INVENTORY BUTTON
	playerBagIcon = new ImageIcon(".//media//taleBag.png");
	inventoryButton = new JButton();
	inventoryButton.setIcon(playerBagIcon);
	inventoryButton.setBackground(Color.black);
	inventoryButton.setForeground(Color.white);
	inventoryButton.setFont(ui.statsFont);
	inventoryButton.setFocusPainted(false);
	inventoryButton.setBorderPainted(false);
	inventoryButton.addActionListener(this);
	inventoryButton.setActionCommand("inventoryButton");
	inventoryButton.setSize(10, 10);
	ui.playerPanel.add(inventoryButton);
	
    //INVENTORY PANEL
    inventoryPanel = new JPanel();
    inventoryPanel.setBackground(Color.black);
    //inventoryPanel.setPreferredSize(new Dimension(330,420));
    inventoryPanel.setLayout(new GridLayout(6,1));
    inventoryPanel.setVisible(false);
    inventoryPanel.setBorder(ui.whiteline);
    inventoryPanel.setBounds(445, 1, 330, 420);
    ui.picturePanel.add(inventoryPanel);
    
    //INVENTORY LABEL
    inventoryLabel = new JLabel("                ---Inventory---");
    inventoryLabel.setForeground(Color.yellow);
    inventoryLabel.setVisible(true);
    inventoryLabel.setFont(ui.statsFont);
    inventoryPanel.add(inventoryLabel);
    
    //INVENTORY BUTTONS
    inventoryButton1 = new JButton();
    inventoryButton1.setBackground(Color.black);
    inventoryButton1.setForeground(Color.white);
    inventoryButton1.setFont(ui.normalFont);
    inventoryButton1.setFocusPainted(false);
    inventoryButton1.addActionListener(this);
    inventoryButton1.setActionCommand("item1");
    
    inventoryButton2 = new JButton();
    inventoryButton2.setBackground(Color.black);
    inventoryButton2.setForeground(Color.white);
    inventoryButton2.setFont(ui.normalFont);
    inventoryButton2.setFocusPainted(false);
    inventoryButton2.addActionListener(this);
    inventoryButton2.setActionCommand("item2");
    
    inventoryButton3 = new JButton();
    inventoryButton3.setBackground(Color.black);
    inventoryButton3.setForeground(Color.white);
    inventoryButton3.setFont(ui.normalFont);
    inventoryButton3.setFocusPainted(false);
    inventoryButton3.addActionListener(this);
    inventoryButton3.setActionCommand("item3");
    
    inventoryButton4 = new JButton();
    inventoryButton4.setBackground(Color.black);
    inventoryButton4.setForeground(Color.white);
    inventoryButton4.setFont(ui.normalFont);
    inventoryButton4.setFocusPainted(false);
    inventoryButton4.addActionListener(this);
    inventoryButton4.setActionCommand("item4");
    
    inventoryButton5 = new JButton();
    inventoryButton5.setBackground(Color.black);
    inventoryButton5.setForeground(Color.white);
    inventoryButton5.setFont(ui.normalFont);
    inventoryButton5.setFocusPainted(false);
    inventoryButton5.addActionListener(this);
    inventoryButton5.setActionCommand("item5");
    
    inventoryPanel.add(inventoryButton1);
    inventoryPanel.add(inventoryButton2);
    inventoryPanel.add(inventoryButton3);
    inventoryPanel.add(inventoryButton4);
    inventoryPanel.add(inventoryButton5);
    
	itemLabel = new JLabel();
    itemLabel.setForeground(Color.white);
    itemLabel.setVisible(false);
    itemLabel.setFont(ui.statsFont);
	ui.infoPanel.add(itemLabel);
    
	itemPriceLabel = new JLabel();
	itemPriceLabel.setForeground(Color.white);
	itemPriceLabel.setVisible(false);
	itemPriceLabel.setFont(ui.statsFont);
	ui.infoPanel.add(itemPriceLabel);
	
	itemHealingValue = new JLabel();
	itemHealingValue.setForeground(Color.white);
	itemHealingValue.setVisible(false);
	itemHealingValue.setFont(ui.statsFont);
	ui.infoPanel.add(itemHealingValue);
    
	equipmentDamageOrArmorValue = new JLabel();
	equipmentDamageOrArmorValue.setForeground(Color.white);
	equipmentDamageOrArmorValue.setVisible(false);
	equipmentDamageOrArmorValue.setFont(ui.statsFont);
	ui.infoPanel.add(equipmentDamageOrArmorValue);
    
    useItemButton = new JButton("Use:");
    useItemButton.setBackground(Color.black);
    useItemButton.setForeground(Color.white);
    useItemButton.setFont(ui.normalFont);
    useItemButton.setFocusPainted(false);
    useItemButton.addActionListener(this);
    useItemButton.setActionCommand("useItem");
    useItemButton.setVisible(false);
    ui.infoPanel.add(useItemButton);
    
    closeItemButton = new JButton("Close");
    closeItemButton.setBackground(Color.black);
    closeItemButton.setForeground(Color.white);
    closeItemButton.setFont(ui.normalFont);
    closeItemButton.setFocusPainted(false);
    closeItemButton.addActionListener(this);
    closeItemButton.setActionCommand("closeItem");
    closeItemButton.setVisible(false);
    ui.infoPanel.add(closeItemButton);
    
    
    //EQUIPMENT PANEL
    equipmentPanel = new JPanel();
    //equipmentPanel.setPreferredSize(new Dimension(330,420));
    equipmentPanel.setBounds(0, 1, 330, 210);
    equipmentPanel.setBackground(Color.BLACK);
    equipmentPanel.setVisible(false);
    equipmentPanel.setBorder(ui.whiteline);
    equipmentPanel.setLayout(new GridLayout(3,2));
    ui.picturePanel.add(equipmentPanel);
    
    equipmentLabel = new JLabel("              ---Equipment---");
    equipmentLabel.setForeground(Color.yellow);
    equipmentLabel.setVisible(true);
    equipmentLabel.setFont(ui.statsFont);
    equipmentPanel.add(equipmentLabel);
    
    equipmentStatsPanel = new JPanel();
    //equipmentStatsPanel.setPreferredSize(new Dimension(330,120));
    equipmentStatsPanel.setBounds(0, 240, 330, 180);
    equipmentStatsPanel.setBackground(Color.black);
    equipmentStatsPanel.setVisible(false);
    equipmentStatsPanel.setBorder(ui.whiteline);
    equipmentStatsPanel.setLayout(new GridLayout(5,1));
    ui.picturePanel.add(equipmentStatsPanel);
    
    equipmentStatsLabel = new JLabel("        ---Equipment Bonus---");
    equipmentStatsLabel.setForeground(Color.yellow);
    equipmentStatsLabel.setVisible(true);
    equipmentStatsLabel.setFont(ui.statsFont);
    equipmentStatsPanel.add(equipmentStatsLabel);
    
    equipmentButtons[0] = new JButton("Weapon:" + player.equippedItems[0].getName());
    equipmentButtons[0].setBackground(Color.black);
    equipmentButtons[0].setForeground(Color.white);
    equipmentButtons[0].setFont(ui.normalFont);
    equipmentButtons[0].setFocusPainted(false);
    equipmentButtons[0].addActionListener(this);
    equipmentButtons[0].setActionCommand("inspectWeapon");
    equipmentButtons[0].setVisible(true);
    equipmentPanel.add(equipmentButtons[0]);
    
    equipmentButtons[1] = new JButton("Armor:" + player.equippedItems[1].getName());
    equipmentButtons[1].setBackground(Color.black);
    equipmentButtons[1].setForeground(Color.white);
    equipmentButtons[1].setFont(ui.normalFont);
    equipmentButtons[1].setFocusPainted(false);
    equipmentButtons[1].addActionListener(this);
    equipmentButtons[1].setActionCommand("inspectArmor");
    equipmentButtons[1].setVisible(true);
    equipmentPanel.add(equipmentButtons[1]);
    
    damageLabel = new JLabel("Damage:" + player.getCurrentWeapon().getDamageValue());
    damageLabel.setForeground(Color.white);
    damageLabel.setVisible(true);
    damageLabel.setFont(ui.statsFont);
    equipmentStatsPanel.add(damageLabel);
    
    armorLabel = new JLabel("Armor:" + player.getCurrentArmor().getArmorValue());
    armorLabel.setForeground(Color.white);
    armorLabel.setVisible(true);
    armorLabel.setFont(ui.statsFont);
    equipmentStatsPanel.add(armorLabel);
    

	}

    public void itemUsed(int slotNumber) {
    	//set the item used = to a temporary SuperItem variable
    	SuperItem currentItem = player.inventoryItems[slotNumber];
   	 	//check to see if the current item used is a Consumable
    	if(currentItem instanceof SuperConsumable consumableItem) {
    			//set the current item used = a SuperConsumable, consumable Item 


				if (consumableItem.getHealingValue() > 0){

					ui.updateGameTextOutputArea("Player used: " + consumableItem.getName() + " +"
											   + consumableItem.getHealingValue() + consumableItem.getConsumableType());
					ui.RemoveInfoPanelAddOutputTextPanel();
				} else if (consumableItem.getHealingValue() < 0) {

					ui.updateGameTextOutputArea("Player used: " + consumableItem.getName() +" "
							+ consumableItem.getHealingValue() + consumableItem.getConsumableType());
					ui.RemoveInfoPanelAddOutputTextPanel();
				}

			player.healPlayer(consumableItem.getHealingValue());
			   	ui.hpLabel.setText(" HP: " + player.getCurrentHp() + "/" + player.getMaxHp());
			   	 
			   	player.inventoryItems[slotNumber] = player.empty;
			   	inventoryButton1.setText(player.inventoryItems[0].getName());
			   	inventoryButton2.setText(player.inventoryItems[1].getName());
			   	inventoryButton3.setText(player.inventoryItems[2].getName());
			   	inventoryButton4.setText(player.inventoryItems[3].getName());
			   	inventoryButton5.setText(player.inventoryItems[4].getName());
    	}  	
    	else {
    		System.out.println("no value found");
    	}
   }
    
    public void equipItem(int slotNumber) {
        // Check if the slotNumber is valid
        if (slotNumber >= 0 && slotNumber < player.equippedItems.length) {
            //set the item used = to a temporary currentItem variable
            SuperItem currentItem = player.inventoryItems[player.getPlayerItemIndex()];
            //check to see if the current item is used is an equip
            if (currentItem instanceof SuperItem) {
                //set the current item used = to a SuperWeapon superWeapon


                player.inventoryItems[player.getPlayerItemIndex()] = player.equippedItems[currentItem.getItemIndex()];
                player.equippedItems[currentItem.getItemIndex()] = currentItem;
                ui.updateGameTextOutputArea("Player equipped item: " + currentItem.getName());
                ui.RemoveInfoPanelAddOutputTextPanel();

                inventoryButton1.setText(player.inventoryItems[0].getName());
                inventoryButton2.setText(player.inventoryItems[1].getName());
                inventoryButton3.setText(player.inventoryItems[2].getName());
                inventoryButton4.setText(player.inventoryItems[3].getName());
                inventoryButton5.setText(player.inventoryItems[4].getName());

                player.setCurrentWeapon(player.equippedItems[0]);
                player.setCurrentArmor(player.equippedItems[1]);
                damageLabel.setText("Damage:" + player.getCurrentWeapon().getDamageValue());
                armorLabel.setText("Armor:" + player.getCurrentArmor().getArmorValue());
                player.setDamage(player.equippedItems[0].getDamageValue());
                player.setArmor(player.equippedItems[1].getArmorValue());

                // Check if slotNumber is valid for equipmentButtons array
                if (slotNumber >= 0 && slotNumber < equipmentButtons.length) {
                    equipmentButtons[slotNumber].setText(currentItem.getEquipmentType() + ":" + player.equippedItems[slotNumber].getName());
                }
				else {
                    System.out.println("Invalid slot number for equipment buttons array.");
                }
            }
			else {
                System.out.println("No item found");
            }
        }
		else {
            System.out.println("Invalid slot number");
        }
    }

    
	public void UnEquipItem(Player player, SuperItem item) {
		
		int slotNumber = 0;
		while(player.inventoryItems[slotNumber] != player.empty && slotNumber <4) {
			slotNumber++;
		}
		if(player.inventoryItems[slotNumber] == player.empty) {
			player.inventoryItems[slotNumber] = player.equippedItems[item.getItemIndex()];
			player.equippedItems[item.getItemIndex()] = player.empty;
			ui.updateGameTextOutputArea("Player unequipped item: " + item.getName());
            ui.RemoveInfoPanelAddOutputTextPanel();
			
		   	inventoryButton1.setText(player.inventoryItems[0].getName());
		   	inventoryButton2.setText(player.inventoryItems[1].getName());
		   	inventoryButton3.setText(player.inventoryItems[2].getName());
		   	inventoryButton4.setText(player.inventoryItems[3].getName());
		   	inventoryButton5.setText(player.inventoryItems[4].getName());
		   	
            player.setCurrentWeapon(player.equippedItems[0]);
            player.setCurrentArmor(player.equippedItems[1]);
            damageLabel.setText("Damage:" + player.getCurrentWeapon().getDamageValue());
            armorLabel.setText("Armor:" + player.getCurrentArmor().getArmorValue());
            player.setDamage(player.equippedItems[0].getDamageValue());
            player.setArmor(player.equippedItems[1].getArmorValue());
		   	
		   	equipmentButtons[0].setText("Weapon:" + player.equippedItems[0].getName());
		   	equipmentButtons[1].setText("Armor:" + player.equippedItems[1].getName());
		}
			else if(player.inventoryItems[slotNumber] != player.empty) {
				System.out.println("player inventory is full");
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
		        inventoryButton.setEnabled(false);

		        // Perform the action associated with the button
		        inventoryButton.addActionListener(null);
		        inventoryButton.setActionCommand("i");
		        System.out.println("made it into inventory*");
		        GameState.pushStateAndSetCurrent(game.playerInventoryState, player);
		        //System.out.println("updated the pushstateandsetcurrentstate*");
		        inventoryPanel.setVisible(true);
		        equipmentPanel.setVisible(true);
		        equipmentStatsPanel.setVisible(true);
		        //ui.buttonPanel.setVisible(false);
		        //ui.button4.removeActionListener(this);
		        //ui.button4.addActionListener(this);
		        
		        
		        
		        inventoryButton1.setText(player.inventoryItems[0].getName());
		        inventoryButton2.setText(player.inventoryItems[1].getName());
		        inventoryButton3.setText(player.inventoryItems[2].getName());
		        inventoryButton4.setText(player.inventoryItems[3].getName());
		        inventoryButton5.setText(player.inventoryItems[4].getName());
		        player.setInventoryStatus("open");
		        //System.out.println(GameState.getGameStateStack() + " GAME STATE STACK IN SWITCH CASEI HANDLER*");

		        // Re-enable the inventory button after the action is completed
		        inventoryButton.setEnabled(true);
		    } else if (player.getInventoryStatus().equals("open")) {
		        System.out.println("inventory already open*");
		    }
		    break;

			
		case "exitInventory":
			System.out.println("exiting inventory");
			inventoryButton.setActionCommand("inventoryButton");
			inventoryPanel.setVisible(false);
			equipmentPanel.setVisible(false);
			equipmentStatsPanel.setVisible(false);
	    	itemHealingValue.setVisible(false);
	    	itemPriceLabel.setVisible(false);
	        itemLabel.setVisible(false); // Hide item label after closing inventory
	        equipmentDamageOrArmorValue.setVisible(false);
	        useItemButton.setVisible(false); // Hide useItemButton after using the item
	        closeItemButton.setVisible(false);
	        
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
			itemLabel.setText("Item:" + consumableItem.getName());
			itemPriceLabel.setText("Price:" + consumableItem.getPrice());
			itemHealingValue.setText("Heals:" + consumableItem.getHealingValue());
			itemHealingValue.setVisible(true);
			itemPriceLabel.setVisible(true);
			itemLabel.setVisible(true);
			equipmentDamageOrArmorValue.setVisible(false);
			ui.RemoveOutputTextPanelAddInfoPanel();
			ui.CloseItemUi();
			
			if(player.getShopStatus().equals("open")) {
				useItemButton.setText("Sell");
				useItemButton.setActionCommand("sellItem");
			}else if(player.getShopStatus().equals("close")) {
				useItemButton.setText("Use:");
				useItemButton.setActionCommand("useItem");
			}

	        useItemButton.setVisible(true);
	        closeItemButton.setVisible(true);
	        player.setPlayerItemIndex(0);  
	        System.out.println(player.getPlayerItemIndex() + "*");

			}	
					else if (player.inventoryItems[0].getType().equals("Equipment")) {
					SuperItem superItem = player.inventoryItems[0];
					itemLabel.setText("Item:" + superItem.getName());
					itemPriceLabel.setText("Price:" + superItem.getPrice());
					if(superItem.getItemIndex() == 0) {
					equipmentDamageOrArmorValue.setText("Damage:" + superItem.getDamageValue());
					} else if(superItem.getItemIndex() == 1) {
						equipmentDamageOrArmorValue.setText("Armor:" + superItem.getArmorValue());
						
					}
					itemPriceLabel.setVisible(true);
					itemLabel.setVisible(true);
					equipmentDamageOrArmorValue.setVisible(true);
					itemHealingValue.setVisible(false);
					ui.RemoveOutputTextPanelAddInfoPanel();
					ui.CloseItemUi();
					
					if(player.getShopStatus().equals("open")) {
						useItemButton.setText("Sell");
						useItemButton.setActionCommand("sellItem");
					}else if(player.getShopStatus().equals("close")) {
						useItemButton.setText("Equip:");
						useItemButton.setActionCommand("equipItem");
					}
					useItemButton.setVisible(true);
					closeItemButton.setVisible(true);
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
			itemLabel.setText("Item:" + consumableItem.getName());
			itemPriceLabel.setText("Price:" + consumableItem.getPrice());
			itemHealingValue.setText("Heals:" + consumableItem.getHealingValue());
			itemHealingValue.setVisible(true);
			itemPriceLabel.setVisible(true);
			itemLabel.setVisible(true);
			equipmentDamageOrArmorValue.setVisible(false);
			ui.RemoveOutputTextPanelAddInfoPanel();
			ui.CloseItemUi();
			
			if(player.getShopStatus().equals("open")) {
				useItemButton.setText("Sell");
				useItemButton.setActionCommand("sellItem");
			}else if(player.getShopStatus().equals("close")) {
				useItemButton.setText("Use:");
				useItemButton.setActionCommand("useItem");
			}
			
	        useItemButton.setVisible(true);
	        closeItemButton.setVisible(true);
	        player.setPlayerItemIndex(1);  
	        System.out.println(player.getPlayerItemIndex() + "*");

			}	
					else if (player.inventoryItems[1].getType().equals("Equipment")) {
					SuperItem superItem = player.inventoryItems[1];
					itemLabel.setText("Item:" + superItem.getName());
					itemPriceLabel.setText("Price:" + superItem.getPrice());
					if(superItem.getItemIndex() == 0) {
					equipmentDamageOrArmorValue.setText("Damage:" + superItem.getDamageValue());
					} else if(superItem.getItemIndex() == 1) {
						equipmentDamageOrArmorValue.setText("Armor:" + superItem.getArmorValue());
						
					}
					itemPriceLabel.setVisible(true);
					itemLabel.setVisible(true);
					equipmentDamageOrArmorValue.setVisible(true);
					itemHealingValue.setVisible(false);
					ui.RemoveOutputTextPanelAddInfoPanel();
					ui.CloseItemUi();
					
					if(player.getShopStatus().equals("open")) {
						useItemButton.setText("Sell");
						useItemButton.setActionCommand("sellItem");
					}else if(player.getShopStatus().equals("close")) {
						useItemButton.setText("Equip:");
						useItemButton.setActionCommand("equipItem");
					}
				    useItemButton.setVisible(true);
				    closeItemButton.setVisible(true);
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
			itemLabel.setText("Item:" + consumableItem.getName());
			itemPriceLabel.setText("Price:" + consumableItem.getPrice());
			itemHealingValue.setText("Heals:" + consumableItem.getHealingValue());
			itemHealingValue.setVisible(true);
			itemPriceLabel.setVisible(true);
			itemLabel.setVisible(true);
			equipmentDamageOrArmorValue.setVisible(false);
			ui.RemoveOutputTextPanelAddInfoPanel();
			ui.CloseItemUi();
			
			if(player.getShopStatus().equals("open")) {
				useItemButton.setText("Sell");
				useItemButton.setActionCommand("sellItem");
			}else if(player.getShopStatus().equals("close")) {
				useItemButton.setText("Use:");
				useItemButton.setActionCommand("useItem");
			}
	        useItemButton.setVisible(true);
	        closeItemButton.setVisible(true);
	        player.setPlayerItemIndex(2);  
	        System.out.println(player.getPlayerItemIndex() + "*");
	        
			}	
					else if (player.inventoryItems[2].getType().equals("Equipment")) {
					SuperItem superItem = player.inventoryItems[2];
					itemLabel.setText("Item:" + superItem.getName());
					itemPriceLabel.setText("Price:" + superItem.getPrice());
					if(superItem.getItemIndex() == 0) {
					equipmentDamageOrArmorValue.setText("Damage:" + superItem.getDamageValue());
					} else if(superItem.getItemIndex() == 1) {
						equipmentDamageOrArmorValue.setText("Armor:" + superItem.getArmorValue());
						
					}
					itemPriceLabel.setVisible(true);
					itemLabel.setVisible(true);
					equipmentDamageOrArmorValue.setVisible(true);
					itemHealingValue.setVisible(false);
					ui.RemoveOutputTextPanelAddInfoPanel();
					ui.CloseItemUi();
					
					if(player.getShopStatus().equals("open")) {
						useItemButton.setText("Sell");
						useItemButton.setActionCommand("sellItem");
					}else if(player.getShopStatus().equals("close")) {
						useItemButton.setText("Equip:");
						useItemButton.setActionCommand("equipItem");
					}
				    useItemButton.setVisible(true);
				    closeItemButton.setVisible(true);
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
			itemLabel.setText("Item:" + consumableItem.getName());
			itemPriceLabel.setText("Price:" + consumableItem.getPrice());
			itemHealingValue.setText("Heals:" + consumableItem.getHealingValue());
			itemHealingValue.setVisible(true);
			itemPriceLabel.setVisible(true);
			itemLabel.setVisible(true);
			equipmentDamageOrArmorValue.setVisible(false);
			ui.RemoveOutputTextPanelAddInfoPanel();
			ui.CloseItemUi();
			
			if(player.getShopStatus().equals("open")) {
				useItemButton.setText("Sell");
				useItemButton.setActionCommand("sellItem");
			}else if(player.getShopStatus().equals("close")) {
				useItemButton.setText("Use:");
				useItemButton.setActionCommand("useItem");
			}
	        useItemButton.setVisible(true);
	        closeItemButton.setVisible(true);
	        player.setPlayerItemIndex(3);  
	        System.out.println(player.getPlayerItemIndex() + "*");

			}	
					else if (player.inventoryItems[3].getType().equals("Equipment")) {
					SuperItem superItem = player.inventoryItems[3];
					itemLabel.setText("Item:" + superItem.getName());
					itemPriceLabel.setText("Price:" + superItem.getPrice());
					if(superItem.getItemIndex() == 0) {
					equipmentDamageOrArmorValue.setText("Damage:" + superItem.getDamageValue());
					
					} else if(superItem.getItemIndex() == 1) {
						equipmentDamageOrArmorValue.setText("Armor:" + superItem.getArmorValue());
						
					}
					itemPriceLabel.setVisible(true);
					itemLabel.setVisible(true);
					equipmentDamageOrArmorValue.setVisible(true);
					itemHealingValue.setVisible(false);
					ui.RemoveOutputTextPanelAddInfoPanel();
					ui.CloseItemUi();
					
					if(player.getShopStatus().equals("open")) {
						useItemButton.setText("Sell");
						useItemButton.setActionCommand("sellItem");
					}else if(player.getShopStatus().equals("close")) {
						useItemButton.setText("Equip:");
						useItemButton.setActionCommand("equipItem");
					}
				    useItemButton.setVisible(true);
				    closeItemButton.setVisible(true);
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
			itemLabel.setText("Item:" + consumableItem.getName());
			itemPriceLabel.setText("Price:" + consumableItem.getPrice());
			itemHealingValue.setText("Heals:" + consumableItem.getHealingValue());
			itemHealingValue.setVisible(true);
			itemPriceLabel.setVisible(true);
			itemLabel.setVisible(true);
			equipmentDamageOrArmorValue.setVisible(false);
			ui.RemoveOutputTextPanelAddInfoPanel();
			ui.CloseItemUi();
			
			if(player.getShopStatus().equals("open")) {
				useItemButton.setText("Sell");
				useItemButton.setActionCommand("sellItem");
			}else if(player.getShopStatus().equals("close")) {
				useItemButton.setText("Use:");
				useItemButton.setActionCommand("useItem");
			}
	        useItemButton.setVisible(true);
	        closeItemButton.setVisible(true);
	        player.setPlayerItemIndex(4);  
	        System.out.println(player.getPlayerItemIndex() + "*");

			}
					else if (player.inventoryItems[4].getType().equals("Equipment")) {
					SuperItem superItem = player.inventoryItems[4];
					itemLabel.setText("Item:" + superItem.getName());
					itemPriceLabel.setText("Price:" + superItem.getPrice());
					if(superItem.getItemIndex() == 0) {
					equipmentDamageOrArmorValue.setText("Damage:" + superItem.getDamageValue());
					} else if(superItem.getItemIndex() == 1) {
						equipmentDamageOrArmorValue.setText("Armor:" + superItem.getArmorValue());
						
					}
					itemPriceLabel.setVisible(true);
					itemLabel.setVisible(true);
					equipmentDamageOrArmorValue.setVisible(true);
					itemHealingValue.setVisible(false);
					ui.RemoveOutputTextPanelAddInfoPanel();
					ui.CloseItemUi();
					
					if(player.getShopStatus().equals("open")) {
						useItemButton.setText("Sell");
						useItemButton.setActionCommand("sellItem");
					}else if(player.getShopStatus().equals("close")) {
						useItemButton.setText("Equip:");
						useItemButton.setActionCommand("equipItem");
					}
				    useItemButton.setVisible(true);
				    closeItemButton.setVisible(true);
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
			InventoryManager inventoryManager1 = new InventoryManager();
			
			//check if player inventory is full
			if(inventoryManager1.SellItemToShop(player, player.inventoryItems[player.getPlayerInventoryIndex()])) {
				System.out.println("player sold item to shop* at the inventory index:" + player.getPlayerInventoryIndex());

			ui.goldLabel.setText(" Gold: " + player.getGold());
			
			System.out.println("Player gold:" + player.getGold() + "*");
			
			ui.infoPanel.setVisible(false);
			
		   	inventoryButton1.setText(player.inventoryItems[0].getName());
		   	inventoryButton2.setText(player.inventoryItems[1].getName());
		   	inventoryButton3.setText(player.inventoryItems[2].getName());
		   	inventoryButton4.setText(player.inventoryItems[3].getName());
		   	inventoryButton5.setText(player.inventoryItems[4].getName());
		   	
		   	ui.RemoveInfoPanelAddOutputTextPanel();
		   	
		   	
		   	
			} else {			
					ui.infoPanel.setVisible(false);
					ui.sellMessagePanel.setVisible(true);
					
					
					ui.sellMessagePanel.setVisible(true);
					ui.soldItemMessage.setText(inventoryManager1.OutOfGoldMessage());
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
            	for(int i = 0; i < player.inventoryItems.length; i++) {
        			System.out.println(player.inventoryItems[i].getName());
        			}
                System.out.println("Item index:*" + player.getPlayerItemIndex()); // Print index for debugging
                itemUsed(player.getPlayerItemIndex());// Use the item at this index
                
                itemHealingValue.setVisible(false);
                itemPriceLabel.setVisible(false);
                itemLabel.setVisible(false); // Hide item label after using the item
                equipmentDamageOrArmorValue.setVisible(false);
                useItemButton.setVisible(false); // Hide useItemButton after using the item
                closeItemButton.setVisible(false); // Hide closeItemButton after using the item
                
            } else {
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
                // Use the item at this index
                equipItem(player.getPlayerEquipmentIndex());
                
                
                itemHealingValue.setVisible(false);
                itemPriceLabel.setVisible(false);
                itemLabel.setVisible(false); // Hide item label after using the item
                equipmentDamageOrArmorValue.setVisible(false);
                useItemButton.setVisible(false); // Hide useItemButton after using the item
                closeItemButton.setVisible(false); // Hide closeItemButton after using the item
                //debugging!
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
                // Use the item at this index
                UnEquipItem(player, player.equippedItems[player.getPlayerEquipmentIndex()]);
                player.setPlayerEquipmentIndex(-1);
                itemHealingValue.setVisible(false);
                itemPriceLabel.setVisible(false);
                itemLabel.setVisible(false); // Hide item label after using the item
                equipmentDamageOrArmorValue.setVisible(false);
                useItemButton.setVisible(false); // Hide useItemButton after using the item
                closeItemButton.setVisible(false); // Hide closeItemButton after using the item
                //debugging!
                
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
    		   
   			itemLabel.setText("Item:" + player.equippedItems[0].getName());
   			itemPriceLabel.setText("Price:" + player.equippedItems[0].getPrice());
     	   
 			equipmentDamageOrArmorValue.setVisible(true);
 			equipmentDamageOrArmorValue.setText("Damage:" + player.equippedItems[0].getDamageValue());
 			itemPriceLabel.setVisible(true);
 			itemLabel.setVisible(true);
 			itemHealingValue.setVisible(false);
 			
 			useItemButton.setText("Unequip:");
 			useItemButton.setActionCommand("unEquipItem");
 	        useItemButton.setVisible(true);
 	        closeItemButton.setVisible(true);
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
    		   
   			itemLabel.setText("Item:" + player.equippedItems[1].getName());
   			itemPriceLabel.setText("Price:" + player.equippedItems[1].getPrice());
     	   
 			equipmentDamageOrArmorValue.setVisible(true);
 			equipmentDamageOrArmorValue.setText("Armor:" + player.equippedItems[1].getArmorValue());
 			itemPriceLabel.setVisible(true);
 			itemLabel.setVisible(true);
 			itemHealingValue.setVisible(false);
 			
 			useItemButton.setText("Unequip:");
 			useItemButton.setActionCommand("unEquipItem");
 	        useItemButton.setVisible(true);
 	        closeItemButton.setVisible(true);
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
    	   itemHealingValue.setVisible(false);
    	   itemPriceLabel.setVisible(false);
           itemLabel.setVisible(false); // Hide item label after using the item
           equipmentDamageOrArmorValue.setVisible(false);
           useItemButton.setVisible(false); // Hide useItemButton after using the item
           closeItemButton.setVisible(false);
           player.setPlayerItemIndex(-1);
           System.out.println(player.getPlayerItemIndex() + "*");
    	   break;
			
		}
		
	}
	
	public void CloseInventoryHandlerUi() {
 	   itemHealingValue.setVisible(false);
 	   itemPriceLabel.setVisible(false);
        itemLabel.setVisible(false); // Hide item label after using the item
        equipmentDamageOrArmorValue.setVisible(false);
        useItemButton.setVisible(false); // Hide useItemButton after using the item
        closeItemButton.setVisible(false);
        
	}
}