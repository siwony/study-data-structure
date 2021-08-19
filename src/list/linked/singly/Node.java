package list.linked.singly;

public class Node {

    private int data;
    private Node link = null;

    public Node(int data, Node link){
        this.data = data;
        this.link = link;
    }

    public Node(int data){
        this(data, null);
    }

    public Node getNextNode(){
        return this.link;
    }

    public int getData(){
        return data;
    }

    public Node updateLink(Node link){
        this.link = link;

        return link;
    }
}
