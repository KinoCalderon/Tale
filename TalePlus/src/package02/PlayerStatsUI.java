package package02;

import package01.Player;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayerStatsUI {
    Dimension buttonSize = new Dimension(30, 30); // Set the preferred size of buttons
    public Player player;
    public UI ui;
    public JButton increaseStrStatButton;
    public JButton decreaseStrStatButton;
    public JPanel playerStatsPanel;
    public JLabel playerStrStatLabel;
    public JLabel playerDefStatLabel;

    public PlayerStatsUI(Player player, UI ui) {
        this.player = player;
        this.ui = ui;

        playerStatsPanel = new JPanel();
        playerStatsPanel.setBounds(0, 1, 100, 410);
        playerStatsPanel.setBackground(Color.blue);
        playerStatsPanel.setVisible(false);
        playerStatsPanel.setBorder(ui.whiteline);        
        playerStatsPanel.setLayout(new FlowLayout(FlowLayout.LEFT));  // Use FlowLayout for buttons

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

        ui.picturePane.add(playerStatsPanel); // Add the panel to the UI
    }
    
    public void ClosePlayerStatsUI() {
    	playerStatsPanel.setVisible(false);
    }
}
