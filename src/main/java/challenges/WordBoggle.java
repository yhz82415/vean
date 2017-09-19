package challenges;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * dictionary, a method to do lookup in dictionary and a M x N board where every cell has one character. Find all possible words that can be formed by a sequence of adjacent characters. Note that we can move to any of 8 adjacent characters, but a word should not have multiple instances of same cell.

 Example:
 Input: dictionary[] = {"GEEKS", "FOR", "QUIZ", "GO"};
 findWords[][]   = {{'G','I','Z'},
                {'U','E','K'},
                {'Q','S','E'}};
 isWord(str): returns true if str is present in dictionary
 else false.

 Output:  Following words of dictionary are present
 GEEKS
 QUIZ
 */
public class WordBoggle {

    public static void main(String... args) {
        char[][] boggle = new char[][]{{'G', 'I', 'Z'}, {'U','E','K'}, {'Q','S','E'}};
        List<String> dic = new ArrayList<>();
        dic.add("GEEKS");
        dic.add("FOR");
        dic.add("QUIZ");
        dic.add("GO");
        String[] dictionary = new String[] {"GEEKS", "FOR", "QUIZ", "GO"};
        findWords(boggle, dictionary);
    }
    private static void findWords(char[][] boggle, String[] dictionary) {
        boolean[][] visited = new boolean[][]{{false, false, false}, {false, false, false}, {false, false, false}};
        String str = "";
        Set<String> dicSet = new HashSet<>();
        for (String d : dictionary) {
            dicSet.add(d);
        }
        for (int i = 0; i < 3; i ++) {
            for (int j = 0; j < 3; j++) {
                findWordsUtil(boggle, visited, i, j, str, dicSet);
            }
        }
    }
    private static void findWordsUtil(char[][] boggle, boolean[][] visited, int i, int j, String str, Set<String> dicSet) {
//        System.out.println("i: " + i + ", j: " + j);
        str = str + boggle[i][j];
        visited[i][j] = true;
        if(dicSet.contains(str)) {
            System.out.println(str);
            dicSet.remove(str); // remove the word so that it won't print twice
        }
        for(int row = i - 1; row <= i + 1 && row < 3; row++) {
            for (int col = j - 1; col <= j + 1 && col < 3; col++) {
                if (row >= 0 && col >= 0 && !visited[row][col])
                findWordsUtil(boggle, visited, row, col, str, dicSet);
            }
        }
        str = "";
        visited[i][j] = false;
    }
}
