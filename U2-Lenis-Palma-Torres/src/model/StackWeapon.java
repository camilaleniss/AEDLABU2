package model;

public class StackWeapon extends Stack<Weapon>{
	
	public StackWeapon() {
		Weapon pickaxe = new Pickaxe();
		super.push(pickaxe);
	}

	public void useWeapon() {
			try {
				top().useWeapon();
				boolean emptyWeapon =top().isEmpty();
				if (emptyWeapon)
					pop();
			} catch (StackException e) {
				e.printStackTrace();
			}
	}
	
	@Override
	public Weapon pop() throws StackException {
		if(size()>1) {
			return super.pop();
		} else {
			throw new StackException("Trying to get pop from the pickaxe");
		}	
	}

}
