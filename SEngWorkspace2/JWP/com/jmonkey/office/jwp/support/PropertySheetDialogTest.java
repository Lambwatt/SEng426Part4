package jmonkey.office.jwp.support;

import static org.junit.Assert.*;

import java.awt.Frame;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.junit.Test;

public class PropertySheetDialogTest {

	@Test
	public void test_PropertySheetDialog() {		
		try {
			Class<PropertySheetDialog> propertySheetDialogImpl = PropertySheetDialog.class;
	        Class cls[] = new Class[] {Frame.class, Properties.class, boolean.class};
	        Constructor<PropertySheetDialog> constructor = propertySheetDialogImpl.getDeclaredConstructor(cls);			
	        constructor.setAccessible(true);	
	        Object args[] = new Object[] {new Frame(), new Properties(), true};
			PropertySheetDialog propertySheetDialog = constructor.newInstance(args);
		} catch (SecurityException e) {
			fail("Unexpected SecurityException in PropertySheetDialogTest");
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			fail("Unexpected NoSuchMethodException in PropertySheetDialogTest");
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			fail("Unexpected IllegalArgumentException in PropertySheetDialogTest");
			e.printStackTrace();
		} catch (InstantiationException e) {
			fail("Unexpected InstantiationException in PropertySheetDialogTest");
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			fail("Unexpected IllegalAccessException in PropertySheetDialogTest");
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			fail("Unexpected InvocationTargetException in PropertySheetDialogTest");
			e.printStackTrace();
		}
	}

	@Test
	public void test_isCellEditable(){
		try {
			Class<PropertySheetDialog> propertySheetDialogImpl = PropertySheetDialog.class;
	        Class cls[] = new Class[] {Frame.class, Properties.class, boolean.class};
	        Constructor<PropertySheetDialog> constructor = propertySheetDialogImpl.getDeclaredConstructor(cls);			
	        constructor.setAccessible(true);	
	        Object args[] = new Object[] {new Frame(), new Properties(), true};
			PropertySheetDialog propertySheetDialog = constructor.newInstance(args);
			propertySheetDialog.m_model.isCellEditable(0, 0);
			propertySheetDialog.m_model.isCellEditable(1, 1);
			propertySheetDialog.m_model.isCellEditable(2, 2);
		} catch (SecurityException e) {
			fail("Unexpected SecurityException in PropertySheetDialogTest");
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			fail("Unexpected NoSuchMethodException in PropertySheetDialogTest");
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			fail("Unexpected IllegalArgumentException in PropertySheetDialogTest");
			e.printStackTrace();
		} catch (InstantiationException e) {
			fail("Unexpected InstantiationException in PropertySheetDialogTest");
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			fail("Unexpected IllegalAccessException in PropertySheetDialogTest");
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			fail("Unexpected InvocationTargetException in PropertySheetDialogTest");
			e.printStackTrace();
		}
	}
	
	@Test
	public void test_getColumnName(){
		try {
			Class<PropertySheetDialog> propertySheetDialogImpl = PropertySheetDialog.class;
	        Class cls[] = new Class[] {Frame.class, Properties.class, boolean.class};
	        Constructor<PropertySheetDialog> constructor = propertySheetDialogImpl.getDeclaredConstructor(cls);			
	        constructor.setAccessible(true);	
	        Object args[] = new Object[] {new Frame(), new Properties(), true};
			PropertySheetDialog propertySheetDialog = constructor.newInstance(args);
			propertySheetDialog.m_model.getColumnName(0);
			propertySheetDialog.m_model.getColumnName(1);
			propertySheetDialog.m_model.getColumnName(2);
		} catch (SecurityException e) {
			fail("Unexpected SecurityException in PropertySheetDialogTest");
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			fail("Unexpected NoSuchMethodException in PropertySheetDialogTest");
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			fail("Unexpected IllegalArgumentException in PropertySheetDialogTest");
			e.printStackTrace();
		} catch (InstantiationException e) {
			fail("Unexpected InstantiationException in PropertySheetDialogTest");
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			fail("Unexpected IllegalAccessException in PropertySheetDialogTest");
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			fail("Unexpected InvocationTargetException in PropertySheetDialogTest");
			e.printStackTrace();
		}
	}

