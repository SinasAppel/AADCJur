import java.util.Scanner;

public class GAME {

    public static void main(String args[]) {
        int n;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        long[] s = new long[100001];
        int a;
        for (int i=0; i < n; i++) {
            a = scanner.nextInt();
            s[a]++;
        }
        scanner.close();

        System.out.println(calculateWithDP(s, 100001));
    }

    private static long calculateWithDP(long[] s, int n) {
        if(n==0) {
            return 0;
        }
        if(n==1) {
            return s[0];
        }

        long[] points = new long[n];

        points[0] = s[0];
        points[1] = Math.max(s[0], s[1]);

        for(int i=2;i<n;i++){
            points[i] = Math.max((s[i]*i)+points[i-2], points[i-1]);
        }
        return points[n-1];
    }
}
