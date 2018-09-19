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
	
	//FALTAAAA
	void setUpStage11() {
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

}
