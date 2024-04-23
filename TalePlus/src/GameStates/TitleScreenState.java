package GameStates;

import package01.Game;
import package01.Player;
import package01.UI;

public class TitleScreenState extends GameState {
    
    public TitleScreenState(Game game, Player player, UI ui) {
        super(game, player, ui);
    }
    
    @Override
    public void update() {
        // Set the current state to this state
       // setCurrentState(this);
        // Push this state onto the game state stack
       // pushGameState(this);
        // Set the player's current state to this state
        player.setCurrentState(this);
        System.out.println(gameStateStack.peek());

    }

    @Override
    public void ui() {
        // Show the title and start button panels 
        ui.titleNamePanel.setVisible(true);
        ui.startButtonPanel.setVisible(true);
        // Hide the main text, player, and choice button panels
                
        // Add an action listener to the start button
        ui.startButton.addActionListener(e -> {
        	
            // Create a new TownState and push it onto the game state stack
        	pushStateAndSetCurrent(game.townState);

        });
    }

    @Override
    public void sound() {
        // TODO Auto-generated method stub
    }
}