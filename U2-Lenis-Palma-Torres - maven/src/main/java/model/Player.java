package model;

public class Player {

	private String nickname;
	private String platform;
	private boolean platformMode;
	private double matchValue;
	
	private double ability;
	private int ping;
	private int playedGames;
	private int wonGames;

	public Player(String name, String plat) {
		nickname = name;
		platform = plat;
		matchValue = 0;
	}

	public void calcAbility() {
		ability = playedGames == 0 ? 0 : (double) wonGames / playedGames * 100;
	}

	public void calcMatchValue() {
		calcAbility();
		matchValue = ability * 10 * 0.5 + (1000 - ping) * 0.5;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	
	public boolean isPlatformMode() {
		return platformMode;
	}

	public void setPlatformMode(boolean platformMode) {
		this.platformMode = platformMode;
	}

	public String getPlatform() {
		return platformMode ? Server.ALL : platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
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
		calcMatchValue();
	}

	public int getPlayedGames() {
		return playedGames;
	}

	public void setPlayedGames(int playedGames) {
		this.playedGames = playedGames;
		calcMatchValue();
	}

	public int getWonGames() {
		return wonGames;
	}

	public void setWonGames(int wonGames) {
		this.wonGames = wonGames;
		calcMatchValue();
	}

}
