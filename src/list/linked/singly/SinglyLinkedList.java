package list.linked.singly;

public interface SinglyLinkedList {

    void printAll();

    /**
     * 데이터를 통해 node를 찾는 매서드
     * @param data 찾을 node의 데이터
     * @return 해당 데이터에 대한 node
     * @throws RuntimeException 해당 데이터로 노드를 찾이 않았을 때
     */
    Node findNodeByNodeData(int data);

    /**
     * Head앞에 node를 추가한다.
     * 즉 현재 추가할 node가 Head가 되고 기존 Head는 추가할 노드의 다음 노드가 된다.
     * @param data 현재 Head앞에 추가할 Node의 데이터
     * @return 추가한 노드
     */
    Node addAtHead(int data);

    /**
     * 연결리스트의 맨 끝에 node를 추가한다.
     * @param data 현재 리스트의 맨 끝에 추가할 Node의 데이터
     * @return 추가한 노드
     */
    Node addAtTail(int data);

    /**
     * 특정 노드 앞에 특정 node를 추가한다.
     * @param node 특정 노드
     * @param data 특정 노드 앞에 추가할 노드의 데이터
     * @return 추가한 노드
     */
    Node addAtSpecificNode(Node node, int data);

    /**
     * 리스트의 헤드를 삭제한다.
     * 삭제되기 전 헤드의 다음 노드가 해당 리스트의 헤드가 된다.
     */
    void deleteAtHead();

    /**
     * 리스트의 마지막 노드를 삭제한다.
     */
    void deleteAtTail();

    /**
     * 해당 노드의 특정 node를 삭제한다.
     * @param node
     */
    void deleteAtSpecificNode(Node node);

    /**
     * 해당 리스트를 삭제한다. (비워 버린다.)
     */
    void deleteThisList();
}
