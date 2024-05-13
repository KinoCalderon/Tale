package GameStates;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gameHandlers.ShopKeeperHandler;
import main.*;
import gameUI.InventoryUI;
import gameUI.ShopKeeperUI;
import gameUI.UI;


public class TavernState extends GameState implements ActionListener {




	//private JButton shopButton1, shopButton2;
	//private JButton shopKeeperButton1, shopKeeperButton2;

	public TavernState(Game game, Player player, UI ui, InventoryUI invoUI, ShopKeeperUI shopKeeperUI, ShopKeeperHandler shopKeeperHandler) {
		super(game, player, ui, invoUI, shopKeeperUI, shopKeeperHandler);
		setName("TavernState");



		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		player.setShopLocation("tavernShop");
		player.setShopStatus("open");

		System.out.println(player.getCurrentState());
		System.out.println("Player shop status* " + player.getShopStatus());
		System.out.println(getGameStateStack() + " GAME STATE STACK INSIDE TAVERN STATE");


	}

	@Override
	public void ui() {
		//UPDATE THE PLAYERS LOCATION IN THE GAME OUTPUT AREA
		ui.updateGameTextOutputArea("Welcome to " + player.getCurrentState().getName());
		shopKeeperUI.shopKeeperPanel.setVisible(true);
		invoUI.inventoryPanel.setVisible(true);
		invoUI.refreshInventoryButtons();

		ui.button4.setVisible(true);
		ui.button4.setText("Exit");
		ui.button4.setActionCommand("closeTavern");
		ui.button4.removeActionListener(this);
		ui.button4.addActionListener(this);
		ui.button1.setVisible(false);


	}

	@Override
	void sound() {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String yourChoice = e.getActionCommand();

		switch (yourChoice){
			case"closeTavern":
				shopKeeperUI.shopKeeperPanel.setVisible(false);
				goBackToPreviousState(player);
				ui.button1.setVisible(true);
				player.setShopStatus("close");
				ui.button4.removeActionListener(this);
				ui.button4.setVisible(false);
				shopKeeperHandler.GetShopKeeperFromIndex(0).shopKeeperButton.addActionListener(shopKeeperHandler);
				break;
		}


	}
}
