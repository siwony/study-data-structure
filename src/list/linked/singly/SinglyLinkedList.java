package list.linked.singly;

public interface SinglyLinkedList {

    void printAll();

    void addAtHead(int data);

    void addAtTail(int data);

    void addAtSpecificNode(Node node, int data);

    void deleteAtHead();

    void deleteAtTail();

    void deleteAtSpecificNode(Node node, int data);

    void deleteThisList();
}
