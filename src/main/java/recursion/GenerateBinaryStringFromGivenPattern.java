package recursion;

/**
 * Given a string containing of ‘0’, ‘1’ and ‘?’ wildcard characters,
 * generate all binary strings that can be formed by replacing each wildcard character by ‘0’ or ‘1’.

 Input str = "1??0?101"
 Output:
 10000101
 10001101
 10100101
 10101101
 11000101
 11001101
 11100101
 11101101
 */
public class GenerateBinaryStringFromGivenPattern {

    public static void main(String... args) {
        generate("1??0?101", "", 0);
    }
    private static void generate (String pattern, String output, int index) {
        if (index == pattern.length()) {
            System.out.println(output);
            return;
        }
        if (pattern.charAt(index) == '?') {
            generate(pattern, output + "0", index+1);

            generate(pattern, output + "1", index+1);
        } else {
            generate(pattern, output + pattern.charAt(index), index+1);
        }
    }
}
