package model;

public class Player {
	
	private String nickname;
	private String platform;
	
	private int matchValue;
	
	
	public Player(String name, String plat) {
		nickname=name;
		platform=plat;
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

	public int getMatchValue() {
		return matchValue;
	}
}
