import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class LIBRARY_OLD {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int len = s.nextInt();
        ArrayList<Integer> ids = new ArrayList<>();
        boolean[] idIsUsed = new boolean[len+1];
        for (int i=0; i < len; i++) {
            int id = s.nextInt();
            ids.add(id);
            idIsUsed[id] = true;

        }

        boolean[] idIsPrinted = new boolean[len+1];

        Iterator<Integer> idIterator = ids.iterator();




        while (idIterator.hasNext()) {
            int currentid = idIterator.next();
            if (idIsUsed[currentid]) {
                if (idIsPrinted[currentid]) {
                    for (int i=1; i <= len; i++) {
                        if (!idIsUsed[i]) {
                            System.out.print(i + " ");
                            idIsUsed[i] = true;
                            idIsPrinted[i] = true;
                            break;
                        }
                    }
                } else {
                    System.out.print(currentid + " ");
                    idIsPrinted[currentid] = true;
                }

            } else {
                idIsUsed[currentid] = true;
                idIsPrinted[currentid] = true;
                System.out.print(currentid + " ");
            }
        }

        System.out.println();
    }
}
