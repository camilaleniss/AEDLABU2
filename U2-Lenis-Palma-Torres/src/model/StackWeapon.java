package model;

public class StackWeapon extends Stack<Weapon>{
	
	public StackWeapon() {
		Weapon weapon = new Ax("Ax", "Basic", "Default", 1);
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
			throw new StackException("Trying to get pop from the ax");
		}	
	}

	/*
	@Override
	public T top() throws StackException {
		if(!isEmpty()) {
			return top.getValue();
		} else {
			throw new StackException("This Stack cannot be empty");
		}
	}
	*/
}
