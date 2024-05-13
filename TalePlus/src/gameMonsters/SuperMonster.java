package gameMonsters;

import main.Game;
import main.Player;
import gameUI.UI;

import javax.swing.*;
import java.awt.*;
import java.util.TimerTask;
import java.util.Timer;

public class SuperMonster {

	private int monsterSpeed;
	private int monsterMoveDelay;
	private String name;
	private int hp;
	private int maxHp;
	private int monsterDamage;
	private int monsterX;
	private int monsterY;
	private int monsterOriginalX;
	private int monsterOriginalY;
	private int width;
	private int height;
	public JLabel monsterLabel;
	protected Player player;
	protected UI ui;
	protected Game game;
	private int monsterGold;
	private int damageCooldown = 1000;
	private int lastDamageTime = 0;

	private boolean movingRight = true; // Flag to track the movement direction


	private Timer moveTimer;

	public Timer monsterRespawnTimer;

	public SuperMonster(Game game, Player player, UI ui) {
		this.game = game;
		this.player = player;
		this.ui = ui;

		monsterRespawnTimer = new Timer();
		moveTimer = new Timer();
	}



	// Method to stop the move timer
	public void stopMoveTimer() {
		moveTimer.cancel();
	}

	// Method to start the respawn timer
	public void startRespawnTimer() {
		DropLoot();

		// Cancel the previous timer if it exists
		if (monsterRespawnTimer != null) {
			monsterRespawnTimer.cancel();
		}

		// Initialize a new timer
		monsterRespawnTimer = new Timer();

		// Schedule the respawn task to execute after 7 seconds (7000 milliseconds)
		monsterRespawnTimer.schedule(new TimerTask() {
			@Override
			public void run() {
				respawn();
				// Method to respawn the monster
			}
		}, 7000); // 7 seconds delay (7000 milliseconds)
	}

	public void respawn() {
		setHp(maxHp);
		setMonsterX(getMonsterOriginalX());
		setMonsterY(getMonsterOriginalY());
		monsterLabel.setLocation(getMonsterOriginalX(), getMonsterOriginalY());
		ui.mainGraphicsPane.add(monsterLabel);
		ui.mainGraphicsPane.repaint();
	}

	public void DropLoot() {
		player.setGold(this.monsterGold);
		ui.goldLabel.setText(" Gold: " + player.getGold());
	}

	public boolean CollidesWithPlayer(Player player) {
		Rectangle monsterBounds = new Rectangle(monsterX, monsterY, width, height);
		Rectangle playerBounds = new Rectangle(player.getPlayerX(), player.getPlayerY()+15, player.getPLAYER_WIDTH_X(), player.getPLAYER_HEIGHT_Y());



		return monsterBounds.intersects(playerBounds);
	}

	public boolean isMovingRight() {
		return movingRight;
	}

	public void setMovingRight(boolean movingRight) {
		this.movingRight = movingRight;
	}

	public void HurtMonster(int damage){
		this.hp = this.hp - damage;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}


	public int getMonsterX() {
		return monsterX;
	}

	public void setMonsterX(int monsterX) {
		this.monsterX = monsterX;
	}

	public int getMonsterY() {
		return monsterY;
	}

	public void setMonsterY(int monsterY) {
		this.monsterY = monsterY;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public JLabel getMonsterLabel() {
		return monsterLabel;
	}

	public void setMonsterLabel(JLabel monsterLabel) {
		this.monsterLabel = monsterLabel;
	}

	public int getMonsterDamage() {
		return monsterDamage;
	}

	public void setMonsterDamage(int monsterDamage) {
		this.monsterDamage = monsterDamage;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public int getMonsterGold() {
		return monsterGold;
	}

	public void setMonsterGold(int monsterGold) {
		this.monsterGold = monsterGold;
	}

	public int getMonsterOriginalX() {
		return monsterOriginalX;
	}

	public void setMonsterOriginalX(int monsterOriginalX) {
		this.monsterOriginalX = monsterOriginalX;
	}

	public int getMonsterOriginalY() {
		return monsterOriginalY;
	}

	public void setMonsterOriginalY(int monsterOriginalY) {
		this.monsterOriginalY = monsterOriginalY;
	}

	public int getMonsterSpeed() {
		return monsterSpeed;
	}

	public void setMonsterSpeed(int monsterSpeed) {
		this.monsterSpeed = monsterSpeed;
	}

	public int getMonsterMoveDelay() {
		return monsterMoveDelay;
	}

	public void setMonsterMoveDelay(int monsterMoveDelay) {
		this.monsterMoveDelay = monsterMoveDelay;
	}

	// Other getters and setters...
}
