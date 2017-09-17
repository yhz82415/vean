package recursion;

public class HanoiTower {

    public static void main(String... args) {
        hanoi(4, 'A', 'C', 'B');
    }

    private static void hanoi(int n, char from, char to, char aux) {
        if (n == 1) {
            System.out.println("move " + n + " from " + from + " to " + to);
            return;
        }
        hanoi(n - 1, from, aux, to);
        System.out.println("move " + n + " from " + from + " to " + to);
        hanoi(n - 1, aux, to, from);
    }
}
