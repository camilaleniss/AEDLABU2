package model;

public class Server {
	private XboxOne microsoft;
	private PlayStation sony;
	private Switch nintendo;
	private Mobile phone;
	private Pc computer;
	
	public Server() {
		setMicrosoft(new XboxOne());
		setSony(new PlayStation());
		setNintendo(new Switch());
		setPhone(new Mobile());
		setComputer(new Pc());
	}
	
	public void addPlayer(Player logIn) throws Exception {
		String platform=logIn.getPlatform().toLowerCase();
		char letter=platform.charAt(0);
		if(letter=='s') {
			letter=platform.charAt(1);
			if(platform.matches("switch")) {
				nintendo.enqueue(logIn);
			}else if(platform.matches("playstation")) {
				sony.enqueue(logIn);
			}
		}else if(platform.matches("mobile")) {
			phone.enqueue(logIn);
		}else if(platform.matches("pc")) {
			computer.enqueue(logIn);
		}else if(platform.matches("xboxone")) {
			microsoft.enqueue(logIn);
		}else {
			throw new Exception("Platform does Not exist");
		}
	}

	public XboxOne getMicrosoft() {
		return microsoft;
	}

	public void setMicrosoft(XboxOne microsoft) {
		this.microsoft = microsoft;
	}

	public Switch getNintendo() {
		return nintendo;
	}

	public void setNintendo(Switch nintendo) {
		this.nintendo = nintendo;
	}

	public Mobile getPhone() {
		return phone;
	}

	public void setPhone(Mobile phone) {
		this.phone = phone;
	}

	public PlayStation getSony() {
		return sony;
	}

	public void setSony(PlayStation sony) {
		this.sony = sony;
	}

	public Pc getComputer() {
		return computer;
	}

	public void setComputer(Pc computer) {
		this.computer = computer;
	}
	
	
}
