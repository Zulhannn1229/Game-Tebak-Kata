// File: Node.java
public class Node {
    String username;
    String password;
    int key;
    String word;
    String hint;
    int score;
    Node left, right; 
    Node next, prev; 

    public Node(String username, String password) {
        this.username = username;
        this.password = password;
        this.next = null;
        this.prev = null;
    }

    public Node(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }

    public Node(int key, Node next, Node prev) {
        this.key = key;
        this.next = next;
        this.prev = prev;
    }

    public Node(String word, String hint) {
        this.word = word;
        this.hint = hint;
        this.next = null;
        this.prev = null;
    }

    public Node(String username, int score) {
        this.username = username;
        this.score = score;
        this.next = null;
        this.prev = null;
    }
}
