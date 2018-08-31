package model;

public class Stack <T> implements IStack<T> {
	
	private Node<T> top;
	
	public Stack() {
		top = null;
	}

	@Override
	public boolean isEmpty() {
		return top == null;
	}

	@Override
	public void push(T item) {
		Node<T> toAdd = new Node<>(item);
		toAdd.setNext(top);
		top = toAdd;
	}

	@Override
	public T top() throws StackException {
		if(!isEmpty()) {
			return top.getValue();
		} else {
			throw new StackException("Cannot get top from an empty stack");
		}
	}

	@Override
	public T pop() throws StackException {
		if(!isEmpty()) {
			Node<T> toPop = top;
			top = toPop.getNext();
			return toPop.getValue();
		} else {
			throw new StackException("Trying to get top from an empty stack");
		}
		
	}
	
}
