package project;


public class DoubleLinkedList<T> {
    private Node<T> root;

    public DoubleLinkedList() {
        this.root = null;
    }

    public void add(T data) {
        Node<T> newNode = new Node<T>(data);
        if (root == null) {
            root = newNode;
        } else {
            Node<T> nodeData = root;
            while (nodeData.getNextElement() != null) {
                nodeData = nodeData.getNextElement();
            }
            nodeData.setNextElement(newNode);
            newNode.setPreviousElement(nodeData);
        }
    }

    public void addChild(T dataParent, T data) {
        NodeChild<T> nodeChild = new NodeChild<>(data);
        if (root != null) {
            Node<T> nodeData = root;
            while (nodeData != null) {
                if (nodeData.getData().equals(dataParent)) {
                    if (nodeData.getChildElement() == null) {
                        nodeData.setChildElement(nodeChild);
                        nodeData.getChildElement().setChildPreviuos(nodeChild);
                    } else {
                        NodeChild<T> nodeDataChild = nodeData.getChildElement();
                        while (nodeDataChild.getChildNext() != null) {
                            nodeDataChild = nodeDataChild.getChildNext();
                        }
                        nodeDataChild.setChildNext(nodeChild);
                        nodeChild.setChildPreviuos(nodeDataChild);
                    }
                    break;
                }
                nodeData = nodeData.getNextElement();
            }
        }
    }

    public void delete(T data) {
        if (root != null) {
            Node<T> nodeData = root;
            Node<T> previous = null;
            while (nodeData != null) {
                if (nodeData.getData().equals(data)) {
                    if (previous == null) {
                        root = root.getNextElement();
                        nodeData.setNextElement(null);
                        nodeData = root;
                    } else {
                        previous.setNextElement(nodeData.getNextElement());
                        nodeData.setNextElement(null);
                        nodeData = previous.getNextElement();
                    }
                } else {
                    previous = nodeData;
                    nodeData = nodeData.getNextElement();
                }
            }
        }
    }

    public T search(T data) {
        T result = null;
        if (root != null) {
            Node<T> nodoData = root;
            while (nodoData != null) {
                if (nodoData.getData().equals(data)) {
                    result = nodoData.getData();
                    break;
                } else {
                    nodoData = nodoData.getNextElement();
                }
            }
        }
        return result;
    }

    public T searchChild(T parentData, T data) {
        T result = null;
        if (root != null) {
            Node<T> nodoData = root;
            while (nodoData != null) {
                if (nodoData.getData().equals(parentData)) {
                    if (nodoData.getChildElement() != null) {
                        NodeChild<T> nodeChild = nodoData.getChildElement();
                        while (nodeChild != null) {
                            if (nodeChild.getData().equals(data)) {
                                result = nodeChild.getData();
                                break;
                            } else {
                                nodeChild = nodeChild.getChildNext();
                            }
                        }
                    }
                    break;
                } else {
                    nodoData = nodoData.getNextElement();
                }
            }
        }
        return result;
    }

    public T nextData(T data) {
        T result = null;
        if (root != null) {
            Node<T> nodoData = root;
            while (nodoData != null) {
                if (nodoData.getData().equals(data)) {
                    result = nodoData.getNextElement().getData();
                    break;
                } else {
                    nodoData = nodoData.getNextElement();
                }
            }
        }
        return result;
    }

    public T nextChildData(T parentData, T data) {
        T result = null;
        if (root != null) {
            Node<T> nodoData = root;
            while (nodoData != null) {
                if (nodoData.getData().equals(parentData)) {
                    if (nodoData.getChildElement() != null) {
                        NodeChild<T> nodeChild = nodoData.getChildElement();
                        while (nodeChild != null) {
                            if (nodeChild.getData().equals(data)) {
                                result = nodeChild.getChildNext().getData();
                                break;
                            } else {
                                nodeChild = nodeChild.getChildNext();
                            }
                        }
                    }
                    break;
                } else {
                    nodoData = nodoData.getNextElement();
                }
            }
        }
        return result;
    }

    public T previousData(T data) {
        T result = null;
        if (root != null) {
            Node<T> nodoData = root;
            while (nodoData != null) {
                if (nodoData.getData().equals(data)) {
                    result = nodoData.getPreviousElement().getData();
                    break;
                } else {
                    nodoData = nodoData.getNextElement();
                }
            }
        }
        return result;
    }

    public T previousChildData(T parentData, T data) {
        T result = null;
        if (root != null) {
            Node<T> nodoData = root;
            while (nodoData != null) {
                if (nodoData.getData().equals(parentData)) {
                    if (nodoData.getChildElement() != null) {
                        NodeChild<T> nodeChild = nodoData.getChildElement();
                        while (nodeChild != null) {
                            if (nodeChild.getData().equals(data)) {
                                result = nodeChild.getChildPreviuos().getData();
                                break;
                            } else {
                                nodeChild = nodeChild.getChildNext();
                            }
                        }
                    }
                    break;
                } else {
                    nodoData = nodoData.getNextElement();
                }
            }
        }
        return result;
    }
}
