import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

class Main
{
    public static void main(String args[])
    {
        int n, l, r;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        l = scanner.nextInt();
        r = scanner.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        s.push(n);
        while (list.size() <= r) {
            n = s.pop();

            if (n != 0 && n != 1) {
                int x = n/2;
                s.push(x);
                s.push(n%2);
                s.push(x);
            } else {
                list.add(n);
            }
        }

        int j = 0;
        for(int i = l; i <= r; i++) {
            if (list.get(i) == 1) {
                j++;
            }
        }

        System.out.println(j);

    }
}