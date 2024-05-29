package gameHandlers;

import gameMonsters.Monster_Goblin;
import gameMonsters.SuperMonster;
import gameObjects.RopeObject;
import gameUI.UI;
import main.Game;
import main.Player;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MonsterHandler {

    private static final int DAMAGE_COOLDOWN = 1000;
    private long lastDamageTime = 0;
    private Game game;
    private Player player;
    private UI ui;
    private GameObjectHandler gameObjectHandler;
    private Timer moveTimer;
    public ArrayList<SuperMonster> monsterList = new ArrayList<>();


    public MonsterHandler(Game game, Player player, UI ui, GameObjectHandler gameObjectHandler) {
        this.gameObjectHandler = gameObjectHandler;
        this.game = game;
        this.player = player;
        this.ui = ui;

        Monster_Goblin monsterGoblin = new Monster_Goblin(game, player, ui, 100,320,100,320);
        Monster_Goblin monsterGoblin1 = new Monster_Goblin(game, player, ui, 160,320,120,320);

        AddMonsterToArray(monsterGoblin);
        AddMonsterToArray(monsterGoblin1);

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


    private int margin = 10; // Adjust this value to set the margin distance

    private void moveMonster() {
        // Get the player's x and y coordinates
        int playerX = player.getPlayerX();
        int playerY = player.getPlayerY();

        // Loop through each monster
        for (int i = 0; i < monsterList.size(); i++) {
            // Get the width of the game object
            int gameObjectWidth = gameObjectHandler.getPlatformObjectFromList(i).getWidth();

            // Get the current movement direction of the monster
            boolean movingRight = monsterList.get(i).isMovingRight();

            // Calculate distance between monster and player on x-axis
            int monsterX = monsterList.get(i).getMonsterX();
            int distanceToPlayerX = Math.abs(monsterX - playerX);

            // Calculate distance between monster and player on y-axis
            int monsterY = monsterList.get(i).getMonsterY();
            int distanceToPlayerY = Math.abs(monsterY - playerY);

            // If player is within 100 distance on x-axis and on the same y-level
            if (distanceToPlayerX <= 100 && distanceToPlayerY <= 100) {
                if (playerX > monsterX) {
                    // Move the monster towards player on the right
                    monsterList.get(i).setMovingRight(true);
                } else {
                    // Move the monster towards player on the left
                    monsterList.get(i).setMovingRight(false);
                }
            }

            // Move the monster
            int newX;
            if (movingRight) {
                // Move the monster to the right
                newX = monsterList.get(i).getMonsterX() + monsterList.get(i).getMonsterSpeed();
                newX = Math.min(newX, gameObjectHandler.getPlatformObjectFromList(i).getGameObjectX() + gameObjectWidth - margin);
                monsterList.get(i).setMonsterX(newX);

                // Check if the monster has reached the right edge
                if (newX >= gameObjectHandler.getPlatformObjectFromList(i).getGameObjectX() + gameObjectWidth - margin) {
                    monsterList.get(i).setMovingRight(false); // Change direction
                }
            } else {
                // Move the monster to the left
                newX = monsterList.get(i).getMonsterX() - monsterList.get(i).getMonsterSpeed();
                newX = Math.max(newX, gameObjectHandler.getPlatformObjectFromList(i).getGameObjectX() + margin);
                monsterList.get(i).setMonsterX(newX);

                // Check if the monster has reached the left edge
                if (newX <= gameObjectHandler.getPlatformObjectFromList(i).getGameObjectX() + margin) {
                    monsterList.get(i).setMovingRight(true); // Change direction
                }
            }

            // Set the new location of the monster
            monsterList.get(i).monsterLabel.setLocation(newX, monsterList.get(i).getMonsterY());
        }

        // Repaint the UI after moving all monsters
        ui.mainGraphicsPane.repaint();
    }



    public void AddMonsterToArray(SuperMonster superMonster) {
        monsterList.add(superMonster);
    }

    public SuperMonster GetMonsterFromIndex(int i) {
        return monsterList.get(i);
    }

   public void HandleMonsterCollision(){
       long currentTime = System.currentTimeMillis();
       for (int k = 0; k < monsterList.size(); k++) {
           if (GetMonsterFromIndex(k).CollidesWithPlayer(player) && player.IsPlayerHpZero() == false && GetMonsterFromIndex(k).getHp() > 0 && (currentTime - lastDamageTime) >= DAMAGE_COOLDOWN) {

               player.healPlayer(-GetMonsterFromIndex(k).getMonsterDamage());
               ui.hpLabel.setText("HP: " + player.getCurrentHp() + "/" + player.getMaxHp());
               player.IsPlayerHpZero();
               lastDamageTime = currentTime;



           } else if (GetMonsterFromIndex(k).CollidesWithPlayer(player) && GetMonsterFromIndex(k).getHp() <= 0) {

               ui.mainGraphicsPane.remove(GetMonsterFromIndex(k).monsterLabel);
               GetMonsterFromIndex(k).setMonsterX(k);
               GetMonsterFromIndex(k).setMonsterY(k);
               ui.mainGraphicsPane.repaint();
               GetMonsterFromIndex(k).startRespawnTimer();

           }
       }
   }



    private void KillMonster(int i) {
        ui.mainGraphicsPane.remove(GetMonsterFromIndex(i).monsterLabel);
        GetMonsterFromIndex(i).setMonsterX(0);
        GetMonsterFromIndex(i).setMonsterY(0);
        ui.mainGraphicsPane.repaint();
        GetMonsterFromIndex(i).startRespawnTimer();
    }



    public SuperMonster GetMonsterWithLowestHp(){
        SuperMonster currentLowestHp = monsterList.get(0);

        for (int i = 0; i < monsterList.size(); i++){
            if (monsterList.get(i).getHp() < currentLowestHp.getHp()){
                  currentLowestHp = monsterList.get(i);
            }
        }

        return currentLowestHp;
    }

    public void ShouldMonsterBeKilled(){
        for (int j = 0; j < monsterList.size(); j++){
            if (monsterList.get(j).getHp()<=0){
                KillMonster(j);
            }

        }

    }


}
