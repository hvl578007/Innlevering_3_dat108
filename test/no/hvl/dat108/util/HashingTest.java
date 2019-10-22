package no.hvl.dat108.util;


import static org.junit.jupiter.api.Assertions.assertTrue;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.xml.bind.DatatypeConverter;

import org.junit.jupiter.api.Test;

//frå prosjekt på canvas

public class HashingTest {
	
	String password = "password123";
	@Test
	public void testValidatePasswordWithoutSalt() throws NoSuchAlgorithmException {
		
		Hashing ph = new Hashing(Hashing.SHA256);
		
		long start = System.currentTimeMillis();
		ph.generateHashWithoutSalt(password);
		long end = System.currentTimeMillis();
		long diff = end - start;
		
		String hashedpassword = ph.getPasswordHashinHex();
		
		System.out.println("p: Runtime: "+diff+" Hash: "+hashedpassword);
		
		boolean actual = ph.validatePasswordWithoutSalt(password, hashedpassword);
		
		assertTrue(actual);
	}

	@Test
	public void testValidatePasswordWithSalt() throws NoSuchAlgorithmException {
		Hashing ph = new Hashing(Hashing.SHA256);
		byte[] salt = ph.getSalt();
		
		long start = System.currentTimeMillis();
		ph.generateHashWithSalt(password, salt);
		long end = System.currentTimeMillis();
		long diff = end - start;
		
		String hashedpassword = ph.getPasswordHashinHex();
		System.out.println("ps: Runtime: "+diff+" Hash: "+hashedpassword);
		
		String saltinhex = DatatypeConverter.printHexBinary(salt);
		boolean actual = ph.validatePasswordWithSalt(password, saltinhex, hashedpassword);
		
		assertTrue(actual);
	}

	@Test
	public void testValidatePasswordWithSaltAndIteration() throws NoSuchAlgorithmException, InvalidKeySpecException {
		
		int iteration = 120000;
		int keylength = 256;		// we need 256 bits key length
		Hashing ph = new Hashing();	// the PBKDF uses its own algorithm (e.g. PBKDF2WithHmacSHA1) to derive a secret key
		byte[] salt = ph.getSalt();
		
		long start = System.currentTimeMillis();
		ph.generateHashWithSaltAndIteration(password, salt, keylength, iteration);
		long end = System.currentTimeMillis();
		long diff = end - start;
		
		String hashedpassword = ph.getPasswordHashinHex();
		System.out.println("psi: Runtime: "+diff+" Hash: "+hashedpassword);
		
		String saltinhex = DatatypeConverter.printHexBinary(salt);
		
		boolean actual = ph.validatePasswordWithSaltAndIteration(password, saltinhex, hashedpassword, keylength, iteration);
		
		assertTrue(actual);
	}

}
