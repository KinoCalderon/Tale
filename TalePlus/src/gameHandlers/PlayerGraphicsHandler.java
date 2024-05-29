package gameHandlers;

import gameMonsters.SuperMonster;
import gameObjects.RopeObject;
import gameObjects.SuperGameObject;
import main.Game;
import main.Player;
import gameUI.UI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerGraphicsHandler implements KeyListener {
    private boolean collidedWithPlatform;
    private boolean collidesWithRope;
    private static final int ROPE_CLIMB_HEIGHT = 2;
    private static final double MOVE_SPEED = 2;
    private static final int INITIAL_JUMP_VELOCITY = 21;
    private static final int TERMINAL_VELOCITY = 25;
    private static final int KNOCK_BACK_VELOCITY_X = 7;
    private static final int KNOCK_BACK_VELOCITY_Y = 7;
    private static final int TERMINAL_KNOCK_BACK_VELOCITY_Y = 10;
    private double currentKnockBackVelocityY = 0;
    private double knockBackDirectionX = 0;
    private double currentJumpVelocity = 0;
    private static final double GRAVITY = 1.5;
    private static final double ASCENT_GRAVITY = 10;
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
        PLATFORM,
        KNOCKED_BACK
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
        if (playerState != PlayerState.ON_ROPE) {
            if (keyCode == KeyEvent.VK_D) {
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
            }
        }
        if (keyCode == KeyEvent.VK_W) {
            playerAbilitiesHandler.GetAbilityFromIndex(0).useAbility();
        }

        if (keyCode == KeyEvent.VK_UP) {
            playerAbilitiesHandler.GetAbilityFromIndex(0).RemoveAbilityFromScreen();

            player.setPlayerMoving(true);
            player.setUpPressed(true);
            player.setCheckIfOnRope(true);
        } else if (keyCode == KeyEvent.VK_DOWN) {
            playerAbilitiesHandler.GetAbilityFromIndex(0).RemoveAbilityFromScreen();
            player.setPlayerMoving(true);
            player.setDownPressed(true);
            player.setCheckIfOnRope(true);
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
            long currentTime = System.currentTimeMillis();
            int dx = 0, dy = 0;

            for (RopeObject ropeObject : gameObjectHandler.ropeObjectsList) {
                if (ropeObject.RopeCollidesWithPlayer(player)) {
                    collidesWithRope = true;
                    playerState = PlayerState.ON_ROPE;
                    break;
                }
            }

            for (SuperMonster monster : monsterHandler.monsterList) {
                if (monster.CollidesWithPlayer(player) && (currentTime - lastDamageTime) >= DAMAGE_COOLDOWN) {
                    currentKnockBackVelocityY = -KNOCK_BACK_VELOCITY_Y;
                    knockBackDirectionX = player.getPlayerDirection().equals("left") ? KNOCK_BACK_VELOCITY_X : -KNOCK_BACK_VELOCITY_X;
                    lastDamageTime = currentTime;
                    playerState = PlayerState.KNOCKED_BACK;
                    break;
                }
            }

            if (playerState != PlayerState.ON_ROPE) {
                if (player.isLeftPressed()) {
                    dx -= MOVE_SPEED;
                    ui.playerGraphics.setIcon(ui.playerImageLeft);
                }
                if (player.isRightPressed()) {
                    dx += MOVE_SPEED;
                    ui.playerGraphics.setIcon(ui.playerImageRight);
                }
                if (player.isSpacePressed() && playerState == PlayerState.GROUNDED && !hasJumped) {
                    currentJumpVelocity = -INITIAL_JUMP_VELOCITY;
                    playerState = PlayerState.JUMPING;
                    hasJumped = true;
                }
                if (player.isSpacePressed() && playerState == PlayerState.PLATFORM && !hasJumped) {
                    currentJumpVelocity = -INITIAL_JUMP_VELOCITY;
                    playerState = PlayerState.JUMPING;
                    hasJumped = true;
                }
            }

            switch (playerState) {
                case GROUNDED:
                    player.setCheckIfOnRope(false);
                    hasJumped = false;
                    break;

                case KNOCKED_BACK:
                    collidedWithPlatform = false;
                    hasJumped = true;
                    if (currentKnockBackVelocityY < 0) {
                        currentKnockBackVelocityY += GRAVITY;
                    } else {
                        currentKnockBackVelocityY += GRAVITY;
                        playerState = PlayerState.FALLING;
                    }
                    dy = (int) currentKnockBackVelocityY;
                    dx = (int) knockBackDirectionX;
                    if (dy > TERMINAL_KNOCK_BACK_VELOCITY_Y) {
                        dy = TERMINAL_KNOCK_BACK_VELOCITY_Y;
                    }
                    break;
                case JUMPING:
                    player.setSpacePressed(false);
                    collidedWithPlatform = false;
                    if (currentJumpVelocity < 0) {
                        currentJumpVelocity += ASCENT_GRAVITY;
                    } else {
                        playerState = PlayerState.FALLING;
                    }
                    dy = (int) currentJumpVelocity;
                    break;
                case FALLING:
                    collidedWithPlatform = false;
                    hasJumped = true;
                    currentJumpVelocity += GRAVITY;
                    dy = (int) currentJumpVelocity;
                    if (dy > TERMINAL_VELOCITY) {
                        dy = TERMINAL_VELOCITY;
                    }
                    break;
                case ON_ROPE:
                    hasJumped = false;
                    dx = 0; // Disable horizontal movement while on rope
                    if (player.isUpPressed()) {
                        dy -= ROPE_CLIMB_HEIGHT;
                    } else if (player.isDownPressed()) {
                        dy += ROPE_CLIMB_HEIGHT;
                    } else {
                        dy = 0; // Stay in place if no vertical movement
                    }
                    break;
                case PLATFORM:
                    player.setCheckIfOnRope(false);
                    hasJumped = false;
                    break;
            }

            movePlayer(dx, dy);

            try {
                Thread.sleep((long) 16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void movePlayer(int dx, int dy) {
        if (player.getShopStatus().equals("open")) {
            player.setRightPressed(false);
            player.setLeftPressed(false);
            player.setUpPressed(false);
        }

        int startX = ui.playerGraphics.getX();
        int startY = ui.playerGraphics.getY();
        int newX = startX + dx;
        int newY = startY + dy;

        newX = Math.min(Math.max(0, newX), ui.mainGraphicsPane.getWidth() - player.getPLAYER_WIDTH_X());
        newY = Math.min(Math.max(0, newY), ui.mainGraphicsPane.getHeight() - player.getPLAYER_HEIGHT_Y());

        collidedWithPlatform = false;

        for (int j = 0; j < gameObjectHandler.platformObjectsList.size(); j++) {
            if (platformCollisionDetected(startX, startY, newX, newY, gameObjectHandler.platformObjectsList.get(j))) {
                collidedWithPlatform = true;
                newY = Math.min(newY, gameObjectHandler.platformObjectsList.get(j).getGameObjectY() - player.getPLAYER_HEIGHT_Y());
            }
        }

        monsterHandler.HandleMonsterCollision();

        ui.playerGraphics.setLocation(newX, newY);

        player.setPlayerX(newX);
        player.setPlayerY(newY);

        if (player.getPlayerDirection().equals("right")) {
            playerAbilitiesHandler.GetAbilityFromIndex(0).abilityLabel.setLocation(newX + player.getPLAYER_WIDTH_X(), newY + player.getPLAYER_CENTER_Y());
        } else if (player.getPlayerDirection().equals("left")) {
            playerAbilitiesHandler.GetAbilityFromIndex(0).abilityLabel.setLocation(newX - player.getPLAYER_WIDTH_X() * 2, newY + player.getPLAYER_CENTER_Y());
        }

        if (newY >= ui.mainGraphicsPane.getHeight() - player.getPLAYER_HEIGHT_Y()) {
            playerState = PlayerState.GROUNDED;
        } else if (collidedWithPlatform) {
            playerState = PlayerState.PLATFORM;
        } else if (playerState != PlayerState.KNOCKED_BACK) {
            playerState = PlayerState.FALLING;
        }
    }

    private boolean platformCollisionDetected(int startX, int startY, int newX, int newY, SuperGameObject platform) {
        int stepCount = Math.max(Math.abs(newX - startX), Math.abs(newY - startY));

        if (stepCount == 0) {
            return platform.PlatformCollidesWithPlayer(player, newX, newY);
        }

        for (int step = 0; step <= stepCount; step++) {
            int testX = startX + (newX - startX) * step / stepCount;
            int testY = startY + (newY - startY) * step / stepCount;
            if (platform.PlatformCollidesWithPlayer(player, testX, testY)) {
                return true;
            }
        }
        return false;
    }
}
