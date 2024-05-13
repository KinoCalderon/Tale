package gameHandlers;


import main.Player;
import gameItems.SuperConsumable;
import gameItems.SuperItem;

public class InventoryManager {

	public void GivePlayerItem(Player player, SuperItem item) {
		
		int slotNumber = 0;
		while(player.inventoryItems[slotNumber] != player.empty && slotNumber <4) {
			slotNumber++;
		}

		if(player.inventoryItems[slotNumber] == player.empty) {
			player.inventoryItems[slotNumber] = item;
		}
		else if(player.inventoryItems[slotNumber] != player.empty) {
				System.out.println("player inventory is full");
		}
	}
	
	public boolean BuyItem(Player player, SuperItem item) {
		
		int slotNumber = 0;
		boolean itemSold = false;
		while(player.inventoryItems[slotNumber] != player.empty && slotNumber <4) {
			slotNumber++;
		}
		if(player.inventoryItems[slotNumber] == player.empty && player.getGold() >= item.getPrice()) {
			if (item.getName().equals("Hp Potion")){

				System.out.println("attempting to buy item..");
				player.addHpPotion(item);

				player.setGold(-item.getPrice());

				itemSold = true;
				System.out.println("item sold " + item.getName());
			} else if (item.getName().equals("Mp Potion")) {

				System.out.println("attempting to buy item..");
				player.addMpPotion(item);

				player.setGold(-item.getPrice());

				itemSold = true;
				System.out.println("item sold " + item.getName());
			} else {
				System.out.println("attempting to buy item..");

				player.inventoryItems[slotNumber] = item;
				player.setGold(-item.getPrice());

				itemSold = true;
				System.out.println("item sold " + item.getName());
			}
			
		}
		else if(!player.inventoryItems[slotNumber].getName().isEmpty() || player.getGold() < item.getPrice()) {
				System.out.println("player inventory is full or not enough gold");
		}
		return itemSold;
	}
	
	public boolean SellItemToShop(Player player, SuperItem item) {

		boolean itemSold;

		if(player.getPlayerInventoryIndex() >=0 || player.getPlayerInventoryIndex() <=4) {
			System.out.println("Player sold: " + item.getName() + " for " + item.getPrice() + " Gold");
			player.inventoryItems[player.getPlayerItemIndex()] = player.empty;
			player.setGold(+item.getPrice());
			itemSold = true;

		}
		else {
			itemSold = false;
			System.out.println("item not sold to shop@@@@");
		}
		return itemSold;
	}

	public void itemUsed(int slotNumber, Player player) {
		//set the item used = to a temporary SuperItem variable
		SuperItem currentItem = player.inventoryItems[slotNumber];
		//check to see if the current item used is a Consumable
		if(currentItem instanceof SuperConsumable consumableItem) {
			System.out.println("Player used item: " + consumableItem.getName());
			player.healPlayer(consumableItem.getHealingValue());
			player.inventoryItems[slotNumber] = player.empty;
			System.out.println("Player healed for: " + consumableItem.getHealingValue());
		}
		else {
			System.out.println("no value found");
		}
	}

	public void equipItem(int slotNumber, Player player) {
		// Check if the slotNumber is valid
		if (slotNumber >= 0 && slotNumber < player.equippedItems.length) {
			//set the item used = to a temporary currentItem variable
			SuperItem currentItem = player.inventoryItems[player.getPlayerItemIndex()];

				player.inventoryItems[player.getPlayerItemIndex()] = player.equippedItems[currentItem.getItemIndex()];
				player.equippedItems[currentItem.getItemIndex()] = currentItem;
				player.setCurrentWeapon(player.equippedItems[0]);
				player.setCurrentArmor(player.equippedItems[1]);
				player.setDamage(player.equippedItems[0].getDamageValue());
				player.setArmor(player.equippedItems[1].getArmorValue());

			}
			else {
				System.out.println("No item found*");
			}
		}




	public void UnEquipItem(Player player, SuperItem item) {

		int slotNumber = 0;
		while(player.inventoryItems[slotNumber] != player.empty && slotNumber <4) {
			slotNumber++;
		}
		if(player.inventoryItems[slotNumber] == player.empty) {
			player.inventoryItems[slotNumber] = player.equippedItems[item.getItemIndex()];
			player.equippedItems[item.getItemIndex()] = player.empty;


			player.setCurrentWeapon(player.equippedItems[0]);
			player.setCurrentArmor(player.equippedItems[1]);
			player.setDamage(player.equippedItems[0].getDamageValue());
			player.setArmor(player.equippedItems[1].getArmorValue());

		}
		else if(player.inventoryItems[slotNumber] != player.empty) {
			System.out.println("player inventory is full");
		}
	}
	

	
	public boolean IsInventoryFull(Player player) {
		
		int slotNumber = 0;
		boolean isFull = false;
		while(player.inventoryItems[slotNumber] != player.empty && slotNumber <4) {
			slotNumber++;
		}
		if(player.inventoryItems[slotNumber] == player.empty) {
			isFull = false;
		}
		else if(player.inventoryItems[slotNumber] != player.empty) {
				System.out.println("player inventory is full");
				isFull = true;
		}
		return isFull;
		
	}
	
	public String OutOfGoldMessage() {
		String string = "Sorry not enough gold...";
		return string;
	}
}
