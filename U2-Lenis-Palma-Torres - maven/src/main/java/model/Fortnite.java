package model;

import javafx.scene.image.Image;

public class Fortnite {

	private Server server;
	private String platform;
	private boolean platformMode;
	private StackWeapon inventory;

	public Fortnite(String platform, boolean platformMode) {
		super();
		this.platform = platform;
		this.platformMode = platformMode;
		server = new Server();
		inventory = new StackWeapon();
		generateRandomPlayers();

	}

	public String getPlatform() {
		return platform;
	}

	public boolean isPlatformMode() {
		return platformMode;
	}

	public void generateRandomPlayers() {
		for (int i = 0; i < 15000; i++) {
			Player p = new Player("", "");
			String platform = "";
			int rand = (int) (Math.random() * 5);
			switch (rand) {
			case 0:
				platform = Server.XBOX;
				break;
			case 1:
				platform = Server.PLAYSTATION;
				break;
			case 2:
				platform = Server.SWITCH;
				break;
			case 3:
				platform = Server.PC;
				break;
			case 4:
				platform = Server.MOBILE;
				break;
			}
			p.setPlatform(platform);
			p.setPlayedGames((int) (Math.random() * 200) + 20);
			p.setPing((int) (Math.random() * 1000));
			int wonGames = (int) (Math.random() * 100);
			while (wonGames > p.getPlayedGames()) {
				wonGames = (int) (Math.random() * 100);
			}
			p.setWonGames(wonGames);
			p.setPlatformMode(Math.random() < 0.5);
			server.addPlayer(p);
		}
	}

	public void pickUpWeapon() {
		String range = "";
		int ran = (int) (Math.random() * 5);
		switch (ran) {
		case 0:
			range = Weapon.BASIC;
			break;
		case 1:
			range = Weapon.UNCOMMON;
			break;
		case 2:
			range = Weapon.RARE;
			break;
		case 3:
			range = Weapon.EPIC;
			break;
		case 4:
			range = Weapon.LEGENDARY;
			break;
		}
		Image img = new Image(getClass().getResourceAsStream("/img/weapons/" + (int) (Math.random() * 11) + ".png"));
		int supplies = (int) (Math.random() * 15) + 1;
		Weapon weapon = new Weapon("", range, "", supplies);
		weapon.setImage(img);
		inventory.push(weapon);
	}

	public void useWeapon() {
		inventory.useWeapon();
	}

	public StackWeapon getInventory() {
		return inventory;
	}

	public Server getServer() {
		return server;
	}

}
