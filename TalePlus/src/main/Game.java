package main;

import GameStates.GameState;
import GameStates.PlayerInventoryState;
import GameStates.PlayerStatsScreenState;
import GameStates.TavernState;
import GameStates.TitleScreenState;
import GameStates.TownState;
import gameHandlers.*;
import gameUI.InventoryUI;
import gameUI.PlayerStatsUI;
import gameUI.ShopKeeperUI;
import gameUI.UI;
import gameMonsters.Monster_Goblin;

public class Game {
	
	GameState gameState;
	public Player player  = new Player(this);

	public UI ui = new UI(player, this); // create a new UI instance;
	public GameObjectHandler gameObjectHandler = new GameObjectHandler(this,player,ui);

	//public Monster_Goblin monsterGoblin = new Monster_Goblin(this, player, ui);

	public PlayerStatsUI playerStatsUI = new PlayerStatsUI(player, ui);
	public InventoryUI invoUI = new InventoryUI(player, ui);
	public ShopKeeperUI shopKeeperUI = new ShopKeeperUI(this,player,ui,invoUI);

	public MonsterHandler monsterHandler = new MonsterHandler(this, player, ui,gameObjectHandler);
	public ShopKeeperHandler shopKeeperHandler = new ShopKeeperHandler(this,player,ui,invoUI,shopKeeperUI);
	public InventoryHandler iHandler = new InventoryHandler(player, ui, this, invoUI, shopKeeperUI);
	public PlayerStatsHandler sHandler = new PlayerStatsHandler(this, player, ui, playerStatsUI);
	public PlayerGraphicsHandler pHandler = new PlayerGraphicsHandler(this, player, ui, monsterHandler, gameObjectHandler);


	public TitleScreenState titleScreenState = new TitleScreenState(this, player, ui, invoUI);
	public TownState townState = new TownState(this, player, ui, invoUI);
	public TavernState tavernState = new TavernState(this, player, ui, invoUI,shopKeeperUI);
	public PlayerStatsScreenState playerStatsScreenState = new PlayerStatsScreenState(this, player, ui, sHandler, playerStatsUI);
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
