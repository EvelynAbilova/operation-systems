import java.util.concurrent.atomic.AtomicReference;

public class LFStack<T> {
    private AtomicReference<Node<T>> head;

    public LFStack() {
        head = new AtomicReference<>(null);
    }

    private class Node<T> {

        public volatile T value;
        public AtomicReference<Node<T>> next;

        public Node(T v) {
            value = v;
            next = new AtomicReference<Node<T>>();
        }
    }

    public void push(T item) {
        if (item == null)
            throw new NullPointerException();
        Node<T> oldHeadNode = new Node<T>(item);

        while (true) {
            Node<T> oldRootNode = head.get();
            if (oldRootNode != null) {
                oldHeadNode.next.set(oldRootNode);
            }
            if (head.compareAndSet(oldRootNode, oldHeadNode)) {
                break;
            }
        }
    }

    public T pop() {
        T payload;
        while (true) {
            Node<T> oldHeadNode = head.get();
            if (oldHeadNode == null) {
                return null;
            }
            payload = head.get().value;
            if (head.compareAndSet(oldHeadNode, oldHeadNode.next.get())) {
                break;
            }
        }
        return payload;
    }

    public T peek() {
        T payload = null;
        Node<T> node = head.get();
        if (node != null) {
            payload = node.value;
        }
        return payload;
    }

    public boolean isEmpty() {
        return peek() == null;
    }

    public boolean contains(T elem) {
        if (elem == null) {
            return false;
        }
        for (Node<T> n = head.get(); n != null; n = n.next.get()) {
            if (n.value.equals(elem))
                return true;
        }
        return false;
    }
}

