package jmonkey.export;

import static org.junit.Assert.*;

import org.junit.Test;

public class RegistryPropertyExceptionTest {

	@Test
	public void test_RegistryPropertyExceptionNull() {
		RegistryPropertyException propertyException = new RegistryPropertyException(null, null, null);
		assertEquals(null, propertyException.getKey());
		assertEquals(null, propertyException.getGroup());
	}
	
	@Test
	public void test_RegistryPropertyExceptionEmpty() {
		RegistryPropertyException propertyException = new RegistryPropertyException("", "", "");
		assertEquals("", propertyException.getKey());
		assertEquals("", propertyException.getGroup());
	}
	
	@Test
	public void test_RegistryPropertyException_valid1() {
		RegistryPropertyException propertyException = new RegistryPropertyException("message", "key");
		assertEquals("key", propertyException.getKey());
	}
	
	@Test
	public void test_RegistryPropertyException_valid2() {
		RegistryPropertyException propertyException = new RegistryPropertyException("message", "group", "key");
		assertEquals("key", propertyException.getKey());
		assertEquals("group", propertyException.getGroup());
	}
	
	@Test
	public void test_getGroup() {
		RegistryPropertyException propertyException = new RegistryPropertyException("message", "group", "key");
		String group = propertyException.getGroup();
		assertEquals("group", group);
	}
	
	@Test
	public void test_getKey() {
		RegistryPropertyException propertyException = new RegistryPropertyException("message", "group", "key");
		String key = propertyException.getKey();
		assertEquals("key", key);
	}
	
	@Test
	public void test_getMessage() {
		RegistryPropertyException propertyException = new RegistryPropertyException("message", "group", "key");
		String message = propertyException.getMessage();
		assertEquals("message: group = group, key = key", message);
	}
}
