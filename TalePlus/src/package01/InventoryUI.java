package package01;

import javax.swing.*;
import java.awt.*;

public class InventoryUI {

    public JButton[] equipmentButtons = new JButton[2];
    public JButton inventoryButton, inventoryButton1, inventoryButton2, inventoryButton3, inventoryButton4, inventoryButton5;
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
        inventoryPanel.setBounds(445, 1, 330, 420);
        ui.picturePane.add(inventoryPanel, JLayeredPane.DEFAULT_LAYER);

        //INVENTORY LABEL
        inventoryLabel = new JLabel("                ---Inventory---");
        inventoryLabel.setForeground(Color.yellow);
        inventoryLabel.setVisible(true);
        inventoryLabel.setFont(ui.statsFont);
        inventoryPanel.add(inventoryLabel);

        //INVENTORY BUTTONS
        inventoryButton1 = new JButton();
        inventoryButton1.setBackground(Color.black);
        inventoryButton1.setForeground(Color.white);
        inventoryButton1.setFont(ui.normalFont);
        inventoryButton1.setFocusPainted(false);

        inventoryButton1.setActionCommand("item1");

        inventoryButton2 = new JButton();
        inventoryButton2.setBackground(Color.black);
        inventoryButton2.setForeground(Color.white);
        inventoryButton2.setFont(ui.normalFont);
        inventoryButton2.setFocusPainted(false);

        inventoryButton2.setActionCommand("item2");

        inventoryButton3 = new JButton();
        inventoryButton3.setBackground(Color.black);
        inventoryButton3.setForeground(Color.white);
        inventoryButton3.setFont(ui.normalFont);
        inventoryButton3.setFocusPainted(false);

        inventoryButton3.setActionCommand("item3");

        inventoryButton4 = new JButton();
        inventoryButton4.setBackground(Color.black);
        inventoryButton4.setForeground(Color.white);
        inventoryButton4.setFont(ui.normalFont);
        inventoryButton4.setFocusPainted(false);

        inventoryButton4.setActionCommand("item4");

        inventoryButton5 = new JButton();
        inventoryButton5.setBackground(Color.black);
        inventoryButton5.setForeground(Color.white);
        inventoryButton5.setFont(ui.normalFont);
        inventoryButton5.setFocusPainted(false);

        inventoryButton5.setActionCommand("item5");

        inventoryPanel.add(inventoryButton1);
        inventoryPanel.add(inventoryButton2);
        inventoryPanel.add(inventoryButton3);
        inventoryPanel.add(inventoryButton4);
        inventoryPanel.add(inventoryButton5);

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
        ui.picturePane.add(equipmentPanel, JLayeredPane.DEFAULT_LAYER);

        equipmentLabel = new JLabel("              ---Equipment---");
        equipmentLabel.setForeground(Color.yellow);
        equipmentLabel.setVisible(true);
        equipmentLabel.setFont(ui.statsFont);
        equipmentPanel.add(equipmentLabel);

        equipmentStatsPanel = new JPanel();
        //equipmentStatsPanel.setPreferredSize(new Dimension(330,120));
        equipmentStatsPanel.setBounds(0, 240, 330, 180);
        equipmentStatsPanel.setBackground(Color.black);
        equipmentStatsPanel.setVisible(false);
        equipmentStatsPanel.setBorder(ui.whiteline);
        equipmentStatsPanel.setLayout(new GridLayout(5,1));
        ui.picturePane.add(equipmentStatsPanel, JLayeredPane.DEFAULT_LAYER);

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
        ui.picturePane.add(equipmentInfoPopUpBoxPanel, JLayeredPane.DRAG_LAYER);


        damageLabel = new JLabel("Damage:" + player.getCurrentWeapon().getDamageValue());
        damageLabel.setForeground(Color.white);
        damageLabel.setVisible(true);
        damageLabel.setFont(ui.statsFont);
        equipmentStatsPanel.add(damageLabel);

        armorLabel = new JLabel("Armor:" + player.getCurrentArmor().getArmorValue());
        armorLabel.setForeground(Color.white);
        armorLabel.setVisible(true);
        armorLabel.setFont(ui.statsFont);
        equipmentStatsPanel.add(armorLabel);

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
