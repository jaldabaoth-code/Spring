package com.wildcodeschool.wildandwizard.unitTesting;

/* Spring Quests : Unit Testing */
public class StringUtils {
    private static final String ALL_VOWELS = "aeiouyAEIOUY";

    /**
     * Renvoie la chaine formée par les voyelles d'une chaine de caractères
     * @return Chaine avec uniquement des voyelles
     */
    public static String vowels(String candidate) {
        String vowels = "";
        if (candidate == null )throw new InvalidStringException ("Ca ne peut pas etre null");
        char[] letters = candidate.toCharArray();
        for (int i = 0; i < candidate.length(); i++) {
            if (ALL_VOWELS.indexOf(letters[i]) >= 0) {
                vowels += letters[i];
            }
        }
        return vowels;
    }
    
    /**
     * Renvoie la chaine formée par les voyelles d'une chaine de caractères sans doublon
     * @return Chaine avec uniquement des voyelles sans doublon
     */
    public static String uniqueVowels(String candidate) {
        String vowels = "";
        if (candidate == null )throw new InvalidStringException ("Ca ne peut pas etre null");
        char[] letters = candidate.toCharArray();
        for (int i = 0; i < candidate.length(); i++) {
            if (ALL_VOWELS.indexOf(letters[i]) >= 0) {
                vowels += letters[i];
            }
        }
        vowels = vowels.toLowerCase();
        letters = vowels.toCharArray();
        vowels = "";
        for(int i = 0; i < letters.length; i++) {
            if(vowels.indexOf(letters[i]) == -1) {
            	vowels += letters[i];
            }
        }
        return vowels;
    }
}
