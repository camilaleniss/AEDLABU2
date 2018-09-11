package model;

public class PlayStation extends Queue<Player> {
	private Queue<Player> players;
	
	public PlayStation() {
		players=new Queue<Player>();
	}
	public void queuePlayer(Player newPlayer) {
		players.enqueue(newPlayer);
	}
	public void dequeuePlayer() {
		try {
			players.dequeue();
		} catch (QueueException e) {
			e.printStackTrace();
		}
	}
	public int getQueueSize() {
		return players.size();
	}
	public Player showFirstPlayer() {
		Player infront=null;
		try {
			 infront=players.front();
		} catch (QueueException e) {
			e.printStackTrace();
		}
		return infront;
	}

}
