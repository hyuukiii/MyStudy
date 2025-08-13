package dingcorithm.ex03.teacher;

// Q. 다음과 같은 숫자로 이루어진 배열이 있을 때, 이 배열 내에 특정 숫자가 존재한다면 True, 존재하지 않다면 False 를 반환하시오.

// 빅오 Ω -> 최악의 경우
// 빅오메가 N으로 표기 -> 최선의 경우
class IsNumberExist {

    public static boolean isNumberExist(int number, int[] array) {

        for (int arrays : array) { // for문을 통해서 array의 길이만큼 아래의 연산이 실행 된다.
            if (number == arrays) { // 비교 연산 1번 실행
                return true;        // 시간복잡도는 N만큼 걸린다.
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("정답 = True 현재 풀이 값 = " + isNumberExist(3, new int[]{3, 5, 6, 1, 2, 4}));
        // 운이 좋은 경우!! 시간 복잡도가 1밖에 안걸린다. --> 최선의 경우 1만큼의 연산만 필요하다.
        System.out.println("정답 = True 현재 풀이 값 = " + isNumberExist(4, new int[]{3, 5, 6, 1, 2, 4}));
        // 운이 좋지 않은 경우!! 배열의 끝까지 찾아야 하기 떄문에 시간 복잡도가 N 만큼 걸린다.
        // 따라서 알고리즘의 성능은 항상 동일한게 아니다. 어떤 값을 입력하느냐? 어떤 패턴을 이루는 데이터인지 따라서 달라질 수 있다.
        // 좋을 떄 1 만큼 연산 소요 빅 오메가 ==> Ω(1), 좋지 않을 떄 N만큼 연산 소요 빅오O(N) 됨.

        // 우리는 앞서 빅오 표기법으로만 즉 최악의 경우를 생각해서 표기 했다. 그 이유는 앞서 말했다시피 알고리즘의 성능은 항상 다르다.
        // 그리고 우리가 예측 할 수 없는 바운더리는 수 없이 많으므로 최악의 경우를 생각해서 알고리즘을 짜고 성능을 파악 하는것이 맞다.
        System.out.println("정답 = False 현재 풀이 값 = " + isNumberExist(7, new int[]{6, 6, 6}));
        System.out.println("정답 = True 현재 풀이 값 = " + isNumberExist(2, new int[]{6, 9, 2, 7, 1888}));
    }
}
