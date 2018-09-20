package model;

public class Game {

	private Player[] players;
	private int atyp;
	private double mean;

	public Game(int size) {
		players = new Player[size];
		atyp = -1;
		mean = 0;
	}
	
	public int getAtyp() {
		return atyp;
	}
	
	public double getMean() {
		return mean;
	}

	public void setPlayers(Player[] players) {
		this.players = players;
		calcMean();
		calcAtyp();
	}

	public Player tryToInsert(Player p) {
		Player toReturn = p;
		if(desv(p) <= desv(players[atyp])) {
			toReturn = players[atyp];
			players[atyp] = p;
			calcMean();
			calcAtyp();
		}
		return toReturn;
	}

	private void calcMean() {
		int count = 0;
		double mean = 0;
		if (players[0] != null) {
			for (int i = 0; i < players.length; i++) {
				count += players[i].getMatchValue();
			}
			mean = (double) count / players.length;
		}
		this.mean = mean;
	}
	
	private void calcAtyp() {
		int index = -1;
		if (players[0] != null) {
			index = 0;
			for (int i = 0; i < players.length; i++) {
				if(desv(players[i]) >= desv(players[index])) {
					index = i;
				}
			} 
		}
		atyp = index;
	}
	
	private double desv(Player p) {
		return Math.abs(p.getMatchValue() - mean);
	}

	public Player[] getPlayers() {
		return players;
	}

}
