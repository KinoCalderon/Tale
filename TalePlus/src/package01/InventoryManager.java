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
	
	public void SellPlayerItem(Player player, SuperItem item) {
		
		int slotNumber = 0;
		while(!player.inventoryItems[slotNumber].getName().equals("") && slotNumber <4) {
			slotNumber++;
		}
		if(player.inventoryItems[slotNumber].getName().equals("")) {
			if(player.getGold() >= item.getPrice()) {
				System.out.println("attempting to buy item..");
			player.inventoryItems[slotNumber] = item;
			player.setGold(-item.getPrice());}
				System.out.println("item sold " + item.getName());
			
		}
			else if(!player.inventoryItems[slotNumber].getName().equals("")) {
				System.out.println("player inventory is full");
		}
	}
	

}
