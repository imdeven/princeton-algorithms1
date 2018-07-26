import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by devendra.mandan on 23/07/18.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

    private int numberOfItems;
    private int n;
    private Item[] items;

    public RandomizedQueue()                 // construct an empty randomized queue
    {
        items = (Item[]) new Object[2];
        numberOfItems = 0;
        n = 0;
    }

    public boolean isEmpty()                 // is the randomized queue empty?
    {
        return numberOfItems == 0;
    }

    public int size()                        // return the number of items on the randomized queue
    {
        return numberOfItems;
    }

    public void enqueue(Item item)           // add the item
    {
        if (item == null) throw new IllegalArgumentException();

        if (n == items.length) resize(2 * n);
        items[n] = item;
        n++;
        numberOfItems++;
    }

    private void resize(final int newSize) {
        Item[] temp = (Item[]) new Object[newSize];
        for (int i = 0; i < items.length; i++) {
            temp[i] = items[i];
        }
        items = temp;
    }

    public Item dequeue()                    // remove and return a random item
    {
        if (isEmpty()) throw new NoSuchElementException("Stack Underflow!");
        int indexToEmpty = nonNullRandomIndex();
        Item toReturn = items[indexToEmpty];
        items[indexToEmpty] = null;
        numberOfItems--;
        if ((numberOfItems > 0) && (numberOfItems == items.length / 4)) {
            resize(items.length / 2);
        }
        return toReturn;

    }

    public Item sample()                     // return a random item (but do not remove it)
    {
        if (isEmpty()) throw new NoSuchElementException("Stack Underflow!");
        int i = nonNullRandomIndex();
        return items[i];
    }

    private int nonNullRandomIndex() {
        int indexToEmpty = StdRandom.uniform(n);
        while (items[indexToEmpty] == null) {
            indexToEmpty = StdRandom.uniform(n);
        }
        return indexToEmpty;
    }

    public Iterator<Item> iterator()         // return an independent iterator over items in random order
    {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Item> {

        private final int[] nonNullItems = new int[numberOfItems];
        private int current = 0;

        public ArrayIterator() {
            int i = 0;
            for (int j = 0; j < n; j++) {
                if (items[j] != null) {
                    nonNullItems[i] = j;
                    i++;
                }
            }
            StdRandom.shuffle(nonNullItems);
        }

        @Override
        public boolean hasNext() {
            return current < nonNullItems.length;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item toReturn = items[nonNullItems[current]];
            current++;
            return toReturn;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args)   // unit testing (optional)
    {
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();
        assert (randomizedQueue.isEmpty());
        assert (randomizedQueue.size() == 0);
        randomizedQueue.enqueue("first");
        randomizedQueue.enqueue("second");
        randomizedQueue.enqueue("third");
        randomizedQueue.enqueue("four");
        randomizedQueue.enqueue("five");
        // System.out.println(randomizedQueue.sample());
        randomizedQueue.dequeue();
        randomizedQueue.dequeue();
        for (String item : randomizedQueue) {
            System.out.println(item);
        }
        for (String item : randomizedQueue) {
            System.out.println(item);
        }
    }

}
