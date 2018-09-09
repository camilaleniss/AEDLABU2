package model;

public class StackWeapon<T> extends Stack<T> implements IStackWeapon<T>{
	
	public StackWeapon() {
		super();
		Node<Ax> ax = new Node<Ax>(new Ax("Ax", "Basic", 1));
		super.push(T ax = ax);
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
