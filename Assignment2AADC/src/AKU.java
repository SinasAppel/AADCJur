import java.util.Scanner;
import java.util.Stack;

class AKU
{
    public static void main(String args[])
    {
        long n, l, r;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextLong();
        l = scanner.nextLong();
        r = scanner.nextLong();
        scanner.close();

        long k = 1;
        int output = 0;
        Stack<Long> s = new Stack<>();
        s.push(n);
        while (k <= r) {
            n = s.pop();

            if (n > 1) {
                long x = n/2;
                s.push(x);
                s.push(n%2);
                s.push(x);
            } else {
                if (k >= l && n == 1) {
                    output++;
                }
                k++;
            }
        }

        System.out.println(output);

    }
}