import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int k = s.nextInt();
        s.close();

        System.out.println(compute(n, m, k));
    }

    private static int compute(int n, int m, int k) {
         int[] a = new int[n*m];
         int counter = 0;
         for(int i=1; i <= n; i++) {
             for (int j=1; j <= m; j++) {
                 a[counter++] = i*j;
             }
         }
         Arrays.sort(a);

         // return k-1 because an array starts with 0 not with 1
         return a[k-1];
    }

}
