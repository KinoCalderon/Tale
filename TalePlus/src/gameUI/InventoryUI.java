package gameUI;

import main.Player;

import javax.swing.*;
import java.awt.*;

public class InventoryUI {
    Player player;
    UI ui;
    public JButton[] equipmentButtons = new JButton[2];
    public JButton[] inventoryButtons = new JButton[5];
    public JButton inventoryButton;
    public JButton useItemButton;
    public JButton closeItemButton;
    public JPanel inventoryPanel;
    public ImageIcon playerBagIcon;
    public JLabel itemLabel;
    public JLabel itemPriceLabel;
    public JLabel itemHealingValue;
    public JLabel equipmentDamageOrArmorValue;
    public JLabel damageLabel, armorLabel;
    public JLabel equipmentStatsLabel, equipmentLabel, inventoryLabel;
    public JPanel equipmentPanel;
    public JPanel equipmentStatsPanel;
    public JPanel equipmentInfoPopUpBoxPanel;

    public InventoryUI(Player player, UI ui){
        this.player = player;
        this.ui = ui;

        playerBagIcon = new ImageIcon(".//media//taleBag.png");
        inventoryButton = new JButton();
        inventoryButton.setIcon(playerBagIcon);
        inventoryButton.setBackground(Color.black);
        inventoryButton.setForeground(Color.white);
        inventoryButton.setFont(ui.statsFont);
        inventoryButton.setFocusPainted(false);
        inventoryButton.setBorderPainted(false);

        inventoryButton.setActionCommand("inventoryButton");
        inventoryButton.setSize(10, 10);
        ui.playerPanel.add(inventoryButton);

        //INVENTORY PANEL
        inventoryPanel = new JPanel();
        inventoryPanel.setBackground(Color.black);
        //inventoryPanel.setPreferredSize(new Dimension(330,420));
        inventoryPanel.setLayout(new GridLayout(6,1));
        inventoryPanel.setVisible(false);
        inventoryPanel.setBorder(ui.whiteline);
        inventoryPanel.setBounds(445, 1, 330, 350);
        ui.mainGraphicsPane.add(inventoryPanel, JLayeredPane.DRAG_LAYER);

        //INVENTORY LABEL
        inventoryLabel = new JLabel("                ---Inventory---");
        inventoryLabel.setForeground(Color.yellow);
        inventoryLabel.setVisible(true);
        inventoryLabel.setFont(ui.statsFont);
        inventoryPanel.add(inventoryLabel);

        //INVENTORY BUTTONS
        inventoryButtons[0] = new JButton();
        inventoryButtons[0].setBackground(Color.black);
        inventoryButtons[0].setForeground(Color.white);
        inventoryButtons[0].setFont(ui.normalFont);
        inventoryButtons[0].setFocusPainted(false);
        inventoryButtons[0].setActionCommand("item1");
        inventoryButtons[0].setName("inventoryButton1");

        inventoryButtons[1] = new JButton();
        inventoryButtons[1].setBackground(Color.black);
        inventoryButtons[1].setForeground(Color.white);
        inventoryButtons[1].setFont(ui.normalFont);
        inventoryButtons[1].setFocusPainted(false);
        inventoryButtons[1].setActionCommand("item2");
        inventoryButtons[1].setName("inventoryButton2");

        inventoryButtons[2] = new JButton("item3");
        inventoryButtons[2].setBackground(Color.black);
        inventoryButtons[2].setForeground(Color.white);
        inventoryButtons[2].setFont(ui.normalFont);
        inventoryButtons[2].setFocusPainted(false);
        inventoryButtons[2].setActionCommand("item3");
        inventoryButtons[2].setName("inventoryButton3");

        inventoryButtons[3] = new JButton("item4");
        inventoryButtons[3].setBackground(Color.black);
        inventoryButtons[3].setForeground(Color.white);
        inventoryButtons[3].setFont(ui.normalFont);
        inventoryButtons[3].setFocusPainted(false);
        inventoryButtons[3].setActionCommand("item4");
        inventoryButtons[3].setName("inventoryButton4");

        inventoryButtons[4] = new JButton("item5");
        inventoryButtons[4].setBackground(Color.black);
        inventoryButtons[4].setForeground(Color.white);
        inventoryButtons[4].setFont(ui.normalFont);
        inventoryButtons[4].setFocusPainted(false);
        inventoryButtons[4].setActionCommand("item5");
        inventoryButtons[4].setName("inventoryButton5");

        inventoryPanel.add(inventoryButtons[0]);
        inventoryPanel.add(inventoryButtons[1]);
        inventoryPanel.add(inventoryButtons[2]);
        inventoryPanel.add(inventoryButtons[3]);
        inventoryPanel.add(inventoryButtons[4]);

        itemLabel = new JLabel();
        itemLabel.setForeground(Color.white);
        itemLabel.setVisible(false);
        itemLabel.setFont(ui.statsFont);
        ui.infoPanel.add(itemLabel);

        itemPriceLabel = new JLabel();
        itemPriceLabel.setForeground(Color.white);
        itemPriceLabel.setVisible(false);
        itemPriceLabel.setFont(ui.statsFont);
        ui.infoPanel.add(itemPriceLabel);

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

        useItemButton = new JButton("Use:");
        useItemButton.setBackground(Color.black);
        useItemButton.setForeground(Color.white);
        useItemButton.setFont(ui.normalFont);
        useItemButton.setFocusPainted(false);

        useItemButton.setActionCommand("useItem");
        useItemButton.setVisible(false);
        ui.infoPanel.add(useItemButton);

        closeItemButton = new JButton("Close");
        closeItemButton.setBackground(Color.black);
        closeItemButton.setForeground(Color.white);
        closeItemButton.setFont(ui.normalFont);
        closeItemButton.setFocusPainted(false);

        closeItemButton.setActionCommand("closeItem");
        closeItemButton.setVisible(false);
        ui.infoPanel.add(closeItemButton);


        //EQUIPMENT PANEL
        equipmentPanel = new JPanel();
        //equipmentPanel.setPreferredSize(new Dimension(330,420));
        equipmentPanel.setBounds(0, 1, 330, 210);
        equipmentPanel.setBackground(Color.BLACK);
        equipmentPanel.setVisible(false);
        equipmentPanel.setBorder(ui.whiteline);
        equipmentPanel.setLayout(new GridLayout(3,2));
        ui.mainGraphicsPane.add(equipmentPanel, JLayeredPane.DRAG_LAYER);

        equipmentLabel = new JLabel("              ---Equipment---");
        equipmentLabel.setForeground(Color.yellow);
        equipmentLabel.setVisible(true);
        equipmentLabel.setFont(ui.statsFont);
        equipmentPanel.add(equipmentLabel);

        equipmentStatsPanel = new JPanel();
        //equipmentStatsPanel.setPreferredSize(new Dimension(330,120));
        equipmentStatsPanel.setBounds(0, 240, 330, 120);
        equipmentStatsPanel.setBackground(Color.black);
        equipmentStatsPanel.setVisible(false);
        equipmentStatsPanel.setBorder(ui.whiteline);
        equipmentStatsPanel.setLayout(new GridLayout(5,1));
        ui.mainGraphicsPane.add(equipmentStatsPanel, JLayeredPane.DRAG_LAYER);

        equipmentStatsLabel = new JLabel("        ---Equipment Bonus---");
        equipmentStatsLabel.setForeground(Color.yellow);
        equipmentStatsLabel.setVisible(true);
        equipmentStatsLabel.setFont(ui.statsFont);
        equipmentStatsPanel.add(equipmentStatsLabel);

        equipmentButtons[0] = new JButton("Weapon:" + player.equippedItems[0].getName());
        equipmentButtons[0].setBackground(Color.black);
        equipmentButtons[0].setForeground(Color.white);
        equipmentButtons[0].setFont(ui.normalFont);
        equipmentButtons[0].setFocusPainted(false);

        equipmentButtons[0].setActionCommand("inspectWeapon");
        equipmentButtons[0].setVisible(true);
        equipmentPanel.add(equipmentButtons[0]);

        equipmentButtons[1] = new JButton("Armor:" + player.equippedItems[1].getName());
        equipmentButtons[1].setBackground(Color.black);
        equipmentButtons[1].setForeground(Color.white);
        equipmentButtons[1].setFont(ui.normalFont);
        equipmentButtons[1].setFocusPainted(false);

        equipmentButtons[1].setActionCommand("inspectArmor");
        equipmentButtons[1].setVisible(true);
        equipmentPanel.add(equipmentButtons[1]);

        equipmentInfoPopUpBoxPanel = new JPanel();
        equipmentInfoPopUpBoxPanel.setLayout(null);
        equipmentInfoPopUpBoxPanel.setBounds(455, 200, 150, 100);
        equipmentInfoPopUpBoxPanel.setBackground(Color.pink);
        equipmentInfoPopUpBoxPanel.setBorder(ui.whiteline);
        equipmentInfoPopUpBoxPanel.setVisible(false);
        //equipmentInfoPopUpBoxPanel.addMouseListener(this);
        ui.mainGraphicsPane.add(equipmentInfoPopUpBoxPanel, JLayeredPane.DRAG_LAYER);


        damageLabel = new JLabel("Damage: " + player.getCurrentWeapon().getDamageValue());
        damageLabel.setForeground(Color.white);
        damageLabel.setVisible(true);
        damageLabel.setFont(ui.statsFont);
        equipmentStatsPanel.add(damageLabel);

        armorLabel = new JLabel("Armor: " + player.getCurrentArmor().getArmorValue());
        armorLabel.setForeground(Color.white);
        armorLabel.setVisible(true);
        armorLabel.setFont(ui.statsFont);
        equipmentStatsPanel.add(armorLabel);

    }

    public void refreshInventoryButtons(){
        for (int i = 0; i < player.inventoryItems.length; i++)
            inventoryButtons[i].setText(player.inventoryItems[i].getName());
    }

    public void CloseInventoryUI() {
        itemHealingValue.setVisible(false);
        itemPriceLabel.setVisible(false);
        itemLabel.setVisible(false); // Hide item label after using the item
        equipmentDamageOrArmorValue.setVisible(false);
        useItemButton.setVisible(false); // Hide useItemButton after using the item
        closeItemButton.setVisible(false);


    }

    public void CloseInventoryUIAbsolute(){

        inventoryPanel.setVisible(false);
        equipmentPanel.setVisible(false);
        equipmentStatsPanel.setVisible(false);

        itemHealingValue.setVisible(false);
        itemPriceLabel.setVisible(false);
        itemLabel.setVisible(false); // Hide item label after closing inventory
        equipmentDamageOrArmorValue.setVisible(false);
        useItemButton.setVisible(false); // Hide useItemButton after using the item
        closeItemButton.setVisible(false);
    }
}
