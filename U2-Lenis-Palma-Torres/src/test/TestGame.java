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
		arr[0].setMatchValue(1);
		arr[0].setMatchValue(2);
		arr[0].setMatchValue(3);
		arr[0].setMatchValue(4);
		arr[0].setMatchValue(10);
	}
	
	void setUpStage2() {
		Player []  arr = new Player[5];
		for (int i = 0; i<arr.length; i++)
			arr[i].setMatchValue(10);
	}
	
	void setUpStage3() {
		Player []  arr = new Player[5];
		arr[0].setMatchValue(1);
		arr[0].setMatchValue(2);
		arr[0].setMatchValue(3);
		arr[0].setMatchValue(20);
		arr[0].setMatchValue(4);
	}
	
	void setUpStage4() {
		Player []  arr = new Player[5];
		arr[0].setMatchValue(2);
		for (int i = 1; i<arr.length-1; i++)
			arr[i].setMatchValue(1);
	}
	
	void setUpStage5() {
		Player []  arr = new Player[5];
		arr[0].setMatchValue(10);
		arr[0].setMatchValue(15);
		arr[0].setMatchValue(20);
		arr[0].setMatchValue(25);
		arr[0].setMatchValue(30);
	}
	
	
	

}
