package iterator;

public class Node<T> {
    public T value;
    public Node<T> left = null;
    public Node<T> right = null;

    public Node(T t) {
        value = t;
    }

    private Node() {}
}
