package jmonkey.office.jwp.support;

import static org.junit.Assert.*;

import javax.swing.undo.UndoManager;

import jmonkey.export.Registry;
import jmonkey.office.jwp.JWP;
import jmonkey.office.jwp.support.editors.HTMLEditor;
import jmonkey.office.jwp.support.editors.RTFEditor;
import jmonkey.office.jwp.support.editors.TEXTEditor;

import org.junit.Test;

public class EditorTest {

	@Test
	public void testEditorCreatedForText() {
		//Editor nullEditor = Editor.createEditorForContentType("text/plain", null);
		
		JWP jwp = new JWP();
		Editor unexpectedEditor = Editor.createEditorForContentType("text/notAType", jwp);
		assertTrue("failed to return default editor", unexpectedEditor instanceof TEXTEditor);
		Editor htmlEditor = Editor.createEditorForContentType("text/html", jwp);
		assertTrue("failed to return HTML editor", htmlEditor instanceof HTMLEditor);
		Editor rtfEditor = Editor.createEditorForContentType("text/rtf", jwp);
		assertTrue("failed to return RTF editor", rtfEditor instanceof RTFEditor);
		Editor txtEditor = Editor.createEditorForContentType("text/plain", jwp);
		assertTrue("failed to return TEXT editor", txtEditor instanceof TEXTEditor);
	}
	
	@Test
	public void testEditorCreatedForExtension() {
		//Editor nullEditor = Editor.createEditorForExtension("txt", null);
		
		JWP jwp = new JWP();
		Editor unexpectedEditor = Editor.createEditorForExtension("unknown", jwp);
		assertTrue("failed to return default editor", unexpectedEditor instanceof TEXTEditor);
		Editor htmlEditor = Editor.createEditorForExtension("html", jwp);
		assertTrue("failed to return HTML editor", htmlEditor instanceof HTMLEditor);
		Editor rtfEditor = Editor.createEditorForExtension("rtf", jwp);
		assertTrue("failed to return RTF editor", rtfEditor instanceof RTFEditor);
		Editor txtEditor = Editor.createEditorForExtension("txt", jwp);
		assertTrue("failed to return TXT editor", txtEditor instanceof TEXTEditor);
	}
	
	@Test
	public void testUndoManagerInit() {
		
		
		JWP jwp = new JWP();
		Editor x = Editor.createEditorForExtension("unknown", jwp);
		UndoManager y = x.getUndoManager();
		assertTrue("failed to return default editor", y==x.getUndoManager());
	}
	
	@Test
	public void testRegistryInit() {
		
		
		JWP jwp = new JWP();
		Editor x = Editor.createEditorForExtension("unknown", jwp);
		Registry y = x.getRegistry();
		assertTrue("failed to return default editor", y==x.getRegistry());
	}
}
