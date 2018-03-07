import java.util.Scanner;

class AKU {
    public static void main(String args[]) {
        long n, l, r;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextLong();
        l = scanner.nextLong();
        r = scanner.nextLong();
        scanner.close();

        BinaryTree tree = new BinaryTree(n, null);
        while (tree.getSum() > r) {
            tree = tree.getChild();
        }

        if (tree.getParent() != null) {
            tree = tree.getParent();
        }



    }
}

class BinaryTree {
    private long value;
    private long modValue;
    private BinaryTree child;
    private BinaryTree parent;

    public BinaryTree(long value, BinaryTree parent) {
        this.value = value;
        this.modValue = value%2;
        this.parent = parent;
        if (this.value > 1) {
            child = new BinaryTree(value / 2, this);
        }
    }

    public long getValue() {
        return value;
    }

    public BinaryTree getChild() {
        return child;
    }

    public long getSum() {
        if (this.value > 1) {
            return (child.getSum() * 2) + modValue;
        } else {
            return this.value;
        }
    }

    public BinaryTree getParent() {
        return parent;
    }
}