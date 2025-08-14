package dingcorithm.ex05;
// Q. 정수를 입력 했을 때, 그 정수 이하의 소수를 모두 반환하시오.

// ⭐⭐️ 소수는 자신보다 작은 두 개의 자연수를 곱하여 만들 수 없는 1보다 큰 자연수이다. ⭐️⭐️

// 값이 20이 입력 된다 했을떄 == {2,3,5,7,11,13,17,19} 나오게 된다

import java.util.*;

public class PrimeFinder {

    public static List<Integer> findPrimeListUnderNumber(int number) {

        // 1. 소수를 담을 배열을 만들어준다.(List는 동적 배열이다)
        List <Integer> primeList = new ArrayList<>();

        // 2. 1~20까지 숫자를 순회하는 외부 중첩문을 만들어준다. 이는 리스트 배열에 담길 소수값이다.
        for(int i = 1; i <= number; i++) {
            //3. 해당 값이 소수인지 아닌지 판별값이 필요하다.
            boolean isCheckPrime = true;

            //4. 소수는 1보다 커야 하므로 2부터 시작해야한다.
            if(i <= 1) {
                //5. 만약 i가 1보다 작거나 같다면 소수가 아니므로 판별값은 거짓이다.
                isCheckPrime = false;
            }

            //6. 이제 i의 값이 소수인지 아닌지 비교하는 값이 있어야 한다.
            for (int j=2; j < i; j++) {

                //7. i를 j로 나눴을 때 나머지 값이 0이 나온다면 소수가 아니므로 그 즉시 비교를 멈추고 다음 반복으로 넘어간다.
                if (i % j == 0) {
                    isCheckPrime = false;
                    break;
                }
            }

            //8. 마지막으로 판별값이 진실일 때 배열에 i값을 추가 해준다.
            if (isCheckPrime){
                primeList.add(i);
            }
        }
        return primeList;
    }

    /*
     * 시간복잡도를 계산 해보자 현재는 소수인지 아닌지 확인하기 위해 만약 19가 들어왔을 떄
     * 소수인지 아닌지 비교 한다고 했을 때 2,3,4,5,6,7,8,9 . . . 19 까지 나누면서 비교한다.
     * 즉 시간 복잡도는 O(N^2)이 된다.
     */

    public static void main(String[] args) {
        int input = 20;
        List<Integer> result = findPrimeListUnderNumber(input);
        System.out.println(result);
    }
}
