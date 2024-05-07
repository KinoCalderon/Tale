package gameUI;

import main.Game;
import main.Player;

import javax.swing.*;
import java.awt.*;

public class ShopKeeperUI {
    public Game game;
    public Player player;
    public UI ui;
    public InventoryUI invoUI;
    public JButton[] shopButtons = new JButton[2];
    public JLabel itemLabel;
    public JLabel itemShopPriceLabel;
    public JLabel itemHealingValue;
    public JLabel equipmentDamageOrArmorValue;
    public JButton buyItemButton;
    public JButton closeItemButton;
    public JPanel shopKeeperPanel;
    public JLabel shopNameLabel;

    public ShopKeeperUI(Game game, Player player, UI ui, InventoryUI invoUI){
        this.game = game;
        this.player = player;
        this.ui = ui;
        this.invoUI = invoUI;

        shopKeeperPanel = new JPanel();
        shopKeeperPanel.setBounds(0, 1, 330, 350);
        shopKeeperPanel.setBackground(Color.black);
        shopKeeperPanel.setVisible(false);
        shopKeeperPanel.setBorder(ui.whiteline);
        shopKeeperPanel.setLayout(new GridLayout(5,1));
        ui.mainGraphicsPane.add(shopKeeperPanel, JLayeredPane.DRAG_LAYER);

        shopNameLabel = new JLabel("Tavern Shop");
        shopNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        shopNameLabel.setForeground(Color.orange);
        shopNameLabel.setVisible(true);
        shopNameLabel.setFont(ui.normalFont);
        shopKeeperPanel.add(shopNameLabel);

        shopButtons[0] = new JButton();
        shopButtons[0].setBackground(Color.black);
        shopButtons[0].setForeground(Color.white);
        shopButtons[0].setFont(ui.normalFont);
        shopButtons[0].setFocusPainted(false);
        shopButtons[0].setActionCommand("button0");
        shopButtons[0].setVisible(true);
        shopKeeperPanel.add(shopButtons[0]);

        shopButtons[1] = new JButton();
        shopButtons[1].setBackground(Color.black);
        shopButtons[1].setForeground(Color.white);
        shopButtons[1].setFont(ui.normalFont);
        shopButtons[1].setFocusPainted(false);
        shopButtons[1].setActionCommand("button1");
        shopButtons[1].setVisible(true);
        shopKeeperPanel.add(shopButtons[1]);

        itemLabel = new JLabel();
        itemLabel.setForeground(Color.white);
        itemLabel.setVisible(false);
        itemLabel.setFont(ui.statsFont);
        ui.infoPanel.add(itemLabel);

        itemShopPriceLabel = new JLabel();
        itemShopPriceLabel.setForeground(Color.white);
        itemShopPriceLabel.setVisible(false);
        itemShopPriceLabel.setFont(ui.statsFont);
        ui.infoPanel.add(itemShopPriceLabel);

        itemHealingValue = new JLabel();
        itemHealingValue.setForeground(Color.white);
        itemHealingValue.setVisible(false);
        itemHealingValue.setFont(ui.statsFont);
        ui.infoPanel.add(itemHealingValue);

        equipmentDamageOrArmorValue = new JLabel();
        equipmentDamageOrArmorValue.setForeground(Color.white);
        equipmentDamageOrArmorValue.setVisible(false);
        equipmentDamageOrArmorValue.setFont(ui.statsFont);
        ui.infoPanel.add(equipmentDamageOrArmorValue);

        buyItemButton = new JButton();
        buyItemButton.setBackground(Color.black);
        buyItemButton.setForeground(Color.white);
        buyItemButton.setFont(ui.normalFont);
        buyItemButton.setFocusPainted(false);
        buyItemButton.setActionCommand("buyItem");
        buyItemButton.setVisible(false);
        ui.infoPanel.add(buyItemButton);

        closeItemButton = new JButton("Close");
        closeItemButton.setBackground(Color.black);
        closeItemButton.setForeground(Color.white);
        closeItemButton.setFont(ui.normalFont);
        closeItemButton.setFocusPainted(false);
        closeItemButton.setActionCommand("closeItem");
        closeItemButton.setVisible(false);
        ui.infoPanel.add(closeItemButton);



    }

    public void CloseShopItemInfoUI() {

        itemHealingValue.setVisible(false);
        itemShopPriceLabel.setVisible(false);
        itemLabel.setVisible(false); // Hide item label after using the item
        equipmentDamageOrArmorValue.setVisible(false);
        buyItemButton.setVisible(false); // Hide useItemButton after using the item
        closeItemButton.setVisible(false);
    }
}
