import java.util.Scanner;

public class TABLE {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int k = s.nextInt();
        s.close();

        System.out.println(compute(n, m, k));
    }

    private static int compute(int m, int n, int k) {
         int low = 1;
         int high = m * n;
         while (low < high) {
             int middle = (low + high) / 2;
             if (!isBigEnough(middle, m, n, k)) {
                 low = middle + 1;
             } else {
                 high = middle;
             }
         }
         return low;
    }

    private static boolean isBigEnough(int a, int m, int n, int k) {
        int counter = 0;
        for (int i=1; i <= m; i++) {
            counter += Math.min(a/i, n);
        }
        return counter >= k;
    }

}
