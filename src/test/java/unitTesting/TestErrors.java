package unitTesting;

import com.wildcodeschool.wildandwizard.unitTesting.InvalidStringException;
import com.wildcodeschool.wildandwizard.unitTesting.StringUtils;
import org.junit.Test;
import static org.junit.Assert.*;

/* Quest : Unit Testing */
public class TestErrors {
	@Test
	public void testNonPassant() {
		StringUtils stringUtils = new StringUtils();
		String name = "Zurabi";
		String vowels = stringUtils.vowels(name);
		assertEquals("uai", vowels);
		String name2 = "uai";
		String vowels2 = stringUtils.vowels(name2);
		assertEquals("uai", vowels2);
		String name3 = "u";
		String vowels3 = stringUtils.vowels(name3);
		assertEquals("u", vowels3);
	}

	@Test (expected = InvalidStringException.class)
	public void testException() {
		StringUtils stringUtils = new StringUtils();
		String name = null;
		String vowels = stringUtils.vowels(name);
		assertEquals("", vowels);
	}
	
	@Test
	public void testUniqueVowels() {
		StringUtils stringUtils = new StringUtils();
		String name = "Zuuuraadau";
		String vowels = stringUtils.uniqueVowels(name);
		assertEquals("ua", vowels);
	}
	
	@Test (expected = InvalidStringException.class)
	public void testUniqueVowelsException() {
		StringUtils stringUtils = new StringUtils();
		String name = null;
		String vowels = stringUtils.uniqueVowels(name);
		assertEquals("", vowels);
	}
	
	@Test
	public void testUniqueVowelsMajusculeAndMinuscle() {
		StringUtils stringUtils = new StringUtils();
		String name = "UUUUaaauaU";
		String vowels = stringUtils.uniqueVowels(name);
		assertEquals("ua", vowels);
	}
	
	@Test
	public void testUniqueVowelsNoWovels() {
		StringUtils stringUtils = new StringUtils();
		String name = "pppppfdsfsgfsdg";
		String vowels = stringUtils.uniqueVowels(name);
		assertEquals("", vowels);
	}
}
