package dingcorithm.ex06;
/*Q.
0과 1로만 이루어진 문자열이 주어졌을 때, 이 문자열에 있는 모든 숫자를 전부 같게 만들려고 한다.
할 수 있는 행동은 문자열에서 연속된 하나 이상의 숫자를 잡고 모두 뒤집는 것이다. 뒤집는 것은 1을 0으로, 0을 1로 바꾸는 것을 의미한다.

예를 들어 S=0001100 일 때,

전체를 뒤집으면 1110011이 된다.
4번째 문자부터 5번째 문자까지 뒤집으면 1111111이 되어서 2번 만에 모두 같은 숫자로 만들 수 있다.
하지만, 처음부터 4번째 문자부터 5번째 문자까지 문자를 뒤집으면 한 번에 0000000이 되어서 1번 만에 모두 같은 숫자로 만들 수 있다.

주어진 문자열을 모두 0 혹은 모두 1로 같게 만드는 최소 횟수를 반환하시오.

*/

import java.util.ArrayList;
import java.util.List;

public class FlipToSame {

    public static int findCountToTurnOutToAllZeroOrAllOne(String string) {
        // 0이 들어갈 그룹
        int zeroGroup = 0;
        // 1이 들어갈 그룹
        int oneGroup = 0;

        for (int i = 0; i < string.length(); i++) {

            //인덱스안의 문자를 뽑아올 수 있음
            char c = string.charAt(i);
            //System.out.println(string.charAt(0));

            //인덱스가 0번째가 맞아?
            if (i == 0) {
                // 0번째가 맞다면 0번째에 '0'이 맞음?
                if (c == '0'){
                    // 그러면 zero그룹 +1
                    zeroGroup++;
                }else {
                    // 아니면 one그룹 +1
                    oneGroup++;
                }
            }else if (c != string.charAt(i-1)) { // c의 인덱스 안의 값이 1, i의 값이 1이라고 가정.
                                                 // 1 != 0 true -> 1 == '0' false --> else문 실행
                if (c == '0') {
                     zeroGroup++;
                }else {
                     oneGroup++;
                }
            }
        }

        return Math.min(zeroGroup,oneGroup);
    }

    public static void main(String[] args) {
        String input = "011110";
        int result = findCountToTurnOutToAllZeroOrAllOne(input);
        System.out.println(result);
    }
}
