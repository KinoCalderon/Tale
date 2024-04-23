package GameStates;

import package01.Game;
import package01.Player;
import package01.UI;

import java.util.Stack;

public abstract class GameState {
	

    // The stack to store the previous game states
    protected static Stack<GameState> gameStateStack = new Stack<>();
    
    // The current game state
    protected static GameState currentState;

    // The games object
    protected Game game;
    protected Player player;
    protected UI ui;


    public GameState(Game game,Player player,UI ui) {
        this.game = game;
        this.player = player;
        this.ui = ui;
    }

    // Method to update the game state
    public abstract void update();

    // Method to update the user interface
    public abstract void ui();

    // Method to play sound effects
    abstract void sound();
    
    // Method to push and set the current state; call it's methods
    public static void pushStateAndSetCurrent(GameState state) {
        gameStateStack.push(state);
        currentState = state;
        currentState.update();
        currentState.ui();
    }

    // Method to pop the previous game state off the stack and go back to it
    public static void goBackToPreviousState() {
        // Pop the previous state off the history stack
        gameStateStack.pop();
        
        // Set the previous state as the current state
        currentState = gameStateStack.peek();

        // Update the UI with the previous state
        currentState.update();
        currentState.ui();
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
        gameStateStack.push(state);
    }
}