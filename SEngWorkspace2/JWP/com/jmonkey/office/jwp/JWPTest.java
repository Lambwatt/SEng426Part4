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
	
	/* Functional Testing
	 * 
	 * Run JWP
	 * 
	 * Close document
	 * Create New Document
	 * Create New Document
	 * Click On Original Document
	 * Ensure Original Document is at the front
	 * Write some Text
	 * Click on text Size Dropdown Menu and select one
	 * Click on text Font Dropdown Menu and select one
	 * Click on text Colour Dropdown Menu and select one
	 * Write some Text
	 * Click on Bold, Italic, Underline, and strike Through
	 * Write some Text
	 * Ensure the new text in the document matches the settings.
	 * Go to the blank document
	 * Write 3 lines
	 * Select the middle line
	 * Select Middle Alignment, Left Alignment Right alignment and Justify
	 * ensure only the middle line moves with the alignment selections.
	 * Save As JWPTest.txt
	 * 
	 * Close JWP
	 * 
	 */

}

