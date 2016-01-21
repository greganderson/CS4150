import java.util.ArrayList;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by greg on 1/19/16.
 */
public class Timing {

    public static void main(String[] args) {
        for (int i = 10; i <= 13; i++) {
            int size = (int)Math.pow(2, i);
            TreeSet<Integer> tree = generateBinaryTree(size);
            timeLookup(tree, size);
        }

        System.out.println("\n\n");
        System.out.println("----------------------");
        System.out.println("\n\n");

        for (int i = 10; i <= 20; i++) {
            long size = (long)Math.pow(2, i);
            TreeSet<Integer> tree = generateBinaryTree(size);
            timeLookup(tree, size);
        }
    }

    public static TreeSet<Integer> generateBinaryTree(long size) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < size; i++) {
            treeSet.add(i);
        }
        return treeSet;
    }

    public static void timeLookup(TreeSet<Integer> tree, long size) {
        tree.contains(7);
        tree.contains(4038);
        tree.contains(2898833);

        int limit = 50000000;
        int randomSize = 1000000;

        // Generate a list of random numbers to get rid of the time it takes
        // to generate the numbers
        ArrayList<Integer> randomNums = new ArrayList<>();
        for (int i = 0; i < randomSize; i++)
            randomNums.add(ThreadLocalRandom.current().nextInt(0, (int)size));

        // Store the overhead of a for loop
        long start = System.nanoTime();
        for (int i = 0; i < limit; i++);
        long stop = System.nanoTime();
        long overheadTime = stop - start;

        // Time the lookups
        start = System.nanoTime();
        for (int i = 0; i < limit; i++)
            tree.contains(randomNums.get(i%randomSize));
        stop = System.nanoTime();

        System.out.println((stop - start - overheadTime) / 1000000);
    }
}
