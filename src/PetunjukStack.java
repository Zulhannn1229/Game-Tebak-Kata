//Stack.java
class PetunjukStack {
    private class StackNode {
        String petunjuk;
        StackNode next;

        StackNode(String petunjuk) {
            this.petunjuk = petunjuk;
        }
    }

    private StackNode top;
    private int size;
    private static final int MAX_SIZE = 5;

    public void push(String petunjuk) {
        if (size >= MAX_SIZE) {
            pop();
        }

        StackNode newNode = new StackNode(petunjuk);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public String pop() {
        if (isEmpty()) {
            return null;
        }
        String petunjuk = top.petunjuk;
        top = top.next;
        size--;
        return petunjuk;
    }

    public String peek() {
        return isEmpty() ? null : top.petunjuk;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }
}
