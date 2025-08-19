# 1. 알고리즘 문제 풀이
- [배열에서 최댓값 구하기](Algorithm/ex01/my/FindMaxNum.java)
- [최빈값 찾기](Algorithm/ex02/FindMaxOccurredAlphabet.java)
- [배열에 원하는 값을 true,false로 반환하기](Algorithm/ex03/my/IsNumberExist.java)  
- [배열 사이에 +,* 연산자 넣어서 최댓값 출력하기](Algorithm/ex04/MaxPlusOrMultiply.java)
- [문자열에서 반복되지 않는 제일 첫번째로 만나는 문자 출력하기](Algorithm/ex04/NotRepeatingCharacter.java)
- [소수 구하기, O(N^2).ver](Algorithm/ex05/PrimeFinder.java)
- [소수 구하기, O(N^N).ver](Algorithm/ex05/optimizePrimeFinder.java)
- [그룹 변화 감지,문자열 뒤집기](Algorithm/ex06/FlipToSame.java)
    
     
- [링크드리스트 기본](Algorithm/ex01/my/FindMaxNum.java)
- [링크드리스트 0번째추가, 중간 노드에 삽입](Algorithm/ex01/my/FindMaxNum.java)
- [링크드리스트 삭제](Algorithm/ex01/my/FindMaxNum.java)
   
    
## 시간복잡도란?  
    입력값에 비해서 얼마나 일을 수행 해야하는가?를 뜻한다.  
  
    💡💡 항상 입력값이 변경 될 수 있다고 가정 해야한다! 💡💡
  
예시로 최댓값 찾기 알고리즘의 시간 복잡도를 판단 해보자.   
- [배열에서 최댓값 구하기2](Algorithm/ex01/teacher/FindMaxNum1.java)
    
그럼 이 함수가 시간이 얼마나 걸리는지 어떻게 알 수 있을까?  
  -- 💡 '각 줄이 실행되는걸 한 번의 연산이 수행된다' 라고 생각 하고 계산 할 수 있다.  
``` java

public static int findMaxNum(int[] array) {
    for (int number : array) {  // array의 길이만큼 연산 실행
        for (int compareNum : array) { // array의 길이만큼 연산 실행 
            if(compareNum > number) { //  비교 연산 1번 실행    
                isMaxNum = false; // 대입 연산 1번 실행
            }
        }
        if (isMaxNum) { // 비교 연산 1번 실행
            return number;
        }

// ===== ⭐️ 각 숫자마다 모든 숫자와 비교해서 최댓값인지 확인 하는 로직이다. 만약 다른  값들보다 크면 반복문을 중단한다. ⭐️ ====== //

   array 연산 : 2
   대입 연산 : 1
   비교연산  : 1

위의 연산된 것들을 더해보면(입력값은 N으로 표기 한다.)  
  array의 길이 X array의 길이 (비교 연산 1번 + 대입 연산 1번)    
           N x N x 2
  라는 시간이 필요하다.

마지막 비교 연산은
if (isMaxNum) { // 비교 연산 1번 실행
            return number;
           }

아래 for문의
 
  for (int number : array) {  // array의 길이만큼 연산 실행

비교 연산 이기에

    N

만큼의 시간이 필요하다고 말할 수 있다.

그럼 최종적으로   
' 2 * N² + N '

혹은 Big O 표기 법으로

'O(n²)'

만큼의 시간이 걸렸다고 말할 수 있다.

```

그럼 내가 풀었던 코드로 시간 복잡도를 계산 해보자.
  
``` java  
public void find_max_num1() {

        for (int data1Arrays : data1) { // array의 길이 만큼 연산 실행
            System.out.print(data1Arrays+", ");
        }


        int MaxIndex = 0;
        for (int i = 1; i < data1.length ; i++) { // array의 길이만큼 연산 실행
            if (data1[MaxIndex] < data1[i]) { //비교 연산 1번 실행
                MaxIndex = i; // 대입 연산 1번 실행
            }
        }

' 2N - 1 '  == ' O(n) '

라는 시간 복잡도가 나온다
```
첫번쨰 알고리즘과 두번째 알고리즘의 성능차이는 많이 날 것이다.  
  
왜냐 N이 1000이라고 가정 했을 떄

첫번째 알고리즘 : 1,000,000     
두번째 알고리즘 : 1,000    
  
