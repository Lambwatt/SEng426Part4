package jmonkey.office.jwp;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class DocumentManagerTest {

	@Test
	public void test_DocumentManager_valid() {
		JWP jwp = new JWP();
		DocumentManager dm= new DocumentManager(jwp);
		assertNotNull(dm);
	}
	
	@Test
	public void test_DocumentManager_invalid() {
		JWP jwp = new JWP();
		
		try{
			DocumentManager dm= new DocumentManager(null);
		}catch(IllegalArgumentException e){
			return;
		}
		fail("Expected illegal argumenttest_DocumentManager_invalid");

	}
	
	/*
	 * Functional Testing
	 * 
	 * Open JWP
	 * Create New File
	 * Write text to the file
	 * Save file, name it File1.txt
	 * Write text to the file
	 * Save file as File2.txt
	 * Write text to the file
	 * Revert to changes
	 * SaveCopy of file
	 * Cascade Windows under window menu
	 * Tile Windows under window menu
	 * Minimize Windows under window menu
	 * Close document with x
	 * Close using file menu
	 * Create New File
	 * Create New File
	 * CloseAll
	 * Close JWP
	 * 
	 * If no error occured, Functional Test Passed
	 */

}
