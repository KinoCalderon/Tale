package gameHandlers;

import gameMonsters.Monster_Goblin;
import gameMonsters.SuperMonster;
import gameUI.UI;
import main.Game;
import main.Player;

import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class MonsterHandler {

    private static final int MOVEMENT_DURATION = 10;
    private static final int MONSTER_SPEED = 5;
    private Game game;
    private Player player;
    private UI ui;
    private GameObjectHandler gameObjectHandler;
    private Timer moveTimer;

    public SuperMonster[] monsterArray = new SuperMonster[1];

    public MonsterHandler(Game game, Player player, UI ui, GameObjectHandler gameObjectHandler) {
        this.gameObjectHandler = gameObjectHandler;
        this.game = game;
        this.player = player;
        this.ui = ui;

        Monster_Goblin monsterGoblin = new Monster_Goblin(game, player, ui, 100,320,100,320);
        AddMonsterToArray(monsterGoblin, 0);

        // Start the timer to move the monster
        startMoveTimer();
    }

    // Method to start the timer for moving the monster
    private void startMoveTimer() {
        moveTimer = new Timer();
        moveTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                moveMonster();
            }
        }, 1000, 1000); // Move the monster every 50 milliseconds
    }

    // Method to move the monster
    private boolean movingRight = true; // Flag to track the direction of movement

    private int margin = 20; // Adjust this value to set the margin distance

    private void moveMonster() {
        // Get the width of the game object
        int gameObjectWidth = gameObjectHandler.GetObjectFromIndex(0).getWidth();

        if (movingRight) {
            // Move the monster to the right
            int newX = monsterArray[0].getMonsterX() + MONSTER_SPEED;
            newX = Math.min(newX, gameObjectHandler.GetObjectFromIndex(0).getGameObjectX() + gameObjectWidth - margin);
            monsterArray[0].setMonsterX(newX);

            // Check if the monster has reached the right edge
            if (newX >= gameObjectHandler.GetObjectFromIndex(0).getGameObjectX() + gameObjectWidth - margin) {
                movingRight = false; // Change direction
            }
        } else {
            // Move the monster to the left
            int newX = monsterArray[0].getMonsterX() - MONSTER_SPEED;
            newX = Math.max(newX, gameObjectHandler.GetObjectFromIndex(0).getGameObjectX() + margin);
            monsterArray[0].setMonsterX(newX);

            // Check if the monster has reached the left edge
            if (newX <= gameObjectHandler.GetObjectFromIndex(0).getGameObjectX() + margin) {
                movingRight = true; // Change direction
            }
        }

        // Set the new location of the monster
        monsterArray[0].monsterLabel.setLocation(monsterArray[0].getMonsterX(), monsterArray[0].getMonsterY());
        ui.mainGraphicsPane.repaint();
    }





    public void AddMonsterToArray(SuperMonster superMonster, int i) {
        monsterArray[i] = superMonster;
    }

    public SuperMonster GetMonsterFromIndex(int i) {
        return monsterArray[i];
    }
}
