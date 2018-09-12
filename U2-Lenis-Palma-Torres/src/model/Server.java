package model;

public class Server {
	private HashTableOpen<String,Queue<Player>> queues;
	
	public Server() {
		setQueues(new HashTableOpen<String,Queue<Player>>(8));
		try {
			queues.insert("Xbox", new Queue<Player>());
			queues.insert("PlayStation", new Queue<Player>());
			queues.insert("Switch", new Queue<Player>());
			queues.insert("Pc", new Queue<Player>());
			queues.insert("Mobile", new Queue<Player>());
			queues.insert("All", new Queue<Player>());
			
		} catch (HashTableException e) {
			e.printStackTrace();
		}
		
	}
	
	public void addNewPlatform(String platform) {
		try {
			queues.insert(platform, new Queue<Player>());
		} catch (HashTableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addPlayer(Player ready) {
		queues.search(ready.getPlatform()).enqueue(ready);
	}

	public HashTableOpen<String,Queue<Player>> getQueues() {
		return queues;
		
	}

	public void setQueues(HashTableOpen<String,Queue<Player>> queues) {
		this.queues = queues;
	}
}
