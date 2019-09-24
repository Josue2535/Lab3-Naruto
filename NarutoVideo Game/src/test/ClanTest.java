package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Character;
import model.Clan;
import model.Technique;
import model.*;

class ClanTest {
	private Character c1;
	private Character c2;
	private Clan c;
	private Clan cl;
	public void setupStage() {
		String  name = "naruto";
		String d1 = "2016-06-5";
		c1 = new Character(2000, name, d1);
		c2 = new Character(2000, "zasque", "20000");
		cl = new Clan("cris");
		c = new Clan("josue");
		c.addCharacter(c1);
		c.addCharacter(c2);
	}
	@Test
	void ordeninTest() {
		setupStage();
		c.ordeningAll();
		assertTrue(c.getFrist().equals(c1));
	}
	
	@Test 
	void findCharacterTestt() {
		setupStage();
		assertTrue(!c.findCharacter("naruto").equals("the character was not found"));
	}
	@Test
	void compareClanTest() {
		setupStage();
		assertTrue(c.compare(c, cl)==1);
	}
}
