package dingcorithm.ex04;

//Q. 다음과 같이 0 혹은 양의 정수로만 이루어진 배열이 있을 때,
// 왼쪽부터 오른쪽으로 하나씩 모든 숫자를 확인하며 숫자 사이에 '✕' 혹은 '+' 연산자를 넣어 결과적으로 가장 큰 수를 구하는 프로그램을 작성하시오.
// 단, '+' 보다 '✕' 를 먼저 계산하는 일반적인 방식과는 달리, 모든 연산은 왼쪽에서 순서대로 이루어진다.

public class MaxPlusOrMultiply {
//  ⭐️첫번째의 원소값 + 그 다음 원소값 , 첫번째의 원소값 * 그 다음 원소값 중에 결과가 더 큰 수를 업데이트 해줘야한다.
    public static int findMaxPlusOrMultiply(int[] array) {

        // 1. 배열의 0번째 원소 값으로 시작한다
        int result = array[0];

        // 2. 배열의 0번째 원소값과 비교 해줘야 하므로 i는 1로 시작하자
        for (int i = 1; i < array.length; i++) {
            // 만약 0번째 원소 + 1번째 원소의 값이 , 0번째 원소 * 1번째 원소 보다 크면
            if (result + array[i] > result * array[i]) {
                    // 덧셈 공식을 업데이트 시켜준다.
                    result = result + array[i];
            }else {
                // 만약 곱셉이 더 크다면? 곱셈의 값을 업데이트 시켜준다.
                result = result * array[i];
            }
        }

        // 시간복잡도를 계산 해보자 난 최악의 경우인 빅오 표기법을 사용 할것 이므로 'N' 이라는 시간 복잡도가 계산 됐다.

        /*
            * 방법 2
                * Math.max는 계산만 해주는 게산기이다 이를 업데이트 시켜줄려면 그 값을 저장하는 공간이 필요하고
                * 이를 int 자료형의 result변수의 공간에 =을 이용하여 업데이트 시켜주는 것이다.

        for (int i = 1; i < array.length; i++) {
           result  = Math.max(result + array[i], result * array[i]);
        }

        */

        return result;
    }

    public static void main(String[] args) {
        System.out.println("정답 = 728 현재 풀이 값 = " + findMaxPlusOrMultiply(new int[]{0,3,5,6,1,2,4}));
        System.out.println("정답 = 8820 현재 풀이 값 = " + findMaxPlusOrMultiply(new int[]{3,2,1,5,9,7,4}));
        System.out.println("정답 = 270 현재 풀이 값 = " + findMaxPlusOrMultiply(new int[]{1,1,1,3,3,2,5}));
    }

}
