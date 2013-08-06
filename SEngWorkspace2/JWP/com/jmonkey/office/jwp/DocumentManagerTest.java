package jmonkey.office.jwp;

import static org.junit.Assert.*;

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
	public void test_EditorOpen_valid() {
		JWP jwp = new JWP();
		DocumentManager dm= new DocumentManager(null);
		try{
			dm.editorOpen();
		}catch(Exception e){
			fail("unexpected exception " + e.getCause() + ", in test_activate");
		}
		

	}

}
