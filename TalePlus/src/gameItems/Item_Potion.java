package gameItems;

public class Item_Potion extends SuperConsumable{
	
	public Item_Potion(){
		setName("Potion");
		setHealingValue(10);
		setType("Consumable");
		setConsumableType("Hp");
		setPrice(3);
	}

}
