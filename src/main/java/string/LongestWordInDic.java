package string;

import java.util.HashSet;
import java.util.Set;

/**
 * Giving a dictionary and a string ‘str’, find the longest string in dictionary which can be formed by
 * deleting some characters of the given ‘str’.

 Examples:

 Input : dict = {"ale", "apple", "monkey", "plea"}
 str = "abpcplea"
 Output : apple

 Input  : dict = {"pintu", "geeksfor", "geeksgeeks",
 " forgeek"}
 str = "geeksforgeeks"
 Output : geeksgeeks
 */
public class LongestWordInDic {

    public static void main(String... args) {
        Set<String> dictionary = new HashSet<>();
        dictionary.add("ale");
        dictionary.add("apple");
        dictionary.add("monkey");
        dictionary.add("plea");

        find(dictionary, "abpcplea");
    }

    private static void find(Set<String> dictionary, String word) {
        String longestWord = "";
        for (String w : dictionary) {
            String found = find(w, word, longestWord);
            if (found != null && longestWord.length() < found.length()) {
                longestWord = found;
            }
        }
        System.out.println(longestWord);
    }

    private static String find(String dicWord, String word, String lonestWord) {
//        System.out.println("dicWord: " + dicWord);
        char[] dicWordChars = dicWord.toCharArray();
        char[] wordChars = word.toCharArray();
        int dicWordIndex = 0;
        for (int i = 0; i < wordChars.length; i++) {
            if (dicWordIndex == dicWord.length() && lonestWord.length() < dicWord.length()) {
                return dicWord;
            }
            if (dicWordIndex < dicWord.length() && wordChars[i] == dicWordChars[dicWordIndex]) {
                dicWordIndex++;
            }
        }
        return null;
    }
}
