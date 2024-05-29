package main;
//MAKE A GET INVENTORY FUNCTION THAT DISPLAYS THE PLAYERS INVO INFO TO THE UI UPDATE TEXT AREA
//
import GameStates.GameState;
import gameEquipment.Armor_Cloth_Body;
import gameEquipment.Weapon_Dagger;
import gameItems.*;

import java.util.ArrayList;

public class Player {


    private volatile boolean isSpacePressed = false;
    private volatile boolean isUpPressed = false;
    private volatile boolean isDownPressed = false;
    private volatile boolean isLeftPressed = false;
    private volatile boolean isRightPressed = false;
    private volatile boolean isPlayerMoving = false;
    private boolean checkIfOnRope = false;
    private String playerDirection;
    private boolean isFacingRight;
    private String shopLocation;
    private final int PLAYER_WIDTH_X = 30;
    private final int PLAYER_HEIGHT_Y = 60;
    private final int PLAYER_CENTER_X = PLAYER_WIDTH_X/2;
    private final int PLAYER_CENTER_Y = PLAYER_HEIGHT_Y/2;
    private int playerX;
    private int playerY;
    private GameState currentState;
    private SuperItem currentWeapon;
    private SuperItem currentArmor;
    private int maxHp;
    private int currentHp;
    private int maxMp;
    private int currentMp;
    private int maxExp;
    private int currentExp;
    private int strengthStat;
    private int defenceStat;
    private int level;
    private int gold;
    private int damage;
    private int armor;
    private boolean playerAlive;
    private boolean inventoryFull;
    private String shopStatus;
    private String inventoryStatus;
    private String statScreenStatus;
    private String textFieldStatus;
    private int playerItemIndex;
    private int playerEquipmentIndex;
    private int playerInventoryIndex;
    private int shopItemIndex;
    public SuperItem[] equippedItems = new SuperItem[3];
    public Weapon_Dagger dagger = new Weapon_Dagger();
    public Armor_Cloth_Body clothBody = new Armor_Cloth_Body();
	public SuperItem[] inventoryItems = new SuperItem[5];
	public Item_Hp_Potion hpPotion = new Item_Hp_Potion();
    public Item_Mp_Potion mpPotion = new Item_Mp_Potion();
	public Item_Empty empty = new Item_Empty( );
    private ArrayList<SuperItem> hpPotionArray = new ArrayList<>();
    private ArrayList<SuperItem> mpPotionArray = new ArrayList<>();
    public Game game;

    public Player( Game game) {
    	this.game = game;

        playerX = 5;
        playerY = 360;
        isFacingRight = true;
        setUpPressed(false);
        playerDirection = "right";

        equippedItems[0] = empty;
        equippedItems[1] = empty;
        equippedItems[2] = empty;

        hpPotionArray.add(hpPotion);
        mpPotionArray.add(mpPotion);

        inventoryItems[0] = clothBody;
        inventoryItems[1] = dagger;
        inventoryItems[2] = empty;
        inventoryItems[3] = empty;
        inventoryItems[4] = empty;

        currentWeapon = equippedItems[0];
        currentArmor = equippedItems[1];

        level = 1;
        maxHp = 10;
        currentHp = maxHp;
        maxMp = 10;
        currentMp = maxMp;
        strengthStat = 1;
        defenceStat = 1;
        damage = currentWeapon.getDamageValue();
        armor = currentArmor.getArmorValue();
        currentExp = 0;
        maxExp = level * 10;
        gold = 100;
        playerAlive = true;

        shopLocation = "none";
        statScreenStatus = "close";
        inventoryStatus = "close";
        shopStatus = "close";
        textFieldStatus = "close";

        setPlayerItemIndex(-1);
        setPlayerInventoryIndex(-1);



    }

    public boolean IsPlayerHpZero(){
        boolean isZero = false;
        if (getCurrentHp() == 0){
            System.out.println("player is dead");
            setCurrentHp(0);
            isZero = true;
        }
        return isZero;
    }
    public void GetPlayerCoordinates(){
        System.out.println("Player Coordinates x:" + playerX + ", y:" + playerY);
    }

