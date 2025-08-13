package dingcorithm.ex04;
// Q. 다음과 같이 영어로 되어 있는 문자열이 있을 때,
// 이 문자열에서 반복되지 않는 첫번째 문자를 반환하시오. 만약 그런 문자가 없다면 _ 를 반환하시오.

public class NotRepeatingCharacter {

    // 1. 첫번째 문자 이므로 "abadabac" 이라고 치면 첫번쨰 문자라고 했으니 d이다.
    // 2. 문자를 아스키코드로 변환 후 배열의 인덱스를 증가 시켜준다.
    // 3. 그 중 1인것을 찾고 난 뒤 다시 아스키코드를 문자로 변환 한 뒤 출력 한다.
    public static String findNotRepeatingFirstCharacter(String string) {

        // 1. 먼저 문자를 담을 배열을 만들어준다.
        int[] strArray = new int[26];
        int index = 0;

        for (char c : string.toCharArray()) {
            //3. 공백이 있으면 음수를 발생 시키므로 조건문을 넣는다 ( 빈도수 찾아 주기)
            if(c >= 'a' && c<= 'z'){
                // 2. 해당 문자열을 아스키코드로 변환 시켜준다.
                index = c -'a';
                strArray[index]++;
                System.out.print("문자 ="+ c +", 인덱스 =" +index + ",");
            }
        }

        // 4. 원래 문자열을 다시 순회 해주면서 인덱스의 값이 1인것을 찾아준다.
        for (char c : string.toCharArray()) {
            if(c >= 'a' && c<= 'z'){
                index = c -'a';
                if(strArray[index] == 1) {
                    //5. 첫번째 발견시 return으로 바로 반환
                    return String.valueOf(c);
                }
            }
        }

        return "_";
    }

        /* 배열 순서로 보면: a(빈도수4), b(빈도수2), c(빈도수1), d(빈도수1)
                * 해당 코드로는 c를 먼저 찾게 된다 (배열에서 c가 d보다 앞에 있으니까)
                * 하지만 문자열에서는 d가 c보다 먼저 나타나기 떄문에 틀린 로직이다.
            int result = 0;
            for (int i = 0; i < strArray.length; i++) {
                if (strArray[i] == 1) {
                    result = strArray[i];
                }
            }
            */

    public static void main(String[] args) {
        System.out.println("정답 = d 현재 풀이 값 = " + findNotRepeatingFirstCharacter("abadabac"));
        System.out.println("정답 = c 현재 풀이 값 = " + findNotRepeatingFirstCharacter("aabbcddd"));
        System.out.println("정답 = _ 현재 풀이 값 = " + findNotRepeatingFirstCharacter("aaaaaaaa"));
    }
}
