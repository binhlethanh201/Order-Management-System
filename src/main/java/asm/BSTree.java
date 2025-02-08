package asm;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class BSTree<E extends Comparable<E>> {
    public Node<E> root;
    boolean isEmpty() {return root == null;}
    void clear() {root = null;}
    int height(Node N) {
        if (N == null) {
            return 0;
        }
        return N.height;
    }
    int max(int a, int b) {
        return (a > b) ? a : b;
    }
    Node<E> rightRotate(Node<E> y) {
        Node<E> x = y.left;
        Node<E> T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;
        return x;
    } 
    Node<E> leftRotate(Node x) {
        Node<E> y = x.right;
        Node<E> T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;
        return y;
    }
    int getBalance(Node N) {
        if (N == null) {
            return 0;
        }
        return height(N.left) - height(N.right);
    }
    Node<E> insert(Node<E> node, E key) {
        if (node == null) 
            return (new Node(key)); 
        if (key.compareTo(node.info) < 0) 
            node.left = insert(node.left, key); 
        else if (key.compareTo(node.info) > 0) 
            node.right = insert(node.right, key); 
        else 
            return node; 
        node.height = 1 + max(height(node.left), 
                              height(node.right)); 
        int balance = getBalance(node); 
        if (balance > 1 && key.compareTo(node.left.info) < 0) 
            return rightRotate(node); 
        if (balance < -1 && key.compareTo(node.right.info) > 0) 
            return leftRotate(node);  
        if (balance > 1 && key.compareTo(node.left.info) > 0) { 
            node.left = leftRotate(node.left); 
            return rightRotate(node); 
        } 
        if (balance < -1 && key.compareTo(node.right.info) < 0) { 
            node.right = rightRotate(node.right); 
            return leftRotate(node); 
        } 
        return node; 
    }
    public void insertTo(E x) {
        this.root = insert(this.root, x);
    }
    Node<E> minValueNode(Node<E> node) {
        Node<E> current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
    Node<E> deleteNode(Node<E> root, E key) {
         if (root == null)  
            return root;   
        if (key.compareTo(root.info) < 0)  
            root.left = deleteNode(root.left, key);   
        else if (key.compareTo(root.info) > 0)  
            root.right = deleteNode(root.right, key);  
        else
        {  
            if ((root.left == null) || (root.right == null))  
            {  
                Node<E> temp = null;  
                if (temp == root.left)  
                    temp = root.right;  
                else
                    temp = root.left;   
                if (temp == null)  
                {  
                    temp = root;  
                    root = null;  
                }  else 
                    root = temp; 
            } else {  
                  Node<E> temp = minValueNode(root.right);  
                root.info = temp.info;  
                root.right = deleteNode(root.right, temp.info);  
            }  
        }  
        if (root == null)  
            return root;  
        root.height = max(height(root.left), height(root.right)) + 1;  
        int balance = getBalance(root);  
        if (balance > 1 && getBalance(root.left) >= 0)  
            return rightRotate(root);  
        if (balance > 1 && getBalance(root.left) < 0)  
        {  
            root.left = leftRotate(root.left);  
            return rightRotate(root);  
        }   
        if (balance < -1 && getBalance(root.right) <= 0)  
            return leftRotate(root);   
        if (balance < -1 && getBalance(root.right) > 0)  
        {  
            root.right = rightRotate(root.right);  
            return leftRotate(root);  
        }  
  
        return root;  
    }
    
    public void delete(E key){
        this.root = deleteNode(this.root, key);
    }
    
    public void visit(Node<E> p){
        System.out.print(p.info);
    }

    public void preOrder(Node<E> p) {
        if (p == null) {
            return;
        }
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }
    public void inOrder(Node<E> p) {
        if (p == null) {
            return;
        }
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }

        public void inOrderTraversal(Node node, BufferedWriter writer) throws IOException {
                Node<Customer> current = null ;
        if (node != null) {
            inOrderTraversal(node.left, writer);
            writer.write(current.getInfo().getCcode() + "| " + current.getInfo().getCus_name()  + "| " + current.getInfo().getPhone() +"\n");
            writer.newLine();
            inOrderTraversal(node.right, writer);
        }
    }
    public void visitTravese(Node<E> p, FileWriter fw){
        System.out.print(p.info );
    }
    public void traveseToFile(Node <E> p, FileWriter fw){
        if (p == null) return;
        traveseToFile(p.left, fw);
        visitTravese(p, fw);
        traveseToFile(p.right, fw);
        
    }
    public void postOrder(Node<E> p) {
        if (p == null) {
            return;
        }
        inOrder(p.left);
        inOrder(p.right);
        visit(p);
    }
    public void breadthTravel() {
        int h = height(root);
        for (int i = 1; i <= h; i++) {
            printLevel(root, i);
        }
    }
    void printLevel(Node<E> root, int level) {
        if (root == null) {
            return;
        }
        if (level == 1) {
            System.out.print(root.info);
        } else if (level > 1) {
            printLevel(root.left, level - 1);
            printLevel(root.right, level - 1);
        }
    }
    public int countNode() {
        if (root == null) {
            return 0;
        } else {
            return getSize(root);
        }
    }

    int getSize(Node<E> p) {
        int count = 1;
        if (p.left != null) {
            count += getSize(p.left);
        }
        if (p.right != null) {
            count += getSize(p.right);
        }
        return count;
    }
    public Node search(Node<E> p, E x) {
        if (p == null) {
            return (null);
        }
        if (p.info.compareTo(x) == 0) {
            return p;
        } else if (p.info.compareTo(x) < 0) {
            return search(p.right, x);
        } else {
            return search(p.left, x);
        }
    }


   
}
