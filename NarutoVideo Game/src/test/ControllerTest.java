package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import model.*;
class ControllerTest {
	private Controller co;
	private Clan c;
	private Clan cl;

	public void setupStage() {
		cl = new Clan("cris");
		c = new Clan("josue");
		co = new Controller();
		co.getFristClan().add(c);
		co.getFristClan().add(cl);
	}
	@Test
	void ordeninTest() {
		setupStage();
		co.ordeningClan();;
		assertTrue(co.getFristClan().get(0).equals(cl));
	}

}
