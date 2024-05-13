package gameHandlers;

import gameObjects.RopeObject;
import main.Game;
import main.Player;
import gameUI.UI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.font.FontRenderContext;

public class PlayerGraphicsHandler implements KeyListener {
    private boolean collidedWithPlatform;
    private boolean collidesWithRope;
    private static final int ROPE_CLIMB_HEIGHT = 5;
    private static final double THREAD_SLEEP = 2; // Adjusted sleep duration
    private static final double MOVE_SPEED = 10;
    private static final int INITIAL_JUMP_VELOCITY = 40;
    private static final int KNOCK_BACK_VELOCITY = 5;
    private double currentJumpVelocity = 0; // Track current jump velocity

    private static final double GRAVITY = 15;

    private static final int MOVEMENT_DURATION = 150;


    private static final int DAMAGE_COOLDOWN = 1000;
    private long lastDamageTime = 0;

    private Game game;
    private Player player;
    private UI ui;
    private MonsterHandler monsterHandler;
    private GameObjectHandler gameObjectHandler;
    private PlayerAbilitiesHandler playerAbilitiesHandler;
    private PlayerState playerState;

    public boolean isCollidesWithRope() {
        return collidesWithRope;
    }

    public void setCollidesWithRope(boolean collidesWithRope) {
        this.collidesWithRope = collidesWithRope;
    }

    private enum PlayerState {
        GROUNDED,
        JUMPING,
        FALLING,
        ON_ROPE,
        PLATFORM
    }

    public PlayerGraphicsHandler(Game game, Player player, UI ui, MonsterHandler monsterHandler, GameObjectHandler gameObjectHandler, PlayerAbilitiesHandler playerAbilitiesHandler) {
        this.playerAbilitiesHandler = playerAbilitiesHandler;
        this.gameObjectHandler = gameObjectHandler;
        this.monsterHandler = monsterHandler;
        this.game = game;
        this.player = player;
        this.ui = ui;
        this.playerState = PlayerState.GROUNDED;
        ui.mainGraphicsPane.addKeyListener(this);

        Thread movementThread = new Thread(this::handleMovement);
        movementThread.start();
    }



