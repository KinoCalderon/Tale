package GameStates;

import npc.TavernShopKeeper;
import package01.Game;
import package01.InventoryHandler;
import package01.Player;
import package01.UI;

public class TownState extends GameState {

    public TownState(Game game, Player player, UI ui, InventoryHandler iHandler) {
        super(game, player, ui, iHandler);
        
    }

    @Override
    public void update() {

        // Set the player's current state to this state
        game.player.setCurrentState(this);
        System.out.println(gameStateStack.peek());
        player.setShopStatus("close");
        System.out.println(player.getShopStatus());
        
    }

    @Override
    public void ui() {
        // Update the player's game screen and UI
    	ui.shopKeeperPanel.setVisible(false);
    	
    	ui.button1.setText("Tavern");
        ui.button1.addActionListener(e -> {pushStateAndSetCurrent(game.tavernState);});

        // Hide the title screen
        ui.titleNamePanel.setVisible(false);
        ui.startButtonPanel.setVisible(false);
        
        // Show the game screen 
    	ui.picturePanel.setVisible(true);
        ui.pictureLabel.setVisible(false);
        ui.buttonPanel.setVisible(true);
        ui.masterPlayerPanel.setVisible(true);
        
        //hide potential left open panels
        iHandler.inventoryPanel.setVisible(false);
        iHandler.itemHealingValue.setVisible(false);
        iHandler.itemPriceLabel.setVisible(false);
        iHandler.itemLabel.setVisible(false); // Hide item label after using the item
        iHandler.equipmentDamageOrArmorValue.setVisible(false);
        iHandler.useItemButton.setVisible(false); // Hide useItemButton after using the item
        iHandler.closeItemButton.setVisible(false);
        
    }

    @Override
    public void sound() {
        // TODO Auto-generated method stub
    }
}