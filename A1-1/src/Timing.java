import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by greg on 1/19/16.
 */
public class Timing {

    public static void main(String[] args) {
        for (int i = 10; i <= 20; i++) {
            int size = (int)Math.pow(2, i);
            TreeSet<Integer> tree = generateBinaryTree(size);
            timeLookup(tree, size);
        }
    }

    public static TreeSet<Integer> generateBinaryTree(int size) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < size; i++) {
            treeSet.add(i);
        }
        return treeSet;
    }

    public static void timeLookup(TreeSet<Integer> tree, int size) {
        tree.contains(7);
        tree.contains(4038);
        tree.contains(2898833);

        int step = 10000000;
        int limit = 100000000;

        for (int i = step; i <= limit; i+=step) {
            long start = System.nanoTime();
            for (int j = 0; j < i; j++) {
                tree.contains(ThreadLocalRandom.current().nextInt(0, size));
            }
            long stop = System.nanoTime();
            System.out.println(i + " -> " + (stop - start) / 1000000);
        }
    }
}
