package challenges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MagicDictionary {
    private Map<String, List<int[]>> magicDict = new HashMap<>();

    /** Initialize your data structure here. */
    public MagicDictionary() {
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String w : dict) {
            for(int i = 0; i < w.length(); i++) {
                String key = null;
                if (i != w.length() - 1) {
                    key = w.substring(0, i) + w.substring(i + 1);
                } else {
                    key = w.substring(0, i);
                }
                List<int[]> value = magicDict.getOrDefault(key, new ArrayList<int[]>());
                int[] pair = new int[]{i, w.charAt(i)};
                value.add(pair);
                magicDict.put(key, value);
            }
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        for(int i = 0; i < word.length(); i++) {
            String key = word.substring(0, i) + word.substring(i + 1);
            if (magicDict.containsKey(key)) {
                for(int[] pair : magicDict.get(key)) {
                    if (pair[0] == i && pair[1] != word.charAt(i)) return true;
                }
            }
        }
        return false;
    }
}

/**
 * Your challenges.MagicDictionary object will be instantiated and called as such:
 * challenges.MagicDictionary obj = new challenges.MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */

