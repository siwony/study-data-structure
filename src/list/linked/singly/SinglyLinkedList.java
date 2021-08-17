package list.linked.singly;

public interface SinglyLinkedList {

    void printAll();

    Node findNodeByNodeData(int data);

    Node addAtHead(int data);

    Node addAtTail(int data);

    Node addAtSpecificNode(Node node, int data);

    void deleteAtHead();

    void deleteAtTail();

    void deleteAtSpecificNode(Node node);

    void deleteThisList();
}
