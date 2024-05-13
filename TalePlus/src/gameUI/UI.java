package gameUI;

import main.Game;
import main.Player;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;


public class UI implements ActionListener {
	public JFrame frame;

	public JLayeredPane mainGraphicsPane;

	public ImageIcon playerImageRight;
	public ImageIcon playerImageLeft;
	public ImageIcon mainGraphicsImage;
	public JLabel mainGraphicsImageLabel;

	public Border whiteline = BorderFactory.createLineBorder(Color.white);
	public Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
	public Font normalFont = new Font("Times New Roman", Font.PLAIN, 25);
	public Font statsFont = new Font("Times New Roman", Font.PLAIN, 25);
	public Font gameOutputFont = new Font("Italic", Font.ITALIC, 20);



	public JPanel titleNamePanel, startButtonPanel;
	public JPanel masterPlayerPanel;
	public JPanel playerPanel;
	public JPanel infoPanel;
	public JPanel buttonPanel;
	public JPanel gameOutputTextPanel;

	public JMenuBar gameMenuBar;
	public JMenu openMenu;
	public JMenuItem textFieldMenuItem;
	private final JTextArea gameTextOutputArea;
	public JTextField gameTextField;
	public JLabel titleNameLabel;
	public JButton startButton ;
	public JButton button1, button2, button3, button4;

	public JLabel hpLabel, expLabel, levelLabel, goldLabel, mpLabel, hpPotLabel, mpPotLabel;


	public JLabel playerGraphics;
	public Player player;
	public Game game;
	public JScrollPane scrollPane;
	public UI (Player player, Game game) {
		this.player = player;
		this.game = game;


		// Main frame
		frame = new JFrame();
		frame.setSize(1280, 720);
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
		masterPlayerPanel.setBounds(10, 515, 1245, 160);
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

		hpLabel = new JLabel("Hp: "+ player.getCurrentHp() +"/"+ player.getMaxHp());
		hpLabel.setForeground(Color.white);
		hpLabel.setVisible(true);
		hpLabel.setFont(statsFont);
		playerPanel.add(hpLabel);


		mpLabel = new JLabel("Mp: " + player.getCurrentMp() + "/" + player.getMaxMp());
		mpLabel.setForeground(Color.white);
		mpLabel.setVisible(true);
		mpLabel.setFont(statsFont);
		playerPanel.add(mpLabel);

		expLabel = new JLabel(" Exp: " + player.getCurrentExp() + "/" + player.getMaxExp());
		expLabel.setForeground(Color.white);
		expLabel.setVisible(true);
		expLabel.setFont(statsFont);
		playerPanel.add(expLabel);

		hpPotLabel = new JLabel("Hp Pots: " + player.getHpPotionArray().size());
		hpPotLabel.setForeground(Color.white);
		hpPotLabel.setVisible(true);
		hpPotLabel.setFont(statsFont);
		playerPanel.add(hpPotLabel);

		mpPotLabel = new JLabel("Mp Pots: " + player.getMpPotionArray().size());
		mpPotLabel.setForeground(Color.white);
		mpPotLabel.setVisible(true);
		mpPotLabel.setFont(statsFont);
		playerPanel.add(mpPotLabel);

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


		mainGraphicsImage = new ImageIcon();
		mainGraphicsImageLabel = new JLabel();
		mainGraphicsImageLabel.setOpaque(true);
		mainGraphicsImageLabel.setIcon(mainGraphicsImage);
		mainGraphicsImageLabel.setVisible(true);
		mainGraphicsImageLabel.setBounds(0,0,mainGraphicsImage.getIconWidth(), mainGraphicsImage.getIconHeight());

		mainGraphicsPane = new JLayeredPane();
		mainGraphicsPane.setLayout(null);
		mainGraphicsPane.setBounds(10, 10, 1245, 495);
		mainGraphicsPane.setBackground(Color.black);
		mainGraphicsPane.setBorder(BorderFactory.createLineBorder(Color.white));
		mainGraphicsPane.setVisible(false);
		mainGraphicsPane.setFocusable(true);

		mainGraphicsPane.add(mainGraphicsImageLabel,JLayeredPane.DEFAULT_LAYER);
		frame.add(mainGraphicsPane);

		playerImageLeft = new ImageIcon(".//media//playerImageLeft.png");
		playerImageRight = new ImageIcon(".//media//playerImageRight.png");
		playerGraphics = new JLabel();
		playerGraphics.setLocation(player.getPlayerX(), player.getPlayerY());
		playerGraphics.setSize(player.getPLAYER_WIDTH_X(), player.getPLAYER_HEIGHT_Y());
		//playerGraphics.setOpaque(true);
		playerGraphics.setVisible(true);
		playerGraphics.setIcon(playerImageRight);
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
		scrollPane.setBounds(5, 5, 475, 150); // Adjust bounds as needed
		scrollPane.getVerticalScrollBar().setUI(new CustomScrollBarUI());

		gameTextField = new JTextField();
		gameTextField.setBounds(8,105,250,20);
		gameTextField.setForeground(Color.blue);
		gameTextField.setVisible(false);
		gameTextField.setFont(gameOutputFont);
		gameTextField.addActionListener(this);
		mainGraphicsPane.add(gameTextField,JLayeredPane.DRAG_LAYER);

		gameMenuBar = new JMenuBar();
		gameMenuBar.setBackground(Color.white);
		gameMenuBar.setVisible(true);

		openMenu = new JMenu("Menu");
		textFieldMenuItem = new JMenuItem("TextField");
		textFieldMenuItem.addActionListener(this);
		textFieldMenuItem.setActionCommand("openTextField");

		openMenu.add(textFieldMenuItem);
		gameMenuBar.add(openMenu);
		//frame.setJMenuBar(gameMenuBar);

		// Add JScrollPane to infoPanel
		gameOutputTextPanel.add(scrollPane);
		infoPanel.setVisible(true);
		frame.setVisible(true);

	}


