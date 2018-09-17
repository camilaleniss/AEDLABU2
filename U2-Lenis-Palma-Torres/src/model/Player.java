package model;

public class Player {

	private String nickname;
	private String platform;
	private StackWeapon inventory;
	private double matchValue;
	private double ability;
	private int ping;
	private int playedGames;
	private int wonGames;

	public Player(String name, String plat) {
		nickname = name;
		platform = plat;
		matchValue = 0;
		inventory = new StackWeapon();
	}

	public void calcAbility() {
		ability = (double) wonGames / playedGames * 100;
	}

	public void calcMatchValue() {
		matchValue = ability * 10 * 0.5 + (1000 - ping) * 0.5;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public StackWeapon getInventory() {
		return inventory;
	}

	public void setInventory(StackWeapon inventory) {
		this.inventory = inventory;
	}

	public double getMatchValue() {
		return matchValue;
	}

	public void setMatchValue(double matchValue) {
		this.matchValue = matchValue;
	}

	public double getAbility() {
		return ability;
	}

	public void setAbility(double ability) {
		this.ability = ability;
	}

	public int getPing() {
		return ping;
	}

	public void setPing(int ping) {
		this.ping = ping;
	}

	public int getPlayedGames() {
		return playedGames;
	}

	public void setPlayedGames(int playedGames) {
		this.playedGames = playedGames;
	}

	public int getWonGames() {
		return wonGames;
	}

	public void setWonGames(int wonGames) {
		this.wonGames = wonGames;
	}

}
