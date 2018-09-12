package model;

public class Server {
	private HashTableOpen<String,Queue<Player>> queues;
	
	public Server() {
		setQueues(new HashTableOpen<String,Queue<Player>>(8));
		try {
			queues.insert("Xbox", new Queue<Player>());
			
		} catch (HashTableException e) {
			e.printStackTrace();
		}
		
	}

	public HashTableOpen<String,Queue<Player>> getQueues() {
		return queues;
	}

	public void setQueues(HashTableOpen<String,Queue<Player>> queues) {
		this.queues = queues;
	}
}
