package GameStates;

import package01.*;

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
    protected InventoryHandler iHandler;
    protected PlayerStatsUI playerStatsUI;
    
    private String name;
    


    public GameState(Game game,Player player,UI ui, InventoryHandler iHandler) {
        this.game = game;
        this.player = player;
        this.ui = ui;
        this.iHandler = iHandler;
        
    }

    public GameState(Game game2, Player player2, UI ui2, InventoryHandler iHandler2, PlayerStatsUI playerStatsUI) {
    	this.game = game2;
    	this.player = player2;
    	this.ui = ui2;
    	this.iHandler = iHandler2;
    	this.playerStatsUI = playerStatsUI;
		// TODO Auto-generated constructor stub
	}

	// Method to update the game state
    public abstract void update();

    // Method to update the user interface
    public abstract void ui();

    // Method to play sound effects
    abstract void sound();
    
    public static <T> GameState getGameStateAtIndex( int index) {
        if (index >= gameStateStack.size() || index < -gameStateStack.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        if (index < 0) {
            index += gameStateStack.size();
        }

        // Temporary stack to hold elements popped from the original stack
        Stack<T> tempStack = new Stack<>();

        // Pop elements from the original stack until reaching the desired index
        for (int i = 0; i < index; i++) {
            tempStack.push((T) gameStateStack.pop());
        }

        // Get the element at the desired index
        GameState element = gameStateStack.peek();

        // Restore the original stack by pushing back elements from the temporary stack
        while (!tempStack.isEmpty()) {
            gameStateStack.push((GameState) tempStack.pop());
        }

        return element;
    }
    
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