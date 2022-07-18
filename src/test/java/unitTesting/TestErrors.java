package unitTesting;

import com.wildcodeschool.wildandwizard.unitTesting.InvalidStringException;
import com.wildcodeschool.wildandwizard.unitTesting.StringUtils;
import org.junit.Test;
import static org.junit.Assert.*;

/* Spring Quests : Unit Testing */
public class TestErrors {
	@Test
	public void testNonPassant() {
		StringUtils stringUtils = new StringUtils();
		String nom = "Zurabi";
		String vowels = stringUtils.vowels(nom);
		assertEquals("uai", vowels);
		String nom2 = "uai";
		String vowels2 = stringUtils.vowels(nom2);
		assertEquals("uai", vowels2);
		String nom3 = "u";
		String vowels3 = stringUtils.vowels(nom3);
		assertEquals("u", vowels3);
	}

	@Test (expected = InvalidStringException.class)
	public void testException() {
		StringUtils stringUtils = new StringUtils();
		String nom = null;
		String vowels = stringUtils.vowels(nom);
		assertEquals("", vowels);
	}
	
	@Test
	public void testUniqueVowels() {
		StringUtils stringUtils = new StringUtils();
		String nom = "Zuuuraadau";
		String vowels = stringUtils.uniqueVowels(nom);
		assertEquals("ua", vowels);
	}
	
	@Test (expected = InvalidStringException.class)
	public void testUniqueVowelsException() {
		StringUtils stringUtils = new StringUtils();
		String nom = null;
		String vowels = stringUtils.uniqueVowels(nom);
		assertEquals("", vowels);
	}
	
	@Test
	public void testUniqueVowelsMajusculeAndMinuscle() {
		StringUtils stringUtils = new StringUtils();
		String nom = "UUUUaaauaU";
		String vowels = stringUtils.uniqueVowels(nom);
		assertEquals("ua", vowels);
	}
	
	@Test
	public void testUniqueVowelsNoWovels() {
		StringUtils stringUtils = new StringUtils();
		String nom = "pppppfdsfsgfsdg";
		String vowels = stringUtils.uniqueVowels(nom);
		assertEquals("", vowels);
	}
}
