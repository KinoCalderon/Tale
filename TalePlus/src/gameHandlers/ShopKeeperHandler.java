package gameHandlers;

import gameNPC.TavernShopKeeperObject;
import main.Game;
import main.Player;
import gameUI.InventoryUI;
import gameUI.ShopKeeperUI;
import gameUI.UI;
import gameItems.SuperConsumable;
import gameItems.SuperItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static GameStates.GameState.goBackToPreviousState;
import static GameStates.GameState.pushStateAndSetCurrent;

public class ShopKeeperHandler implements ActionListener {
    private Game game;
    private Player player;
    private UI ui;
    private InventoryUI invoUI;
    private ShopKeeperUI shopKeeperUI;
    private TavernShopKeeperObject[] shopKeeperObjects = new TavernShopKeeperObject[1];


    public ShopKeeperHandler(Game game, Player player, UI ui,InventoryUI invoUI, ShopKeeperUI shopKeeperUI){
        this.game = game;
        this.player = player;
        this.ui = ui;
        this.invoUI = invoUI;
        this.shopKeeperUI = shopKeeperUI;


        TavernShopKeeperObject tavernShopKeeperObject = new TavernShopKeeperObject(game,player,ui);
        tavernShopKeeperObject.shopKeeperButton.addActionListener(this);
        tavernShopKeeperObject.shopKeeperButton.setActionCommand("ShopKeeperButton");
        AddShopKeeperToArray(tavernShopKeeperObject,0);

        shopKeeperUI.buyItemButton.addActionListener(this);
        shopKeeperUI.shopButtons[0].addActionListener(this);
        shopKeeperUI.shopButtons[1].addActionListener(this);
        shopKeeperUI.closeItemButton.addActionListener(this);
        shopKeeperUI.shopButtons[0].setText("Item1:" + tavernShopKeeperObject.getShopItems(0).getName());
        shopKeeperUI.shopButtons[1].setText("Item2:" + tavernShopKeeperObject.getShopItems(1).getName());


    }

