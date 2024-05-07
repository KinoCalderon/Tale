package gameHandlers;

import main.Game;
import main.Player;
import gameUI.PlayerStatsUI;
import gameUI.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static GameStates.GameState.*;

public class PlayerStatsHandler implements ActionListener {
    public Game game;
    public Player player;
    public UI ui;
    public PlayerStatsUI playerStatsUI;

    public PlayerStatsHandler(Game game, Player player, UI ui, PlayerStatsUI playerStatsUI){
        this.game = game;
        this.player = player;
        this.ui = ui;
        this.playerStatsUI = playerStatsUI;

        playerStatsUI.playerStatsScreenButton.addActionListener(this);
        playerStatsUI.playerStatsScreenButton.setActionCommand("playerStatsButton");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String yourChoice = e.getActionCommand();

        switch (yourChoice){
            case"playerStatsButton":

                System.out.println("Attempting to access PlayerStatsScreenState Switch Case*");
                System.out.println(player.getShopStatus());
                if(player.getShopStatus().equals("close") || player.getStatScreenStatus().equals("close")) {
                    pushStateAndSetCurrent(game.playerStatsScreenState, player);
                    //playerStatsUI.playerStatsScreenButton.addActionListener(null);
                    playerStatsUI.playerStatsScreenButton.setActionCommand(null);
                    player.setStatScreenStatus("open");
                }
                else if (player.getStatScreenStatus().equals("open")){
                    System.out.println("Sorry playerStats already open");
                    System.out.println(player.getShopStatus());
                }

                break;

            case "exitStatsScreen":
                System.out.println("exited stats screen* " + getCurrentState());
                goBackToPreviousState(player);
                playerStatsUI.playerStatsScreenButton.setActionCommand("playerStatsButton");
                playerStatsUI.ClosePlayerStatsUI();
                player.setStatScreenStatus("close");
                break;
        }
    }
}
