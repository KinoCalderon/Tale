package npc;

import package02.Weapon_Dagger;
import package04.Item_Orange;
import package04.Item_Potion;
import package04.SuperItem;

public class TavernShopKeeper {
	
	private SuperItem[] shopItems = new SuperItem[5];
	private Item_Potion potion = new Item_Potion();
	private Weapon_Dagger dagger = new Weapon_Dagger();
	private Item_Orange orange = new Item_Orange();
	
	
	
	public TavernShopKeeper() {
		shopItems[0] = potion;
		shopItems[1] = dagger;
		shopItems[2] = orange;
		shopItems[3] = potion;
		shopItems[4] = potion;
		
	}
	
	
	public SuperItem getShopItems(int i) {
		return shopItems[i];
	}
	public void setShopItems(SuperItem[] shopItems) {
		this.shopItems = shopItems;
	}


	public Item_Potion getPotion() {
		return potion;
	}


	public void setPotion(Item_Potion potion) {
		this.potion = potion;
	}


	public Weapon_Dagger getDagger() {
		return dagger;
	}


	public void setDagger(Weapon_Dagger dagger) {
		this.dagger = dagger;
	}


	public Item_Orange getOrange() {
		return orange;
	}


	public void setOrange(Item_Orange orange) {
		this.orange = orange;
	}
	
	public String sellMessage(SuperItem item) {
		String string = "Item Bought: " + item.getName() + " -" + item.getPrice() + "gold";
		return string;
	}

}
