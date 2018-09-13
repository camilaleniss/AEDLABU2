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
		Weapon w = new Weapon("M16", "Common", "Rifle", 30);
		stack.push(w);
	}
	
	void setUpStage2() {
		setUpStage1();
		Weapon w = new Weapon("SMG", "Rare", "SMG", 30);
		stack.push(w);
	}
	
	void setUpStage3() {
		setUpStage1();
		for (int i=0; i<29; i++)
			stack.useWeapon();
	}
	
	void setUpStage4() {
		setUpStage1();
		for (int i=0; i<30; i++)
			stack.useWeapon();
	}
	
	void setUpStage5() {
		setUpStage2();
		for (int i=0; i<29; i++)
			stack.useWeapon();
	}
	
	void setUpStage6() {
		setUpStage2();
		for (int i=0; i<30; i++)
			stack.useWeapon();
	}
	
	void setUpStage7() {
		setUpStage5();
		Weapon w = new Weapon("Rocket Laucher", "Rare", "Granade Launcher", 1);
		stack.push(w);
		stack.useWeapon();
		stack.useWeapon();
	}
	
	@Test
	void testPush1() {
		setUpStage1();
		try {
			Weapon w = stack.top();
			assertTrue(w.getName().equals("M16"));
			assertTrue(w.getRange().equals("Common"));
			assertTrue(w.getType().equals("Rifle"));
			assertTrue(w.getSupplies()==30);
			assertTrue(stack.size()==2);
		} catch (StackException e) {
			fail("The Stack does not have size 2");
		}
	}
	
	@Test
	void testPush2() {
		setUpStage2();
		try {
			Weapon w = stack.top();
			assertTrue(w.getName().equals("SMG"));
			assertTrue(w.getRange().equals("Rare"));
			assertTrue(w.getType().equals("SMG"));
			assertTrue(w.getSupplies()==30);
			assertTrue(stack.size()==3);
		} catch (StackException e) {
			fail("The Stack does not have size 2");
		}
	}
	
	@Test
	void testPop1() {
		try {
			stack.pop();
			fail("It must fail");
		} catch (StackException e) {
			assert(true);
		}
	}
	
	@Test
	void testPop2() {
		setUpStage1();
		try {
			stack.pop();
			Weapon w =stack.top();
			assertTrue(w.getName().equals("Ax"));
			assertTrue(stack.size()==1);
		} catch (StackException e) {
			fail("It must not fail");
		}
	}
	
	@Test
	void testPop3() {
		setUpStage2();
		try {
			stack.pop();
			Weapon w = stack.top();
			assertTrue(w.getName().equals("M16"));
			assertTrue(stack.size()==2);
		} catch (StackException e) {
			fail("It must not fail");
		}	
	}
	
	@Test
	void testUseWeapon() {
		stack.useWeapon();
		assertTrue(stack.size()==1);
		Weapon w;
		try {
			w = stack.top();
			assertTrue(w.getName().equals("Ax"));
		} catch (StackException e) {
			fail("It must not fail");
		}
		
		setUpStage3();
		try {
			w=stack.top();
			assertTrue(w.getName().equals("M16"));
			assertTrue(w.getSupplies()==1);
		} catch (StackException e) {
			fail("It must not fail");
		}
		
		stack = new StackWeapon();
		setUpStage4();
		
		try {
			w=stack.top();
			assertTrue(w.getName().equals("Ax"));
			assertTrue(w.getSupplies()==1);
		} catch (StackException e) {
			fail("It must not fail");
		}
		
		stack = new StackWeapon();
		setUpStage5();
		
		try {
			w=stack.top();
			assertTrue(w.getName().equals("SMG"));
			assertTrue(w.getSupplies()==1);
		} catch (StackException e) {
			fail("It must not fail");
		}
		
		stack = new StackWeapon();
		setUpStage6();
		
		try {
			w=stack.top();
			assertTrue(w.getName().equals("M16"));
			assertTrue(w.getSupplies()==30);
		} catch (StackException e) {
			fail("It must not fail");
		}
		
		stack = new StackWeapon();
		setUpStage7();
		
		try {
			w=stack.top();
			assertTrue(w.getName().equals("M16"));
			assertTrue(w.getSupplies()==30);
		} catch (StackException e) {
			fail("It must not fail");
		}
		
		
	}
	
	

}
