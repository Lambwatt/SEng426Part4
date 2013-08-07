package jmonkey.office.jwp;

import static org.junit.Assert.*;

import java.io.File;

import javax.swing.JFileChooser;

import jmonkey.export.RegistryFormatException;
import jmonkey.office.jwp.support.Editor;
import jmonkey.office.jwp.support.editors.TEXTEditor;

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
	
	@Test
	public void test_editorNew(){
		DocumentManager dm;
		try {
			dm = new DocumentManager(new JWP(new String[]{""}));
			dm.editorNew();
		} catch (RegistryFormatException e) {
			fail("Exception found: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Test
	public void test_minimizeAll(){
		DocumentManager dm;
		try {
			dm = new DocumentManager(new JWP(new String[]{""}));
			dm.minimizeAll();
		} catch (RegistryFormatException e) {
			fail("Exception found: " + e.getMessage());
			e.printStackTrace();
		}
	}


	@Test
	public void test_tileAll(){
		DocumentManager dm;
		try {
			dm = new DocumentManager(new JWP(new String[]{""}));
			dm.tileAll();
		} catch (RegistryFormatException e) {
			fail("Exception found: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Test
	public void test_closeAllDocuments(){
		DocumentManager dm;
		try {
			dm = new DocumentManager(new JWP(new String[]{""}));
			dm.closeAllDocuments();
		} catch (Exception e) {
			fail("Exception found: " + e.getMessage());
			e.printStackTrace();
		}
	}

	@Test
	public void test_cascadeAll(){
		DocumentManager dm;
		try {
			dm = new DocumentManager(new JWP(new String[]{""}));
			dm.cascadeAll();
		} catch (Exception e) {
			fail("Exception found: " + e.getMessage());
			e.printStackTrace();
		}
	}

	@Test
	public void test_configureFileType(){
		DocumentManager dm;
		try {
			dm = new DocumentManager(new JWP(new String[]{""}));
			dm.configureFileType(new JFileChooser(), "");
			dm.configureFileType(new JFileChooser(), "text/rtf");
			dm.configureFileType(new JFileChooser(), "text/html");
			dm.configureFileType(new JFileChooser(), "text/plain");
		} catch (Exception e) {
			fail("Exception found: " + e.getMessage());
			e.printStackTrace();
		}
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
