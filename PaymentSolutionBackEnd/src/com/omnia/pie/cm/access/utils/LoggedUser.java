package com.omnia.pie.cm.access.utils;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.NoResultException;

import org.apache.commons.collections.MapUtils;
import com.omnia.pie.cm.data.model.Users;

public class LoggedUser {
	public static enum AccessType {
		SYSTEM, USER, WEB_SERVICE
	}
	
	private static final String ACCESS_TYPE_KEY = "pie.loggedUser.accessType";
	private static final String ELEMENT_KEY = "pie.loggedUser.element";
	private static final String GROUP_KEY = "pie.loggedUser.group";
	private static final String USER_KEY = "pie.loggedUser.user";
	private static final String REMOTE_ADDRESS_KEY = "pie.loggedUser.remoteAddress";
	private static final String SERVICE_CLIENT_KEY = "pie.loggedUser.serviceClient";
	private static final String POS_KEY = "pie.loggedUser.pos";	
	private static final ThreadLocal<Map<String, Object>> ATTRIBUTES = new ThreadLocal<Map<String, Object>>();

	/**
	 * Release resources. Should be called before the current thread dies
	 */
	public static void cleanup() {
		final Map<String, Object> map = ATTRIBUTES.get();
		if (map != null) {
			map.clear();
		}
		ATTRIBUTES.remove();
	}
	
	/**
	 * Returns whether there is an user in the current transaction
	 */
	public static boolean hasUser() {
		return getAttribute(USER_KEY) != null;
	}
	/**
	 * Initializes. Should be called before any other methods on the current
	 * thread
	 */
	public static void init(final Map<String, Object> attributes) {
		if (MapUtils.isNotEmpty(attributes)) {
			ATTRIBUTES.set(attributes);
		}
	}
	
	/**
	 * Initializes. Should be called before any other methods on the current
	 * thread
	 */
	public static void init(final Users user) {
		init(user, null, null);
	}
	
	/**
	 * Initializes. Should be called before any other methods on the current
	 * thread
	 */
	public static void init(final Users user, final String remoteAddress, final Map<String, Object> attributes) {
		initMap(AccessType.USER, remoteAddress, attributes,user);
	}
	/**
	 * Sets an attribute for the given key
	 */
	public static void setAttribute(final String key, final Object value) {
		final Map<String, Object> map = ATTRIBUTES.get();
		if (map != null) {
			map.put(key, value);
		}
	}
	
	/**
	 * Returns the logged user
	 */
	@SuppressWarnings("unchecked")
	public static <U extends Users> U user() {
		final Users user = getAttribute(USER_KEY);
		if (user == null) {
			throw new NoResultException();
		}
		return (U) user;
	}
	

	
	/**
	 * Returns the attribute for the given key
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getAttribute(final String key) {
		final Map<String, Object> map = ATTRIBUTES.get();
		if (map != null) {
			return (T) map.get(key);
		}
		return null;
	}
	private static Map<String, Object> initMap(final AccessType accessType, final String remoteAddress,
			final Map<String, Object> attributes,Users user) {
		final Map<String, Object> map = new HashMap<String, Object>();
		//map.put(ACCESS_TYPE_KEY, accessType);
		/*if (element != null) {
			map.put(ELEMENT_KEY, element);
			map.put(USER_KEY, element.getUser());
			map.put(GROUP_KEY, element.getGroup());
		}*/
		map.put(USER_KEY, user);
		//System.err.println("stored user in class :"+map.get(USER_KEY).toString());
		//Users user1 = (Users) map.get(USER_KEY);
		//System.err.println(user1.getUsername());
		//map.put(REMOTE_ADDRESS_KEY, remoteAddress);
		if (attributes != null) {
			map.putAll(attributes);
		}
		ATTRIBUTES.set(map);
		return map;
	}
}