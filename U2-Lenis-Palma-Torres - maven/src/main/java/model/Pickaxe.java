package model;

import javafx.scene.image.Image;

public class Pickaxe extends Weapon{

	public Pickaxe() {
		super("Pickaxe", Weapon.BASIC, "Default", 1);
		setImage(new Image(getClass().getResourceAsStream("/img/weapons/pickaxe.png")));
	}
	
	@Override
	public void addSupplies(int supplies) {
		
	}
	
	@Override
	public void useWeapon() {
		
	}

}
