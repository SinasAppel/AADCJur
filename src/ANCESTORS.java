import java.util.Scanner;

public class ANCESTORS {

    public static void main(String args[]) {
        int n, m;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        Person[] persons = new Person[n + 1];


        for (int i = 1; i <= n; i++) {
            int nextId = scanner.nextInt();
            if (nextId == 0) {
                addPerson(i, persons, null);
            } else {
                addPerson(i, persons, getPerson(nextId, persons));
            }
        }

        for (int i=0; i < m; i++) {
            boolean nullFound = false;
            Person p = persons[scanner.nextInt()];
            int level = scanner.nextInt();
            for (int j=0; j < level; j++) {
                if (p.getAncestor() == null) {
                    nullFound = true;
                    break;
                }
                p = p.getAncestor();
            }
            if (nullFound) {
                System.out.println(0);
            } else {
                System.out.println(p.getId());
            }
        }


    }

    private static Person addPerson(int id, Person[] p, Person ancestor) {
        if (p[id] == null) {
            p[id] = new Person(id);
        }
        p[id].setAncestor(ancestor);
        return p[id];
    }

    private static Person getPerson(int id, Person[] p) {
        if (p[id] == null) {
            return addPerson(id, p, null);
        }
        return p[id];
    }

}

class Person {
    private int id;
    private Person ancestor;

    public Person(int id) {
        this.id = id;
    }

    public void setAncestor(Person ancestor) {
        this.ancestor = ancestor;
    }

    public int getId() {
        return id;
    }

    public Person getAncestor() {
        return ancestor;
    }
}


