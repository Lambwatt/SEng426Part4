package jmonkey.office.jwp;

import static org.junit.Assert.*;
import jmonkey.export.Registry;

import org.junit.Test;

public class JWPTest {

	@Test
	public void testInitializationOfRgistry() {
		JWP x = new JWP();
		Registry y = x.getRegistry();
		assertTrue("failed to return default editor", y==x.getRegistry());
	}

}
