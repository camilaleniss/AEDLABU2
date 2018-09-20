package model;

public class StackWeapon extends Stack<Weapon>{
	/**
	 * This Stack has by default an ax (called pickaxe in Fortnite) that can�t be popped 
	 * This Stack can push Weapons that can be used by the method useWeapon
	 */
	public StackWeapon() {
		Weapon pickaxe = new Pickaxe();
		super.push(pickaxe);
	}

	/**
	 * This method use the Weapon that is in the top
	 * pre: Stack is not empty 
	 * post: The weapon of the top has -1 supplies and if it hasn�t supplies it pops it. 
	 */
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
	
	/**
	 * The Stack only can pop the weapon that does not have supplies
	 * It can not pop the pickaxe.
	 */
	@Override
	public Weapon pop() throws StackException {
		if(size()>1) {
			return super.pop();
		} else {
			throw new StackException("Trying to get pop from the pickaxe");
		}	
	}

}
