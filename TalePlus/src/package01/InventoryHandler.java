package package01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import GameStates.TavernState;
import package04.SuperConsumable;
import package04.SuperItem;

public class InventoryHandler implements ActionListener{
	public Player player;
	public UI ui;
	public JButton[] equipmentButtons = new JButton[2];
	public JButton equipmentButton1, equipmentButton2;
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
	private JLabel equipmentStatsLabel, equipmentLabel, inventoryLabel;
	private JPanel equipmentPanel;
	private JPanel equipmentStatsPanel;
	InventoryManager inventoryManager = new InventoryManager();
	
	public InventoryHandler(Player player, UI ui) {	
	this.player = player;
	this.ui = ui;
	
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
    	if(currentItem instanceof SuperConsumable) {
    			//set the current item used = a SuperConsumable, consumable Item 
    			SuperConsumable consumableItem = (SuperConsumable) currentItem;
    		
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
                SuperItem superItem = (SuperItem) currentItem;
                //set the slotNumber = to the itemIndex of the currentItem
                player.inventoryItems[player.getPlayerItemIndex()] = player.equippedItems[superItem.getItemIndex()];
                player.equippedItems[superItem.getItemIndex()] = superItem;

                inventoryButton1.setText(player.inventoryItems[0].getName());
                inventoryButton2.setText(player.inventoryItems[1].getName());
                inventoryButton3.setText(player.inventoryItems[2].getName());
                inventoryButton4.setText(player.inventoryItems[3].getName());
                inventoryButton5.setText(player.inventoryItems[4].getName());  
                
                player.setCurrentWeapon(player.equippedItems[0]);
                player.setCurrentArmor(player.equippedItems[1]);
                damageLabel.setText("Damage:" + player.getCurrentWeapon().getDamageValue());
                armorLabel.setText("Armor:" + player.getCurrentArmor().getArmorValue());
              
                // Check if slotNumber is valid for equipmentButtons array
                if (slotNumber >= 0 && slotNumber < equipmentButtons.length) {
                    equipmentButtons[slotNumber].setText(superItem.getEquipmentType() + ":" + player.equippedItems[slotNumber].getName());
                } else {
                    System.out.println("Invalid slot number for equipment buttons array.");
                }
            } else {
                System.out.println("No item found");
            }
        } else {
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
			
		   	inventoryButton1.setText(player.inventoryItems[0].getName());
		   	inventoryButton2.setText(player.inventoryItems[1].getName());
		   	inventoryButton3.setText(player.inventoryItems[2].getName());
		   	inventoryButton4.setText(player.inventoryItems[3].getName());
		   	inventoryButton5.setText(player.inventoryItems[4].getName());
		   	
            player.setCurrentWeapon(player.equippedItems[0]);
            player.setCurrentArmor(player.equippedItems[1]);
            damageLabel.setText("Damage:" + player.getCurrentWeapon().getDamageValue());
            armorLabel.setText("Armor:" + player.getCurrentArmor().getArmorValue());
		   	
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
			System.out.println("attempting to access inventory...");
			if(player.getInventoryStatus().equals("close") && player.getShopStatus().equals("close")) {
				System.out.println("made it into inventory");
				inventoryPanel.setVisible(true);
				equipmentPanel.setVisible(true);
				equipmentStatsPanel.setVisible(true);
				ui.buttonPanel.setVisible(false);
				
				inventoryButton1.setText(player.inventoryItems[0].getName());
				inventoryButton2.setText(player.inventoryItems[1].getName());
				inventoryButton3.setText(player.inventoryItems[2].getName());
				inventoryButton4.setText(player.inventoryItems[3].getName());
				inventoryButton5.setText(player.inventoryItems[4].getName());
				player.setInventoryStatus("open");
			}
			else if(player.getInventoryStatus().equals("open")) {
				System.out.println("closing inventory");
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
			}
			break;
			
		case "item1":
			if(player.inventoryItems[0].getName().equals("")) {	
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
	        System.out.println(player.getPlayerItemIndex());

			}	
					else if (player.inventoryItems[0].getType().equals("Equipment")) {
					SuperItem superItem = (SuperItem) player.inventoryItems[0];
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
					System.out.println(player.getPlayerItemIndex());
				
			}
			break;
			
		case "item2":
			if(player.inventoryItems[1].getName().equals("")) {	
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
	        System.out.println(player.getPlayerItemIndex());

			}	
					else if (player.inventoryItems[1].getType().equals("Equipment")) {
					SuperItem superItem = (SuperItem) player.inventoryItems[1];
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
				    System.out.println(player.getPlayerItemIndex());
				
			}
			break;
			
		case "item3":
			if(player.inventoryItems[2].getName().equals("")) {	
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
	        System.out.println(player.getPlayerItemIndex());
	        
			}	
					else if (player.inventoryItems[2].getType().equals("Equipment")) {
					SuperItem superItem = (SuperItem) player.inventoryItems[2];
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
				    System.out.println(player.getPlayerItemIndex());
				    System.out.println(player.getPlayerEquipmentIndex());
				
			}	
			break;
			
		case "item4":
			if(player.inventoryItems[3].getName().equals("")) {
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
	        System.out.println(player.getPlayerItemIndex());

			}	
					else if (player.inventoryItems[3].getType().equals("Equipment")) {
					SuperItem superItem = (SuperItem) player.inventoryItems[3];
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
				    System.out.println(player.getPlayerItemIndex());
				    System.out.println(player.getPlayerEquipmentIndex());
						
			}
			
			break;
			
		case "item5":
			if(player.inventoryItems[4].getName().equals("")) {	
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
	        System.out.println(player.getPlayerItemIndex());

			}
					else if (player.inventoryItems[4].getType().equals("Equipment")) {
					SuperItem superItem = (SuperItem) player.inventoryItems[4];
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
				    System.out.println(player.getPlayerItemIndex());
						
			}
			break;
			
        case "useItem":
            // Print a message to check if the "useItem" case is being triggered
            System.out.println("Attempting to use item...");
            // Check if index is valid
            if (player.getPlayerItemIndex() != -1) {// Call itemUsed only if index is valid
                System.out.println("Item index: " + player.getPlayerItemIndex()); // Print index for debugging
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
        	if (player.getPlayerEquipmentIndex() != -1) {// Call itemUsed only if index is valid
                System.out.println("Item index: " + player.getPlayerEquipmentIndex()); // Print index for debugging
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
             
        		for(int i = 0; i < player.equippedItems.length; i++) {
        			System.out.println(player.equippedItems[i]);
        		}
                
            } else {
                System.out.println("No item selected."); // Print a message if no item is selected
            }
        	System.out.println(player.getPlayerEquipmentIndex());
            
            System.err.println(player.getPlayerItemIndex());
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
    		   
   			itemLabel.setText("Item:" + player.equippedItems[0].getName());
   			itemPriceLabel.setText("Price:" + player.equippedItems[0].getPrice());
     	   
 			equipmentDamageOrArmorValue.setVisible(true);
 			equipmentDamageOrArmorValue.setText("Damage:" + player.equippedItems[0].getDamageValue());
 			itemPriceLabel.setVisible(true);
 			itemLabel.setVisible(true);
 			useItemButton.setText("Unequip:");
 			useItemButton.setActionCommand("unEquipItem");
 	        useItemButton.setVisible(true);
 	        closeItemButton.setVisible(true);
 	        player.setPlayerEquipmentIndex(player.equippedItems[0].getItemIndex());
 	        
 	        System.out.println(player.getPlayerEquipmentIndex());
 	        System.out.println("item found" + player.equippedItems[0].getName());
  
    	   }else if(player.equippedItems[0].getName().equals("")){
			System.out.println("no item selected");
		}

	        	
			break;
			
       case "inspectArmor":
    	   
    	   System.out.println("Attempting to inspect armor...");
    	  		   
    	   if (player.equippedItems[1].getEquipmentType().equals("Armor")){
    		   
   			itemLabel.setText("Item:" + player.equippedItems[1].getName());
   			itemPriceLabel.setText("Price:" + player.equippedItems[1].getPrice());
     	   
 			equipmentDamageOrArmorValue.setVisible(true);
 			equipmentDamageOrArmorValue.setText("Armor:" + player.equippedItems[1].getArmorValue());
 			itemPriceLabel.setVisible(true);
 			itemLabel.setVisible(true);
 			useItemButton.setText("Unequip:");
 			useItemButton.setActionCommand("unEquipItem");
 	        useItemButton.setVisible(true);
 	        closeItemButton.setVisible(true);
 	        player.setPlayerEquipmentIndex(player.equippedItems[1].getItemIndex());
 	        
 	        System.out.println(player.getPlayerEquipmentIndex());
 	        System.out.println("item found" + player.equippedItems[1].getName());
  
    	   }else if(player.equippedItems[1].getName().equals("")){
			System.out.println("no item selected");
		}

	        	
			break;
    	   
            
       case "closeItem":
    	   
    	   itemHealingValue.setVisible(false);
    	   itemPriceLabel.setVisible(false);
           itemLabel.setVisible(false); // Hide item label after using the item
           equipmentDamageOrArmorValue.setVisible(false);
           useItemButton.setVisible(false); // Hide useItemButton after using the item
           closeItemButton.setVisible(false);
           player.setPlayerItemIndex(-1);
           System.out.println(player.getPlayerItemIndex());
    	   break;
			
		}
	
	}
}