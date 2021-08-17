package list.linked.singly;

public class SinglyLinkedListImpl implements SinglyLinkedList{

    private Node head;

    public SinglyLinkedListImpl(int data){
        this.head = new Node(1, null);
    }

    public void addAtHead(int data){
        this.head = new Node(data, this.head);
    }

    public void printAll(){
        Node headNode = head;
        for(; headNode != null; headNode = headNode.getNextNode()){
            printNode(headNode);
        }
    }

    private void printNode(Node node){
        System.out.print(
                "|   " + node.getData() + "   |"
        );
    }

}
