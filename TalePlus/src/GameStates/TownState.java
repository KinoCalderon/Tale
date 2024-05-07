package GameStates;

import main.*;
import gameUI.InventoryUI;
import gameUI.UI;

public class TownState extends GameState{


    public TownState(Game game, Player player, UI ui, InventoryUI invoUI) {
        super(game, player, ui, invoUI);
        setName("TownState");


        
    }

    @Override
    public void update() {
    	System.out.println(GameState.getGameStateStack() + " GAME STATE STACK INSIDE TOWN STATE*");
        System.out.println(getGameStateStack().peek()+" inside townstate*");
        

    }

    @Override
    public void ui() {
        // Update the player's game screen and UI
    	ui.RemoveInfoPanelAddOutputTextPanel();
    	ui.updateGameTextOutputArea("Welcome to " + player.getCurrentState().getName());
    	//ui.shopKeeperPanel.setVisible(false);
    	invoUI.CloseInventoryUI();

        // Hide the title screen
        ui.titleNamePanel.setVisible(false);
        ui.startButtonPanel.setVisible(false);
        
        // Show the game screen 

        ui.toggleMainGraphicsPanelVisibility(true);
        ui.buttonPanel.setVisible(true);
        ui.masterPlayerPanel.setVisible(true);
        
        //hide potential left open panels
        invoUI.equipmentPanel.setVisible(false);
        invoUI.equipmentStatsPanel.setVisible(false);
        invoUI.inventoryPanel.setVisible(false);
        invoUI.itemHealingValue.setVisible(false);
        invoUI.itemPriceLabel.setVisible(false);
        invoUI.itemLabel.setVisible(false); // Hide item label after using the item
        invoUI.equipmentDamageOrArmorValue.setVisible(false);
        invoUI.useItemButton.setVisible(false); // Hide useItemButton after using the item
        invoUI.closeItemButton.setVisible(false);
        
    }

    @Override
    public void sound() {
        // TODO Auto-generated method stub
    }

}

		
	

