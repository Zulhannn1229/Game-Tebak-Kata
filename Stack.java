class Stack {
    private class Node{
        String petunjuk;
        Node next;

        public Node(String petunjuk){
            this.petunjuk = petunjuk;
            this.next = null;
        }
    }
    private Node top;
    private int size;
    private int maxSize;
    public Stack(int maxSize){
        this.top = null;
        this.size = 0;
        this.maxSize = maxSize;
    }
    public void push(String petunjuk){
        if(size == maxSize){
            System.out.println("Tidak dapat menambahkan petunjuk terbaru.");
        }else{
            Node newNode = new Node(petunjuk);
            newNode.next = top;
            top = newNode;
            size++;
        }
    }
    public String pop(){
        if (top == null){
            System.out.println("Tidak ada petunjuk yang tersedia");
            return null;
        }else{
            String petunjuk = top.petunjuk;
            top = top.next;
            size--;
            return petunjuk;
        }
    }
}
