package dingcorithm.ex07;

// Q1. 링크드 리스트에서 index번째 원소를 반환하시오.
// getNode 메서드 안의 내용을 채워 넣으시오.

// Q2. 링크드 리스트에서 index번째 원소를 추가하시오.
// addNode 메서드 안의 내용을 채워 넣으시오


/* next변수를 Node 타입으로 지정하는 이유
 * 링크드 리스트는 노드 안의 값과 노드 다음을 가리키는 포인터가 필요하다.
 * 즉 포인터의 타입은 똑같이 Node 타입이여야 한다.

 * 기차로 비유를 해보자
 * 다음 기차칸도 똑같이 '기차칸'이여야 한다. 이게 만약 다른 종류의 칸이라면?
 * 기차칸 --> 택시칸 --> ? 말이 안된다.
 */
class LinkedListGetNode {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    public LinkedListGetNode(int value) {
        this.head = new Node(value);
    }


    public void append(int value) {
        Node cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new Node(value);
    }

    public void printAll() {
        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.data+", ");
            cur = cur.next;
        }
    }

/* 링크드 리스트

     * head  : 첫 번째 노드를 가리키는 포인터 (항상 고정)
     * index : 노드의 위치 번호 (0, 1, 2, 3...)
     * node  : 전체 구조체 (data + next 포함)
     * data  : 노드 안에 저장된 실제 값
     * next  : 다음 노드를 가리키는 포인터

    head (항상 첫 번째 노드를 가리킨다)
      ↓
     [3]  -->   [5] -->   [6] -->   [7] --> null
    node       node       node      node
    index[0]   index[1]   index[2] index[3]
    data=3     data=5     data=6    data=7
*/
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

    // index는 노드의 위치 , value는 노드 안의 값.
    // 1. 0번쨰 인덱스 즉 첫번째 노드에 값을 넣기 위해서는 head의 위치를 바꿔줘야한다.
    // 2. 중간 삽입 로직에서는 head를 절대 건드리면 안된다. head는 첫번째 노드만을 가르켜야 하기 떄문.


    // [5] --> [12]   ------   [3] --> [5] --> [12]
    public static void main(String[] args) {
        LinkedListGetNode linkedList = new LinkedListGetNode(5);
        linkedList.append(12);
        linkedList.printAll();


        Node result = linkedList.getNode(0); // -> 5를 들고 있는 노드를 반환해야 합니다!
        if (result != null) {
            System.out.println("Index 0의 노드 데이터: " + result.data + "\n");
        }
    }
}

/* 잘못된 코드
 * getNode의 매개변수는 int타입인 index로 지정 돼 있다.
 * break 문 떄문에 첫번 쨰 노드만 확인하고 종료 돼 버린다.(첫번쨰 노드의 값만 확인하면 되는 줄 알았다)
 * 실제로는 null을 반환 받고 있기 떄문에 실제 노드 값을 받지 못한다.
    Node cur = this.head;

    while (cur != null) {
        System.out.println(cur.data);
        break;
    }
     return null;
*/


/* 잘못된 코드2

   Node cur = this.head;

        for (int i = 0; i < index; i++) {
            if (index == 0) {
                index += value;
            }
        }
 */
