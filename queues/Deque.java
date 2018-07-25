import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int size;

    private class Node {
        private Item item;
        private Node left;
        private Node right;
    }

    //check internal invariants
    private boolean check() {

        if (size < 0) return false;

        else if (first == null && last != null) return false;

            //after this statement both first and last would be null together
        else if (first != null && last == null) return false;

        else if (first == null && size != 0) return false;

        else if (size == 1) {
            if (first == null) return false;
            if (first != last) return false;
            if (first.right != null) return false;
            if (last.left != null) return false;
        } else {
            if (first == null) return false;
            if (last == null) return false;
            if (first.right != null) return false;
            if (last.left == null) return false;
        }

        int numberOfNodes = 0;
        for (Node i = first; i != null; i = i.right) {
            numberOfNodes++;
        }
        if (numberOfNodes != size) return false;

        numberOfNodes = 0;
        for (Node i = last; i != null; i = i.left) {
            numberOfNodes++;
        }
        if (numberOfNodes != size) return false;
        return true;
    }

    // construct an empty deque
    public Deque() {
        first = null;
        last = null;
        size = 0;
        assert (check());
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) throw new IllegalArgumentException();
        Node newNode = new Node();
        newNode.item = item;
        if (isEmpty()) {
            first = newNode;
            last = first;

        } else {
            first.left = newNode;
            Node oldFirst = first;
            first = newNode;
            first.right = oldFirst;
        }
        size++;
        assert (check());
    }

    // add the item to the end
    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException();
        Node newNode = new Node();
        newNode.item = item;
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            last.right = newNode;
            newNode.left = last;
            last = newNode;
        }
        size++;
        assert (check());
    }

    // remove and return the item from the front
    public Item removeFirst() {
        Item item;
        if (isEmpty()) throw new NoSuchElementException();
        item = first.item;
        if (size() == 1) {
            first = null;
            last = null;
        } else {
            Node second = first.right;
            first.right.left = null;
            first.right = null;
            first = second;
        }
        size--;
        check();
        return item;
    }

    // remove and return the item from the end
    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException();

        Item item = last.item;
        if (size() == 1) {
            first = null;
            last = null;
        } else {
            last = last.left;
            last.right = null;
        }
        size--;
        assert (check());
        return item;
    }

    // return an iterator over items in order from front to end
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item toReturn = current.item;
            current = current.right;
            return toReturn;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    // unit testing (optional)
    public static void main(String[] args) {

        Deque<String> testDeque = new Deque<>();
        testDeque.addFirst("one");
        testDeque.addFirst("two");
        testDeque.addLast("three");
        testDeque.addLast("four");

        for (String item : testDeque) {
            System.out.print("Entry - ");
            System.out.println(item);
        }
        System.out.println();

        testDeque.removeFirst();
        testDeque.removeLast();

        testDeque.addLast("three");
        testDeque.addLast("four");
        testDeque.addFirst("one");
        testDeque.addFirst("two");

        for (String item : testDeque) {
            System.out.print("Entry - ");
            System.out.println(item);
        }
        System.out.println();

        testDeque.removeFirst();
        testDeque.removeLast();
        testDeque.removeLast();

        for (String item : testDeque) {
            System.out.print("Entry - ");
            System.out.println(item);
        }
    }

}