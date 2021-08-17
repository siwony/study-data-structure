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
        return findTail().updateNext(new Node(data));
    }

    @Override
    public Node addAtSpecificNode(Node node, int data) {
        Node newNode = new Node(data, node.getNextNode());
        node.updateNext(newNode);

        return newNode;
    }

    @Override
    public void deleteAtHead() {
        this.head = head.getNextNode();
    }

    @Override
    public void deleteAtTail() {
        Node node = head;
        // 마지막 노드의 전 노드를 찾아야 되므로 현재 탐색한 노드를 기준으로 다음다음 node를 찾아 null이면 해당 노드에서 next를 null로 만든다.
        while(node.getNextNode().getNextNode() !=null)
            node = node.getNextNode();

        node.updateNext(null);
    }

    @Override
    public void deleteAtSpecificNode(Node node) {
        Node deleteAfterNode = head;
        while(deleteAfterNode.getNextNode() != node){
            deleteAfterNode = deleteAfterNode.getNextNode();
        }

        deleteAfterNode.updateNext(node.getNextNode());
    }

    @Override
    public void deleteThisList() {
        this.head = null;
    }

    @Override
    public void printAll(){
        Node findNode = head;
        int count = 0;
        for(; findNode != null; findNode = findNode.getNextNode()){
            count++;
            printNode(findNode);
        }
        if(count == 0)
            System.out.println("해당 리스트는 비었습니다.");
        System.out.println();
    }

    @Override
    public Node findNodeByNodeData(int data) {
        for(Node node = head; node.getNextNode() != null; node = node.getNextNode()) {
            if (node.getData() == data)
                return node;
        }

        throw new RuntimeException("해당 데이터로 Node를 찾을 수 없습니다.");
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
