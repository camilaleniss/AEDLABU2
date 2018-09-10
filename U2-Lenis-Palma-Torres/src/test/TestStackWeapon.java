package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.StackException;
import model.StackWeapon;
import model.Weapon;

class TestStackWeapon {
	
	private StackWeapon stack;

	TestStackWeapon(){
		stack = new StackWeapon();
	}
	
	void setUpStage1() {
		Weapon w = new Weapon("M16", "Común", "Rifle", 30);
		stack.push(w);
	}
	
	void setUpStage2() {
		setUpStage1();
		Weapon w = new Weapon("SMG", "Raro", "SMG", 30);
		stack.push(w);
	}
	
	void setUpStage3() {
		setUpStage1();
		for (int i=1; i<29; i++)
			stack.useWeapon();
	}
	
	void setUpStage4() {
		setUpStage1();
		for (int i=1; i<30; i++)
			stack.useWeapon();
	}
	
	void setUpStage5() {
		setUpStage2();
		for (int i=1; i<29; i++)
			stack.useWeapon();
	}
	
	void setUpStage6() {
		setUpStage2();
		for (int i=1; i<30; i++)
			stack.useWeapon();
	}
	
	void setUpStage7() {
		setUpStage5();
		Weapon w = new Weapon("Lanzacohetes", "Raro", "Lanzagranadas", 1);
		stack.push(w);
		stack.useWeapon();
		stack.useWeapon();
	}
	
	@Test
	void testPush() {
		setUpStage1();
		try {
			Weapon w = stack.top();
			assertTrue(w.getName().equals("M16"));
			assertTrue(w.getRange().equals("Común"));
			assertTrue(w.getType().equals("Rifle"));
			assertTrue(w.getSupplies()==30);
			assertTrue(stack.size()==2);
		} catch (StackException e) {
			fail("The Stack does not have size 2");
		}
		
	}

}
