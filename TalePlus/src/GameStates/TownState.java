package GameStates;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import npc.TavernShopKeeper;
import package01.Game;
import package01.InventoryHandler;
import package01.Player;
import package01.UI;

public class TownState extends GameState implements ActionListener{

    public TownState(Game game, Player player, UI ui, InventoryHandler iHandler) {
        super(game, player, ui, iHandler);
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
    	ui.updateTextArea("Welcome to " + player.getCurrentState().getName());
    	ui.shopKeeperPanel.setVisible(false);
    	iHandler.CloseInventoryHandlerUi();
    	
    	ui.button1.setVisible(true);
    	ui.button1.setText("Tavern");
    	ui.button1.removeActionListener(this);
        ui.button1.addActionListener(this);
        ui.button4.setVisible(false);
        
        ui.playerStatsScreenButton.setVisible(true);
        ui.playerStatsScreenButton.removeActionListener(this);
        ui.playerStatsScreenButton.addActionListener(this);
        ui.playerStatsScreenButton.setActionCommand("playerStatsButton");
        
        
        //ui.playerStatsScreenButton.addActionListener(e -> {pushStateAndSetCurrent(game.playerStatsScreenState, player);});
        //iHandler.inventoryButton.addActionListener(e->{pushStateAndSetCurrent(game.playerInventoryState, player);});
        

        // Hide the title screen
        ui.titleNamePanel.setVisible(false);
        ui.startButtonPanel.setVisible(false);
        
        // Show the game screen 
        //ui.picturePanel.setLayout(new BorderLayout());
    	ui.picturePanel.setVisible(true);
        ui.pictureLabel.setVisible(false);
        ui.buttonPanel.setVisible(true);
        ui.masterPlayerPanel.setVisible(true);
        
        //hide potential left open panels
        iHandler.equipmentPanel.setVisible(false);
        iHandler.equipmentStatsPanel.setVisible(false);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String yourChoice = e.getActionCommand();
		
		switch(yourChoice) {
		case "tavernButton":
			System.out.println("button1 is pressed");
			pushStateAndSetCurrent(game.tavernState, player);
			
			break;
			
		case "playerStatsButton":
			System.out.println("Attempting to access PlayerStatsScreenState Switch Case*");
			System.out.println(player.getShopStatus());
			if(player.getShopStatus().equals("close")) {
			pushStateAndSetCurrent(game.playerStatsScreenState, player);
			} else {
				System.out.println("Sorry can't open PlayerStats*");
				System.out.println(player.getShopStatus());
			}
			break;
		}			
	}
}
		
	