	// Inside the class where you toggle the visibility of mainGraphicsPanel
// Assuming you have a method like toggleMainGraphicsPanelVisibility()

	public void SetMpLabelText(){
		mpLabel.setText("MP: " + player.getCurrentMp() + "/" + player.getMaxMp());
	}

	public void GetPlatFormObjectXY(int i){
		System.out.println("x"+game.gameObjectHandler.getPlatformObjectFromList(i).getGameObjectX());
		System.out.println("y"+game.gameObjectHandler.getPlatformObjectFromList(i).getGameObjectY());

	}

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

		String yourChoice = e.getActionCommand();
		switch (yourChoice){
			case "openTextField":
					if (player.getTextFieldStatus().equals("close")){
					gameTextField.setVisible(true);
					player.setTextFieldStatus("open");
					}else if (e.getSource() == textFieldMenuItem && player.getTextFieldStatus().equals("open")){
						gameTextField.setVisible(false);
						player.setTextFieldStatus("close");
					}
			break;
		}

		if (e.getSource() == gameTextField) {
			String inputText = gameTextField.getText(); // Get the text entered by the user
			// Process the input text as needed

			if (inputText.equals("::getx")){
				System.out.println(player.getPlayerX());
				// Example: Update the game text output area with the input text
				updateGameTextOutputArea("Input received: " + inputText);
				System.out.println(inputText);

				// Clear the text field after processing
				gameTextField.setText("");
				mainGraphicsPane.requestFocusInWindow();
			}
			else if (inputText.contains("platform")) {
				if (inputText.contains("0")) {
					GetPlatFormObjectXY(0);
					updateGameTextOutputArea("Input received: " + inputText);
					System.out.println(inputText);
					gameTextField.setText("");
					mainGraphicsPane.requestFocusInWindow();
				}
				else if (inputText.contains("platform")) {
					if (inputText.contains("1")) {
						GetPlatFormObjectXY(1);
						updateGameTextOutputArea("Input received: " + inputText);
						System.out.println(inputText);
						gameTextField.setText("");
						mainGraphicsPane.requestFocusInWindow();
					}

				}
			} else if (inputText.equals("::gety")) {
				System.out.println(player.getPlayerY());
				updateGameTextOutputArea("Input received: " + inputText);
				System.out.println(inputText);
				gameTextField.setText("");
				mainGraphicsPane.requestFocusInWindow();

			}
			else if (inputText.equals("::getxy")) {
				System.out.println("x" + player.getPlayerX() + ",y" + player.getPlayerY());
				updateGameTextOutputArea("Input received: " + inputText);
				System.out.println(inputText);
				gameTextField.setText("");
				mainGraphicsPane.requestFocusInWindow();

			} else if (inputText.equals("::playerhp")) {
				System.out.println("hp: " + player.getCurrentHp());
				updateGameTextOutputArea("Input received: " + inputText);
				System.out.println(inputText);
				gameTextField.setText("");
				mainGraphicsPane.requestFocusInWindow();


			} else {
				updateGameTextOutputArea("Input received: " + inputText);
				System.out.println(inputText);
				//System.out.println(game.gameObjectHandler.platformObjects[0].getHeight() + "platform height");

				// Clear the text field after processing
				gameTextField.setText("");
				mainGraphicsPane.requestFocusInWindow();
			}

		}

	}

}

