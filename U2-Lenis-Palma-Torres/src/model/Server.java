package model;

public class Server {
	private HashTableOpen<String, Queue<Player>> platform;
	public Server() {
		platform= new HashTableOpen<String, Queue<Player>>(10);
		try {
			platform.insert("Xbox", new Queue<Player>());
			platform.insert("PlayStation", new Queue<Player>());
			platform.insert("Switch", new Queue<Player>());
			platform.insert("Pc", new Queue<Player>());
			platform.insert("Mobile", new Queue<Player>());
			platform.insert("All", new Queue<Player>());
			
		} catch (HashTableException e) {
			e.printStackTrace();
		}
	}
	
	public void addNewPlatform(String platform) {
		try {
			this.platform.insert(platform, new Queue<Player>());
		} catch (HashTableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addPlayer(Player ready) {
		platform.search(ready.getPlatform()).enqueue(ready);
	}
	public HashTableOpen<String,Queue<Player>> getPlatform(){
		return platform;
	}
}
