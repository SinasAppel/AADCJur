import java.util.Scanner;

public class LIBRARY {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int[] histogram = new int[100001];
        int[] inputOrder = new int[n];
        boolean[] isUsed = new boolean[100001];
        boolean[] isPrinted = new boolean[100001];

        int lowestNonUsedId = findLowest(0, isUsed);

        for (int i=0; i < n; i++) {
            int input = s.nextInt();
            histogram[input]++;
            inputOrder[i] = input;
            isUsed[input] = true;
        }

        for (int i=0; i < n; i++) {
            if (isPrinted[inputOrder[i]] || histogram[inputOrder[i]] > 1 || inputOrder[i] > n) {
                // needs to be changed
                if (lowestNonUsedId < inputOrder[i]) {
                    // we can use a lower id that is not used yet
                    isUsed[lowestNonUsedId] = true;
                    isPrinted[lowestNonUsedId] = true;
                    System.out.print(lowestNonUsedId + " ");
                    lowestNonUsedId = findLowest(lowestNonUsedId, isUsed);
                } else {
                    if (isUsed[inputOrder[i]] && !isPrinted[inputOrder[i]]) {
                        // we can use the current id
                        isUsed[inputOrder[i]] = true;
                        isPrinted[inputOrder[i]] = true;
                        System.out.print(inputOrder[i] + " ");
                    } else {
                        // need to find the lowest non used id that is higher than current id
                        int higherThanCurrentButAsLowAsPossible = findLowest(inputOrder[i], isUsed);
                        isUsed[higherThanCurrentButAsLowAsPossible] = true;
                        isPrinted[higherThanCurrentButAsLowAsPossible] = true;
                        System.out.print(higherThanCurrentButAsLowAsPossible + " ");
                    }
                }

            } else {
                // can be used without changing
                isUsed[inputOrder[i]] = true;
                isPrinted[inputOrder[i]] = true;
                System.out.print(inputOrder[i] + " ");
            }
            histogram[inputOrder[i]]--;
        }
    }

    private static int findLowest(int lowest, boolean isUsed[]) {
        int i = lowest + 1;
        while (isUsed[i]) {
            i++;
        }
        return i;
    }
}
