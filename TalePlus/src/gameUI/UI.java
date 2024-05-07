package gameUI;

import main.Game;
import main.Player;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.*;
import javax.swing.border.Border;


public class UI implements ActionListener {
	public ImageIcon playerImage;

	public JLabel mainGraphicsImageLabel;
	public JLayeredPane mainGraphicsPane;
	public ImageIcon mainGraphicsImage;
	public Border whiteline = BorderFactory.createLineBorder(Color.white);
	public Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
	public Font normalFont = new Font("Times New Roman", Font.PLAIN, 25);
	public Font statsFont = new Font("Times New Roman", Font.PLAIN, 20);
	public Font gameOutputFont = new Font("Italic", Font.ITALIC, 20);

	public JFrame frame;


	public JPanel titleNamePanel, startButtonPanel;
	public JPanel masterPlayerPanel;
	public JPanel playerPanel;
	public JPanel infoPanel;
	public JPanel buttonPanel;
	public JPanel gameOutputTextPanel;

	public JTextField gameTextField;
	public JLabel titleNameLabel;
	public JButton startButton ;
	public JButton button1, button2, button3, button4;

	public JLabel hpLabel, expLabel, levelLabel, goldLabel, mpLabel;


	public JLabel playerGraphics;
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

		// MASTER PANEL FOR THE PLAYER MAP AND INFO TO GO ON THE BOTTOM
		masterPlayerPanel = new JPanel();
		masterPlayerPanel.setLayout(new BoxLayout(masterPlayerPanel, BoxLayout.X_AXIS));
		masterPlayerPanel.setBounds(5, 424, 772, 130);
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
		masterPlayerPanel.add(infoPanel);

		// MAIN PANEL THAT TAKES UP THE REST OF THE SCREEN


		mainGraphicsImage = new ImageIcon(".//media//taleForest1.jpg");
		mainGraphicsImageLabel = new JLabel();
		mainGraphicsImageLabel.setOpaque(true);
		mainGraphicsImageLabel.setIcon(mainGraphicsImage);
		mainGraphicsImageLabel.setVisible(true);
		mainGraphicsImageLabel.setBounds(0,0,mainGraphicsImage.getIconWidth(), mainGraphicsImage.getIconHeight());

		mainGraphicsPane = new JLayeredPane();
		mainGraphicsPane.setLayout(null);
		mainGraphicsPane.setBounds(5, 5, 775, 410);
		mainGraphicsPane.setBackground(Color.black);
		mainGraphicsPane.setBorder(BorderFactory.createLineBorder(Color.white));
		mainGraphicsPane.setVisible(false);
		mainGraphicsPane.setFocusable(true);

		mainGraphicsPane.add(mainGraphicsImageLabel,JLayeredPane.DEFAULT_LAYER);
		frame.add(mainGraphicsPane);

		playerImage = new ImageIcon(".//media//playerImage.jpg");
		playerGraphics = new JLabel();
		playerGraphics.setLocation(player.getPlayerX(), player.getPlayerY());
		playerGraphics.setSize(player.getPLAYER_WIDTH_X(), player.getPLAYER_HEIGHT_Y());
		playerGraphics.setBackground(Color.red);
		playerGraphics.setOpaque(true);
		playerGraphics.setVisible(true);
		playerGraphics.setIcon(playerImage);
		mainGraphicsPane.add(playerGraphics, JLayeredPane.POPUP_LAYER);


		gameOutputTextPanel = new JPanel();
		gameOutputTextPanel.setPreferredSize(new Dimension(237, 130)); // reduced size to accommodate space for mappanel
		gameOutputTextPanel.setBackground(Color.black);
		gameOutputTextPanel.setBorder(whiteline);
		gameOutputTextPanel.setLayout(null);

		// Initialize JTextArea
		gameTextOutputArea = new JTextArea();
		gameTextOutputArea.setEditable(false); // Set text area as non-editable
		gameTextOutputArea.setLineWrap(true); // Enable line wrapping
		gameTextOutputArea.setWrapStyleWord(true); // Wrap at word boundaries
		gameTextOutputArea.setFont(gameOutputFont);
		gameTextOutputArea.setForeground(Color.white);
		gameTextOutputArea.setVisible(true);
		gameTextOutputArea.setBackground(Color.black);
		//gameTextOutputArea.setBounds(5, 5, 100, 80);


		// Initialize JScrollPane and add JTextArea to it
		scrollPane = new JScrollPane(gameTextOutputArea);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // Always show vertical scroll bar
		scrollPane.setBounds(5, 5, 320, 120); // Adjust bounds as needed
		scrollPane.getVerticalScrollBar().setUI(new CustomScrollBarUI());

		gameTextField = new JTextField();
		gameTextField.setBounds(8,105,250,20);
		gameTextField.setForeground(Color.blue);
		gameTextField.setVisible(true);
		gameTextField.setFont(gameOutputFont);
		gameTextField.addActionListener(this);
		mainGraphicsPane.add(gameTextField,JLayeredPane.DRAG_LAYER);

		// Add JScrollPane to infoPanel
		gameOutputTextPanel.add(scrollPane);
		infoPanel.setVisible(true);
		frame.setVisible(true);

	}


	// Inside the class where you toggle the visibility of mainGraphicsPanel
// Assuming you have a method like toggleMainGraphicsPanelVisibility()

	public void toggleMainGraphicsPanelVisibility(boolean isVisible) {
		mainGraphicsPane.setVisible(isVisible);
		if (isVisible) {
			mainGraphicsPane.requestFocusInWindow(); // Request focus when panel is visible
		} else {
			frame.requestFocusInWindow(); // Transfer focus to the frame when panel is not visible
		}
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


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == gameTextField) {
			String inputText = gameTextField.getText(); // Get the text entered by the user
			// Process the input text as needed

			// Example: Update the game text output area with the input text
			updateGameTextOutputArea("Input received: " + inputText);
			System.out.println(inputText);

			// Clear the text field after processing
			gameTextField.setText("");
			mainGraphicsPane.requestFocusInWindow();
		}
	}

}