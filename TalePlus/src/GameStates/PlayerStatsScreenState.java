package GameStates;

import main.*;
import gameUI.PlayerStatsUI;
import gameUI.UI;
import gameHandlers.PlayerStatsHandler;

public class PlayerStatsScreenState extends GameState {

	public PlayerStatsScreenState(Game game, Player player, UI ui, PlayerStatsHandler sHandler, PlayerStatsUI playerStatsUI) {
		super(game, player, ui, sHandler, playerStatsUI);
		setName("PlayerStatsState");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println(getGameStateStack() + "GAME STATE STACK INSIDE PLAYER STATS SCREEN STATE");
		
		playerStatsUI.playerStatsScreenButton.setVisible(true);
		System.out.println("*Players Current GameState " + player.getCurrentState());
		
		System.out.println("*Made it inside playerStats if loop " + getCurrentState());
        //System.out.println(player.toString());
        System.out.println(getGameStateStack());
        System.out.println(getGameStateStack().peek());
        
		
	}

	@Override
	public void ui() {
		// TODO Auto-generated method stub
		
		ui.button1.setVisible(false);
		ui.button4.setText("Exit");
		ui.button4.setVisible(true);
		//ui.button4.addActionListener(e -> {goBackToPreviousState(); playerStatsUI.ClosePlayerStatsUI(); ui.playerStatsScreenButton.setVisible(true);
		//System.out.println(getGameStateStack());});
		ui.button4.removeActionListener(sHandler);
		ui.button4.addActionListener(sHandler);
		ui.button4.setActionCommand("exitStatsScreen");
		playerStatsUI.playerStatsPanel.setVisible(true);
		System.out.println("*Made it inside PlayerStatsUI");
		//ui.playerStatsScreenButton.setActionCommand("statsButton");
		
		
		
	}

	@Override
	void sound() {
		// TODO Auto-generated method stub
		
	}

}
