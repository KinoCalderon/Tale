package GameStates;

import package01.Game;
import package01.Player;
import package01.UI;

public class TownState extends GameState {

    public TownState(Game game, Player player, UI ui) {
        super(game, player, ui);
    }

    @Override
    public void update() {

        // Set the player's current state to this state
        game.player.setCurrentState(this);
        System.out.println(gameStateStack.peek());
    }

    @Override
    public void ui() {
        // Update the player's game screen and UI


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
    }

    @Override
    public void sound() {
        // TODO Auto-generated method stub
    }
}