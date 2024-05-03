package GameStates;

import package01.*;
import package02.InventoryUI;
import package02.PlayerStatsUI;
import package02.UI;
import package03.InventoryHandler;

import java.util.Stack;

public abstract class GameState {
	

    // The stack to store the previous game states
    private static Stack<GameState> gameStateStack = new Stack<>();
    
    // The current game state
    protected static GameState currentState;

    // The games object
    protected Game game;
    protected Player player;
    protected UI ui;
    protected InventoryUI invoUI;
    protected InventoryHandler iHandler;
    protected PlayerStatsUI playerStatsUI;
    
    private String name;
    


    public GameState(Game game,Player player,UI ui, InventoryUI invoUI) {
        this.game = game;
        this.player = player;
        this.ui = ui;
        this.invoUI = invoUI;
        
    }

    public GameState(Game game2, Player player2, UI ui2, InventoryUI invoUI2, PlayerStatsUI playerStatsUI) {
    	this.game = game2;
    	this.player = player2;
    	this.ui = ui2;
    	this.invoUI = invoUI2;
    	this.playerStatsUI = playerStatsUI;
		// TODO Auto-generated constructor stub
	}

    public GameState(Game game, Player player, UI ui, InventoryUI invoUI, InventoryHandler iHandler) {
        this.game = game;
        this.player = player;
        this.invoUI = invoUI;
        this.ui = ui;
    }

    // Method to update the game state
    public abstract void update();

    // Method to update the user interface
    public abstract void ui();

    // Method to play sound effects
    abstract void sound();

    
    // Method to push and set the current state; call it's methods
    public static void pushStateAndSetCurrent(GameState state, Player player) {
        getGameStateStack().push(state);
        currentState = state;
        player.setAbsoluteCurrentState();
        currentState.update();
        currentState.ui();
    }

    // Method to pop the previous game state off the stack and go back to it
    public static void goBackToPreviousState(Player player) {
        // Pop the previous state off the history stack
        getGameStateStack().pop();
        
        // Set the previous state as the current state
        currentState = getGameStateStack().peek();
        player.setAbsoluteCurrentState();
        // Update the UI with the previous state
        currentState.update();
        currentState.ui();
    }
    
    public static GameState getPreviousState() {
        // Check if there's a previous state to return
        if (gameStateStack.size() > 1) {
            // Pop the current state to get to the previous state
            gameStateStack.pop();
            // Return the previous state without removing it from the stack
            return gameStateStack.peek();
        } else {
            // If there's no previous state, return null or handle it as needed
            return null;
        }
    }


    
    
    // Method to set the current game state
    public static void setCurrentState(GameState state) {
        currentState = state;
    }

    // Method to get the current game state
    public static GameState getCurrentState() {
        return currentState;
    }

    // Method to push a game state onto the stack
    public static void pushGameState(GameState state) {
        getGameStateStack().push(state);
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static Stack<GameState> getGameStateStack() {
		return gameStateStack;
	}

	public static void setGameStateStack(Stack<GameState> gameStateStack) {
		GameState.gameStateStack = gameStateStack;
	}
}