    @Override
    public void keyTyped(KeyEvent e) {
        // Not used in this implementation
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_D) {
            //playerAbilitiesHandler.GetAbilityFromIndex(0).RemoveAbilityFromScreen();
            player.setPlayerMoving(true);
            player.setSpacePressed(true);
        } else if (keyCode == KeyEvent.VK_LEFT) {
            playerAbilitiesHandler.GetAbilityFromIndex(0).RemoveAbilityFromScreen();
            player.setPlayerMoving(true);
            player.setLeftPressed(true);
            player.setPlayerDirection("left");
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            playerAbilitiesHandler.GetAbilityFromIndex(0).RemoveAbilityFromScreen();
            player.setPlayerMoving(true);
            player.setRightPressed(true);
            player.setPlayerDirection("right");
        } else if (keyCode == KeyEvent.VK_W) {
            playerAbilitiesHandler.GetAbilityFromIndex(0).useAbility();


        } else if (keyCode == KeyEvent.VK_UP) {

            playerAbilitiesHandler.GetAbilityFromIndex(0).RemoveAbilityFromScreen();
            player.setPlayerMoving(true);
            player.setUpPressed(true);
            //player.setPlayerDirection("up");

        } else if (keyCode == KeyEvent.VK_DOWN) {

            playerAbilitiesHandler.GetAbilityFromIndex(0).RemoveAbilityFromScreen();
            player.setPlayerMoving(true);
            player.setDownPressed(true);
            player.setPlayerDirection("down");

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_D) {
            player.setPlayerMoving(false);
            player.setSpacePressed(false);
        } else if (keyCode == KeyEvent.VK_LEFT) {
            player.setPlayerMoving(false);
            player.setLeftPressed(false);
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            player.setPlayerMoving(false);
            player.setRightPressed(false);
        } else if (keyCode == KeyEvent.VK_UP) {
            player.setPlayerMoving(false);
            player.setUpPressed(false);
        } else if (keyCode == KeyEvent.VK_DOWN) {
            player.setPlayerMoving(false);
            player.setDownPressed(false);
        }
    }



    private void handleMovement() {

        boolean hasJumped = false;

        while (true) {
            int frameCount = 0;
            int dx = 0, dy = 0;


            for (RopeObject ropeObject : gameObjectHandler.ropeObjectsList) {
                if (ropeObject.RopeCollidesWithPlayer(player) && playerState != PlayerState.GROUNDED) {
                    collidesWithRope = true;
                    playerState = PlayerState.ON_ROPE;
                    break; // Exit the loop early if collides with any rope
                }
            }



            if (player.isLeftPressed()) {
                dx -= MOVE_SPEED;
                ui.playerGraphics.setIcon(ui.playerImageLeft);
            }
            if (player.isRightPressed()) {
                dx += MOVE_SPEED;
                ui.playerGraphics.setIcon(ui.playerImageRight);
            }
            if (player.isSpacePressed() && playerState == PlayerState.GROUNDED && !hasJumped) {
                currentJumpVelocity = INITIAL_JUMP_VELOCITY;
                playerState = PlayerState.JUMPING;
                hasJumped = true;
            }

            if (player.isSpacePressed() && playerState == PlayerState.PLATFORM && !hasJumped) {
                currentJumpVelocity = INITIAL_JUMP_VELOCITY;
                playerState = PlayerState.JUMPING;
                hasJumped = true;
            }




            switch (playerState) {
                case JUMPING:
                    collidedWithPlatform = false;
                    hasJumped = true;
                    //System.out.println("jumping state");
                    if (currentJumpVelocity > 0) {
                        dy -= currentJumpVelocity;
                        //currentJumpVelocity -= GRAVITY;
                    } else {
                        playerState = PlayerState.FALLING;

                    }
                    break;
                case FALLING:
                    //System.out.println("falling state");
                    hasJumped = true;
                    //setCollidesWithRope(false);
                    dy += GRAVITY;
                    break;
                case GROUNDED:
                    //System.out.println("grounded state");
                    hasJumped = false;
                    break;

                case ON_ROPE:
                    //System.out.println("rope state");
                    dx=0;
                    hasJumped = false;

                    if (player.isUpPressed()) {
                        dy -= ROPE_CLIMB_HEIGHT;
                        // Logic for climbing up the rope
                    } else if (player.isDownPressed()) {
                        dy += ROPE_CLIMB_HEIGHT;
                        // Logic for climbing down the rope
                    }

                    // Additional logic for swinging, jumping off the rope, animations, collision handling, etc.
                    break;

                case PLATFORM:
                    hasJumped = false;
                    break;

            }

            movePlayer(dx, dy);


            try {
                Thread.sleep((long) THREAD_SLEEP);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    private void movePlayer(int dx, int dy) {
        if (player.getShopStatus().equals("open")){
            player.setRightPressed(false); player.setRightPressed(false); player.setRightPressed(false);
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
                for (int j = 0; j < gameObjectHandler.platformObjectsList.size(); j++) {
                    if (gameObjectHandler.platformObjectsList.get(j).PlatformCollidesWithPlayer(player)) {
                        collidedWithPlatform = true;
                        // Adjust player's Y position to prevent falling through the platform
                        newY = Math.min(newY, gameObjectHandler.platformObjectsList.get(j).getGameObjectY() - player.getPLAYER_HEIGHT_Y());
                    }
                }



            monsterHandler.HandleMonsterCollision();

            ui.playerGraphics.setLocation(newX, newY);

            // Update player position
            player.setPlayerX(newX);
            player.setPlayerY(newY);


            if (player.getPlayerDirection().equals("right")){
                playerAbilitiesHandler.GetAbilityFromIndex(0).abilityLabel.setLocation(newX+player.getPLAYER_WIDTH_X(),newY+player.getPLAYER_CENTER_Y());

            }else if (player.getPlayerDirection().equals("left")){
                playerAbilitiesHandler.GetAbilityFromIndex(0).abilityLabel.setLocation(newX-player.getPLAYER_WIDTH_X()*2,newY+player.getPLAYER_CENTER_Y());
            }

            try {
                Thread.sleep(2); // Adjust for smoother movement
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }


        // Update player state
        if ((endY >= ui.mainGraphicsPane.getHeight() - player.getPLAYER_HEIGHT_Y()) ) {
            playerState = PlayerState.GROUNDED;
        } else if (collidedWithPlatform) {
            playerState = PlayerState.PLATFORM;

        } else {
            playerState = PlayerState.FALLING;
        }
    }
}