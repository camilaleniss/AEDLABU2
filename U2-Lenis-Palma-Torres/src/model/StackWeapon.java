package model;

public class StackWeapon<T> extends Stack<T> implements IStackWeapon<T>{
	
	public StackWeapon() {
		//IDK
	}

	@Override
	public void useWeapon() {
		
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
