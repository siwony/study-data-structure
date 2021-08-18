package list.linked.circular;

public class Node {
    private int data;
    private Node next;

    public Node(int data, Node next){
        this.data = data;
        this.next = next;
    }

    public Node(int data){
        this(data, null);
    }

    public Node getNextNode(){
        return this.next;
    }

    public int getData(){
        return data;
    }

    public Node updateNext(Node next){
        if(next != null){
            this.next = next;
            return next;
        }
        else
            throw new RuntimeException("원형 연결 리스트의 next에 null이 허용되지 않습니다.");
    }
}
