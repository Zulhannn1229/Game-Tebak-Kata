//Queue.java
class Queue {
    private Node front;
    private Node rear;

    public Queue() {
        this.front = null;
        this.rear = null;
    }

    public void enqueue(String word, String hint) {
        Node newNode = new Node(word, hint);
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public Node dequeue() {
        if (front == null) {
            System.out.println("Queue kosong.");
            return null;
        }
        Node temp = front;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return temp;
    }
}
