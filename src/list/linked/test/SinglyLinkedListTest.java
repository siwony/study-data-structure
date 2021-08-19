package list.linked.test;

import list.linked.singly.SinglyLinkedList;
import list.linked.singly.SinglyLinkedListImpl;

public class SinglyLinkedListTest {

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedListImpl(1);

        singlyLinkedList.deleteAtSpecificNode(singlyLinkedList.findNodeByNodeData(1));
        singlyLinkedList.printAll();

        singlyLinkedList.addAtHead(12);
        singlyLinkedList.addAtHead(10);
        singlyLinkedList.addAtSpecificNode(singlyLinkedList.addAtTail(98), 18);
        singlyLinkedList.printAll();

        singlyLinkedList.addAtTail(99);
        singlyLinkedList.printAll();

        singlyLinkedList.deleteAtHead();
        singlyLinkedList.printAll();

        singlyLinkedList.deleteAtTail();
        singlyLinkedList.printAll();

        singlyLinkedList.deleteThisList();
        singlyLinkedList.printAll();
    }
}
