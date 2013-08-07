package jmonkey.office.jwp.support;

import static org.junit.Assert.*;

import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JEditorPane;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.StyledEditorKit;

import jmonkey.export.Registry;
import jmonkey.office.jwp.support.ActionComboBox;

import org.junit.Test;

import jmonkey.export.RegistryFormatException;
import jmonkey.office.jwp.JWP;

public class ActionComboBoxTest {
	
	public boolean contains(Object[] a, Object x)
	{
		for(int i = 0; i<a.length; i++)
		{
			if(a[i].equals(x)){
				return true;
			}
		}
		return false;
	}
	
	
	
	public boolean containsAll(Hashtable h, Object[] b)
	{
		for (int i = 0; i<b.length; i++)
		{
			if(!h.contains(b[i]))
				return false;
		}
		return true;
	}

	@Test
	public void testNoItems() {
		ActionComboBox x = new ActionComboBox();
		assertTrue("Failed void construction: did not contain void", x.getActions().isEmpty());
		assertTrue("Failed void construction: getItemListeners did not include x", contains(x.getItemListeners(),x));
		assertTrue("Failed void construction: incorrect length of getActions", x.getActions().size()==0);
	}

	@Test
	public void testEmptyList() {
		Action[] i = new Action[0];
		ActionComboBox x = new ActionComboBox(i);
		assertTrue("Failed emptyList construction: did not contain void", x.getActions().isEmpty());
		assertTrue("Failed emptyList construction: getItemListeners did not include x", contains(x.getItemListeners(),x));
		assertTrue("Failed emptyList construction: incorrect length of getActions", x.getActions().size()==0);
	}
	
	@Test
	public void testValidList() throws RegistryFormatException {
		JWP jwp = new JWP();
		jmonkey.export.Registry reg = jwp.getRegistry();
		Enumeration colourEnum = reg.getKeys("COLOURS");
		jmonkey.office.jwp.support.EditorActionManager eam = jwp.getEditorActionManager();
		Action[] i = eam.createDefaultColourActions();

		ActionComboBox x = new ActionComboBox(i);
		assertTrue("Failed emptyList construction: did not contain void", containsAll(x.getActions(),i));
		assertTrue("Failed emptyList construction: getItemListeners did not include x", contains(x.getItemListeners(),x));
		assertTrue("Failed emptyList construction: incorrect length of getActions", x.getActions().size()==13);
	}
	
	@Test
	public void testNull()  throws RegistryFormatException {
		ActionComboBox x = new ActionComboBox(null);
		assertTrue("Failed emptyList construction: did not contain void", x.getActions().isEmpty());
		assertTrue("Failed emptyList construction: getItemListeners did not include x", contains(x.getItemListeners(),x));
		assertTrue("Failed emptyList construction: incorrect length of getActions", x.getActions().size()==0);
	}
	
	@Test
	public void testListWithOneInvalid() throws RegistryFormatException {
		JWP jwp = new JWP();
		jmonkey.office.jwp.support.EditorActionManager eam = jwp.getEditorActionManager();
		Action[] a = eam.createDefaultColourActions();
		Action[] i = new Action[14];
		for(int j = 0; j<a.length; j++)
		{
			i[j] = a[j];
		}
		i[13]=a[12];
		
		ActionComboBox x = new ActionComboBox(i);
		assertTrue("Failed emptyList construction: did not contain void", containsAll(x.getActions(),i));
		assertTrue("Failed emptyList construction: getItemListeners did not include x", contains(x.getItemListeners(),x));
		assertTrue("Failed emptyList construction: incorrect length of getActions", x.getActions().size()==13);
	}
	
	@Test
	public void testListOfOneInvalid() throws RegistryFormatException {
		JWP jwp = new JWP();
		jmonkey.office.jwp.support.EditorActionManager eam = jwp.getEditorActionManager();
		Action[] a = eam.createDefaultColourActions();
		Action[] i = new Action[2];
		i[0] = a[2];
		i[1] = a[2];
		Action[] j = new Action[1];
		j[0] = a[2];
		
		ActionComboBox x = new ActionComboBox(i);
		assertTrue("Failed emptyList construction: did not contain void", containsAll(x.getActions(),j));
		assertTrue("Failed emptyList construction: getItemListeners did not include x", contains(x.getItemListeners(),x));
		assertTrue("Failed emptyList construction: incorrect length of getActions", x.getActions().size()==1);
	}
	
