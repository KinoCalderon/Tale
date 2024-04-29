package package01;


import package04.SuperItem;

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
	
	public boolean SellPlayerItem(Player player, SuperItem item) {
		
		int slotNumber = 0;
		boolean itemSold = false;
		while(player.inventoryItems[slotNumber] != player.empty && slotNumber <4) {
			slotNumber++;
		}
		if(player.inventoryItems[slotNumber] == player.empty && player.getGold() >= item.getPrice()) {
			if(player.getGold() >= item.getPrice()) {
				System.out.println("attempting to buy item..");
			player.inventoryItems[slotNumber] = item;
			player.setGold(-item.getPrice());}
			itemSold = true;
				System.out.println("item sold " + item.getName());
			
		}
			else if(!player.inventoryItems[slotNumber].getName().equals("") || player.getGold() < item.getPrice()) {
			itemSold = false;
				System.out.println("player inventory is full or not enough gold");
		}
		return itemSold;
	}
	
	public boolean SellItemToShop(Player player, SuperItem item) {
		
		boolean itemSold = false;
		System.out.println("inside the sellitemtoshop method*");
		if(player.getPlayerInventoryIndex() >=0 || player.getPlayerInventoryIndex() <=4) {
			System.out.println("attempting to sell item to shop*" + item.getName());
			player.inventoryItems[player.getPlayerItemIndex()] = player.empty;
			player.setGold(+item.getPrice());
		itemSold = true;
		
		} else {
		itemSold = false;
			System.out.println("item not sold to shop*");
		}
		
		
		return itemSold;
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
