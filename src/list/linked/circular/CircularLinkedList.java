package list.linked.circular;

public interface CircularLinkedList {

    void printAll();

    /**
     * 데이터를 통해 node를 찾는 매서드
     * @param data 찾을 node의 데이터
     * @return 해당 데이터에 대한 node
     * @throws RuntimeException 해당 데이터로 노드를 찾지 않았을 때
     */
    Node findNodeByNodeData(int data);

    /**
     * Head앞에 node를 추가한다.<br><br>
     * 삽입 순서
     * <ol>
     *     <li>newNode의 next를 head로 저장한다.</li>
     *     <li>head의 next를 newNode로 저장한다.</li>
     * </ol>
     * @param data 현재 Head앞에 추가할 node의 데이터 &rarr; 리스트의 첫 번째 node의 데이터
     * @return 추가한 노드
     */
    Node addFirst(int data);

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
    Node addAtHead(int data);

    /**
     * 특정 노드 앞에 특정 node를 추가한다.
     * @param node 특정 노드
     * @param data 특정 노드 앞에 추가할 노드의 데이터
     * @return 추가한 노드
     */
    Node addAtSpecificNode(Node node, int data);

    /**
     * 리스트의 헤드를 삭제한다.
     * 삭제되기 전 헤드의 다음 노드가 해당 리스트의 헤드가 된다. <br><br>
     */
    void deleteAtFirstNode();

    /**
     * 리스트의 마지막 노드(head)를 삭제한다.
     */
    void deleteAtHead();

    /**
     * 해당 리스트의 특정 node를 삭제한다.
     * @param node
     */
    void deleteAtSpecificNode(Node node);

    /**
     * 해당 리스트를 삭제한다. (비워 버린다.)
     */
    void deleteThisList();
}
