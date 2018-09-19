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
	
	public void setJ(int j) {
		this.j=j;
	}
	
	public void setMatches(Game [] matches) {
		this.matches=matches;
	}
	
	public ArrayList<Player> getPlayers(){
		return players;
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
	/**
	 * Add a player if it is not full
	 * @param p The player you want to add
	 * @return If it is a successful add.
	 */
	public boolean addPlayer(Player p) {
		boolean success = false;
		if(players.size() < n) {
			players.add(p);
			int n = players.size();
			int k = (int) Math.ceil((double) n / 100);
			matches = new Game[k];
			j = (int) Math.ceil((double) n / k);
			success = true;
		}
		return success;
	}

	public void createGames() {
		while(players.size() > 0) {
			createGame();
		}
	}

	/**
	 * It creates a game of j length as default
	 * Then it try to add the rest of the players and if it is returned it try to add it to
	 * another match.  
	 */
	public void createGame() {
		//Create an array of players with the size of the actual players in the Matchmaking
		Player[] toAdd = new Player[players.size()];
		//If the size of the array is larger than j (number of player in each match), the size of the 
		//match will be j
		if(players.size() > j) {
			toAdd = new Player[j];
		} 
		//Add all the players in the Matchmaking (until it reach the size of the match)
		for (int i = 0; i < toAdd.length; i++) {
			toAdd[i] = players.get(0);
			players.remove(0);
		}
		//Create a game of the size of the match and add the player of the match in the game. 
		Game game = new Game(toAdd.length);
		game.setPlayers(toAdd);
		//Try to add the rest of players to the match to have a equality at least as possible of 
		//standard deviation
		for (int i = 0; i < players.size(); i++) {
			players.set(i, game.tryToInsert(players.get(i)));
		}
		//Find the empty match to fill it with the new match created
		matches[getEmptyMatch()] = game;
	}

	public Game[] getMatches() {
		return matches;
	}
	
}
