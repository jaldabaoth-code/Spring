package com.wildcodeschool.wildandwizard.unitTesting;

/* Quests : Unit Testing */
public class StringUtils {
    private static final String ALL_VOWELS = "aeiouyAEIOUY";

    /**
     * Returns the string formed by the vowels of a character string
     * @return String with only vowels
     */
    public static String vowels(String candidate) {
        String vowels = "";
        if (candidate == null )throw new InvalidStringException ("It can't be null");
        char[] letters = candidate.toCharArray();
        for (int i = 0; i < candidate.length(); i++) {
            if (ALL_VOWELS.indexOf(letters[i]) >= 0) {
                vowels += letters[i];
            }
        }
        return vowels;
    }
    
    /**
     * Returns the string formed by the vowels of a character string without duplicate
     * @return String with only vowels without duplicates
     */
    public static String uniqueVowels(String candidate) {
        String vowels = "";
        if (candidate == null )throw new InvalidStringException ("It can't be null");
        char[] letters = candidate.toCharArray();
        for (int i = 0; i < candidate.length(); i++) {
            if (ALL_VOWELS.indexOf(letters[i]) >= 0) {
                vowels += letters[i];
            }
        }
        vowels = vowels.toLowerCase();
        letters = vowels.toCharArray();
        vowels = "";
        for (int i = 0; i < letters.length; i++) {
            if (vowels.indexOf(letters[i]) == -1) {
            	vowels += letters[i];
            }
        }
        return vowels;
    }
}
