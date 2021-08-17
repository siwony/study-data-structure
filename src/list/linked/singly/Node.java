package list.linked.singly;

class Node {

    private int data;
    private Node next = null;

    public Node(int data, Node next){
        this.data = data;
        this.next = next;
    }

    public void updateNode(int data, Node next){
        this.data = data;
        this.next = next;
    }

    public Node getNextNode(){
        return this.next;
    }

    public int getData(){
        return data;
    }
}
