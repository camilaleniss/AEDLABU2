package model;

public class Weapon{
	
	private String name;
	private String range;
	private int supplies;

	public Weapon(String name, String range, int supplies) {
		this.name=name;
		this.range=range;
		this.supplies=supplies;
	}

	public String getName() {
		return name;
	}

	public String getRange() {
		return range;
	}

	public int getSupplies() {
		return supplies;
	}
	
	public void setSupplies(int supplies) {
		this.supplies=supplies;
	}

	public void useWeapon() {
		supplies-=1;
	}
	
	public boolean isEmpty() {
		return (supplies>=0);
	}
	
	

}
