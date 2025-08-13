package dingcorithm.ex01.my;

public class FindMaxNum {

    int[] data1 = {3, 5, 6, 1, 2, 4}; // 첫번쨰 문제
    int[] data2 = {6, 6, 6}; // 두번째 문제
    int[] data3 = {6, 9, 2, 7, 1888}; // 세번쨰 문제


    // ** data1의 배열의 0번쨰 값 부터 차례대로 나머지 배열의 값들과 비교 한다.
    // ** 비교 시 제일 큰 값은 0번째에 위치 하게 만든다.
    public void find_max_num1() {
        System.out.println("data1의 배열:");

        for (int data1Arrays : data1) {
            System.out.print(data1Arrays+", ");
        }

        System.out.println();

        // 1. 비교할 변수의 값이 필요하다 MaxIndex라는 변수를 만들어서 0으로 초기화 시킨다.
        int MaxIndex = 0;
        // 2. MaxIndex값을 0으로 초기화 시켜줬으므로 i의 값은 1로 초기화 시켜준다.
        for (int i = 1; i < data1.length ; i++) {
            // 3. data1의 배열에 MaxIndex[0]값이 data1[1]의 값보다 작은지 비교한다.
            if (data1[MaxIndex] < data1[i]) {
                //4. 배열의 값들을 순회하면서 비교 한다.
                //       MaxIndex의 주소 안에 있는 값이 남아 있는 주소 안의 값들과 비교 후 MaxIndex값이 크다면
                //         MaxIndex 값을 i의 주소에 저장한다.
                MaxIndex = i;
            }
        }

        System.out.println("최댓값의 위치는 :"+ MaxIndex);
        System.out.println("최댓값은 :"+ data1[MaxIndex]);

    }

}


