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
	

}
