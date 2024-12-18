//Stack.java
class Stack {
    private class HintNode {
        String petunjuk;
        HintNode next;
        public HintNode(String petunjuk) {
            this.petunjuk = petunjuk;
            this.next = null;
        }
    }
    private HintNode top;
    public Stack(){
        top = null;
    }
    public void push(String petunjuk){
        HintNode newNode = new HintNode(petunjuk);
        if (top == null){
            top = newNode;
        }else{
            newNode.next = top;
            top = newNode;
        }
    }
    public String pop(){
        if (top == null){
            System.out.println("Tidak ada hint");
            return null;
        }else{
            String hint = top.petunjuk;
            top = top.next;
            return hint;
        }
    }
    public boolean isEmpty(){
        return top == null;
    }
}
