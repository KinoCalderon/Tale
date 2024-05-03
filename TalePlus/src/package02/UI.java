package package02;

import package01.Game;
import package01.Player;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.Border;


public class UI {
    public Border whiteline = BorderFactory.createLineBorder(Color.white);
    public Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    public Font normalFont = new Font("Times New Roman", Font.PLAIN, 25);
    public Font statsFont = new Font("Times New Roman", Font.PLAIN, 20);
    public Font gameOutputFont = new Font("Italic", Font.ITALIC, 20);
   
    public JFrame frame;
    
    public JPanel shopKeeperPanel;
    public JPanel titleNamePanel, startButtonPanel;
    public JPanel masterPlayerPanel;
    public JPanel playerPanel;
    public JPanel infoPanel;
    public JPanel buttonPanel;
    //public JPanel picturePanel;
	public JLayeredPane picturePane;
    public JPanel sellMessagePanel;
    public JPanel gameOutputTextPanel;
    
    public JLabel pictureLabel;
	public JLabel titleNameLabel;
	
	public JButton startButton ;
	public JButton button1, button2, button3, button4;
	
	public ImageIcon image;
	public JLabel hpLabel, expLabel, levelLabel, goldLabel, mpLabel;
	
	public JButton[] shopButtons = new JButton[2];
	public JLabel itemLabel;
	public JLabel itemShopPriceLabel;
	public JLabel itemHealingValue;
	public JLabel equipmentDamageOrArmorValue;
	public JButton buyItemButton;
	public JButton closeItemButton;
	public JButton playerStatsScreenButton;
	
	public JLabel soldItemMessage;
	
	
	public Player player;
	public Game game;
	public JScrollPane scrollPane;
	private final JTextArea gameTextOutputArea;


	
	public UI (Player player, Game game) {
		this.player = player;
		this.game = game;
	
		
        // Main frame
        frame = new JFrame();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.black);
        frame.setResizable(false);
        
