package dingcorithm.ex01.teacher;

/* 1. 첫번 쨰 방법
{3, 5, 6, 1, 2, 4}

    ⭐️ 0번째의 원소가 나머지 원소들과 비교
    ⭐️ 1번쨰의 원소가 나머지 원소들과 비교
    ⭐️ 2번째의 원소가 나머지 원소들과 비교 . . . . .
3 -- > 5, 6, 1, 2, 4

5 --> 6, 1, 2, 4

6 --> 1, 2, 4

1 --> 2 , 4

2 --> 4

*/
class FindMaxNum1 {
    public static int findMaxNum(int[] array) {
        // 1. 원소의 값들을 모두 뽑아온다.
        for (int number : array) {
           //2. 최댓값의 초기 값을 불린 값으로 트루로 지정한다.
            boolean isMaxNum = true;

           // 3. 배열의 전체 원소를 뽑아 왔고 이제 그 값들을 0번쨰 부터 차례대로 비교 해준다
            for (int compareNum : array) {
                //4. number가 compareNum변수 보다 작다면 최댓값이 아니니 isMaxNum의 값을 false로 바꾼다 ⭐⭐️
                if(compareNum > number) {
                    isMaxNum = false;
                }
            }
            // 5. 마지막으로 isMaxNum의 값을 number변수의 값으로 리턴 시켜준다
            if (isMaxNum) {
                return number;
            }
        }
        return 0;
    }

    public static void main (String[]args){

    System.out.println("정답 = 6 / 현재 풀이 값 = " + findMaxNum(new int[]{3, 5, 6, 1, 2, 4}));
    System.out.println("정답 = 6 / 현재 풀이 값 = " + findMaxNum(new int[]{6, 6, 6}));
    System.out.println("정답 = 1888 / 현재 풀이 값 = " + findMaxNum(new int[]{6, 9, 2, 7, 1888}));

    }
}


