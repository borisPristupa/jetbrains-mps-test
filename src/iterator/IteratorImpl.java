package iterator;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class IteratorImpl implements Iterator<Node> {

    // Memory complexity: O(N)
    private Deque<Node> stack = new LinkedList<>();

    // Time complexity: O(1)
    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    // Time complexity: O(1)
    @Override
    public Node next() throws NoSuchElementException {
        if (!hasNext()) throw new NoSuchElementException();

        Node current = stack.removeFirst();

        if (null != current.right) stack.addFirst(current.right);
        if (null != current.left) stack.addFirst(current.left);

        return current;
    }

    // Time complexity: O(1)
    public IteratorImpl(Node root) {
        if (null == root) return;
        stack.addFirst(root);
    }
}
