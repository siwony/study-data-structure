package list.linked.singly;

public class SinglyLinkedListImpl implements SinglyLinkedList{

    private Node head;

    public SinglyLinkedListImpl(int data){
        this.head = new Node(data, null);
    }

    @Override
    public Node addAtHead(int data){
        this.head = new Node(data, this.head);

        return this.head;
    }

    @Override
    public Node addAtTail(int data) {
        return findTail().updateLink(new Node(data));
    }

    @Override
    public Node addAtSpecificNode(Node node, int data) {
        Node newNode = new Node(data, node.getNextNode());
        node.updateLink(newNode);

        return newNode;
    }

    @Override
    public void deleteAtHead() {
        if(head.getNextNode() !=null)
            this.head = head.getNextNode();
        else
            deleteThisList();
    }

    @Override
    public void deleteAtTail() {
        Node node = head;
        // 마지막 노드의 전 노드를 찾아야 되므로 현재 탐색한 노드를 기준으로 다음다음 node를 찾아 null이면 해당 노드에서 next를 null로 만든다.
        while(node.getNextNode().getNextNode() !=null)
            node = node.getNextNode();

        node.updateLink(null);
    }

    @Override
    public void deleteAtSpecificNode(Node node) {
        if(node == head) {
            deleteAtHead();
        }else{
            Node deleteAfterNode = head;
            while(deleteAfterNode.getNextNode() != node){
                deleteAfterNode = deleteAfterNode.getNextNode();
            }
            deleteAfterNode.updateLink(node.getNextNode());
        }
    }

    @Override
    public void deleteThisList() {
        this.head = null;
    }

    @Override
    public void printAll(){
        if(head == null) System.out.println("해당 리스트는 비었습니다.");
        for(Node node = head; node != null; node = node.getNextNode())
            printNode(node);

        System.out.println();
    }

    @Override
    public Node findNodeByNodeData(int data) {
        if(this.head.getData() == data)
            return this.head;

        for(Node node = this.head; node.getNextNode() != null; node = node.getNextNode()) {
            if (node.getData() == data)
                return node;
        }

        System.out.println("해당 데이터로 Node를 찾을 수 없습니다.");
        return null;
    }

    private void printNode(Node node){
        System.out.print(
                "|   " + node.getData() + "   |"
        );
    }

    private Node findTail(){
        Node node = head;
        while( node.getNextNode() != null)
            node = node.getNextNode();

        return node;
    }



}
