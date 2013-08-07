package jmonkey.office.jwp;

import static org.junit.Assert.*;

import java.io.File;

import jmonkey.export.Registry;
import jmonkey.export.RegistryFormatException;

import org.junit.Test;

public class JWPTest {

	@Test
	public void testInitializationOfRgistry() {
		JWP x = new JWP();
		Registry y = x.getRegistry();
		assertTrue("failed to return default editor", y==x.getRegistry());
	}
	
	@Test
	public void test_constructor() {
		try {
			JWP x = new JWP(new String[]{""});
		} catch (RegistryFormatException e) {
			fail("RegistryFormatException");
			e.printStackTrace();
		}
	}
	
	@Test
	public void test_main() {
		try {
			JWP.main(new String[]{""});
		}catch(Exception e){
			fail("Exception " + e.getCause() + ", "+ e.getMessage());
		}
	}
	
	/*@Test
	public void test_masain() {
		try {
			JWP.
			JWP.main(new String[]{""});
		}catch(Exception e){
			fail("Exception " + e.getCause() + ", "+ e.getMessage());
		}
	}*/
	
	@Test	
	public void test_addToFileHistory() {
		try {
			JWP jwp = new JWP(new String[]{""});
			jwp.addToFileHistory(new File(""));
		}catch(Exception e){
			fail("Exception " + e.getCause() + ", "+ e.getMessage());
		}
	}

	@Test	
	public void test_getRegistry() {
		try {
			Registry reg = Registry.loadForClass(JWP.class,  new int[]{ 1, 0 });
			reg.deleteGroup("MAIN");
			reg.deleteGroup("USER");
			reg.deleteGroup("OPTION");
			reg.deleteGroup("FONTS");
			reg.deleteGroup("COLOURS");
			reg.commit();
			JWP jwp = new JWP(new String[]{""});
			jwp.getRegistry();
		}catch(Exception e){
			fail("Exception " + e.getCause() + ", "+ e.getMessage());
		}
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

