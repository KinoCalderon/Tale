package gameItems;

public class Item_Hp_Potion extends SuperConsumable{
	
	public Item_Hp_Potion(){
		setName("Hp Potion");
		setHealingValue(10);
		setType("Consumable");
		setConsumableType("Hp");
		setPrice(3);
	}

}
