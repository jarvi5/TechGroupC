public class MultiLinkedList<T> {
    private Node<T> nodes = null;

    public void append(T value) {
        Node<T> newNode = new Node<T>(value);
        if (nodes != null) {
            Node<T> root = nodes;
            while (root.next != null) {
                root = root.next;
            }
            root.next = newNode;
            newNode.previous = root;
        } else {
            nodes = newNode;
        }
    }

    public void appendChild(Node<T> parentNode, T data) {
        NodeChild<T> nodeChild = new NodeChild<>(data);
        if (nodes != null) {
            Node<T> root = nodes;
            while (root != null) {
                if (root.value.equals(parentNode.value)) {
                    insertNode(nodeChild);
                    break;
                }
                root = root.next;
            }
        }
    }

    private void insertNode(NodeChild<T> childNode) {
        Node<T> root = nodes;
        if (nodes != null) {
            if (root.childElement == null) {
                root.childElement = childNode;
                root.childElement.previous = childNode;
            } else {
                NodeChild<T> rootChild = root.childElement;
                while (rootChild.next != null) {
                    rootChild = rootChild.next;
                }
                rootChild.next = childNode;
                childNode.previous = rootChild;
            }
        }
    }
}
