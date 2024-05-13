package gameHandlers;

import gameNPC.SuperShopKeeperObject;
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
import java.util.ArrayList;

import static GameStates.GameState.goBackToPreviousState;
import static GameStates.GameState.pushStateAndSetCurrent;

public class ShopKeeperHandler implements ActionListener {
    private Game game;
    private Player player;
    private UI ui;
    private InventoryUI invoUI;
    private ShopKeeperUI shopKeeperUI;
    private ArrayList<TavernShopKeeperObject> shopKeeperObjects = new ArrayList<>();


    public ShopKeeperHandler(Game game, Player player, UI ui,InventoryUI invoUI, ShopKeeperUI shopKeeperUI){
        this.game = game;
        this.player = player;
        this.ui = ui;
        this.invoUI = invoUI;
        this.shopKeeperUI = shopKeeperUI;


        TavernShopKeeperObject tavernShopKeeperObject = new TavernShopKeeperObject(game,player,ui);
        tavernShopKeeperObject.shopKeeperButton.addActionListener(this);
        tavernShopKeeperObject.shopKeeperButton.setActionCommand("ShopKeeperButton");
        AddShopKeeperToArray(tavernShopKeeperObject);

        shopKeeperUI.buyItemButton.addActionListener(this);
        shopKeeperUI.shopButtons[0].addActionListener(this);
        shopKeeperUI.shopButtons[1].addActionListener(this);
        shopKeeperUI.closeItemButton.addActionListener(this);
        shopKeeperUI.shopButtons[0].setText("Item1:" + tavernShopKeeperObject.getShopItems(0).getName());
        shopKeeperUI.shopButtons[1].setText("Item2:" + tavernShopKeeperObject.getShopItems(1).getName());


    }

    public void AddShopKeeperToArray(TavernShopKeeperObject shopKeeperObject){
        shopKeeperObjects.add(shopKeeperObject);

    }

    public SuperShopKeeperObject GetShopKeeperFromIndex(int i){
        return shopKeeperObjects.get(i);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String yourChoice = e.getActionCommand();

        switch (yourChoice) {
            case"ShopKeeperButton":
                shopKeeperObjects.get(0).shopKeeperButton.removeActionListener(this);
                System.out.println("ShopKeeperButton is pressed");
                pushStateAndSetCurrent(game.tavernState, player);


                break;
            case"button0":
            ui.RemoveOutputTextPanelAddInfoPanel();

            System.out.println("shop button 0 pressed");

            for (int i = 0; i < shopKeeperObjects.size(); i++) {

                if(shopKeeperObjects.get(i).getShopKeeperName().equals(player.getShopLocation())) {
                    System.out.println("inside");
                    if(shopKeeperObjects.get(i).getShopItems(0).getType().equals("Consumable")) {
                        SuperConsumable consumableItem = (SuperConsumable) shopKeeperObjects.get(i).getShopItems(0);
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
                    else if (shopKeeperObjects.get(i).getShopItems(0).getType().equals("Equipment")) {
                        SuperItem superItem = shopKeeperObjects.get(i).getShopItems(0);
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
                for (int i = 0; i < shopKeeperObjects.size(); i++) {

                    if(shopKeeperObjects.get(i).getShopKeeperName().equals(player.getShopLocation())) {

                        if(shopKeeperObjects.get(i).getShopItems(1).getType().equals("Consumable")) {
                            SuperConsumable consumableItem = (SuperConsumable) shopKeeperObjects.get(i).getShopItems(1);
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
                        else if (shopKeeperObjects.get(i).getShopItems(1).getType().equals("Equipment")) {
                            SuperItem superItem = shopKeeperObjects.get(i).getShopItems(1);
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

                for (int i = 0; i < shopKeeperObjects.size(); i++) {
                    if (shopKeeperObjects.get(i).getShopKeeperName().equals(player.getShopLocation())) {
                        if (inventoryManager.BuyItem(player, shopKeeperObjects.get(i).getShopItems(player.getShopItemIndex()))) {
                            System.out.println("attempting to sell player item..");

                            ui.goldLabel.setText(" Gold: " + player.getGold());
                            ui.hpPotLabel.setText(" Hp Pots: " + player.getHpPotionArray().size());
                            ui.mpPotLabel.setText(" Mp Pots: " + player.getMpPotionArray().size());
                            System.out.println("-" + shopKeeperObjects.get(i).getShopItems(player.getShopItemIndex()).getPrice() + "gold");
                            System.out.println(player.getGold());

                            invoUI.refreshInventoryButtons();//always!!
                            ui.RemoveInfoPanelAddOutputTextPanel();
                            ui.updateGameTextOutputArea(shopKeeperObjects.get(i).SellMessage(shopKeeperObjects.get(i).getShopItems(player.getShopItemIndex())));

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


            case "":
                System.out.println("already in tavern");
                break;
            default:
                throw new IllegalArgumentException("Unexpected value: " + yourChoice);
        }

    }
    }