	@Test
	public void test_getColumnClass(){
		try {
			Class<PropertySheetDialog> propertySheetDialogImpl = PropertySheetDialog.class;
	        Class cls[] = new Class[] {Frame.class, Properties.class, boolean.class};
	        Constructor<PropertySheetDialog> constructor = propertySheetDialogImpl.getDeclaredConstructor(cls);			
	        constructor.setAccessible(true);	
	        Object args[] = new Object[] {new Frame(), new Properties(), true};
			PropertySheetDialog propertySheetDialog = constructor.newInstance(args);
			propertySheetDialog.m_model.getColumnClass(0);
		} catch (SecurityException e) {
			fail("Unexpected SecurityException in PropertySheetDialogTest");
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			fail("Unexpected NoSuchMethodException in PropertySheetDialogTest");
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			fail("Unexpected IllegalArgumentException in PropertySheetDialogTest");
			e.printStackTrace();
		} catch (InstantiationException e) {
			fail("Unexpected InstantiationException in PropertySheetDialogTest");
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			fail("Unexpected IllegalAccessException in PropertySheetDialogTest");
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			fail("Unexpected InvocationTargetException in PropertySheetDialogTest");
			e.printStackTrace();
		}
	}

	@Test
	public void test_getValueAt(){
		try {
			Class<PropertySheetDialog> propertySheetDialogImpl = PropertySheetDialog.class;
	        Class cls[] = new Class[] {Frame.class, Properties.class, boolean.class};
	        Constructor<PropertySheetDialog> constructor = propertySheetDialogImpl.getDeclaredConstructor(cls);			
	        constructor.setAccessible(true);	
	        Object args[] = new Object[] {new Frame(), new Properties(), true};
			PropertySheetDialog propertySheetDialog = constructor.newInstance(args);
			propertySheetDialog.m_model.getValueAt(0, 2);
			propertySheetDialog.m_keys = new Object[]{"1"};
			assertEquals("1",propertySheetDialog.m_model.getValueAt(0, 0));
		} catch (SecurityException e) {
			fail("Unexpected SecurityException in PropertySheetDialogTest");
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			fail("Unexpected NoSuchMethodException in PropertySheetDialogTest");
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			fail("Unexpected IllegalArgumentException in PropertySheetDialogTest");
			e.printStackTrace();
		} catch (InstantiationException e) {
			fail("Unexpected InstantiationException in PropertySheetDialogTest");
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			fail("Unexpected IllegalAccessException in PropertySheetDialogTest");
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			fail("Unexpected InvocationTargetException in PropertySheetDialogTest");
			e.printStackTrace();
		}
	}

	@Test
	public void test_setValueAt(){
		try {
			Class<PropertySheetDialog> propertySheetDialogImpl = PropertySheetDialog.class;
	        Class cls[] = new Class[] {Frame.class, Properties.class, boolean.class};
	        Constructor<PropertySheetDialog> constructor = propertySheetDialogImpl.getDeclaredConstructor(cls);			
	        constructor.setAccessible(true);	
	        Object args[] = new Object[] {new Frame(), new Properties(), true};
			PropertySheetDialog propertySheetDialog = constructor.newInstance(args);
			propertySheetDialog.m_model.setValueAt(0, 0, 0);
			propertySheetDialog.m_keys = new Object[]{"1"};
			propertySheetDialog.m_model.setValueAt(0, 0, 1);
			propertySheetDialog.m_model.setValueAt(0, 0, 2);
		} catch (SecurityException e) {
			fail("Unexpected SecurityException in PropertySheetDialogTest");
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			fail("Unexpected NoSuchMethodException in PropertySheetDialogTest");
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			fail("Unexpected IllegalArgumentException in PropertySheetDialogTest");
			e.printStackTrace();
		} catch (InstantiationException e) {
			fail("Unexpected InstantiationException in PropertySheetDialogTest");
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			fail("Unexpected IllegalAccessException in PropertySheetDialogTest");
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			fail("Unexpected InvocationTargetException in PropertySheetDialogTest");
			e.printStackTrace();
		}
	}

	@Test
	public void test_doExit(){
		try {
			Class<PropertySheetDialog> propertySheetDialogImpl = PropertySheetDialog.class;
	        Class cls[] = new Class[] {Frame.class, Properties.class, boolean.class};
	        Constructor<PropertySheetDialog> constructor = propertySheetDialogImpl.getDeclaredConstructor(cls);			
	        constructor.setAccessible(true);	
	        Object args[] = new Object[] {new Frame(), new Properties(), true};
			PropertySheetDialog propertySheetDialog = constructor.newInstance(args);
			propertySheetDialog.display(new Frame(), new Properties());
			propertySheetDialog.display(new Frame(), new Properties(), true);
		} catch (SecurityException e) {
			fail("Unexpected SecurityException in PropertySheetDialogTest");
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			fail("Unexpected NoSuchMethodException in PropertySheetDialogTest");
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			fail("Unexpected IllegalArgumentException in PropertySheetDialogTest");
			e.printStackTrace();
		} catch (InstantiationException e) {
			fail("Unexpected InstantiationException in PropertySheetDialogTest");
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			fail("Unexpected IllegalAccessException in PropertySheetDialogTest");
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			fail("Unexpected InvocationTargetException in PropertySheetDialogTest");
			e.printStackTrace();
		}
	}
}
