import edu.princeton.cs.algs4.StdIn;

/**
 * Created by devendra.mandan on 25/07/18.
 */
public class Permutation {
    public static void main(String[] args) {

        int k = Integer.parseInt(args[0]);

        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();

        while (!StdIn.isEmpty()) {
            randomizedQueue.enqueue(StdIn.readString());
        }

        while (k > 0) {
            System.out.println(randomizedQueue.dequeue());
            k--;
        }
    }
}
