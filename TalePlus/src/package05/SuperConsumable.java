package package05;

public class SuperConsumable extends SuperItem {
	
	private int healingValue;
	private String consumableType;
	
	public int getHealingValue() {
		return healingValue;
	}
	public void setHealingValue(int healingValue) {
		this.healingValue = healingValue;
	}


	public String getConsumableType() {
		return consumableType;
	}

	public void setConsumableType(String consumableType) {
		this.consumableType = consumableType;
	}
}
