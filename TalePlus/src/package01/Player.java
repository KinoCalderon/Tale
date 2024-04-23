package package01;

import GameStates.GameState;
import GameStates.TavernState;
import package02.Armor_Cloth_Body;
import package02.Weapon_Dagger;
import package04.Item_Empty;
import package04.Item_Orange;
import package04.Item_Potion;
import package04.SuperItem;
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
        inventoryItems[2] = clothBody;
        inventoryItems[3] = dagger;
        inventoryItems[4] = dagger;
    	
        currentWeapon = equippedItems[0];
        currentArmor = equippedItems[1];
        
        level = 1;
        maxHp = 10;
        currentHp = maxHp;
        maxMp = 10;
        damage = currentWeapon.getDamageValue();
        armor = currentArmor.getArmorValue();
        currentMp = maxMp;
        currentExp = 0;
        maxExp = level * 10;
        gold = 100;
        playerAlive = true;
        
        
        
        inventoryStatus = "close";
        shopStatus = "close";
        
        setPlayerItemIndex(-1);
        setPlayerItemIndex(-1);
        
        
        
        
        
        
    }
    

    
    public  GameState getCurrentState() {
        return currentState;
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
	
	public boolean isInventoryFull() {
		
		for(int i = 0; i < inventoryItems.length; i++) {
			if (inventoryItems[i] != this.empty) {
				setInventoryFull(true);
				}
			else if(inventoryItems[i] == this.empty) {
				setInventoryFull(false);
			}
		}
		return inventoryFull;	
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
	
	

}
