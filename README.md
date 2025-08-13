# 1. 알고리즘
- [배열에서 최댓값 구하기](Algorithm/ex01/my/FindMaxNum.java)
- [문자열이 담긴 String 자료형에서 제일 많이 나온 알파벳을 출력하기](Algorithm/ex02/FindMaxOccurredAlphabet.java)
  
# 2. CS 지식
- 시간복잡도란?  
    입력값에 비해서 얼마나 일을 수행 해야하는가?를 뜻한다  
    
에시로 최댓값 찾기 알고리즘의 시간 복잡도를 판단 해보자.
- [배열에서 최댓값 구하기2](Algorithm/ex01/my/FindMaxNum.java)
``` java  
public static int findMaxNum(int[] array) {
    for (int number : array) {
        boolean isMaxNum = true;
        for (int compareNum : array) {
            if(compareNum > number) {
                isMaxNum = false;
            }
        }
        if (isMaxNum) {
            return number;
        }
    }
    return 0;
}
//// ⭐️ 해당 해결 방법은 각 숫자마다 모든 다른 숫자와 비교해서 최댓값인지 확인 하는 로직이다 만약 다른 모든 값보다 크면 반복문을 중단한다. ⭐️
```

    
