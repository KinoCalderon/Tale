package GameStates;

import package01.Game;
import package01.InventoryManager;
import package01.Player;
import package01.UI;


public class TavernState extends GameState{

	public TavernState(Game game, Player player, UI ui) {
		super(game, player, ui);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		game.player.setCurrentState(this);
		
		InventoryManager inventoryManager = new InventoryManager();
		inventoryManager.GivePlayerItem(player, player.potion);
		System.out.println("me");
	}

	@Override
	public void ui() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void sound() {
		// TODO Auto-generated method stub
		
	}

}
