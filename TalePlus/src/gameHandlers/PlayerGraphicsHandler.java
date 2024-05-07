package gameHandlers;

import main.Game;
import main.Player;
import gameUI.UI;
import gameMonsters.Monster_Goblin;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public class PlayerGraphicsHandler implements KeyListener {
    private static final double MOVE_SPEED = 12;
    private static final int INITIAL_JUMP_VELOCITY = 70;
    private static double MAX_JUMP_HEIGHT = 40; // Decreased initial jump velocity
    private static final double GRAVITY = 30;
    private static final int MOVEMENT_DURATION = 260;
    private volatile boolean isSpacePressed = false;// Duration of movement in milliseconds
    private static final int DAMAGE_COOLDOWN = 1000;
    private long lastDamageTime = 0;

    private Game game;
    private Player player;
    private UI ui;
    private MonsterHandler monsterHandler;
    private GameObjectHandler gameObjectHandler;
    private Set<Integer> pressedKeys;
    private PlayerState playerState;

    private enum PlayerState {
        GROUNDED,
        JUMPING,
        FALLING
    }

    public PlayerGraphicsHandler(Game game, Player player, UI ui, MonsterHandler monsterHandler, GameObjectHandler gameObjectHandler) {
        this.gameObjectHandler = gameObjectHandler;
        this.monsterHandler = monsterHandler;
        this.game = game;
        this.player = player;
        this.ui = ui;
        this.pressedKeys = new HashSet<>();
        this.playerState = PlayerState.GROUNDED;
        ui.mainGraphicsPane.addKeyListener(this);

        Thread movementThread = new Thread(this::handleMovement);
        movementThread.start();

    }

    @Override
    public void keyTyped(KeyEvent e) {
        pressedKeys.add(e.getKeyCode());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            isSpacePressed = true; // Set the spacebar press flag
        }
        pressedKeys.add(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            isSpacePressed = false; // Reset the spacebar press flag
        }
        pressedKeys.remove(e.getKeyCode());
    }

    private void handleMovement() {
        long lastUpdateTime = System.currentTimeMillis();
        boolean hasJumped = false; // Track if the jump action has been initiated


        while (true) {
            int dx = 0, dy = 0;

            // Calculate elapsed time since last update
            long currentTime = System.currentTimeMillis();
            long elapsedTime = currentTime - lastUpdateTime;
            lastUpdateTime = currentTime;

            // Calculate movement based on input
            if (pressedKeys.contains(KeyEvent.VK_A)) {
                dx -= MOVE_SPEED;
            }
            if (pressedKeys.contains(KeyEvent.VK_D)) {
                dx += MOVE_SPEED;
            }

            // Check if spacebar is pressed and the jump action hasn't been initiated
            if (isSpacePressed && playerState == PlayerState.GROUNDED && !hasJumped) {
                // Set initial jump velocity
                dy -= INITIAL_JUMP_VELOCITY;
                playerState = PlayerState.JUMPING;
                hasJumped = true; // Set the flag to indicate that jump action has been initiated
                isSpacePressed = false; // Reset spacebar press flag
            }

            switch (playerState) {
                case JUMPING:
                    // Apply gravity and adjust jump height
                    dy += GRAVITY * elapsedTime / 100; // Apply gravity over time
                    if (dy >= 0) { // Player reached peak of jump
                        playerState = PlayerState.FALLING;
                    }
                    break;
                case FALLING:
                    // Apply gravity
                    dy += GRAVITY -10 * elapsedTime / 100; // Apply gravity over time
                    break;
                case GROUNDED:
                    hasJumped = false; // Reset the jump flag when the player is grounded
                    break;
            }

            movePlayer(dx, dy);

            try {
                Thread.sleep(1); // Adjust sleep time for smoother movement
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    private void movePlayer(int dx, int dy) {
        if (player.getShopStatus().equals("open")){
            pressedKeys.clear();
        }
        int startX = ui.playerGraphics.getX();
        int startY = ui.playerGraphics.getY();
        int endX = startX + dx;
        int endY = startY + dy;
        int steps = MOVEMENT_DURATION / 10; // Number of steps based on duration

        // Calculate distance to move in each step
        double stepX = (double) (endX - startX) / steps;
        double stepY = (double) (endY - startY) / steps;

        boolean collidedWithPlatform = false; // Flag to check if collided with a platform

        // Perform gradual movement
        for (double i = 0.0; i < steps; i += 0.5) {
            int newX = (int) (startX + stepX * i);
            int newY = (int) (startY + stepY * i);

            // Perform collision detection and correction with platforms
            newX = Math.min(Math.max(0, newX), ui.mainGraphicsPane.getWidth() - player.getPLAYER_WIDTH_X());
            newY = Math.min(Math.max(0, newY), ui.mainGraphicsPane.getHeight() - player.getPLAYER_HEIGHT_Y());

            // Check if the player collides with a platform


                for (int j = 0; j < gameObjectHandler.platformObjects.length; j++) {
                    if (gameObjectHandler.platformObjects[j].collidesWithPlayer(player)) {
                        collidedWithPlatform = true;
                        // Adjust player's Y position to prevent falling through the platform
                        newY = Math.min(newY, gameObjectHandler.platformObjects[j].getGameObjectY() - player.getPLAYER_HEIGHT_Y());
                    }
                }

                ui.playerGraphics.setLocation(newX, newY);

                // Update player position
                player.setPlayerX(newX);
                player.setPlayerY(newY);

                long currentTime = System.currentTimeMillis();
                if (monsterHandler.GetMonsterFromIndex(0).CollidesWithPlayer(player) && player.IsPlayerHpZero() == false && monsterHandler.GetMonsterFromIndex(0).getHp() > 0 && (currentTime - lastDamageTime) >= DAMAGE_COOLDOWN) {
                    System.out.println(monsterHandler.GetMonsterFromIndex(0).getName() + "takes " + player.getDamage() + " Damage");
                    monsterHandler.GetMonsterFromIndex(0).DamageEnemy(player.getDamage());
                    System.out.println(monsterHandler.GetMonsterFromIndex(0).getHp());
                    player.healPlayer(-monsterHandler.GetMonsterFromIndex(0).getMonsterDamage());
                    ui.hpLabel.setText("HP: " + player.getCurrentHp() + "/" + player.getMaxHp());
                    player.IsPlayerHpZero();
                    lastDamageTime = currentTime;
                    // Update last damage time


                } else if (monsterHandler.GetMonsterFromIndex(0).CollidesWithPlayer(player) && monsterHandler.GetMonsterFromIndex(0).getHp() <= 0) {

                    ui.mainGraphicsPane.remove(monsterHandler.GetMonsterFromIndex(0).monsterLabel);
                    monsterHandler.GetMonsterFromIndex(0).setMonsterX(0);
                    monsterHandler.GetMonsterFromIndex(0).setMonsterY(0);
                    ui.mainGraphicsPane.repaint();
                    monsterHandler.GetMonsterFromIndex(0).startRespawnTimer();

                }

                try {
                    Thread.sleep(1); // Adjust for smoother movement
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


        }


        // Update player state
        if ((endY >= ui.mainGraphicsPane.getHeight() - player.getPLAYER_HEIGHT_Y()) || collidedWithPlatform) {
            playerState = PlayerState.GROUNDED;
        } else {
            playerState = PlayerState.FALLING;
        }
    }



}