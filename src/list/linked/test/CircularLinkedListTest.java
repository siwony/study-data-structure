package list.linked.test;

import list.linked.circular.CircularLinkedList;
import list.linked.circular.CircularLinkedListImpl;

public class CircularLinkedListTest {

    public static void main(String[] args) {
        CircularLinkedList circularLinkedList = new CircularLinkedListImpl(1);

        circularLinkedList.addAtHead(2);
        circularLinkedList.printAll();

        circularLinkedList.addFirst(89);
        circularLinkedList.addFirst(3);
        circularLinkedList.addAtHead(circularLinkedList.findNodeByNodeData(89).getData());

        circularLinkedList.addAtSpecificNode(circularLinkedList.findNodeByNodeData(89), 83);
        circularLinkedList.addAtSpecificNode(circularLinkedList.findNodeByNodeData(3), 190);
        circularLinkedList.printAll();

        circularLinkedList.deleteAtSpecificNode(circularLinkedList.findNodeByNodeData(190));
        circularLinkedList.printAll();

        circularLinkedList.deleteAtFirstNode();
        circularLinkedList.printAll();

        circularLinkedList.deleteAtHead();
        circularLinkedList.printAll();
    }
}
