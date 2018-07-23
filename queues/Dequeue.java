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
    public Dequeue() {
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
        assert (check());
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

        Dequeue<String> testDequeue = new Dequeue<>();
        testDequeue.addFirst("one");
        testDequeue.addFirst("two");

    }

}