package list.linked.singly;

public class SinglyLinkedListImpl implements SinglyLinkedList{

    private Node head;

    public SinglyLinkedListImpl(int data){
        this.head = new Node(1, null);
    }

    @Override
    public void addAtHead(int data){
        this.head = new Node(data, this.head);
    }

    @Override
    public void addAtTail(int data) {
        findTail().updateNext(new Node(data));
    }

    @Override
    public void addAtSpecificNode(Node node, int data) {
        //TODO 특정 노드를 기준으로 노드 추가하기
    }

    @Override
    public void deleteAtHead() {
        //TODO 헤드 노드 삭제하기
    }

    @Override
    public void deleteAtTail() {
        //TODO 꼬리 노드 삭제하기
    }

    @Override
    public void deleteAtSpecificNode(Node node, int data) {
        //TODO 특정 노드 삭제하기
    }

    @Override
    public void deleteThisList() {
        //TODO 이 List 삭제하기
    }

    @Override
    public void printAll(){
        Node findNode = head;
        for(; findNode != null; findNode = findNode.getNextNode()){
            printNode(findNode);
        }
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
