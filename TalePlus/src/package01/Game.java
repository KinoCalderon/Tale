package package01;

import GameStates.GameState;
import GameStates.PlayerInventoryState;
import GameStates.PlayerStatsScreenState;
import GameStates.TavernState;
import GameStates.TitleScreenState;
import GameStates.TownState;

public class Game {
	
	GameState gameState;
	public Player player  = new Player(this);
	public UI ui = new UI(player, this); // create a new UI instance;
	public PlayerStatsUI playerStatsUI = new PlayerStatsUI(player, ui);
	public InventoryHandler inventoryHandler = new InventoryHandler(player, ui, this);
	public TitleScreenState titleScreenState = new TitleScreenState(this, player, ui, inventoryHandler);
	public TownState townState = new TownState(this, player, ui, inventoryHandler);
	public TavernState tavernState = new TavernState(this, player, ui, inventoryHandler);
	public PlayerStatsScreenState playerStatsScreenState = new PlayerStatsScreenState(this, player, ui, inventoryHandler, playerStatsUI);
	public PlayerInventoryState playerInventoryState = new PlayerInventoryState(this, player, ui, inventoryHandler);
	

	public static void main(String[] args) {
		
		new Game();

	}	
	
	public Game() {
		
			GameState.setCurrentState(titleScreenState);
			GameState.pushGameState(titleScreenState);
			player.setCurrentState(gameState);
		
	
			GameState.getCurrentState().update();
			GameState.getCurrentState().ui();
				
			
			}
		
	}
