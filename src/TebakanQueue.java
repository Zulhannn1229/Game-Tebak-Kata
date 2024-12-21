// TebakanQueue.java
class TebakanQueue {
    private class QueueNode {
        Tebakan.DataTebakan tebakan;
        QueueNode next;

        QueueNode(Tebakan.DataTebakan tebakan) {
            this.tebakan = tebakan;
        }
    }

    private QueueNode front;
    private QueueNode rear;
    private int size;
    private static final int MAX_SIZE = 10;

    public void enqueue(Tebakan.DataTebakan tebakan) {
        if (size >= MAX_SIZE) {
            dequeue(); // Hapus tebakan paling depan jika penuh
        }

        QueueNode newNode = new QueueNode(tebakan);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public Tebakan.DataTebakan dequeue() {
        if (isEmpty()) {
            return null;
        }
        Tebakan.DataTebakan tebakan = front.tebakan;
        front = front.next;
        size--;

        if (isEmpty()) {
            rear = null;
        }
        return tebakan;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }
}
