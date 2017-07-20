package souzadriano.utils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Check if a Bean Object is empty or is blank.
 * 
 * @author Adriano de Souza
 *
 */
public class BeanEmpty {

	private static final Set<Class<?>> WRAPPER_TYPES = getWrapperTypes();

	/**
	 * Check if fields are null or fields of type string are empty (lenght == 0)
	 * 
	 * @param bean Bean Object
	 * @return true if object is empty or null
	 * @throws IntrospectionException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public static boolean isEmpty(Object bean) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		if (bean == null) {
			return true;
		}
		BeanInfo info = Introspector.getBeanInfo(bean.getClass(), Object.class);
		PropertyDescriptor[] props = info.getPropertyDescriptors();
		for (PropertyDescriptor pd : props) {
			Method getter = pd.getReadMethod();
			Class<?> type = pd.getPropertyType();
			Object value = getter.invoke(bean);

			if (CharSequence.class.isAssignableFrom(type)) {
				if (isNotEmpty((String) value)) {
					return false;
				}
			} else if (value != null) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Check if fields are not null and fields of type string are not empty (lenght == 0)
	 * 
	 * @param bean Bean Object
	 * @return true if object is empty or null
	 * @throws IntrospectionException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public static boolean isNotEmpty(Object bean) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return !isEmpty(bean);
	}
	
	/**
	 * Check if fields are null or fields of type string are blank or fields of type collection are empty
	 * 
	 * @param bean Bean Object
	 * @return true if object is blank or null
	 * @throws IntrospectionException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public static boolean isBlank(Object bean) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		return isBlank(bean, false);
	}
	
	
	/**
	 * Check if fields are not null and fields of type string are not blank and fields of type collection are not empty
	 * 
	 * @param bean Bean Object
	 * @return true if object is blank or null
	 * @throws IntrospectionException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public static boolean isNotBlank(Object bean) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		return !isBlank(bean);
	}
	
	/**
	 * Check if fields are null or fields of type string are blank or fields of type collection are empty
	 * 
	 * @param bean Bean Object
	 * @param deep check fields of a bean field
	 * @return true if object is blank or null
	 * @throws IntrospectionException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public static boolean isBlank(Object bean, boolean deep) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		if (bean == null) {
			return true;
		}
		Class<? extends Object> clazz = bean.getClass();
		BeanInfo info = Introspector.getBeanInfo(clazz, Object.class);
		PropertyDescriptor[] props = info.getPropertyDescriptors();
		for (PropertyDescriptor pd : props) {
			Method getter = pd.getReadMethod();
			Class<?> type = pd.getPropertyType();
			Object value = getter.invoke(bean);
			
			if (CharSequence.class.isAssignableFrom(type)) {
				if (isNotBlank((String) value)) {
					return false;
				}
			} else if (Collection.class.isAssignableFrom(type)) {
				if (value != null && !((Collection<?>) value).isEmpty()) {
					return false;
				}
			} else if (Map.class.isAssignableFrom(type)) {
				if (value != null && !((Map<?, ?>) value).isEmpty()) {
					return false;
				}
			} else if (deep && !isWrapperType(clazz)) {
				if (!isBlank(value, deep)) {
					return false;
				}
			} else if (value != null) {
				return false;
			}
		}
		
		if (props.length == 0) {
			return bean == null;
		}
		return true;
	}

	/**
	 * Check if fields are not null and fields of type string are not blank and fields of type collection are not empty
	 * 
	 * @param bean Bean Object
	 * @param deep check fields of a bean field
	 * @return true if object is blank or null
	 * @throws IntrospectionException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public static boolean isNotBlank(Object bean, boolean deep)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		return !isBlank(bean, deep);
	}

	/**
	 * Checks if a CharSequence is empty (lenght == 0) or null.
	 * 
	 * @param chars the CharSequence to check
	 * @return true if the CharSequence is empty or null
	 */
	public static boolean isEmpty(final CharSequence chars) {
		return chars == null || chars.length() == 0;
	}
	
	/**
	 * Checks if a CharSequence is not empty (lenght == 0) and not null.
	 * 
	 * @param chars the CharSequence to check
	 * @return true if the CharSequence is not empty and not null
	 */
	public static boolean isNotEmpty(final CharSequence chars) {
		return !isEmpty(chars);
	}

	
	/**
	 * Checks if a CharSequence is empty (lenght == 0), null or whitespace only.
	 * 
	 * @param chars the CharSequence to check
	 * @return true if the CharSequence is null, empty or whitespace only
	 */
	public static boolean isBlank(final CharSequence chars) {
		if (isEmpty(chars)) {
			return true;
		}
		int stringLength = chars.length();
		for (int i = 0; i < stringLength; i++) {
			if (!Character.isWhitespace(chars.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Checks if a CharSequence is not empty (lenght == 0), not null and not whitespace only.
	 * 
	 * @param chars the CharSequence to check
	 * @return true if the CharSequence is not null, not empty and not whitespace only
	 */
	public static boolean isNotBlank(final CharSequence chars) {
		return !isBlank(chars);
	}

	private static boolean isWrapperType(Class<?> clazz) {
		return WRAPPER_TYPES.contains(clazz);
	}

	private static Set<Class<?>> getWrapperTypes() {
		Set<Class<?>> ret = new HashSet<Class<?>>();
		ret.add(Boolean.class);
		ret.add(Character.class);
		ret.add(Byte.class);
		ret.add(Short.class);
		ret.add(Integer.class);
		ret.add(Long.class);
		ret.add(Float.class);
		ret.add(Double.class);
		ret.add(Void.class);
		ret.add(Date.class);
		ret.add(java.sql.Date.class);
		ret.add(BigDecimal.class);
		ret.add(String.class);
		return ret;
	}
}
