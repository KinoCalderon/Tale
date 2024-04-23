package package01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;


public class UI {
    Border whiteline = BorderFactory.createLineBorder(Color.white);
    Border raised = BorderFactory.createRaisedBevelBorder();
    Border whitetitle = BorderFactory.createCompoundBorder(raised, whiteline);
    public Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    public Font normalFont = new Font("Times New Roman", Font.PLAIN, 26);
    public Font statsFont = new Font("Times New Roman", Font.PLAIN, 23);
   
    public JFrame frame;
    
    public JPanel titleNamePanel, startButtonPanel;
    public JPanel masterPlayerPanel;
    public JPanel playerPanel;
    public JPanel infoPanel;
    public JPanel buttonPanel;
    public JPanel picturePanel;
    
    public JLabel pictureLabel;
	public JLabel titleNameLabel;
	
	public JButton startButton ;
	public JButton button1, button2, button3, button4;
	
	public ImageIcon image;
	public JLabel hpLabel, expLabel, levelLabel, goldLabel, mpLabel;
	
	public Player player;


	
	public UI (Player player) {
		this.player = player;
	
		
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
        playerPanel.setLayout(new GridLayout(3,2));
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
        masterPlayerPanel.add(infoPanel);
        

        
        // MAIN PANEL THAT TAKES UP THE REST OF THE SCREEN
        picturePanel = new JPanel();
        picturePanel.setLayout(new BorderLayout());
        picturePanel.setBounds(5, 1, 775, 420);
        picturePanel.setBackground(Color.black);
        picturePanel.setVisible(true);
        frame.add(picturePanel);
 

        // PICTURE LABEL AND IMAGE IMPORT
        pictureLabel = new JLabel();
        image = new ImageIcon(".//media//town.jpg");
        pictureLabel.setIcon(image);
        picturePanel.add(pictureLabel);
        pictureLabel.setVisible(false);
        

        frame.setVisible(true);
		
	}



}
