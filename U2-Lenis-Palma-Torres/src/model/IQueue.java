package model;

public interface IQueue <T>{
	
	public boolean isEmpty();
	
	public void enqueue(T item);
	
	public T front( ) throws QueueException;
	
	public T dequeue( ) throws QueueException;
	
	public int size();	

}
