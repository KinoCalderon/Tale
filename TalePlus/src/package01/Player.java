package package01;
//MAKE A GET INVENTORY FUNCTION THAT DISPLAYS THE PLAYERS INVO INFO TO THE UI UPDATE TEXT AREA
//
import GameStates.GameState;
import package06.Armor_Cloth_Body;
import package06.Weapon_Dagger;
import package05.Item_Empty;
import package05.Item_Orange;
import package05.Item_Potion;
import package05.SuperItem;
public class Player { 
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
    private static String shopStatus;
    private static String inventoryStatus;
    private int playerItemIndex;
    private int playerEquipmentIndex;
    private int playerInventoryIndex;
    private int shopItemIndex;
    public SuperItem[] equippedItems = new SuperItem[3];
    public Weapon_Dagger dagger = new Weapon_Dagger();
    public Armor_Cloth_Body clothBody = new Armor_Cloth_Body();
	public SuperItem[] inventoryItems = new SuperItem[5];
	public Item_Potion potion = new Item_Potion();
	public Item_Orange orange = new Item_Orange( );
	public Item_Empty empty = new Item_Empty( );
	public Game game;

    public Player( Game game) {
    	this.game = game;
    	
        equippedItems[0] = empty;
        equippedItems[1] = empty;
        equippedItems[2] = empty;
        
        inventoryItems[0] = potion;
        inventoryItems[1] = orange;
        inventoryItems[2] = empty;
        inventoryItems[3] = dagger;
        inventoryItems[4] = dagger;
    	
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
                
        inventoryStatus = "close";
        shopStatus = "close";
        
        setPlayerItemIndex(-1);
        setPlayerInventoryIndex(-1);
        
      
        
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
        this.currentMp = currentMp;
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
		Player.inventoryStatus = inventoryStatus;
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
		Player.shopStatus = string;
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
}
