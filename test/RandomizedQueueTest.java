import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * Created by devendra.mandan on 27/07/18.
 */
public class RandomizedQueueTest {

    private RandomizedQueue<String> randomizedQueue;

    @Test
    // When no non-null items in queue or numberOfItems=0, but n non-zero(say)
    // New array created after resize should not be of size 0
    // according to the statement resize(2 * numberOfItems);
    public void test1() {
        randomizedQueue = new RandomizedQueue<>();

        randomizedQueue.enqueue("first");
        randomizedQueue.enqueue("second");

        randomizedQueue.dequeue();
        randomizedQueue.dequeue();

        //here numberOfItems = 0, but n = 2
        try {
            randomizedQueue.enqueue("three");
        } catch (ArrayIndexOutOfBoundsException e) {
            fail(e.toString());
        }
    }
}