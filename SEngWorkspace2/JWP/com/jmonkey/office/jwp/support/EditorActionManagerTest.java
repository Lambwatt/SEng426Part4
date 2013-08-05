package jmonkey.office.jwp.support;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Properties;

import javax.swing.Action;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.event.CaretEvent;
import javax.swing.text.AttributeSet;
import javax.swing.text.Element;
import javax.swing.text.JTextComponent;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.StyledDocument;

import jmonkey.office.jwp.DocumentManager;
import jmonkey.office.jwp.JWP;
import jmonkey.office.jwp.support.editors.RTFEditor;

import org.junit.Test;

public class EditorActionManagerTest {

	@Test
	public void test_EditorActionManager_valid() {
		JWP jwp = new JWP();
		EditorActionManager eam = new EditorActionManager(new JFrame(),new DocumentManager(jwp));
		assertNotNull(eam);
	}

	@Test
	public void test_EditorActionManager_invalid1() {
		JWP jwp = new JWP();
		EditorActionManager eam = new EditorActionManager(null, new DocumentManager(jwp));
		assertNull(eam);
	}

	@Test
	public void test_EditorActionManager_invalid2() {
		EditorActionManager eam = new EditorActionManager(new JFrame(), null);
		assertNull(eam);
	}

	@Test
	public void test_EditorActionManager_invalid3() {
		EditorActionManager eam = new EditorActionManager(null, null);
		assertNull(eam);
	}
	
	@Test
	public void test_createInputAttributes_invalid() {
		JWP jwp = new JWP();
		EditorActionManager eam = new EditorActionManager(new JFrame(),new DocumentManager(jwp));
		try{
			eam.createInputAttributes(null, null);
		}catch(NullPointerException e){
			fail("Unexpected NullPointerException in test_createInputAttributes_invalid");
		}
	}

	@Test
	public void test_activate_valid() {
		JWP jwp = new JWP();
		EditorActionManager eam = new EditorActionManager(new JFrame(),new DocumentManager(jwp));
		try{
			eam.activate(new RTFEditor(eam));
		}catch(Exception e){
			fail("unexpected exception " + e.getCause() + ", in test_activate");
		}
	}

	@Test
	public void test_activate_invalid() {
		JWP jwp = new JWP();
		EditorActionManager eam = new EditorActionManager(new JFrame(),new DocumentManager(jwp));
		try{
			eam.activate(null);
		}catch(Exception e){
			fail("unexpected exception " + e.getCause() + ", in test_activate");
		}
	}

	@Test
	public void test_deactivate_valid() {
		JWP jwp = new JWP();
		EditorActionManager eam = new EditorActionManager(new JFrame(),new DocumentManager(jwp));
		try{
			eam.deactivate(new RTFEditor(eam));
		}catch(Exception e){
			fail("unexpected exception " + e.getCause() + ", in test_activate");
		}
	}

	@Test
	public void test_deactivate_invalid() {
		JWP jwp = new JWP();
		EditorActionManager eam = new EditorActionManager(new JFrame(),new DocumentManager(jwp));
		try{
			eam.deactivate(null);
		}catch(Exception e){
			fail("unexpected exception " + e.getCause() + ", in test_activate");
		}
	}

	@Test
	public void test_getActionByKey_invalid1() {
		JWP jwp = new JWP();
		EditorActionManager eam = new EditorActionManager(new JFrame(),new DocumentManager(jwp));
		Action action = eam.getActionByKey("test");
		assertNull(action);
	}

	@Test
	public void test_getActionByKey_invalid2() {
		JWP jwp = new JWP();
		EditorActionManager eam = new EditorActionManager(new JFrame(),new DocumentManager(jwp));
		Action action = eam.getActionByKey(null);
		assertNull(action);
	}
	
	@Test
	public void test_getColourAction_valid() {
		JWP jwp = new JWP();
		EditorActionManager eam = new EditorActionManager(new JFrame(),new DocumentManager(jwp));
		Action action = eam.getColourAction("White", Color.white);
		assertNotNull(action);
	}
	
	@Test
	public void test_getColourAction_invalid1() {
		JWP jwp = new JWP();
		EditorActionManager eam = new EditorActionManager(new JFrame(),new DocumentManager(jwp));
		Action action = eam.getColourAction(null, Color.white);
		assertNull(action);
	}
	
	@Test
	public void test_getColourAction_invalid2() {
		JWP jwp = new JWP();
		EditorActionManager eam = new EditorActionManager(new JFrame(),new DocumentManager(jwp));
		Action action = eam.getColourAction("White", null);
		assertNull(action);
	}
	
	@Test
	public void test_getFontFaceAction_valid() {
		JWP jwp = new JWP();
		EditorActionManager eam = new EditorActionManager(new JFrame(),new DocumentManager(jwp));
		Action action = eam.getFontFaceAction("Arial");
		assertNotNull(action);
	}
	
	@Test
	public void test_getFontFaceAction_invalid() {
		JWP jwp = new JWP();
		EditorActionManager eam = new EditorActionManager(new JFrame(),new DocumentManager(jwp));
		Font font = null;
		Action action = eam.getFontFaceAction(font);
		assertNull(action);
	}
	
	@Test
	public void test_getFontSizeAction_valid() {
		JWP jwp = new JWP();
		EditorActionManager eam = new EditorActionManager(new JFrame(),new DocumentManager(jwp));
		Action action = eam.getFontSizeAction(10);
		assertNotNull(action);
	}
	
	@Test
	public void test_getFontSizeAction_invalid() {
		JWP jwp = new JWP();
		EditorActionManager eam = new EditorActionManager(new JFrame(),new DocumentManager(jwp));
		Action action = eam.getFontSizeAction(-1);
		assertNull(action);
	}
	
	@Test
	public void test_setCharacterAttributes_invalid() {
		JWP jwp = new JWP();
		EditorActionManager eam = new EditorActionManager(new JFrame(),new DocumentManager(jwp));
		try{
			eam.setCharacterAttributes(null, null, false);
		}catch(Exception e){
			fail("Unexpected exception " + e.getCause() + ", in test_setCharacterAttributes_invalid");
		}
	}
		
	@Test
	public void test_getCharacterAttributes_valid() {
		JWP jwp = new JWP();
		JEditorPane editor = new JEditorPane();
		editor.setSelectionStart(0);
		editor.setSelectionEnd(0);
		EditorActionManager eam = new EditorActionManager(new JFrame(),new DocumentManager(jwp));
		try{
			eam.activate(null);
			eam.getCharacterAttributes(editor);
		}catch(Exception e){
			fail("Unexpected exception " + e.getCause() + ", in test_getCharacterAttributes_valid");
		}
	}
	
	@Test
	public void test_getCharacterAttributes_invalid() {
		JWP jwp = new JWP();
		EditorActionManager eam = new EditorActionManager(new JFrame(),new DocumentManager(jwp));
		try{
			eam.getCharacterAttributes(null);
		}catch(Exception e){
			fail("Unexpected exception " + e.getCause() + ", in test_getCharacterAttributes_invalid");
		}
	}
		
	@Test
	public void test_setParagraphAttributes_invalid() {
		JWP jwp = new JWP();
		EditorActionManager eam = new EditorActionManager(new JFrame(),new DocumentManager(jwp));
		try{
			eam.setParagraphAttributes(null, null, false);
		}catch(Exception e){
			fail("Unexpected exception " + e.getCause() + ", in test_setParagraphAttributes_invalid");
		}
	}
}
