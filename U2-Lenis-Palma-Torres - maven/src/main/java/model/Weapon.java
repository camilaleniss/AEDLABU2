package model;

import javafx.scene.image.Image;

public class Weapon{
	
	public static final String BASIC = "Basic";
	public static final String UNCOMMON = "Uncommon";
	public static final String RARE = "Rare";
	public static final String EPIC = "Epic";
	public static final String LEGENDARY = "Legendary";
	
	private String name;
	private String range;
	private String type;
	private Image image;
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
	
	public void addSupplies(int supplies) {
		this.supplies += supplies;
	}

	public void useWeapon() {
		if (supplies > 0 ) supplies-=1;
	}
	
	public boolean isEmpty() {
		return (supplies==0);
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

}
