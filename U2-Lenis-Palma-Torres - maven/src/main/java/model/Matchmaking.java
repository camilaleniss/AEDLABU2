package model;

import java.util.ArrayList;
/**
 * This class do the matchmaking of a list of n player
 * Classifying them in matches, so that the standard deviation has to be the smallest as possible
 */
public class Matchmaking {

	private ArrayList<Player> players;
	private Game[] matches;
	private int j;
	private int n;
	/**
	 * Creates a Matchmaking and initializes the parameters of the several games that can be done by 
	 * n number of players.
	 * @param n Number of players in the MatchMaking
	 */
	public Matchmaking(int n) {
		this.n = n;
		players = new ArrayList<>();
		int k = (int) Math.ceil((double) n / 100);
		matches = new Game[k];
		j = (int) Math.ceil((double) n / k);
	}
	
	public ArrayList<Player> getPlayers(){
		return players;
	}

	public boolean addPlayer(Player p) {
		boolean success = false;
		if(players.size() < n) {
			players.add(p);
			success = true;
		}
		return success;
	}

	public void createGames() {
		while(players.size() > 0) {
			createGame();
		}
	}

	public void createGame() {
		Player[] toAdd = new Player[players.size()];
		if(players.size() > j) {
			toAdd = new Player[j];
		} 
		for (int i = 0; i < toAdd.length; i++) {
			toAdd[i] = players.get(0);
			players.remove(0);
		}
		
		Game game = new Game(toAdd.length);
		
		game.setPlayers(toAdd);
		
		for (int i = 0; i < players.size(); i++) {
			players.set(i, game.tryToInsert(players.get(i)));
		}
		
		matches[getEmptyMatch()] = game;
	}
	
	private int getEmptyMatch(){
		int index = 0;
		boolean found = false;
		for (int i = 0; i < matches.length && !found; i++) {
			if(matches[i] == null) {
				index = i;
				found = true;
			}
		}
		return index;
	}
	
	

}
