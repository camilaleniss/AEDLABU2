package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.HashTableException;
import model.Matchmaking;
import model.Player;
import model.Server;

class TestServer {

	private Server alpha;

	void setUpStage1() {
		alpha=new Server(10);
		
	}
	void setUpStage2() {
		setUpStage1();
		alpha.addPlayer(new Player("Ninja","Xbox"));
		alpha.addPlayer(new Player("Rambo", "Switch"));
	}
	void setUpStage3() {
		setUpStage1();
		Player logIn= new Player("Jatr9908","Pc");
		alpha.addPlayer(new Player("Millionhat","Pc"));
		alpha.addPlayer(new Player("kungFumasta","Pc"));
		alpha.addPlayer(logIn);
	}
	void setUpStage4() {
		setUpStage1();
		alpha.addPlayer(new Player("pinkyFlower","SuperNintendo"));
	}
	void setUpStage5() {
		setUpStage1();
		alpha.addNewPlatform("Sega");
	}
	void setUpStage6() {
		setUpStage5();
		alpha.addNewPlatform("GameBoy");
		alpha.addNewPlatform("Failure");
	}
	void setUpStage7() {
		setUpStage1();
		alpha.addPlayer(new Player("TripaDeAcero","Atari"));
	}
	
	@Test
	void testAddNewPlatform() {
		setUpStage1();
		Matchmaking test=alpha.getPlatform().search("Pc");
		assertTrue(test.getPlayers().size()==0);
	}
	
	@Test
	void testAddNewPlatform2() {
		setUpStage5();
		assertTrue(alpha.getPlatform().search("Sega")!=null);
	}
	
	@Test
	void testAddNewPlatform3() {
		try {
		setUpStage6();
		}catch (Exception e) {
			assertTrue(e instanceof HashTableException );
			assertTrue(e.getMessage().equals("Hash table overflow"));
		}
	}
	
	@Test
	void testAddPlayer() {
		setUpStage2();
		assertTrue(alpha.getPlatform().search("Xbox").getPlayers().size()==1);
		assertTrue(alpha.getPlatform().search("Switch").getPlayers().size()==1);
	}
	
	@Test
	void testAddPlayer2() {
		setUpStage3();
		assertTrue(alpha.getPlatform().search("Pc").getPlayers().size()==3);
	}
	
	@Test
	void testAddPlayer3() {
		try {
		setUpStage4();
		}catch (NullPointerException e) {
			assertTrue(e instanceof NullPointerException);
		}
		try {
			setUpStage7();
		}catch (Exception e) {
			assertTrue(e instanceof NullPointerException);
		}
	}
	
	@Test
	void testDeletePlatform() {
		setUpStage1();
		alpha.deletePlatform("Pc");
		assertNull(alpha.getPlatform().search("Pc"));
	}
	
	@Test
	void testDeletePlatform2() {
		setUpStage5();
		alpha.deletePlatform("Sega");
		assertNull(alpha.getPlatform().search("Sega"));
	}
	
	@Test
	void testDeletePlatform3() {
		setUpStage1();
		try {
			alpha.deletePlatform("Sega");
		}catch (Exception e) {
			assertTrue(e instanceof NullPointerException);
		}
	}
}
