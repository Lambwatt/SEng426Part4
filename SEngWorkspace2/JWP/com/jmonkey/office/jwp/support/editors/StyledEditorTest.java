package jmonkey.office.jwp.support.editors;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;

import jmonkey.office.jwp.DocumentManager;
import jmonkey.office.jwp.JWP;
import jmonkey.office.jwp.support.EditorActionManager;
import jmonkey.office.jwp.support.FileActionListener;

import org.junit.Test;

public class StyledEditorTest {

	private StyledEditor initializeStyledEditor(){
		JFrame app = new JFrame();
		JWP jwp = new JWP();
		FileActionListener agent = new DocumentManager(jwp);	
		try{		
			EditorActionManager eam = new EditorActionManager(app, agent);		
			StyledEditor editor = new HTMLEditor(eam);
			return editor;
		}catch(IllegalArgumentException e){};
		return null;
	}
	

	@Test
	public void test_construction() {
		try{
			initializeStyledEditor();
		}catch (NullPointerException e){
			fail("NullPointerException during StyledEditor Initialization");
		}		
	}
	
	@Test
	public void test_documentSetSelection(){
		StyledEditor editor = initializeStyledEditor();
		test_documentSetSelection_validFalse(editor);
		test_documentSetSelection_validTrue(editor);
		test_documentSetSelection_invalidStart(editor);
		test_documentSetSelection_invalidEnd(editor);
	}

	private void test_documentSetSelection_validFalse(StyledEditor editor) {	
		try{	
			editor.documentSetSelection(0, 1, false);
		}catch (NullPointerException e){
			fail("NullPointerException during StyledEditor documentSetSelection with false 'wordsOnly");
		}		
	}
		
	private void test_documentSetSelection_validTrue(StyledEditor editor) {		
		try{	
			editor.documentSetSelection(0, 1, true);	
		}catch (NullPointerException e){
			fail("NullPointerException during StyledEditor documentSetSelection with true 'wordsOnly");
		}			
	}
	
	private void test_documentSetSelection_invalidStart(StyledEditor editor){		
		try{
			editor.documentSetSelection(Integer.MIN_VALUE, 1, true);
		}catch (IllegalArgumentException e){
			fail("IllegalArgumentException thrown on invalid input to StyledEditor.documentSetSelection");
		}				
	}
	
	private void test_documentSetSelection_invalidEnd(StyledEditor editor) {		
		try{
			editor.documentSetSelection(1, Integer.MAX_VALUE, true);
		}catch (IllegalArgumentException e){
			fail("IllegalArgumentException thrown on invalid input to StyledEditor.documentSetSelection");
		}			
	}
	
	@Test
	public void test_hasBeenActivated(){
		StyledEditor editor = initializeStyledEditor();
		test_hasBeenActivated_validEditor(editor);
		test_hasBeenActivated_invalidEdtor(editor);
	}

	private void test_hasBeenActivated_validEditor(StyledEditor editor) {
		try{
			editor.hasBeenActivated(editor);
		}catch(NullPointerException e){
			fail("Unexpected NullPointerException in test_hasBeenActivated_validEditor");
		}
	}	
	
	private void test_hasBeenActivated_invalidEdtor(StyledEditor editor) {
		try{
			editor.hasBeenActivated(null);
		}catch(NullPointerException e){
			fail("Unexpected NullPointerException not found in test_hasBeenActivated_invalidEdtor");
		}
	}
	
	/*@Test
	public void test_append(){
		StyledEditor editor = initializeStyledEditor();
		test_append_validFile(editor);
		test_append_invalidFile(editor);
	}

	private void test_append_validFile(StyledEditor editor) {
		File file = new File("file");
		try{
			editor.append(file);
		}catch(NullPointerException e){
			fail("Unexpected NullPointerException in test_append_validFile");
		}catch(IOException e) {
			fail("Unexpected IOException in test_append_validFile");
		}
	}	

	private void test_append_invalidFile(StyledEditor editor) {
		try{
			editor.append(null);
		}catch(NullPointerException e){
			return;
		}catch(IOException e) {
			return;
		}
		fail("Expected IOException not found in test_append_invalidFile");
	}	

	@Test
	public void test_insert(){
		StyledEditor editor = initializeStyledEditor();
		test_insert_validFile(editor);
		test_insert_invalidFile(editor);
	}

	private void test_insert_validFile(StyledEditor editor) {
		File file = new File("file");
		try{
			editor.insert(file, 0);
		}catch(NullPointerException e){
			fail("Unexpected NullPointerException in test_append_validFile");
		}catch(IOException e) {
			fail("Unexpected IOException in test_append_validFile");
		}
	}	

	private void test_insert_invalidFile(StyledEditor editor) {
		try{
			editor.insert(null, 0);
		}catch(NullPointerException e){
			return;
		}catch(IOException e) {
			return;
		}
		fail("Expected IOException not found in test_append_invalidFile");
	}	

	@Test
	public void test_read(){
		StyledEditor editor = initializeStyledEditor();
		test_read_validFile(editor);
		test_read_invalidFile(editor);
	}

	private void test_read_validFile(StyledEditor editor) {
		File file = new File("file");
		try{
			editor.read(file);
		}catch(NullPointerException e){
			fail("Unexpected NullPointerException in test_append_validFile");
		}catch(IOException e) {
			fail("Unexpected IOException in test_append_validFile");
		}
	}	

	private void test_read_invalidFile(StyledEditor editor) {
		try{
			editor.read(null);
		}catch(NullPointerException e){
			return;
		}catch(IOException e) {
			return;
		}
		fail("Expected IOException not found in test_append_invalidFile");
	}	
	
	@Test
	public void test_write(){
		StyledEditor editor = initializeStyledEditor();
		test_write_validFile(editor);
		test_write_invalidFile(editor);
	}

	private void test_write_validFile(StyledEditor editor) {
		File file = new File("file");
		try{
			editor.write(file);
		}catch(NullPointerException e){
			fail("Unexpected NullPointerException in test_append_validFile");
		}catch(IOException e) {
			fail("Unexpected IOException in test_append_validFile");
		}
	}	

	private void test_write_invalidFile(StyledEditor editor) {
		try{
			editor.write(null);
		}catch(NullPointerException e){
			return;
		}catch(IOException e) {
			return;
		}
		fail("Expected IOException not found in test_append_invalidFile");
	}	*/
}


