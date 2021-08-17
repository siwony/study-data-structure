package list.linked.singly;

public class Node {

    private int data;
    private Node next = null;

    public Node(int data, Node next){
        this.data = data;
        this.next = next;
    }

    public Node(int data){
        this(data, null);
    }

    public Node getNextNode(){
        return this.next;
    }

    public int getData(){
        return data;
    }

    public Node updateNext(Node next){
        this.next = next;

        return next;
    }
}
