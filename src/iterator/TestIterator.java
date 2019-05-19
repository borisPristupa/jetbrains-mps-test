package iterator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class TestIterator {

    @Test
    void testIterator() {
        Node<Integer> root;
        {
            root = new Node<>(1);

            root.left = new Node<>(1);
            root.right = new Node<>(1);

            root.left.left = new Node<>(1);
            root.left.right = new Node<>(2);

            root.right.right = new Node<>(3);

            root.left.left.left = new Node<>(5);

            root.right.right.left = new Node<>(6);
            root.right.right.right = new Node<>(7);
        }
        List<Integer> controlList = Arrays.asList(1, 1, 1, 5, 2, 1, 3, 6, 7);

        Iterator<Node> iterator = new IteratorImpl(root);

        for (Integer integer : controlList) {
            assert iterator.hasNext();
            assert iterator.next().value == integer;
        }
    }
}
