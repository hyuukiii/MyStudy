package dingcorithm.ex07;

// 노드는 두 가지 정보가 필요 하다.
// 1. 칸에 있는 데이터
// 2. 다음 칸이 무엇인지

class LinkedListAppend {

    static class Node {
        int data; // 노드 안의 값
        Node next; // 다음 칸이 어떤 칸을 향할지


        public Node(int data) {
            // 각 노드마다 저장할 값이 다르기 때문에 외부에서 받아온다
            this.data = data;
            // 값이 어디로 향할지 모르기 때문에 null로 지정한다
            this.next = null;
        }
    } // node 정적 클래스

    // 링크드 리스트의 '시작점'을 기억하는 변수
    Node head;

    // 링크드 리스트를 만들 떄 첫번째 노드를 생성
    public LinkedListAppend(int value) {
        this.head = new Node(value);
    }

    // LinkedList의 가장 끝에 있는 노드에 새로운 노드를 연결 시켜주는 메서드
    public void append(int value) {
       Node cur = this.head;

       while (cur.next != null) {
            cur = cur.next;
       }
       cur.next = new Node(value);

    }

    // 현재 Linked_list 헤더에 저장된 노드들을 전부 출력 해주는 메서드
    public void printAll() {
        Node cur = this.head;

        while (cur != null) {
            System.out.print(cur.data+", ");
            cur = cur.next;
        }
    }
}

class AppendLinkedList {
    public static void main(String[] args) {

        // 각 객체 안의 노드1
        LinkedListAppend.Node node = new LinkedListAppend.Node(5);
        System.out.print(node.data + ", " + node.next + "\n");

        // 각 객체 안의 노드2
        LinkedListAppend.Node nextNode =  new LinkedListAppend.Node(3);
        System.out.print(nextNode.data+", "+nextNode.next+",");

        // 연결된 노드 체인들
        LinkedListAppend linkedList = new LinkedListAppend(5);
        linkedList.append(8);
        linkedList.append(12);
        linkedList.printAll();

        // linkedList.append(8);
        // linkedList.printAll();
    }
}
