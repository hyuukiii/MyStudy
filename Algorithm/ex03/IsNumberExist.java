package dingcorithm.ex03;

// Q. 다음과 같은 숫자로 이루어진 배열이 있을 때, 이 배열 내에 특정 숫자가 존재한다면 True, 존재하지 않다면 False 를 반환하시오.
// 빅오 -> 최악의 경우
// 빅오메가 -> 최선의 경우
class IsNumberExist {

        public static boolean isNumberExist(int number, int[] array) {

            for (int arrays : array) {
                if (number == arrays) {
                    return true;
                }
            }
            return false;
        }

        /*
            for (int arrays : array) {
                if (number != arrays) {
                    continue;
                }else {
                    return true;
                }
            }
            return false;
        }
        */

        public static void main(String[] args) {
            System.out.println("정답 = True 현재 풀이 값 = " + isNumberExist(3, new int[]{3, 5, 6, 1, 2, 4}));
            System.out.println("정답 = False 현재 풀이 값 = " + isNumberExist(7, new int[]{6, 6, 6}));
            System.out.println("정답 = True 현재 풀이 값 = " + isNumberExist(2, new int[]{6, 9, 2, 7, 1888}));
        }
    }
