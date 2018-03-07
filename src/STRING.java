import java.util.*;

public class STRING {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        char[] s = string.toCharArray();
        int m = scanner.nextInt();
        int len = s.length;
        int[] input = new int[len];

        for (int i=0; i < m; i++) {
            input[scanner.nextInt()]++;
        }

        for (int i=0; i < input.length; i++) {
            input[i] = input[i] % 2;
        }

        for (int i=0; i < input.length; i++) {
            if (input[i] == 1) {
                s = reverse(s, i, len);
            }
        }

        string = new String(s);
        System.out.println(string);
    }

    private static char[] reverse(char[] s, int left, int len) {
        int right = len - left;
        left--;
        while (left < right) {
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }

        return s;
    }
}
