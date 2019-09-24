package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import model.*;
import model.Character;

class CharacterTest {

	private Character c1;
	private Character c2;
	Technique t2;
	Technique t1;

	public void setupStage() {
		String name = "naruto";
		String d1 = "2016-06-5";
		c1 = new Character(2000, name, d1);
		t1 = new Technique("na", 200);
		t2 = new Technique("ne", 1);
		c1.addTechnique(t1);
		c1.addTechnique(t2);
		c2 = new Character(2000, "zasque", "20000");
	}

	@Test
	void delateTest() {
		setupStage();
		c1.delateTechnique("na");
		;
		assertTrue(c1.getFirsTechnique().equals(t2));
	}

	@Test
	void findTechnique() {
		setupStage();
		assertTrue(!c1.findTechnique("na").equals(""));
	}

	@Test
	void ordening() {
		setupStage();
		c1.ordeningFactor();
		assertTrue(c1.getFirsTechnique().equals(t2));
	}
	@Test
	void compareTest() {
		setupStage();
		assertTrue(c1.compareTo(c2)==-1);
	}
}
