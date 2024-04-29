package GameStates;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import package01.Game;
import package01.InventoryHandler;
import package01.Player;
import package01.UI;
import package01.PlayerStatsUI;

public class PlayerStatsScreenState extends GameState implements ActionListener {

	public PlayerStatsScreenState(Game game, Player player, UI ui, InventoryHandler iHandler, PlayerStatsUI playerStatsUI) {
		super(game, player, ui, iHandler, playerStatsUI);
		setName("PlayerStatsState");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println(getGameStateStack() + "GAME STATE STACK INSIDE PLAYER STATS SCREEN STATE");
		
		ui.playerStatsScreenButton.setVisible(true);
		System.out.println("*Players Current GameState " + player.getCurrentState());
		
		System.out.println("*Made it inside playerStats if loop " + getCurrentState());
        //System.out.println(player.toString());
        System.out.println(getGameStateStack());
        System.out.println(getGameStateStack().peek());
        
		
	}

	@Override
	public void ui() {
		// TODO Auto-generated method stub
		ui.playerStatsScreenButton.removeActionListener(this);
		ui.playerStatsScreenButton.addActionListener(this);
		ui.playerStatsScreenButton.setActionCommand("statsButton");
		
		ui.button1.setVisible(false);
		ui.button4.setText("Exit");
		ui.button4.setVisible(true);
		//ui.button4.addActionListener(e -> {goBackToPreviousState(); playerStatsUI.ClosePlayerStatsUI(); ui.playerStatsScreenButton.setVisible(true);
		//System.out.println(getGameStateStack());});
		ui.button4.removeActionListener(this);
		ui.button4.addActionListener(this);
		ui.button4.setActionCommand("exitStatsScreen");
		playerStatsUI.playerStatsPanel.setVisible(true);
		System.out.println("*Made it inside PlayerStatsUI");
		//ui.playerStatsScreenButton.setActionCommand("statsButton");
		
		
		
	}

	@Override
	void sound() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String yourChoice = e.getActionCommand();
		
		switch (yourChoice) {
		case "statsButton": 

			System.out.println("STATS PANEL ALREADY OPEN*");
			
			break;
			
		case "exitStatsScreen":
			System.out.println("exited stats screen* " + getCurrentState());
			ui.button4.removeActionListener(this);
			goBackToPreviousState(player);
			playerStatsUI.ClosePlayerStatsUI();
			break;
		}
		
	}

}
