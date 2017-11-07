package string;

public class StringPermutation {

    public static void main(String... args) {
        String str = "abc";
        perm(str, 0, str.length() - 1);
    }

    private static void perm(String str, int startingIndex, int length) {
        if (startingIndex == length) System.out.println(str);
        for(int i = startingIndex; i <= length; i++) {
            str = swap(str, startingIndex, i);
            perm(str, startingIndex + 1, length);
            str = swap(str, startingIndex, i);
        }
    }

    private static String swap(String string, int i, int j) {
        char[] chars = string.toCharArray();
        char tmp = chars[j];
        chars[j] = chars[i];
        chars[i] = tmp;
        return String.valueOf(chars);
    }
}