	@Test
	public void testSelection() throws RegistryFormatException {
		JWP jwp = new JWP();
		jmonkey.office.jwp.support.EditorActionManager eam = jwp.getEditorActionManager();
		Action[] a = eam.createDefaultColourActions();
		Action[] i = new Action[3];
		i[0] = a[0];
		i[1] = a[1];
		i[2] = a[2];
		
		ActionComboBox x = new ActionComboBox(i);
		
		assertNull("Failed selection of -1 index", x.getItemAt(-1));
		assertTrue("Failed selection of middle element", x.getItemAt(1)==a[1]);
		assertNull("Failed selection of out of bounds element", x.getItemAt(4));
		
		i = new Action[1];
		i[0] = a[0];

		assertTrue("Failed selection of only element", x.getItemAt(0)==a[0]);
	}
	
	@Test
	public void testAdditionOfItems() throws RegistryFormatException {
		
		
		JWP jwp = new JWP();
		jmonkey.office.jwp.support.EditorActionManager eam = jwp.getEditorActionManager();
		Action[] a = eam.createDefaultColourActions();
		Action[] y = new Action[3];
		y[0] = null;
		y[1] = a[0];
		y[2] = a[0];
		
		ActionComboBox x = new ActionComboBox();
		
		int lastSize = x.getItemCount();
		x.addItem(y[0]);
		assertTrue("Failed addition of null", x.getItemCount()==lastSize);
		x.addItem(y[1]);
		assertTrue("Failed addition of valid action", x.getItemCount()==lastSize+1);
		assertTrue("Failed addition of invalid action", x.getItemAt(0)==y[1]);
		x.addItem(y[2]);	
		assertTrue("Failed addition of invalid action",x.getItemCount()==lastSize+1);
	
	}
	
	@Test
	public void testInsertItemAt() throws RegistryFormatException {
		JWP jwp = new JWP();
		jmonkey.office.jwp.support.EditorActionManager eam = jwp.getEditorActionManager();
		Action[] a = eam.createDefaultColourActions();
		Action[] i = new Action[2];
		i[0] = a[0];
		i[1] = a[1];

		ActionComboBox x = new ActionComboBox(i);
		Action[] y = new Action[3];
		y[0] = null;
		y[1] = a[1];
		y[2] = a[2];
		
		int expectedSize = x.getItemCount();
		
		x.insertItemAt(y[0], 1);
		assertTrue("Failed insertion of null element", x.getItemCount()==expectedSize);
		
		x.insertItemAt(y[1], 1);
		assertTrue("Failed insertion of invalid element", x.getItemCount()==expectedSize);
		
		x.insertItemAt(y[2], 0);
		expectedSize++;
		assertTrue("Failed insertion of item at 0", x.getItemCount()==expectedSize && x.getItemAt(0)==y[2]);
		
		x = new ActionComboBox(i);
		expectedSize=x.getItemCount();
		x.insertItemAt(y[2], -1);
		assertTrue("Failed insertion at negatve index.", x.getItemCount()==expectedSize);
		
		x.insertItemAt(y[2], 1);
		expectedSize+=1;
		assertTrue("Failed insertion of item at 1", x.getItemCount()==expectedSize && x.getItemAt(1)==y[2]);

		x = new ActionComboBox(i);
		expectedSize = x.getItemCount();
		x.insertItemAt(y[2], 2);
		assertTrue("Failed insertion of item at 2", x.getItemCount()==expectedSize+1 && x.getItemAt(2)==y[2]);

		x = new ActionComboBox(i);
		expectedSize = x.getItemCount();
		x.insertItemAt(y[2], 3);
		assertTrue("Failed insertion of item at out of bounds index", x.getItemCount()==expectedSize);

		x = new ActionComboBox();
		x.insertItemAt(y[2], 0);
		expectedSize = 1;
		assertTrue("Failed insertion of item to empty list", x.getItemCount()==expectedSize && x.getItemAt(0)==y[2]);
		
	}
	
	@Test
	public void testRemoveItem()throws RegistryFormatException {
		JWP jwp = new JWP();
		jmonkey.office.jwp.support.EditorActionManager eam = jwp.getEditorActionManager();
		Action[] a = eam.createDefaultColourActions();
		Action[] i = new Action[2];
		i[0] = a[0];
		i[1] = a[1];

		ActionComboBox x = new ActionComboBox(i);
		
		int expectedSize = x.getItemCount();
		
		Action[] y = new Action[3];
		y[0]=null;
		y[1] = i[0];
		y[2]=i[0];
		
		x.removeItem(y[0]);
		assertTrue("Failed removal of null.", x.getItemCount()==expectedSize);
		try{
			x.removeItem(y[1]);
			expectedSize-=1;
			assertTrue("Failed removal of non-present item.", x.getItemCount()==expectedSize);
			x.removeItem(y[2]);
			assertTrue("Failed removal of item.", x.getItemCount()==expectedSize);
		}catch(UnsupportedOperationException e){}
	}
	
	@Test
	public void testRemoveItemAt() throws RegistryFormatException {
		JWP jwp = new JWP();
		jmonkey.office.jwp.support.EditorActionManager eam = jwp.getEditorActionManager();
		Action[] a = eam.createDefaultColourActions();
		Action[] i = new Action[3];
		i[0] = a[0];
		i[1] = a[1];
		i[2] = a[2];

		ActionComboBox x = new ActionComboBox(i);
		
		try{
			int expectedSize = x.getItemCount();
		
			x.removeItemAt( 0);
			assertTrue("Failed removal of item at 0", x.getItemCount()==expectedSize-1);
	
			x = new ActionComboBox(i);
			expectedSize=x.getItemCount();
			x.removeItemAt( -1);
			assertTrue("Failed removal at negatve index.", x.getItemCount()==expectedSize);
			
			x.removeItemAt(1);
			assertTrue("Failed removal of item at 1", x.getItemCount()==expectedSize-1);
	
			x = new ActionComboBox(i);
			expectedSize=x.getItemCount();
			x.removeItemAt(2);
			assertTrue("Failed removal of item at 2", x.getItemCount()==expectedSize-1);
	
			x = new ActionComboBox(i);
			expectedSize=x.getItemCount();
			x.removeItemAt(3);
			assertTrue("Failed removal of item at out of bounds index", x.getItemCount()==expectedSize);
	
			x = new ActionComboBox();
			x.removeItemAt(0);
			assertTrue("Failed removal of item from empty list", x.getItemCount()==0);
		}catch(UnsupportedOperationException e){}
		
	}
	
	@Test
	public void testRemoveAll()throws RegistryFormatException {
		JWP jwp = new JWP();
		jmonkey.office.jwp.support.EditorActionManager eam = jwp.getEditorActionManager();
		Action[] a = eam.createDefaultColourActions();
		
		ActionComboBox x = new ActionComboBox();
		
		x.removeAllItems();
		assertTrue("Failed removal of all from empty", x.getItemCount()==0);
		
		Action[] i = new Action[1];
		i[0] = a[0];
		x = new ActionComboBox(i);
		//System.out.println( x.getItemCount());
		x.removeAllItems();
		assertTrue("Failed removal of all from list of 1", x.getItemCount()==0);
		
		i = new Action[2];
		i[0] = a[0];
		i[1] = a[1];
		x = new ActionComboBox(i);
		
		x.removeAllItems();
		assertTrue("Failed removal of all from list of 2", x.getItemCount()==0);
	}
	
	/* Functional Test
	 * 
	 * Run JWP
	 * 
	 * Select Font DropDown Box, select a font
	 * Select Text size DropDown Box, select a text size
	 * Select Colour DropDown Box, select a colour
	 * 
	 * Ensure that for each a drop down box appears
	 * 
	 * Close JWP
	 *
	 */
}