    	//TITLE SCREEN PANEL
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100,100,600,500);
		titleNamePanel.setBackground(Color.black);
		
		//TITLE SCREEN LABEL
		titleNameLabel = new JLabel("TALE");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);
		titleNamePanel.add(titleNameLabel);
		
		//START BUTTON PANEL
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300,400,200,100);
		startButtonPanel.setBackground(Color.black);
		
		//START BUTTON
		startButton = new JButton("START");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(normalFont);
		startButton.setBorderPainted(true);
		startButton.setFocusPainted(false);
		startButton.addActionListener(null);
		startButtonPanel.add(startButton);
		frame.add(startButtonPanel);
		frame.add(titleNamePanel);

        // MASTER PANEL FOR THE PLAYER MAP AND INFO TO GO ON
        masterPlayerPanel = new JPanel();
        masterPlayerPanel.setLayout(new BoxLayout(masterPlayerPanel, BoxLayout.X_AXIS));
        masterPlayerPanel.setBounds(5, 425, 775, 130);
        masterPlayerPanel.setBackground(Color.black);
        masterPlayerPanel.setVisible(false);
        frame.add(masterPlayerPanel);

        // PLAYER PANEL ON THE BOTTOM LEFT
        playerPanel = new JPanel();
        playerPanel.setPreferredSize(new Dimension(237, 130)); // reduced size to accommodate space for mappanel
        playerPanel.setBackground(Color.black);
        playerPanel.setBorder(whiteline);
        playerPanel.setLayout(new GridLayout(3,3));
        masterPlayerPanel.add(playerPanel);
        
        //PLAYER LABELS 
        levelLabel = new JLabel(" LvL: " + player.getLevel());
        levelLabel.setForeground(Color.white);
        levelLabel.setVisible(true);
        levelLabel.setFont(statsFont);
        playerPanel.add(levelLabel);
        
        hpLabel = new JLabel("HP: "+ player.getCurrentHp() +"/"+ player.getMaxHp());
        hpLabel.setForeground(Color.white);
        hpLabel.setVisible(true);
        hpLabel.setFont(statsFont);
        playerPanel.add(hpLabel);
        
        expLabel = new JLabel(" Exp: " + player.getCurrentExp() + "/" + player.getMaxExp());
        expLabel.setForeground(Color.white);
        expLabel.setVisible(true);
        expLabel.setFont(statsFont);
        playerPanel.add(expLabel);
        
        mpLabel = new JLabel("MP: " + player.getCurrentMp() + "/" + player.getMaxMp());
        mpLabel.setForeground(Color.white);
        mpLabel.setVisible(true);
        mpLabel.setFont(statsFont);
        playerPanel.add(mpLabel);
        
        goldLabel = new JLabel(" Gold: " + player.getGold());
        goldLabel.setForeground(Color.white);
        goldLabel.setVisible(true);
        goldLabel.setFont(statsFont);
        playerPanel.add(goldLabel);
        
        
        
        //BUTTON PANEL IN THE BOTTOM MIDDLE
        buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(20, 123)); // updated size
        buttonPanel.setLayout(new GridLayout(4,1));
        buttonPanel.setBackground(Color.black);
        buttonPanel.setBorder(whiteline);
        masterPlayerPanel.add(buttonPanel);
        
        //BUTTON PANEL BUTTONS
        button1 = new JButton();
		button1.setBackground(Color.black);
		button1.setForeground(Color.white);
		button1.setFont(normalFont);
		button1.setFocusPainted(false);
		button1.addActionListener(null);
		button1.setActionCommand("tavernButton");
		
		buttonPanel.add(button1);
		
        button2 = new JButton();
		button2.setBackground(Color.black);
		button2.setForeground(Color.white);
		button2.setFont(normalFont);
		button2.setFocusPainted(false);
		button2.addActionListener(null);
		buttonPanel.add(button2);
		
        button3 = new JButton();
		button3.setBackground(Color.black);
		button3.setForeground(Color.white);
		button3.setFont(normalFont);
		button3.setFocusPainted(false);
		button3.addActionListener(null);
		buttonPanel.add(button3);
		
        button4 = new JButton();
		button4.setBackground(Color.black);
		button4.setForeground(Color.white);
		button4.setFont(normalFont);
		button4.setFocusPainted(false);
		button4.addActionListener(null);
		buttonPanel.add(button4);

		

        // INFO PANEL ON THE BOTTOM RIGHT
        infoPanel = new JPanel();
        infoPanel.setPreferredSize(new Dimension(237, 130)); // reduced size to accommodate space for mappanel
        infoPanel.setBackground(Color.black);
        infoPanel.setBorder(whiteline);
        infoPanel.setLayout(new GridLayout(4,2));
        //infoPanel.setLayout(null);
        masterPlayerPanel.add(infoPanel);
        

        
        // MAIN PANEL THAT TAKES UP THE REST OF THE SCREEN
        picturePane = new JLayeredPane();
        picturePane.setLayout(null);
        picturePane.setBounds(5, 1, 775, 420);
        picturePane.setBackground(Color.black);
        picturePane.setBorder(whiteline);
		picturePane.setVisible(false);
        frame.add(picturePane);
 

        // PICTURE LABEL AND IMAGE IMPORT
        image = new ImageIcon("./media/town.jpg");
        System.out.println("Image width: " + image.getIconWidth() + ", height: " + image.getIconHeight()); // Check image dimensions
        pictureLabel = new JLabel(image);
        pictureLabel.setBounds(0, 0, image.getIconWidth(), image.getIconHeight()); // Set label bounds to match image size
        picturePane.add(pictureLabel);
        pictureLabel.setVisible(false);
        System.out.println("Picture label added: " + pictureLabel.isVisible()); // Check if picture label is added and visible

        
        
	    shopKeeperPanel = new JPanel();
	    shopKeeperPanel.setBounds(0, 1, 330, 410);
	    shopKeeperPanel.setBackground(Color.black);
	    shopKeeperPanel.setVisible(false);
	    shopKeeperPanel.setBorder(whiteline);
	    shopKeeperPanel.setLayout(new GridLayout(5,1));
	    picturePane.add(shopKeeperPanel);
	    
	    shopButtons[0] = new JButton();
	    shopButtons[0].setBackground(Color.black);
	    shopButtons[0].setForeground(Color.white);
	    shopButtons[0].setFont(normalFont);
	    shopButtons[0].setFocusPainted(false);
	    shopButtons[0].setActionCommand("button0");
	    shopButtons[0].setVisible(true);
	    shopKeeperPanel.add(shopButtons[0]);
	    
	    shopButtons[1] = new JButton();
	    shopButtons[1].setBackground(Color.black);
	    shopButtons[1].setForeground(Color.white);
	    shopButtons[1].setFont(normalFont);
	    shopButtons[1].setFocusPainted(false);
	    shopButtons[1].setActionCommand("button1");
	    shopButtons[1].setVisible(true);
	    shopKeeperPanel.add(shopButtons[1]);

	    
		itemLabel = new JLabel();
	    itemLabel.setForeground(Color.white);
	    itemLabel.setVisible(false);
	    itemLabel.setFont(statsFont);
		infoPanel.add(itemLabel);
	    
		itemShopPriceLabel = new JLabel();
		itemShopPriceLabel.setForeground(Color.white);
		itemShopPriceLabel.setVisible(false);
		itemShopPriceLabel.setFont(statsFont);
		infoPanel.add(itemShopPriceLabel);
		
		itemHealingValue = new JLabel();
		itemHealingValue.setForeground(Color.white);
		itemHealingValue.setVisible(false);
		itemHealingValue.setFont(statsFont);
		infoPanel.add(itemHealingValue);
	    
		equipmentDamageOrArmorValue = new JLabel();
		equipmentDamageOrArmorValue.setForeground(Color.white);
		equipmentDamageOrArmorValue.setVisible(false);
		equipmentDamageOrArmorValue.setFont(statsFont);
		infoPanel.add(equipmentDamageOrArmorValue);
	    
		buyItemButton = new JButton();
		buyItemButton.setBackground(Color.black);
		buyItemButton.setForeground(Color.white);
		buyItemButton.setFont(normalFont);
	    buyItemButton.setFocusPainted(false);
	    buyItemButton.setActionCommand("buyItem");
	    buyItemButton.setVisible(false);
	    infoPanel.add(buyItemButton);
	    
	    
	    
	    closeItemButton = new JButton("Close");
	    closeItemButton.setBackground(Color.black);
	    closeItemButton.setForeground(Color.white);
	    closeItemButton.setFont(normalFont);
	    closeItemButton.setFocusPainted(false);    
	    closeItemButton.setActionCommand("closeItem");
	    closeItemButton.setVisible(false);
	    infoPanel.add(closeItemButton);
	    
	    
	    //PLAYER STATS SCREEN BUTTON
	    playerStatsScreenButton = new JButton("Stats");
	    playerStatsScreenButton.setBackground(Color.black);
	    playerStatsScreenButton.setForeground(Color.white);
	    playerStatsScreenButton.setFont(normalFont);
	    playerStatsScreenButton.setFocusPainted(false);    
	    playerStatsScreenButton.setActionCommand("");
	    playerStatsScreenButton.setVisible(true);
	    
	    gameOutputTextPanel = new JPanel();
	    gameOutputTextPanel.setPreferredSize(new Dimension(237, 130)); // reduced size to accommodate space for mappanel
	    gameOutputTextPanel.setBackground(Color.black);
	    gameOutputTextPanel.setBorder(whiteline);
	    gameOutputTextPanel.setLayout(null);
        //masterPlayerPanel.add(gameOutputTextPanel);
	    
	    
	 // Initialize JTextArea
	    gameTextOutputArea = new JTextArea();
	    gameTextOutputArea.setEditable(false); // Set text area as non-editable
	    gameTextOutputArea.setLineWrap(true); // Enable line wrapping
	    gameTextOutputArea.setWrapStyleWord(true); // Wrap at word boundaries
	    gameTextOutputArea.setFont(gameOutputFont);
	    gameTextOutputArea.setForeground(Color.white);
	    gameTextOutputArea.setVisible(true);
	    gameTextOutputArea.setBackground(Color.black);
	    gameTextOutputArea.setBounds(5, 5, 290, 120);

	    // Initialize JScrollPane and add JTextArea to it
	    scrollPane = new JScrollPane(gameTextOutputArea);
	    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // Always show vertical scroll bar
	    scrollPane.setBounds(5, 5, 320, 120); // Adjust bounds as needed
	    scrollPane.getVerticalScrollBar().setUI(new CustomScrollBarUI());
	    
	    // Add JScrollPane to infoPanel
	    gameOutputTextPanel.add(scrollPane);
	    infoPanel.setVisible(true);


	    playerPanel.add(playerStatsScreenButton);
	    
        frame.setVisible(true);
        
		
	}
	
	public void RemoveInfoPanelAddOutputTextPanel() {
		
		masterPlayerPanel.remove(infoPanel);
		masterPlayerPanel.add(gameOutputTextPanel);
		masterPlayerPanel.repaint();
		
	}
	
	public void RemoveOutputTextPanelAddInfoPanel() {
		
		masterPlayerPanel.remove(gameOutputTextPanel);
		masterPlayerPanel.add(infoPanel);
		masterPlayerPanel.repaint();
		
	}
	
    public void updateGameTextOutputArea(String newText) {
        // Append the new text to the existing content with a newline separator
        gameTextOutputArea.append(newText + "\n");

        // Scroll down to show the newly appended text
        gameTextOutputArea.setCaretPosition(gameTextOutputArea.getDocument().getLength());
    }

	
	public void CloseItemUi() {
		
 	   infoPanel.setVisible(true);
 	   itemHealingValue.setVisible(false);
		itemShopPriceLabel.setVisible(false);
 	   itemLabel.setVisible(false); // Hide item label after using the item
 	   equipmentDamageOrArmorValue.setVisible(false);
 	   buyItemButton.setVisible(false); // Hide useItemButton after using the item
 	   closeItemButton.setVisible(false);
	}



}
