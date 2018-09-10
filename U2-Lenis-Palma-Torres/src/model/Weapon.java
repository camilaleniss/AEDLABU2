package model;

public class Weapon{
	
	private String name;
	private String range;
	private String type;
	private int supplies;

	public Weapon(String name, String range, String type, int supplies) {
		this.name=name;
		this.range=range;
		this.type=type;
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
	
	public String getType() {
		return type;
	}
	
	public void setSupplies(int supplies) {
		this.supplies=supplies;
	}

	public boolean useWeapon() {
		supplies-=1;
		return (supplies==0);
	}
	
	public boolean isEmpty() {
		return (supplies>=0);
	}
	
	

}
