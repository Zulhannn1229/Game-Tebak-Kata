//DoubleLinkedList.java
class DoubleLinkedList {
    private Node head;
    private Node tail;

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void signUp(String username, String password) {
        Node newNode = new Node(username, password);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println("Pendaftaran berhasil untuk username: " + username);
    }

    public boolean login(String username, String password) {
        Node current = head;
        while (current != null) {
            if (current.username.equals(username) && current.password.equals(password)) {
                System.out.println("Login berhasil. Selamat datang, " + username + "!");
                return true;
            }
            current = current.next;
        }
        System.out.println("Username atau password salah.");
        return false;
    }

    public void searchUser(String username) {
        Node current = head;
        while (current != null) {
            if (current.username.equals(username)) {
                System.out.println("User ditemukan: " + username);
                return;
            }
            current = current.next;
        }
        System.out.println("User dengan username " + username + " tidak ditemukan.");
    }

    public void showLeaderboard() {
        Node current = head;
        while (current != null) {
            System.out.println("Username: " + current.username + ", Score: " + current.score);
            current = current.next;
        }
    }
}
