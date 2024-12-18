class NodeAkun {
    String username;
    String password;
    NodeAkun next;

    public NodeAkun(String username, String password){
        this.username = username;
        this.password = password;
        this.next = null;
    }
    public class LinkedListAkun{
        NodeAkun head;
        public void addAccount(String username, String password){
            NodeAkun newNode = new NodeAkun(username, password);
            if (head == null){
                head = newNode;
            }else{
                NodeAkun current = head;
                while (current.next != null){
                    current = current.next;
                }
                current.next = newNode;
            }
        }
        public NodeAkun searchAccount(String username){
            NodeAkun current = head;
            while (current != null){
                if(current.username.equals(username)){
                    return current;
                }
                current = current.next;
            }
            return null;
        }
    }
}
