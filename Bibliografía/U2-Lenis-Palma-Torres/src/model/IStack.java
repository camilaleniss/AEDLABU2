package model;

public interface IStack <T> {
	
	public boolean isEmpty();
	
	public void push(T item);
	
	public T top() throws StackException;
	
	public T pop() throws StackException;
	
	public int size();

}
