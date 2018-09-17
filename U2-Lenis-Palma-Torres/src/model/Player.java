package model;

public class Player {
	
	private String nickname;
	private String platform;
	private StackWeapon inventory;
	private int matchValue;
	
	
	public Player(String name, String plat) {
		nickname=name;
		platform=plat;
		matchValue=0;
		inventory= new StackWeapon();
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
	
	public void setMatchValue (int mt) {
		matchValue=mt;
	}

	public int getMatchValue() {
		return matchValue;
	}
	public StackWeapon getStack(){
		return inventory;
	}
}