라는 값을 가정 할 수 있기 때문이다.  
  
## 공간복잡도란?  
    시간복잡도와 개념은 비슷하다.
    
    어떠한 알고리즘으로 문제를 해결 했을 떄 공간을 얼만큼 썼는가? 또한 공간은 몇 배로 늘어났는가? 를 뜻한다.
  
예시로 최빈 값 찾기 알고리즘에서 공간 복잡도를 판단 해보자.  
  
첫번째 방법  
``` python  
alphabet_array = ["a", "b", "c", "d", "e", "f", "g", "h", "i", "g", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"] # 26개의 공간을 사용 
max_occurrence = 0 # 1개의 공간을 사용
max_alphabet = alphabet_array[0] # 1개의 공간을 사용

for alphabet in alphabet_array:
    occurrence = 0; # 1개의 공간을 사용

'29' 만큼의 공간을 사용 했다.

```  
두번째 방법
  
- [최빈값 찾기](Algorithm/ex02/FindMaxOccurredAlphabet.java)
    
``` java  
class FindMaxOccurredAlphabet {

    public static String findMaxOccurredAlphabet(String string) {

        int[] count = new int[26]; // 26개
        for (char c : string.toCharArray()) {
            if (c >= 'a' && c<= 'z') {
                int index = c - 'a'; // 1개
                count[index]++;
            }
        }

        int maxIndexNum = 0; // 1개

        for (int i = 1; i <count.length ; i++) {
            if (count[i] > count[maxIndexNum]) {
                maxIndexNum = i; // 1개
            }
        }

        // System.out.println("가장 큰 값을 가진 인덱스: " + maxIndexNum);

        char result = (char)(maxIndexNum + 'a'); // 1개

        // System.out.println("최종 변환 문자"+result);

        return String.valueOf(result);
    }

총 '30' 만큼의 공간을 사용 했다.

```      

'아 공간을 적게 썼으니 첫번째 방법이 훨씬 효율적이구나'라고 생각 할 수 있다.  
  
아니라고 말할 수 있다.  
  
29와 30은 모두 상수이고 대부분의 문제에서 알고리즘의 성능이 *공간에 의해서 결정 되지 않는다.*
공간을 N^2, N^3 처럼 쓸 경우에는 이야기가 조금 달라지지만  

**대부분의 문제를 해결할 때는 공간 복잡도 보다는 시간 복잡도를 더 신경 써야 한다.**  
  
## 빅오(Ω) , 빅오메가(O) 표기법    

우리는 알고리즘을 구현 후, 시간 복잡도와 공간 복잡도를 예측 할 수 있다고 앞서 말했다.  
  
여기서 개발자들끼리 시간 복잡도를 계산 할 때 약속한 것이 있는데  
  
알고리즘 구현 후 최선의 경우에는 '빅오(Ω)' 표기법을 사용 하기로 했고, 최악의 경우 '빅 오메가(O)' 표기법을 사용 하기로 했다.    
  
- [배열에 원하는 값을 true,false로 반환하기](Algorithm/ex03/teacher/isNumberExist.java)  
  
``` java
class IsNumberExist {

    public static boolean isNumberExist(int number, int[] array) {

        for (int arrays : array) { // for문을 통해서 array의 길이만큼 아래의 연산이 실행 된다.
            if (number == arrays) { // 비교 연산 1번 실행
                return true;        // 시간복잡도는 N만큼 걸린다. (빅오메가 표기법으로 표기 시)
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("정답 = True 현재 풀이 값 = " + isNumberExist(3, new int[]{3, 5, 6, 1, 2, 4}));
        // 운이 좋은 경우!! 시간 복잡도가 1밖에 안걸린다. --> 최선의 경우 1만큼의 연산만 필요하다.
        System.out.println("정답 = True 현재 풀이 값 = " + isNumberExist(4, new int[]{3, 5, 6, 1, 2, 4}));
        // 운이 좋지 않은 경우!! 배열의 끝까지 찾아야 하기 떄문에 시간 복잡도가 N 만큼 걸린다. --> 최악의 경우 N(미지수) 만큼의 연산이 필요하다.
        // 따라서 알고리즘의 성능은 항상 동일한게 아니다. 어떤 값을 입력하느냐? 어떤 패턴을 이루는 데이터인지 따라서 달라질 수 있다.

        //그래서 우린 최선의 경우 1 만큼 연산 소요 빅 오메가Ω(1)로 표기한다 , 최악의 경우 N만큼 연산 소요 빅오O(N)로 표기한다.

        // 우리는 앞서 빅오 표기법으로만 즉 최악의 경우를 생각해서 표기 했다. 그 이유는 앞서 말했다시피 알고리즘의 성능은 항상 다르다.
             그리고 우리가 예측 할 수 없는 바운더리는 수 없이 많으므로 '최악의 경우'를 생각해서 알고리즘을 짜고 성능을 파악 하자.

        System.out.println("정답 = False 현재 풀이 값 = " + isNumberExist(7, new int[]{6, 6, 6}));
        System.out.println("정답 = True 현재 풀이 값 = " + isNumberExist(2, new int[]{6, 9, 2, 7, 1888}));
    }
}

```  
## Array 배열?  

