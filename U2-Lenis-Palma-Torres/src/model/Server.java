package model;

public class Server {

	public static final String XBOX = "Xbox";
	public static final String PLAYSTATION = "PlayStation";
	public static final String SWITCH = "Switch";
	public static final String PC = "Pc";
	public static final String MOBILE = "Mobile";
	public static final String ALL = "All";

	private HashTableOpen<String, Matchmaking> platform;

	public Server() {
		this(100);

	}

	public Server(int n) {
		platform = new HashTableOpen<String, Matchmaking>(n);
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

	public HashTableOpen<String, Matchmaking> getPlatform() {
		return platform;
	}

	public void deletePlatform(String type) {
		platform.delete(type);
	}
}
