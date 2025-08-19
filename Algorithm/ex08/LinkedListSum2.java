package dingcorithm.ex08;
/*
    Q.  다음과 같은 두 링크드 리스트를 입력받았을 때, 합산한 값을 반환하시오.

    예를 들어 아래와 같은 링크드 리스트를 입력받았다면,
    각각 678, 354 이므로 두개의 총합
    678 + 354 = 1032 를 반환해야 한다.

    단, 각 노드의 데이터는 한자리 수 숫자만 들어갈 수 있다.
 */
class LinkedListSum2 {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class LinkedList {
        Node head;

        public LinkedList(int value) {
            this.head = new Node(value);
        }

        public void append(int value) {
            Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node(value);
        }
    }

    public static int getSingleLinkedListSum(LinkedList linkedList) {
        // 1. list1, list2의 헤드를 지정한다.
        Node cur = linkedList.head;
        int sum = 0;

        while (cur != null) {
            sum = sum * 10 + cur.data;
            cur = cur.next;
        }
        return sum;
    }

    public static int getLinkedListSum(LinkedList linkedList1, LinkedList linkedList2) {
        int sum1  = getSingleLinkedListSum(linkedList1);
        int sum2  = getSingleLinkedListSum(linkedList2);

        return sum1 + sum2;
    }

    public static void main(String[] args) {
        LinkedList linkedList1 = new LinkedList(6);
        linkedList1.append(7);
        linkedList1.append(8);

        LinkedList linkedList2 = new LinkedList(3);
        linkedList2.append(5);
        linkedList2.append(4);

        System.out.println(getLinkedListSum(linkedList1, linkedList2));
    }
}