    public  GameState getCurrentState() {
        return currentState;
    }
    public void setAbsoluteCurrentState() {
    	currentState = GameState.getCurrentState();
    }
    public void setCurrentState(GameState state) {
        currentState = state;
    }      

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }

    public int getMaxMp() {
        return maxMp;
    }

    public void setMaxMp(int maxMp) {
        this.maxMp = maxMp;
    }

    public int getCurrentMp() {
        return currentMp;
    }

    public void setCurrentMp(int currentMp) {
        this.currentMp += currentMp;
    }

    public int getMaxExp() {
        return maxExp;
    }

    public void setMaxExp(int maxExp) {
        this.maxExp = maxExp;
    }

    public int getCurrentExp() {
        return currentExp;
    }

    public void setCurrentExp(int currentExp) {
        this.currentExp = currentExp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold += gold;
    }

    public boolean isPlayerAlive() {
        return playerAlive;
    }

    public void setPlayerAlive(boolean playerAlive) {
        this.playerAlive = playerAlive;
    }

    public void gainXp(int amount) {
        setCurrentExp(getCurrentExp() + amount);
        if (getCurrentExp() >= getMaxExp()) {
            levelUp();
        }
    }

    private void levelUp() {
        setLevel(getLevel() + 1);
        setCurrentExp(0);
        setMaxExp(getLevel() * 10);
    }
    
    public void takeDamage(int damage) {
        setCurrentHp(Math.max(0, getCurrentHp() - damage));
        if (getCurrentHp() == 0) {
            setPlayerAlive(false);
        }
    }

    public void healPlayer(int amount) {
        setCurrentHp(Math.min(getMaxHp(), getCurrentHp() + amount));
        if (currentHp > maxHp) {
        	setCurrentHp(maxHp);
        }
    }

    public void restoreMp(int amount) {
        setCurrentMp(Math.min(getMaxMp(), getCurrentMp() + amount));
        
    }

	public  String getInventoryStatus() {
		return inventoryStatus;
	}

	public  void setInventoryStatus(String inventoryStatus) {
		this.inventoryStatus = inventoryStatus;
	}
	
		

	public int getPlayerItemIndex() {
		return playerItemIndex;
	}



	public void setPlayerItemIndex(int playerItemIndex) {
		this.playerItemIndex = playerItemIndex;
	}
	



	public boolean setInventoryFull(boolean inventoryFull) {
		return this.inventoryFull = inventoryFull;
	}
	
	public boolean getInventoryFull() {
		
		return inventoryFull;
	}



	public int getPlayerEquipmentIndex() {
		return playerEquipmentIndex;
	}



	public void setPlayerEquipmentIndex(int playerEquipmentIndex) {
		this.playerEquipmentIndex = playerEquipmentIndex;
	}



	public SuperItem getCurrentWeapon() {
		return currentWeapon;
	}



	public void setCurrentWeapon(SuperItem currentWeapon) {
		this.currentWeapon = currentWeapon;
	}



	public SuperItem getCurrentArmor() {
		return currentArmor;
	}



	public void setCurrentArmor(SuperItem currentArmor) {
		this.currentArmor = currentArmor;
	}



	public int getDamage() {
		return damage;
	}



	public void setDamage(int damage) {
		this.damage = damage;
	}



	public int getArmor() {
		return armor;
	}



	public void setArmor(int armor) {
		this.armor = armor;
	}



	public String getShopStatus() {
		return shopStatus;
	}



	public void setShopStatus(String string) {
		this.shopStatus = string;
	}



	public int getPlayerInventoryIndex() {
		return playerInventoryIndex;
	}



	public void setPlayerInventoryIndex(int playerInventoryIndex) {
		this.playerInventoryIndex = playerInventoryIndex;
	}



	public int getStrengthStat() {
		return strengthStat;
	}



	public void setStrengthStat(int strengthStat) {
		this.strengthStat = strengthStat;
	}



	public int getDefenceStat() {
		return defenceStat;
	}



	public void setDefenceStat(int defenceStat) {
		this.defenceStat = defenceStat;
	}
	
	@Override
	public String toString() {
	    return "Player{" +
	            "currentState=" + currentState +
	            ", currentWeapon=" + currentWeapon.getName() +
	            ", currentArmor=" + currentArmor.getName() +
	            ", maxHp=" + maxHp +
	            ", currentHp=" + currentHp +
	            ", maxMp=" + maxMp +
	            ", currentMp=" + currentMp +
	            ", maxExp=" + maxExp +
	            ", currentExp=" + currentExp +
	            ", strengthStat=" + strengthStat +
	            ", defenceStat=" + defenceStat +
	            ", level=" + level +
	            ", gold=" + gold +
	            ", damage=" + getDamage() +
	            ", armor=" + armor +
	            ", playerAlive=" + playerAlive +
	            ", inventoryFull=" + inventoryFull +
	            ", shopStatus='" + shopStatus + '\'' +
	            ", inventoryStatus='" + inventoryStatus + '\'' +
	            ", playerItemIndex=" + playerItemIndex +
	            ", playerEquipmentIndex=" + playerEquipmentIndex +
	            ", playerInventoryIndex=" + playerInventoryIndex +
	            '}';
	}


    public int getShopItemIndex() {
        return shopItemIndex;
    }

    public void setShopItemIndex(int shopItemIndex) {
        this.shopItemIndex = shopItemIndex;
    }

    public String getStatScreenStatus() {
        return statScreenStatus;
    }

    public void setStatScreenStatus(String statScreenStatus) {
        this.statScreenStatus = statScreenStatus;
    }

    public boolean isInventoryIndexEmpty(int index){
        Boolean isEmpty;
        if (inventoryItems[index].getName().isEmpty()){
            isEmpty = true;
        }else {
            isEmpty = false;
        }
        return isEmpty;
    }


    public int getPlayerX() {
        return playerX;
    }

    public void setPlayerX(int playerX) {
        this.playerX = playerX;
    }

    public int getPlayerY() {
        return playerY;
    }

    public void setPlayerY(int playerY) {
        this.playerY = playerY;
    }

    public void setPlayerPosition(int x, int y) {
    }

    public void setLocation(int newX, int newY) {
        this.playerX = newX;
        this.playerY = newY;
    }

    public int getPLAYER_WIDTH_X() {
        return PLAYER_WIDTH_X;
    }

    public int getPLAYER_HEIGHT_Y() {
        return PLAYER_HEIGHT_Y;
    }

    public String getShopLocation() {
        return shopLocation;
    }

    public void setShopLocation(String shopLocation) {
        this.shopLocation = shopLocation;
    }


    public String getTextFieldStatus() {
        return textFieldStatus;
    }

    public void setTextFieldStatus(String textFieldStatus) {
        this.textFieldStatus = textFieldStatus;
    }


    public boolean isFacingRight() {
        return isFacingRight;
    }

    public void setFacingRight(boolean facingRight) {
        isFacingRight = facingRight;
    }

    public boolean isSpacePressed() {
        return isSpacePressed;
    }

    public void setSpacePressed(boolean spacePressed) {
        isSpacePressed = spacePressed;
    }

    public boolean isLeftPressed() {
        return isLeftPressed;
    }

    public void setLeftPressed(boolean leftPressed) {
        isLeftPressed = leftPressed;
    }

    public boolean isRightPressed() {
        return isRightPressed;
    }

    public void setRightPressed(boolean rightPressed) {
        isRightPressed = rightPressed;
    }

    public String getPlayerDirection() {
        return playerDirection;
    }

    public void setPlayerDirection(String playerDirection) {
        this.playerDirection = playerDirection;
    }

    public boolean isPlayerMoving() {
        return isPlayerMoving;
    }

    public void setPlayerMoving(boolean playerMoving) {
        isPlayerMoving = playerMoving;
    }

    public int getPLAYER_CENTER_X() {
        return PLAYER_CENTER_X;
    }

    public int getPLAYER_CENTER_Y() {
        return PLAYER_CENTER_Y;
    }

    public ArrayList<SuperItem> getHpPotionArray() {
        return hpPotionArray;
    }

    public void setHpPotionArray(ArrayList<SuperItem> hpPotionArray) {
        this.hpPotionArray = hpPotionArray;
    }

    // Method to add a potion to the player's inventory
    public void addHpPotion(SuperItem potion) {
        hpPotionArray.add(potion);
    }

    // Method to remove a potion from the player's inventory
    public void removeHpPotion() {
        hpPotionArray.remove(0);
    }

    public ArrayList<SuperItem> getMpPotionArray() {
        return mpPotionArray;
    }

    public void setMpPotionArray(ArrayList<SuperItem> mpPotionArray) {
        this.mpPotionArray = mpPotionArray;
    }

    // Method to add a potion to the player's inventory
    public void addMpPotion(SuperItem potion) {
        mpPotionArray.add(potion);
    }

    // Method to remove a potion from the player's inventory
    public void removeMpPotion() {
        hpPotionArray.remove(0);
    }

   public boolean isUpPressed(){
        return isUpPressed;
   }

    public void setUpPressed(boolean upPressed) {
        isUpPressed = upPressed;
    }

    public boolean isDownPressed() {
        return isDownPressed;
    }

    public void setDownPressed(boolean downPressed) {
        isDownPressed = downPressed;
    }

    public boolean isCheckIfOnRope() {
        return checkIfOnRope;
    }

    public void setCheckIfOnRope(boolean checkIfOnRope) {
        this.checkIfOnRope = checkIfOnRope;
    }
}

