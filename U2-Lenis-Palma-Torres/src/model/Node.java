package model;

public class Node <T> {

	private T value;
	private T next;
	
	public Node(T value) {
		this.value = value;
		next = null;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public T getNext() {
		return next;
	}

	public void setNext(T next) {
		this.next = next;
	}
	
	
	
}
