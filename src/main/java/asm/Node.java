package asm;
public class Node<E> {
    E info;
    int height;
    public Node<E> left, right;
    Node(E x) {
        info = x;
        left = right = null;
        height = 1;
    }
    Node() { }
    public E getInfo() {
        return info;
    }
    @Override
    public String toString() {
        return "" + info;
    }
}