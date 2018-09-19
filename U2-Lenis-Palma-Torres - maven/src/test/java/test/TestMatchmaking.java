package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Matchmaking;
import model.Player;

class TestMatchmaking {
	
	private Matchmaking mm;

	TestMatchmaking(){
		
	}
	
	void setUpStage1() {
		mm = new Matchmaking(10);
		Player p= new Player("", "");
		for (int i =0; i<9; i++) {
			mm.addPlayer(p);
		}
	}
	
	void setUpStage2() {
		mm = new Matchmaking(10);
		Player p= new Player("", "");
		for (int i =0; i<10; i++) {
			mm.addPlayer(p);
		}
	}
	
	void setUpStage3() {
		mm = new Matchmaking(200);
		Player p= new Player("", "");
		for (int i =0; i<200; i++) {
			mm.addPlayer(p);
		}
	}
	
	void setUpStage4() {
		mm = new Matchmaking(250);
		Player p= new Player("", "");
		for (int i =0; i<200; i++) {
			mm.addPlayer(p);
		}
	}
	
	void setUpStage5() {
		mm = new Matchmaking(250);
		Player p= new Player("", "");
		for (int i =0; i<250; i++) {
			mm.addPlayer(p);
		}
	}
	
	void setUpStage6() {
		mm = new Matchmaking(330);
		Player p= new Player("", "");
		for (int i =0; i<330; i++) {
			mm.addPlayer(p);
		}
	}
	
	void setUpStage7() {
		mm = new Matchmaking(70);
		Player p= new Player("", "");
		for (int i =0; i<70; i++) {
			mm.addPlayer(p);
		}
	}
	
	void setUpStage8() {
		mm = new Matchmaking(200);
		Player p= new Player("", "");
		for (int i =0; i<100; i++) {
			p.setMatchValue(10);
			mm.addPlayer(p);
		}
		for (int i =0; i<100; i++) {
			p.setMatchValue(20);
			mm.addPlayer(p);
		}
	}
	
	void setUpStage9() {
		mm = new Matchmaking(200);
		Player p= new Player("", "");
		int i =0;
		while(i<2) {
			for (int c=0; c<100;c++) {
				p.setMatchValue(c+1);
				mm.addPlayer(p);
			}
			i++;
		}
	}
	
	void setUpStage10() {
		mm = new Matchmaking(100);
		Player p= new Player("", "");
		for (int i =0; i<330; i++) {
			p.setMatchValue(30);
			mm.addPlayer(p);
		}
	}
	
	void setUpStage11() {
		mm = new Matchmaking(300);
		Player p= new Player("", "");
		int i =0;
		while(i<3) {
			for (int c=0; c<50;c++) {
				p.setMatchValue(30);
				mm.addPlayer(p);
			}
			for (int c=0; c<50;c++) {
				p.setMatchValue(60);
				mm.addPlayer(p);
			}
			i++;
		}
	}
	
	void setUpStage12() {
		mm = new Matchmaking(200);
		Player p= new Player("", "");
		for (int i =0; i<30; i++) {
			p.setMatchValue(20);
			mm.addPlayer(p);
		}
		for (int i =0; i<170; i++) {
			p.setMatchValue(50);
			mm.addPlayer(p);
		}
	}
	
	void setUpStage13() {
		mm = new Matchmaking(180);
		Player p= new Player("", "");
		for (int i =0; i<50; i++) {
			p.setMatchValue(3);
			mm.addPlayer(p);
		}
		for (int i =0; i<40; i++) {
			p.setMatchValue(50);
			mm.addPlayer(p);
		}
		for (int i =0; i<50; i++) {
			p.setMatchValue(45);
			mm.addPlayer(p);
		}
		for (int i =0; i<40; i++) {
			p.setMatchValue(20);
			mm.addPlayer(p);
		}
	}
	
	@Test
	void testAddPlayer() {
		setUpStage1();
		Player p = new Player ("Kwaniss", "XBox");
		assertTrue(mm.addPlayer(p));
		
		setUpStage2();
		assertFalse(mm.addPlayer(p));
	}
	
	@Test
	void testCreateGames() {
		setUpStage3();
		mm.createGames();
		assertTrue(mm.getMatches().length==2);
		assertTrue(mm.getJ()==100);
		
		setUpStage4();
		mm.createGames();
		assertTrue(mm.getMatches().length==2);
		assertTrue(mm.getJ()==100);
		
		setUpStage5();
		mm.createGames();
		assertTrue(mm.getMatches().length==3);
		assertTrue(mm.getJ()==84);
		
		setUpStage6();
		mm.createGames();
		assertTrue(mm.getMatches().length==4);
		assertTrue(mm.getJ()==83);
		
		setUpStage7();
		mm.createGames();
		assertTrue(mm.getMatches().length==1);
		assertTrue(mm.getJ()==70);
	}
	
	
	@Test
	void testCreateGame() {
		setUpStage8();
		mm.createGame();
		assertTrue(mm.getMatches()[0].getPlayers().length==100);
		System.out.println(mm.getPlayers().size());
		assertTrue(mm.getMatches()[0].getMean()==10);
	}
}
