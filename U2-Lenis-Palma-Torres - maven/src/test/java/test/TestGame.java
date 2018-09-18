package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Game;
import model.Player;

class TestGame {

	private Game game;

	TestGame() {
		game = new Game(5);
	}

	void setUpStage1() {
		Player[] arr = new Player[5];
		for (int i = 0; i < 5; i++) {
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
		Player[] arr = new Player[5];
		for (int i = 0; i < 5; i++) {
			arr[i] = new Player("", "");
		}
		for (int i = 0; i < arr.length; i++)
			arr[i].setMatchValue(10);
		game.setPlayers(arr);
	}

	void setUpStage3() {
		Player[] arr = new Player[5];
		for (int i = 0; i < 5; i++) {
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
		Player[] arr = new Player[5];
		for (int i = 0; i < 5; i++) {
			arr[i] = new Player("", "");
		}
		arr[0].setMatchValue(2);
		for (int i = 1; i < arr.length - 1; i++)
			arr[i].setMatchValue(1);
		game.setPlayers(arr);
	}

	void setUpStage5() {
		Player[] arr = new Player[5];
		for (int i = 0; i < 5; i++) {
			arr[i] = new Player("", "");
		}
		arr[0].setMatchValue(10);
		arr[1].setMatchValue(15);
		arr[2].setMatchValue(20);
		arr[3].setMatchValue(25);
		arr[4].setMatchValue(30);
		game.setPlayers(arr);
	}

	@Test
	void testSetPlayers() {
		setUpStage1();
		assertTrue(game.getAtyp() == 4);

		setUpStage2();
		assertTrue(game.getAtyp() == 4);

		setUpStage3();
		assertTrue(game.getAtyp() == 3);

		setUpStage4();
		assertTrue(game.getAtyp() == 4);

		setUpStage5();
		assertTrue(game.getAtyp() == 4);

	}

	@Test
	void testTryToInsert() {
		Player ptest;

		Player player = new Player("", "");
		player.setMatchValue(5);

		setUpStage1();
		ptest = game.tryToInsert(player);
		assertTrue(ptest.getMatchValue() == 10);

		setUpStage1();
		player.setMatchValue(11);
		ptest = game.tryToInsert(player);
		assertTrue(ptest.getMatchValue() == 11);

		setUpStage2();
		ptest = game.tryToInsert(player);
		assertTrue(ptest.getMatchValue() == 11);

		setUpStage2();
		player.setMatchValue(9);
		ptest = game.tryToInsert(player);
		assertTrue(ptest.getMatchValue() == 9);

		setUpStage5();
		player.setMatchValue(11);
		ptest = game.tryToInsert(player);
		assertTrue(ptest.getMatchValue() == 30);

		setUpStage5();
		player.setMatchValue(28);
		ptest = game.tryToInsert(player);
		assertTrue(ptest.getMatchValue() == 30);

		setUpStage5();
		player.setMatchValue(40);
		ptest = game.tryToInsert(player);
		assertTrue(ptest.getMatchValue() == 40);
	}

}
