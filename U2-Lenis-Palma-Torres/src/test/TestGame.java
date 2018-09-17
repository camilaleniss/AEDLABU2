package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Game;
import model.Player;

class TestGame {

	private Game game;

	TestGame(){
		game= new Game(5);
	}
	
	void setUpStage1() {
		Player []  arr = new Player[5];
		for (int i =0; i<5; i++){
			arr[i] = new Player("", "");
		}
		arr[0].setMatchValue(1);
		arr[1].setMatchValue(2);
		arr[2].setMatchValue(3);
		arr[3].setMatchValue(4);
		arr[4].setMatchValue(10);
		game.setPlayers(arr);
	}
	
	void setUpStage2() {
		Player []  arr = new Player[5];
		for (int i =0; i<5; i++){
			arr[i] = new Player("", "");
		}
		for (int i = 0; i<arr.length; i++)
			arr[i].setMatchValue(10);
		game.setPlayers(arr);
	}
	
	void setUpStage3() {
		Player []  arr = new Player[5];
		for (int i =0; i<5; i++){
			arr[i] = new Player("", "");
		}
		arr[0].setMatchValue(1);
		arr[1].setMatchValue(2);
		arr[2].setMatchValue(3);
		arr[3].setMatchValue(20);
		arr[4].setMatchValue(4);
		game.setPlayers(arr);
	}
	
	void setUpStage4() {
		Player []  arr = new Player[5];
		for (int i =0; i<5; i++){
			arr[i] = new Player("", "");
		}
		arr[0].setMatchValue(2);
		for (int i = 1; i<arr.length-1; i++)
			arr[i].setMatchValue(1);
		game.setPlayers(arr);
	}
	
	void setUpStage5() {
		Player []  arr = new Player[5];
		for (int i =0; i<5; i++){
			arr[i] = new Player("", "");
		}
		arr[0].setMatchValue(10);
		arr[0].setMatchValue(15);
		arr[0].setMatchValue(20);
		arr[0].setMatchValue(25);
		arr[0].setMatchValue(30);
		game.setPlayers(arr);
	}
	
	@Test
	void testSetPlayers() {
		setUpStage1();	
		System.out.print(game.getAtyp());
		assertTrue(game.getAtyp()==4);
		
		setUpStage2();
		assertTrue(game.getAtyp()==4);
		
		setUpStage3();
		System.out.print(game.getAtyp());
		assertTrue(game.getAtyp()==3);
		
		setUpStage4();
		assertTrue(game.getAtyp()==4);
		
		setUpStage5();
		
		System.out.print(game.getAtyp());
	}


}