--> 💡 배열은 크기가 정해진 데이터의 공간이다. 즉 한번 정해지면 바꿀 수 없는 **불변성**을 가진다.  
       배열은 각 원소에 즉시 접근이 가능하다. 또한 원소의 순서는 0부터 시작 하고 이를 **인덱스**라고 부른다.    
       *즉시 접근이 가능 하다는 상수 시간 내에 접근 할 수 있음을 의미 한다.*  
  
### 배열은 원소를 중간에 삽입하거나 삭제 하려면 모든 원소를 다 옮겨야 한다. 원소를 새로 추가 하려면, 새로운 공간을 할당 해야 하므로 매우 비 효율적이다.  


## Linked List  
--> 💡 리스트는 특정 원소에 접근 하려면 *연결 고리 == 포인터*를 따라 탐색 해야 한다.    
       최악의 경우 모든 *노드* 탐색 해야함. O(N)시간 복잡도를 가진다.    
         
### 원소를 중간에 삽입/삭제 하기 위해서는 앞 뒤의 포인터만 변경 하면 됨. 따라서 원소의 삽입/삭제를 O(1)의 시간 복잡도 안에 할 수 있다.  

## Array vs LinkedList

|  경우 | Array | LinkedList |
|---------|-------|------------|
| 특정 원소 조회 | O(1) | O(N) |
| 중간에 삽입 삭제 | O(N) | O(1) |
| 데이터 추가 | 데이터 추가 시 모든 공간이 다 차버렸다면 새로운 메모리 공간을 할당받아야 한다 | 모든 공간이 다 찼어도 맨 뒤의 노드만 동적으로 추가하면 된다. |
| 정리 | 데이터에 접근하는 경우가 빈번하다면 Array를 사용하자 | 삽입과 삭제가 빈번하다면 LinkedList를 사용하는 것이 좋다. |  


리스트에서는 세가지의 정보가 필요하다  
1. 노드 안에 있는 데이터
2. 노드가 어떤 노드를 가르켜야하는지
3. 시작점이 어디 인지
``` java
   static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;
```
data = 각 노드마다 저장할 값이 다르기 때문에 외부에서 받아왔음.  
next = 각 노드들은 어디를 가르킬지는 모르기 때문에 동적인 할당을 위해 null로 지정했다.     
head = 첫 노드의 시작점이다.  


리스트를 만들 떄 첫번 째 노드를 생성 하는 메서드    
``` java
   public void LinkedListAppend(int value) {
      this.head = new Node(value);
}
```  
💡 빈 배열로 만드는 것이 더 바람직하다  
``` java
LinkedList<Inteager> list = new LinkedList<>();
```

리스트 끝에 새로운 노드를 추가해주는 메서드
``` java
   public void LinkedListAppend(int value) {
   Node cur = this.head;

   while(cur.next != null) {
      cur = cur.next;
   }
    cur.next = new Node(value);
}

예시: [5] --> [12] --> null
null 자리에 3을 추가 할려고 한다.

초기 : cur = 5
1번째 반복 :  cur.next = 노드 [12] (≠ null) → cur = 노드 [12]로 이동
2번째 반복 :  cur.next = 12 , cur.next == null 반복 종료
결과: cur.next = null (= null) → 루프 종료
실행: cur.next = new node[3] ✅
```  


  
          
# 2. CS 지식

