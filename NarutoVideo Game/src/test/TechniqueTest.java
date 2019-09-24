package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Character;
import model.Technique;
class TechniqueTest {
	private Technique t1;
	private Technique t2;
	
	public void setupStage() {
		t1 = new Technique("na", 200);
		t2 = new Technique("ne", 1);
	}
	
	@Test 
	void compareTest() {
		setupStage();
		assertTrue(t1.compareTo(t2)==1);
		
	}

}
