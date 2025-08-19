package dingcorithm.ex07;

class LinkedListDeleteNode {

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
    public void linkedListAppend(int value){
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
    public void printAll(){
        Node cur = this.head;

        while (cur != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }
    }

    public Node getNode(int index) {
        // 새로운 node값 cur(현재 값)변수를 현재 헤드로 지정 한다.
        Node cur = this.head;

        // i는 0번째 인덱스 부터 시작해서 index 값 만큼 반복 한다.
        for (int i = 0; i < index; i++) {
            //범위 초과 체크
            if (cur == null) {
                return null;
            }
            cur = cur.next;
        }
        return cur;
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

        public void deleteNode(int index) {
            if (index == 0) {
                /*
                head
                 [7] --> [6] --> [12] --> [8]

                        head
                 [7] --> [6] --> [12] --> [8]
                 */
                this.head = this.head.next;
            }
            // 예시: [7] → [5] → [6] → [12] → [8]에서 index 2 (노드 [6]) 삭제
            // 1. 이전 노드 찾기
            Node prev = this.getNode(index -1); // node[5]
            // 2. 삭제할 노드 찾기
            Node delNode = getNode(index); // node[6]
            // 3. 연결 바꾸기
            prev.next = delNode.next;
            // node[5] - next:100 , node[6] - next: 200
            // node[5] - next:200 , node[6] - next: 100
            // 5 --> 12 --> 8
        }

    public static void main(String[] args) {
        LinkedListDeleteNode linkedList = new LinkedListDeleteNode();
        linkedList.linkedListAppend(12);
        linkedList.append(8);
        linkedList.printAll();

        System.out.println("==============");

        // [7] --> [6] --> [12] --> [8]
        linkedList.addNode(0, 7);
        linkedList.addNode(1, 6);
        //        head
        // [7] --> [6] --> [12] --> [8]
        linkedList.deleteNode(1);
        linkedList.printAll();

        System.out.println("==============");

        // head
        //      head
        // [7]->[6]->[12]->[8]
        linkedList.deleteNode(0);
        // [6]->[12]->[8]
        linkedList.printAll();
    }
}
