package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Player;
import model.Server;
import model.Queue;

	 class ServerHashTableTest {
		private Server alpha;

		void setup1() {
			alpha=new Server();
			
		}
		void setup2() {
			setup1();
			alpha.addPlayer(new Player("Ninja","Xbox"));
			alpha.addPlayer(new Player("Rambo", "Switch"));
		}
		void setup3() {
			setup1();
			Player logIn= new Player("Jatr9908","Pc");
			alpha.addPlayer(new Player("Millionhat","Pc"));
			alpha.addPlayer(new Player("kungFumasta","Pc"));
			alpha.addPlayer(logIn);
		}
		void setup4() {
			setup1();
			alpha.addPlayer(new Player("pinkyFlower","SuperNintendo"));
			alpha.addPlayer(new Player("TripaDeAcero","Atari"));
		}
		void setup5() {
			setup1();
			alpha.addNewPlatform("Sega");
		}
		
	@Test
	void testInsertPlatform() {
		setup1();
		Queue<Player> test=alpha.getPlatform().search("Pc");
		assertTrue(test.size()==0);
	}

}
