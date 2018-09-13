package model;

public class StackWeapon extends Stack<Weapon>{
	
	public StackWeapon() {
		Weapon weapon = new Pickaxe("Pickaxe", "Basic", "Default", 1);
		super.push(weapon);
	}

	public void useWeapon() {
			try {
				boolean empty =top().useWeapon();
				if (empty)
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