    public void AddShopKeeperToArray(TavernShopKeeperObject shopKeeperObject, int i){
        shopKeeperObjects[i] = shopKeeperObject;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String yourChoice = e.getActionCommand();

        switch (yourChoice) {
            case"ShopKeeperButton":
                System.out.println("ShopKeeperButton is pressed");
                pushStateAndSetCurrent(game.tavernState, player);


                break;
            case"button0":
            ui.RemoveOutputTextPanelAddInfoPanel();

            System.out.println("shop button 0 pressed");

            for (int i = 0; i < shopKeeperObjects.length; i++) {

                if(shopKeeperObjects[i].getShopKeeperName().equals(player.getShopLocation())) {
                    System.out.println("inside");
                    if(shopKeeperObjects[i].getShopItems(0).getType().equals("Consumable")) {
                        SuperConsumable consumableItem = (SuperConsumable) shopKeeperObjects[i].getShopItems(0);
                        shopKeeperUI.itemLabel.setText("Item: " + consumableItem.getName());
                        shopKeeperUI.itemShopPriceLabel.setText("Price: " + consumableItem.getPrice());
                        shopKeeperUI.itemHealingValue.setText("Heals: " + consumableItem.getHealingValue());
                        shopKeeperUI.itemHealingValue.setVisible(true);
                        shopKeeperUI.itemShopPriceLabel.setVisible(true);
                        shopKeeperUI.itemLabel.setVisible(true);
                        shopKeeperUI.buyItemButton.setText("Buy:");
                        shopKeeperUI.buyItemButton.setActionCommand("buyItem");
                        shopKeeperUI.buyItemButton.setVisible(true);
                        shopKeeperUI.closeItemButton.setVisible(true);
                        shopKeeperUI.equipmentDamageOrArmorValue.setVisible(false);
                        invoUI.CloseInventoryUI();
                        ui.RemoveOutputTextPanelAddInfoPanel();

                        player.setShopItemIndex(0);
                        System.out.println("shop item index" + player.getShopItemIndex());

                    }
                    else if (shopKeeperObjects[i].getShopItems(0).getType().equals("Equipment")) {
                        SuperItem superItem = shopKeeperObjects[i].getShopItems(0);
                        shopKeeperUI.itemLabel.setText("Item: " + superItem.getName());
                        shopKeeperUI.itemShopPriceLabel.setText("Price: " + superItem.getPrice());
                        if(superItem.getItemIndex() == 0) {
                            shopKeeperUI.equipmentDamageOrArmorValue.setText("Damage: " + superItem.getDamageValue());
                        } else if(superItem.getItemIndex() == 1) {
                            shopKeeperUI.equipmentDamageOrArmorValue.setText("Armor: " + superItem.getArmorValue());

                        }
                        shopKeeperUI.itemShopPriceLabel.setVisible(true);
                        shopKeeperUI.itemLabel.setVisible(true);
                        shopKeeperUI.equipmentDamageOrArmorValue.setVisible(true);
                        shopKeeperUI.buyItemButton.setText("Buy:");
                        shopKeeperUI.buyItemButton.setActionCommand("buyItem");
                        shopKeeperUI.buyItemButton.setVisible(true);
                        shopKeeperUI.closeItemButton.setVisible(true);
                        shopKeeperUI.itemHealingValue.setVisible(false);
                        invoUI.CloseInventoryUI();
                        ui.RemoveOutputTextPanelAddInfoPanel();


                        player.setShopItemIndex(0);
                        player.setPlayerEquipmentIndex(superItem.getItemIndex());
                        System.out.println("shop item index" + player.getShopItemIndex());

                    }
                }
            }

            break;

            case "button1":
                ui.RemoveOutputTextPanelAddInfoPanel();

                System.out.println("shop button 1 pressed");
                for (int i = 0; i < shopKeeperObjects.length; i++) {

                    if(shopKeeperObjects[i].getShopKeeperName().equals(player.getShopLocation())) {

                        if(shopKeeperObjects[i].getShopItems(1).getType().equals("Consumable")) {
                            SuperConsumable consumableItem = (SuperConsumable) shopKeeperObjects[i].getShopItems(1);
                            shopKeeperUI.itemLabel.setText("Item: " + consumableItem.getName());
                            shopKeeperUI.itemShopPriceLabel.setText("Price: " + consumableItem.getPrice());
                            shopKeeperUI.itemHealingValue.setText("Heals: " + consumableItem.getHealingValue());
                            shopKeeperUI.itemHealingValue.setVisible(true);
                            shopKeeperUI.itemShopPriceLabel.setVisible(true);
                            shopKeeperUI.itemLabel.setVisible(true);
                            shopKeeperUI.buyItemButton.setText("Buy:");
                            shopKeeperUI.buyItemButton.setActionCommand("buyItem");
                            shopKeeperUI.buyItemButton.setVisible(true);
                            shopKeeperUI.closeItemButton.setVisible(true);
                            shopKeeperUI.equipmentDamageOrArmorValue.setVisible(false);
                            invoUI.CloseInventoryUI();
                            ui.RemoveOutputTextPanelAddInfoPanel();

                            player.setShopItemIndex(1);
                            System.out.println("shop item index" + player.getShopItemIndex());

                        }
                        else if (shopKeeperObjects[i].getShopItems(1).getType().equals("Equipment")) {
                            SuperItem superItem = shopKeeperObjects[i].getShopItems(1);
                            shopKeeperUI.itemLabel.setText("Item: " + superItem.getName());
                            shopKeeperUI.itemShopPriceLabel.setText("Price: " + superItem.getPrice());
                            if(superItem.getItemIndex() == 0) {
                                shopKeeperUI.equipmentDamageOrArmorValue.setText("Damage: " + superItem.getDamageValue());
                            } else if(superItem.getItemIndex() == 1) {
                                shopKeeperUI.equipmentDamageOrArmorValue.setText("Armor: " + superItem.getArmorValue());

                            }
                            shopKeeperUI.itemShopPriceLabel.setVisible(true);
                            shopKeeperUI.itemLabel.setVisible(true);
                            shopKeeperUI.equipmentDamageOrArmorValue.setVisible(true);
                            shopKeeperUI.buyItemButton.setText("Buy:");
                            shopKeeperUI.buyItemButton.setActionCommand("buyItem");
                            shopKeeperUI.buyItemButton.setVisible(true);
                            shopKeeperUI.closeItemButton.setVisible(true);
                            shopKeeperUI.itemHealingValue.setVisible(false);
                            invoUI.CloseInventoryUI();
                            ui.RemoveOutputTextPanelAddInfoPanel();


                            player.setShopItemIndex(1);
                            player.setPlayerEquipmentIndex(superItem.getItemIndex());
                            System.out.println("shop item index" + player.getShopItemIndex());

                        }
                    }
                }
                break;

            case "buyItem":

                System.out.println("check");
                for(int i = 0; i < player.inventoryItems.length; i++) {
                    System.out.println(player.inventoryItems[i].getName());
                }
                InventoryManager inventoryManager = new InventoryManager();
                //check if player inventory is full

                for (int i = 0; i < shopKeeperObjects.length; i++) {
                    if (shopKeeperObjects[i].getShopKeeperName().equals(player.getShopLocation())) {
                        if (inventoryManager.BuyItem(player, shopKeeperObjects[i].getShopItems(player.getShopItemIndex()))) {
                            System.out.println("attempting to sell player item..");

                            ui.goldLabel.setText(" Gold: " + player.getGold());
                            System.out.println("-" + shopKeeperObjects[i].getShopItems(player.getShopItemIndex()).getPrice() + "gold");
                            System.out.println(player.getGold());

                            invoUI.refreshInventoryButtons();//always!!
                            ui.RemoveInfoPanelAddOutputTextPanel();
                            ui.updateGameTextOutputArea(shopKeeperObjects[i].SellMessage(shopKeeperObjects[i].getShopItems(player.getShopItemIndex())));

                        } else {
                            ui.RemoveInfoPanelAddOutputTextPanel();
                            ui.updateGameTextOutputArea("Can't buy item");
                            System.out.println("out of gold or invo full*");

                        } {
                            System.out.println("end of buyItem case check");

                            System.out.println("shop item index" + player.getShopItemIndex());

                        }
                    }
                }

            break;

            case "closeItem":

                shopKeeperUI.CloseShopItemInfoUI();
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

