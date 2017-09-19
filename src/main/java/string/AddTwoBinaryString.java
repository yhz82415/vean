package string;

public class AddTwoBinaryString {

    public static void main(String... args) {
        System.out.println(add("1101".toCharArray(), "100".toCharArray()));
    }

    private static String add(char[] a, char[] b) {
        int i = a.length - 1;
        int j = b.length - 1;
        int sum = 0;
        StringBuilder result = new StringBuilder();
        while (i >= 0 || j >= 0 || sum == 1) {
            sum += i >= 0 ? (a[i] - '0') : 0;
            sum += j >= 0 ? (b[j] - '0') : 0;

            result.insert(0, sum % 2);

            i--;
            j--;

            sum /= 2;
        }
        return result.toString();
    }
}
