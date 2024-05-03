package package01;

import GameStates.GameState;
import GameStates.PlayerInventoryState;
import GameStates.PlayerStatsScreenState;
import GameStates.TavernState;
import GameStates.TitleScreenState;
import GameStates.TownState;
import package02.InventoryUI;
import package02.PlayerStatsUI;
import package02.UI;
import package03.InventoryHandler;

public class Game {
	
	GameState gameState;
	public Player player  = new Player(this);
	public UI ui = new UI(player, this); // create a new UI instance;
	public PlayerStatsUI playerStatsUI = new PlayerStatsUI(player, ui);
	public InventoryUI invoUI = new InventoryUI(player, ui);
	public InventoryHandler iHandler = new InventoryHandler(player, ui, this, invoUI);
	public TitleScreenState titleScreenState = new TitleScreenState(this, player, ui, invoUI);
	public TownState townState = new TownState(this, player, ui, invoUI);
	public TavernState tavernState = new TavernState(this, player, ui, invoUI);
	public PlayerStatsScreenState playerStatsScreenState = new PlayerStatsScreenState(this, player, ui, invoUI, playerStatsUI);
	public PlayerInventoryState playerInventoryState = new PlayerInventoryState(this, player, ui, invoUI, iHandler);
	

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
