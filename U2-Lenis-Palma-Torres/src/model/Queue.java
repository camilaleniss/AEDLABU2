package model;

public class Queue <T> implements IQueue<T>{
	
	private Node<T> first;
	private Node<T> last;
	
	public Queue() {
		first = null;
		last = null;
	}

	@Override
	public boolean isEmpty() {
		return first == null;
	}

	@Override
	public void enqueue(T item) {
		Node<T> toAdd = new Node<>(item);
		if(isEmpty()) {
			first = toAdd;
			last = toAdd;
		} else {
			last.setNext(toAdd);
			last = toAdd;
		}
	}

	@Override
	public T front() throws QueueException {
		if(!isEmpty()) {
			return first.getValue();
		} else {
			throw new QueueException("Cannot get front from an empty queue");
		}
	}

	@Override
	public T dequeue() throws QueueException {
		if(!isEmpty()) {
			Node<T> toDequeue = first;
			first = first.getNext();
			return toDequeue.getValue();
		} else {
			throw new QueueException("Cannot dequeue from an empty queue");
		}
	}

}
