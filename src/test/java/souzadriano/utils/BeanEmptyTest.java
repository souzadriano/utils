package souzadriano.utils;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;

import org.junit.Assert;
import org.junit.Test;

public class BeanEmptyTest {
	
	@Test
	public void EMPTY_NULL_OBJECT() {
		Assert.assertTrue(BeanEmpty.isEmpty(null));
	}
	
	@Test
	public void BLANK_NULL_OBJECT() {
		Assert.assertTrue(BeanEmpty.isBlank(null));
	}
	
	@Test
	public void EMPTY_NEW_OBJECT() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		Assert.assertTrue(BeanEmpty.isEmpty(new User()));
	}
	
	@Test
	public void BLANK_NEW_OBJECT() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		Assert.assertTrue(BeanEmpty.isBlank(new User()));
	}
	
	@Test
	public void EMPTY_FILLED_OBJECT() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		User user = new User();
		user.setName("Test");
		user.setAge(20);
		Assert.assertFalse(BeanEmpty.isEmpty(user));
	}
	
	@Test
	public void EMPTY_EMPTY_COLLECTION() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		User user = new User();
		user.setPermissions(new HashSet<String>());
		Assert.assertFalse(BeanEmpty.isEmpty(user));
	}
	
	@Test
	public void BLANK_EMPTY_COLLECTION() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		User user = new User();
		user.setPermissions(new HashSet<String>());
		Assert.assertTrue(BeanEmpty.isBlank(user));
	}
	
	@Test
	public void EMPTY_EMPTY_STRING_IN_OBJECT() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		User user = new User();
		user.setName("");
		Assert.assertTrue(BeanEmpty.isEmpty(user));
	}
	
	@Test
	public void BLANK_FILLED_OBJECT() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		User user = new User();
		user.setName("Test");
		user.setAge(20);
		Assert.assertFalse(BeanEmpty.isBlank(user));
	}
	
	@Test
	public void BLANK_COMPOSE_OBJECT_DEEP() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		User user = new User();
		user.setLogin(new Login());
		Assert.assertTrue(BeanEmpty.isBlank(user, true));
	}
	
	@Test
	public void BLANK_COMPOSE_OBJECT_FILLED_DEEP() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		User user = new User();
		Login login = new Login();
		login.setUsername("Test");
		user.setLogin(login);
		Assert.assertFalse(BeanEmpty.isBlank(user, true));
	}
}
