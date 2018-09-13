package model;

public class Pickaxe extends Weapon{

	public Pickaxe(String name, String range, String type, int supplies) {
		super(name, range, type, supplies);
	}
	
	@Override
	public boolean useWeapon() {
		return false;
	}

}
