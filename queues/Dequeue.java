public class Dequeue<Item> {

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

        else if (first != null && last == null) return false;

        else if (first == null && size != 0) return false;

        else if (size == 1) {
            if (first == null) return false;
        }

        return true;
    }

    // construct an empty deque
    public Dequeue() {
        first = null;
        last = null;
        size = 0;
    }

//    // is the deque empty?
//    public boolean isEmpty() {
//
//    }

//    // return the number of items on the deque
//    public int size() {
//    }

    // add the item to the front
    public void addFirst(Item item) {
    }

    // add the item to the end
    public void addLast(Item item) {
    }

//    // remove and return the item from the front
//    public Item removeFirst() {
//    }
//
//    // remove and return the item from the end
//    public Item removeLast() {
//    }
//
//    // return an iterator over items in order from front to end
//    public Iterator<Item> iterator() {
//    }

    // unit testing (optional)
    public static void main(String[] args) {
    }

}