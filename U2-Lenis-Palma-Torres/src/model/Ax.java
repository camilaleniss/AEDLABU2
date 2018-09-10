package model;

public class Ax extends Weapon{

	public Ax(String name, String range, String type, int supplies) {
		super(name, range, type, supplies);
	}
	
	@Override
	public boolean useWeapon() {
		return false;
	}

}
