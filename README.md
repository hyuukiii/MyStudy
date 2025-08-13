# 1. 알고리즘
- [배열에서 최댓값 구하기](Algorithm/ex01/my/FindMaxNum.java)
- [문자열이 담긴 String 자료형에서 제일 많이 나온 알파벳을 출력하기](Algorithm/ex02/FindMaxOccurredAlphabet.java)
  
# 2. CS 지식
- 시간복잡도란?  
    입력값에 비해서 얼마나 일을 수행 해야하는가?를 뜻한다.
  
    💡💡 알고리즘에서는 항상 입력값이 변경 될 수 있다고 가정 해야한다.
에시로 최댓값 찾기 알고리즘의 시간 복잡도를 판단 해보자.
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
' 2 * N² + N '  == O(n²)
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

' 2N - 1 '  == O(n)

라는 시간 복잡도가 나온다
```
첫번쨰 알고리즘과 두번째 알고리즘의 성능차이는 많이 날 것이다.  
  
왜냐 N이 1000이라고 가정 했을 떄

첫번째 알고리즘 : 1,000,000
두번째 알고리즘 : 1,000

라는 결론값이 나오기 때문이다.
