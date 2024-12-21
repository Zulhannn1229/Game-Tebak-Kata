// DLL.java
class DLL {
    private class Node {
        User user;
        Node next;
        Node prev;

        public Node(User user) {
            this.user = user;
        }
    }

    private Node head;

    public void signUp(String username, String password) {
        if (search(username) != null) {
            System.out.println("Username sudah digunakan");
            return;
        }
        Node newNode = new Node(new User(username, password));
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
        System.out.println("Pendaftaran berhasil");
    }

    public User login(String username, String password) {
        Node userNode = search(username);
        if (userNode != null && userNode.user.password.equals(password)) {
            System.out.println("Login berhasil");
            return userNode.user;
        }
        System.out.println("Username atau password salah");
        return null;
    }

    private Node search(String username) {
        Node temp = head;
        while (temp != null) {
            if (temp.user.username.equals(username)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void searchUser(String username) {
        Node result = search(username);
        if (result != null) {
            System.out.println("User ditemukan: " + result.user.username);
        } else {
            System.out.println("User tidak ditemukan");
        }
    }

    public void showLeaderboard() {
        Node[] users = toArray();
        sort(users);
        for (int i = 0; i < users.length; i++) {
            System.out.println((i + 1) + ". " + users[i].user.username + " - " + users[i].user.score);
        }
    }

    private Node[] toArray() {
        int size = 0;
        Node temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        Node[] array = new Node[size];
        temp = head;
        for (int i = 0; i < size; i++) {
            array[i] = temp;
            temp = temp.next;
        }
        return array;
    }

    // Bubble Sort
    // private void sort(Node[] nodes) {
    //     for (int i = 0; i < nodes.length - 1; i++) {
    //         for (int j = 0; j < nodes.length - i - 1; j++) {
    //             if (nodes[j].user.score < nodes[j + 1].user.score) {
    //                 Node temp = nodes[j];
    //                 nodes[j] = nodes[j + 1];
    //                 nodes[j + 1] = temp;
    //             }
    //         }
    //     }
    // }

    // Selection Sort
    private void sort(Node[] nodes) {
        // Implementasi Selection Sort
        for (int i = 0; i < nodes.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < nodes.length; j++) {
                if (nodes[j].user.score > nodes[maxIndex].user.score) {
                    maxIndex = j;
                }
            }
            // Swap
            Node temp = nodes[maxIndex];
            nodes[maxIndex] = nodes[i];
            nodes[i] = temp;
        }
    }
}
