package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.HashTableException;
import model.Matchmaking;
import model.Player;
import model.Queue;
import model.Server;

class TestServer {

	private Server alpha;

	void setup1() {
		alpha = new Server(10);

	}

	void setup2() {
		setup1();
		alpha.addPlayer(new Player("Ninja", "Xbox"));
		alpha.addPlayer(new Player("Rambo", "Switch"));
	}

	void setup3() {
		setup1();
		Player logIn = new Player("Jatr9908", "Pc");
		alpha.addPlayer(new Player("Millionhat", "Pc"));
		alpha.addPlayer(new Player("kungFumasta", "Pc"));
		alpha.addPlayer(logIn);
	}

	void setup4() {
		setup1();
		alpha.addPlayer(new Player("pinkyFlower", "SuperNintendo"));
	}

	void setup5() {
		setup1();
		alpha.addNewPlatform("Sega");
	}

	void setup6() {
		setup5();
		alpha.addNewPlatform("GameBoy");
		alpha.addNewPlatform("Failure");
	}

	void setup7() {
		setup1();
		alpha.addPlayer(new Player("TripaDeAcero", "Atari"));
	}

	@Test
	void testAddNewPlatform() {
		setup1();
		Matchmaking test = alpha.getPlatform().search("Pc");
		assertTrue(test.getPlayers().size() == 0);
	}

	@Test
	void testAddNewPlatform2() {
		setup5();
		assertTrue(alpha.getPlatform().search("Sega") != null);
	}

	@Test
	void testAddNewPlatform3() {
		try {
			setup6();
		} catch (Exception e) {
			assertTrue(e instanceof HashTableException);
			assertTrue(e.getMessage().equals("Hash table overflow"));
		}
	}

	@Test
	void testAddPlayer() {
		setup2();
		assertTrue(alpha.getPlatform().search("Xbox").getPlayers().size() == 1);
		assertTrue(alpha.getPlatform().search("Switch").getPlayers().size() == 1);
	}

	@Test
	void testAddPlayer2() {
		setup3();
		assertTrue(alpha.getPlatform().search("Pc").getPlayers().size() == 3);
	}

	@Test
	void testAddPlayer3() {
		try {
			setup4();
		} catch (NullPointerException e) {
			assertTrue(e instanceof NullPointerException);
		}
		try {
			setup7();
		} catch (Exception e) {
			assertTrue(e instanceof NullPointerException);
		}
	}

	@Test
	void testDeletePlatform() {
		setup1();
		alpha.deletePlatform("Pc");
		assertNull(alpha.getPlatform().search("Pc"));
	}

	@Test
	void testDeletePlatform2() {
		setup1();
		alpha.deletePlatform("Sega");
		assertNull(alpha.getPlatform().search("Sega"));
	}

}
