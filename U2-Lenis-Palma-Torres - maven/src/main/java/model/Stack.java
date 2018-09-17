package model;

public class Stack <T> implements IStack<T> {
	
	private Node<T> top;
	private int size;
	
	public Stack() {
		top = null;
		size = 0;
	}

	@Override
	public boolean isEmpty() {
		return top == null;
	}

	@Override
	public void push(T t) {
		Node<T> toAdd = new Node<>(t);
		toAdd.setNext(top);
		top = toAdd;
		size++;
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
			size--;
			return toPop.getValue();
		} else {
			throw new StackException("Trying to get top from an empty stack");
		}
		
	}
	
	public int size() {
		return size;
	}
	
}
