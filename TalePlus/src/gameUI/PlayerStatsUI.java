package gameUI;

import main.Player;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.*;

public class PlayerStatsUI {
    Dimension buttonSize = new Dimension(30, 30); // Set the preferred size of buttons
    public Player player;
    public UI ui;
    public JButton increaseStrStatButton;
    public JButton decreaseStrStatButton;
    public JButton playerStatsScreenButton;
    public JPanel playerStatsPanel;
    public JLabel playerStrStatLabel;
    public JLabel playerDefStatLabel;

    public PlayerStatsUI(Player player, UI ui) {
        this.player = player;
        this.ui = ui;

        playerStatsPanel = new JPanel();
        playerStatsPanel.setBounds(200, 280, 100, 100);
        playerStatsPanel.setBackground(Color.magenta);
        playerStatsPanel.setVisible(false);
        playerStatsPanel.setBorder(ui.whiteline);        
        playerStatsPanel.setLayout(new FlowLayout(FlowLayout.LEFT));// Use FlowLayout for buttons

        //PLAYER STATS SCREEN BUTTON
        playerStatsScreenButton = new JButton("Stats");
        playerStatsScreenButton.setBackground(Color.black);
        playerStatsScreenButton.setForeground(Color.white);
        playerStatsScreenButton.setFont(ui.normalFont);
        playerStatsScreenButton.setFocusPainted(false);
        playerStatsScreenButton.setVisible(true);
        ui.playerPanel.add(playerStatsScreenButton);

        playerStrStatLabel = new JLabel(" Str: " + player.getStrengthStat() + "#");
        playerStrStatLabel.setForeground(Color.white);
        playerStrStatLabel.setFont(ui.statsFont);
        playerStatsPanel.add(playerStrStatLabel); // Add the label

        //increaseStrStatButton = new JButton("Increase Strength");
        //increaseStrStatButton.setPreferredSize(buttonSize);
        //playerStatsPanel.add(increaseStrStatButton); // Add the button

        //decreaseStrStatButton = new JButton("Decrease Strength"); // Corrected button text
        //decreaseStrStatButton.setPreferredSize(buttonSize); // Set preferred size
        //playerStatsPanel.add(decreaseStrStatButton); // Add the button
        
        playerDefStatLabel = new JLabel(" Def: " + player.getDefenceStat() + "#");
        playerDefStatLabel.setForeground(Color.white);
        playerDefStatLabel.setFont(ui.statsFont);
        playerStatsPanel.add(playerDefStatLabel); // Add the label

        ui.mainGraphicsPane.add(playerStatsPanel, JLayeredPane.DRAG_LAYER); // Add the panel to the UI
    }
    
    public void ClosePlayerStatsUI() {
    	playerStatsPanel.setVisible(false);
    }
}
