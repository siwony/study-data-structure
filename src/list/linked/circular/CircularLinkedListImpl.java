package list.linked.circular;

public class CircularLinkedListImpl implements CircularLinkedList{

    Node head;

    public CircularLinkedListImpl(int data){
        this.head = new Node(data);
    }

    @Override
    public void printAll() {
        if(head == null)
            System.err.print("해당 원형 연결 리스트는 비었습니다.");
        else if (head.getNextNode() == null)
            printNode(this.head);
        else{
            Node node = head.getNextNode(); // 원형 연결 리스트는 헤더가 마지막 노드 이므로 head다음 노드가 첫번째 노드이다.
            while(node != head){
                printNode(node);
                node = node.getNextNode();
            }
            printNode(node); // 마지막 노드(Head)를 출력한다.
        }
        System.out.println(); // 탐색이 끝나면 줄바꿈
    }

    private void printNode(Node node){
        System.out.print(
                "|   " + node.getData() + "   |"
        );
    }
    /**
     * 데이터를 통해 node를 찾는 매서드
     * @param data 찾을 node의 데이터
     * @return 해당 데이터에 대한 node
     * @throws RuntimeException 해당 데이터로 노드를 찾지 않았을 때
     */
    @Override
    public Node findNodeByNodeData(int data) {
        if (this.head.getNextNode() == null && head.getData() != data){
            System.err.println("검색 결과가 없습니다.");
            return null;
        }
        else if (head.getData() == data)
            return head;
        else {
            for (Node n = head.getNextNode(); n != head; n = n.getNextNode()) {
                if (n.getData() == data) return n;
            }
            System.err.println("검색 결과가 없습니다.");
            return null; // 검색 결과가 없다.
        }

    }

    /**
     * 해당 리스트의 첫 번째에 node를 추가한다. 즉, 해당 node는 원형 연결리스트의 맨 첫 번째 원소가 된다.<br><br>
     * 삽입 순서
     * <ol>
     *     <li>newNode의 next를 head로 저장한다.</li>
     *     <li>head의 next를 newNode로 저장한다.</li>
     * </ol>
     * @param data 현재 Head앞에 추가할 node의 데이터 &rarr; 리스트의 첫 번째 node의 데이터
     * @return 추가한 노드
     */
    @Override
    public Node addFirst(int data) {
        if(head == null) return head = new Node(data);

        Node newNode = new Node(data);
        Node nextHeadNode = this.head.getNextNode();
        if(nextHeadNode == null)  // head의 링크가 비어있다면 리스트의 원소가 1개밖에 없다.
            newNode.updateNext(this.head);
        else
            newNode.updateNext(nextHeadNode);

        this.head.updateNext(newNode); // head는 추가된 노드를 가르킨다.

        return newNode;
    }

    /**
     * 연결리스트의 맨 끝에 node를 추가한다. <br>
     * 즉 원형 연결리스트는 head가 맨 끝노드를 위치하고 있으므로 새로 추가할 node가 head가 된다. <br><br>
     *
     *  <ol>
     *      <li>새로 추가한 newNode는 해당 리스트의 첫 번째 node를 가르킨다.</li>
     *      <li>현재 head는 newNode를 가르킨다.</li>
     *      <li>해당 리스트의 head를 newNode로 변경한다.</li>
     *  </ol>
     *
     * @param data 현재 리스트의 맨 끝에 추가할 Node의 데이터
     * @return 추가한 노드
     */
    @Override
    public Node addAtHead(int data) {
        if(head == null) return head = new Node(data);

        Node firstNode = this.head.getNextNode();

        Node newNode = new Node(data);
        if(firstNode != null)
             newNode.updateNext(firstNode);
        else
            newNode.updateNext(head);

        this.head.updateNext(newNode);
        this.head = newNode;

        return newNode;
    }

    /**
     * 특정 노드 앞에 특정 node를 추가한다.
     * @param node 특정 노드
     * @param data 특정 노드 앞에 추가할 노드의 데이터
     * @return 추가한 노드
     */
    @Override
    public Node addAtSpecificNode(Node node, int data) {
        if(this.head == node) return addAtHead(data);//해당 node가 head일 경우 head앞에 추가한다. 즉, 추가하려는 node는 head가 된다.

        Node newNode = new Node(data, node);
        getPrevNode(node).updateNext(newNode);

        return newNode;
    }

    /**
     * 리스트의 헤드를 삭제한다.
     * 삭제되기 전 헤드의 다음 노드가 해당 리스트의 헤드가 된다. <br><br>
     */
    @Override
    public void deleteAtFirstNode() {
        if(this.head == null) {
            System.out.print("해당 원형 연결 리스트는 비었습니다.");
            return;
        }

        Node firstNode = this.head.getNextNode();
        if(firstNode == null)
            deleteThisList();
        else
            this.head.updateNext(firstNode.getNextNode());

    }

    /**
     * 리스트의 마지막 노드(head)를 삭제한다.
     */
    @Override
    public void deleteAtHead() {
        if(this.head == null) {
            System.err.print("해당 원형 연결 리스트는 비었습니다.");
        }else if(this.head.getNextNode() == null){
            this.head = null;
        }else{
            Node firstNode = this.head.getNextNode();
            Node headFrontOfNode = getPrevNode(this.head);
            if(headFrontOfNode != null)
                headFrontOfNode.updateNext(firstNode);

            this.head = headFrontOfNode;
        }
    }

    /**
     * 리스트의 마지막 노드를 삭제한다.
     */
    private Node getPrevNode(Node node){
        Node headFrontOfNode = null;
        for(Node n = node.getNextNode(); n != node; n = n.getNextNode())
            headFrontOfNode = n;

        return headFrontOfNode;
    }

    /**
     * 해당 리스트의 특정 node를 삭제한다.
     * @param node
     */
    @Override
    public void deleteAtSpecificNode(Node node) {
        if(node == head) {
            deleteAtHead();
            return;
        }
        getPrevNode(node).updateNext(node.getNextNode());
    }

    /**
     * 해당 리스트를 삭제한다. (비워 버린다.)
     */
    @Override
    public void deleteThisList() {
        this.head = null;
    }
}
