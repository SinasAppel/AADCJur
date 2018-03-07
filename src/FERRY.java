import java.util.Scanner;

public class FERRY {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int cents = s.nextInt();

        int[] ferryCosts = new int[n];
        int[] discountFactors = new int[n];

        for (int i=0; i < n; i++) {
            ferryCosts[i] = s.nextInt();
        }

        for (int i=0; i < n; i++) {
            discountFactors[i] = s.nextInt();
        }


    }
}
