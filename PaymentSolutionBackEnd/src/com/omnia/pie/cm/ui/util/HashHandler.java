package com.omnia.pie.cm.ui.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang3.RandomStringUtils;


public class HashHandler {

	public static final String SHA_256 = "SHA-256";
	public static final String MD5 = "MD5";

	public static enum PasswordHash implements StringValuedEnum {
		/**
		 * SHA-256 with per-user salt: The most secure option, used for new
		 * databases since payo 
		 */
		SHA2_SALT("T"),

		/**
		 * SHA-256 alone. Used for compatibility of databases migrated from payo
		 * 3.5
		 */
		SHA2("S"),

		/**
		 * SHA-256 over MD5. Used for compatibility of databases migrated from
		 * payo 3.0
		 */
		SHA2_MD5("M");

		private final String value;

		private PasswordHash(final String value) {
			this.value = value;
		}

		@Override
		public String getValue() {
			return value;
		}
	}
	
	/**
	 * Apply a SHA-256 hash
	 * 
	 * @param string
	 */
	public static String sha2(final String string) {
		return digest(SHA_256, null, string);
	}

	private static String digest(final String algorithm, final String salt, final String string) {
		if (string == null) {
			return null;
		}
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance(algorithm);
		}
		catch (final NoSuchAlgorithmException e) {
			throw new IllegalStateException(e);
		}
		md.reset();
		try {
			if (salt != null) {
				md.update(salt.getBytes("UTF-8"));
			}
			return toHex(md.digest(string.getBytes("UTF-8")));
		}
		catch (final UnsupportedEncodingException e) {
			// Never happens as UTF-8 is always supported
			return null;
		}
	}

	private static String toHex(final byte[] bytes) {
		final char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		final char[] chars = new char[bytes.length * 2];
		int j = 0;
		int k;
		for (final byte element : bytes) {
			k = element;
			chars[j++] = hexDigits[(k >>> 4) & 0x0F];
			chars[j++] = hexDigits[k & 0x0F];
		}
		return new String(chars);
	}

	/**
	 * Hashes the given string according to the current password hash algorithm
	 */
	public String hash(final String salt, final String string) {
		switch (getPasswordHash()) {
		case SHA2_SALT:
			return digest(SHA_256, salt, string);
		case SHA2:
			return digest(SHA_256, null, string);
		case SHA2_MD5:
			return digest(SHA_256, null, digest(MD5, null, string));
		}
		return null;
	}

	/**
	 * Returns a new salt, but only if the password hash is SHA2 / SALT.
	 * Otherwise, returns null
	 */
	public String newSalt() {
		if (getPasswordHash() != PasswordHash.SHA2_SALT) {
			return null;
		}
		return RandomStringUtils.randomAlphanumeric(32);
	}

	private PasswordHash getPasswordHash() {
		return PasswordHash.SHA2_SALT;
	}
	
	public static void main(String[] args) {
		
	String result =	HashHandler.digest("SHA-256", "0RzB7nkPFnDAXslzgE51AGlrryoO31Ac", "F876AB2410E4F28CD2AB7323C16FF817E2BF96BACDAEC7C8854791B1A77279E7");
	System.err.println(result);
	}
	
}
