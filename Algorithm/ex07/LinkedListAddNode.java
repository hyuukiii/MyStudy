package dingcorithm.ex07;
// 노드는 두 가지 정보가 필요 하다.
// 1. 칸에 있는 데이터
// 2. 다음 칸이 무엇인지

// Q2. 링크드 리스트에서 index번째 원소를 추가하시오.
// addNode 메서드 안의 내용을 채워 넣으시오
class LinkedListAddNode {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    // 리스트 연결할 떄 노드를 추가 해주는 메서드
    public void LinkedListAppend(int value){
        this.head = new Node(value);
    }


    // LinkedList의 가장 끝에 있는 노드에 새로운 노드를 연결 시켜주는 메서드
    public void Append(int value) {
        Node cur = this.head;

        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new Node(value);
    }

    // 현재 Linked_list 헤더에 저장된 노드들을 전부 출력 해주는 메서드
    public void PrintAll(){
        Node cur = this.head;

        while (cur != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }
    }

    // index번쨰에 Node를 추가하는 메서드
    public void addNode(int index, int value) {
        Node newNode = new Node(value);

        // 첫 노드에 삽입 시
        if( index == 0) {
            newNode.next = this.head;
            this.head = newNode;

        // 중간 노드에 삽입 시
        } else {
            Node prev = this.head;
            for (int i = 0; i < index -1; i++) {
                prev = prev.next;
            }

            newNode.next = prev.next;
            prev.next = newNode;
        }
    }


    public static void main(String[] args) {
        LinkedListAddNode linkedList = new LinkedListAddNode();
        linkedList.LinkedListAppend(5);
        linkedList.Append(12);
        linkedList.Append(15);
        linkedList.addNode(2,17);

        linkedList.PrintAll();
    }
}
