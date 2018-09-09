package model;

public class Ax extends Weapon{

	public Ax(String name, String range, int supplies) {
		super(name, range, supplies);
	}
	
	@Override
	public void useWeapon() {
		super.useWeapon();
		super.setSupplies(super.getSupplies()+1);
	}

}
