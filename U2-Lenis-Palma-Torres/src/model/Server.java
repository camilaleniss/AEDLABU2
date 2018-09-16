package model;

public class Server {
	
	private HashTableOpen<String, Matchmaking> platform;
	
	public Server() {
		platform= new HashTableOpen<String, Matchmaking>(100);
	}

	public Server(int n) {
		platform= new HashTableOpen<String, Matchmaking>(n);
		try {
			platform.insert("Xbox", new Matchmaking(10000));
			platform.insert("PlayStation", new Matchmaking(10000));
			platform.insert("Switch", new Matchmaking(10000));
			platform.insert("Pc", new Matchmaking(10000));
			platform.insert("Mobile", new Matchmaking(10000));
			platform.insert("All", new Matchmaking(10000));
			
		} catch (HashTableException e) {
			e.printStackTrace();
		}
	}
	
	public void addNewPlatform(String platform) {
		try {
			this.platform.insert(platform, new Matchmaking(10000));
		} catch (HashTableException e) {
			e.printStackTrace();
		}
	}
	
	public void addPlayer(Player ready) {
		platform.search(ready.getPlatform()).addPlayer(ready);
	}
	
	public HashTableOpen<String, Matchmaking> getPlatform(){
		return platform;
	}
	public void deletePlatform(String type) {
		platform.delete(type);
	}
}
