package package01;

import GameStates.GameState;
import GameStates.TavernState;
import GameStates.TitleScreenState;
import GameStates.TownState;

public class Game {
	
	GameState gameState;
	public Player player  = new Player(this);
	public UI ui = new UI(player); // create a new UI instance;
	public InventoryHandler inventoryHandler = new InventoryHandler(player, ui);
	public TitleScreenState titleScreenState = new TitleScreenState(this, player, ui);
	public TownState townState = new TownState(this, player, ui);
	public TavernState tavernState = new TavernState(this, player, ui);

	public static void main(String[] args) {
		
		new Game();

	}	
	
	public Game() {
			GameState.setCurrentState(titleScreenState);
			GameState.pushGameState(titleScreenState);
		
	
			GameState.getCurrentState().update();
			GameState.getCurrentState().ui();
				
			
			}
		
	}
