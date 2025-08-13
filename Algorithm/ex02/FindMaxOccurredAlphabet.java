package dingcorithm.ex02;

// 최빈값 찾기
// 문자열에서 제일 많이 나오는 알파벳을 찾기

class FindMaxOccurredAlphabet {

    public static String findMaxOccurredAlphabet(String string) {

        // 1. 문자(a~z은 26개)를 저장 할 배열을 만들어준다
        int[] count = new int[26];

        //2. 문자열을 순회하며 각 문자의 갯수를 샌다.
        //⭐️ 아스키코드를 사용 하여 해당 문자들을 정수로 변환하여 인덱스에 값을 증가 시켜줄것이다.
        for (char c : string.toCharArray()) {

            // ⭐️공백으로 인해 음수가 나왔으므로 문자인지 확인을 해줘야한다.
            if (c >= 'a' && c<= 'z') {
                int index = c - 'a';
                count[index]++;
            }
        }

        int maxIndexNum = 0;

        //3. 가장 큰 값을 가진 인덱스를 찾는다.
        for (int i = 1; i <count.length ; i++) {
            if (count[i] > count[maxIndexNum]) {
                maxIndexNum = i;
            }
        }
        // System.out.println("가장 큰 값을 가진 인덱스: " + maxIndexNum);

        // 4. 해당 인덱스를 문자로 변환한다. ==> 첫 순회 했을 떄의 결과를 예로들면 현재 maxIndex값은 8이다 이걸 a = 97과 더해주면 105라는 값이 나오는데 ==> 이는 아스키코드에서 i인것을 알 수 있다.
        char result = (char)(maxIndexNum + 'a'); // ⭐️ int는 char보다 큰 자료형이기에 자바는 명시적캐스팅이 필요로 하기 떄문에 다운 캐스팅을 해줘야한다. 알고 있지만 한번 더 복습 하자.

        // System.out.println("최종 변환 문자"+result);

        //⭐️ 현재 메서드의 반환타입이 String 이므로 valueOf 함수를 사용해서 char자료형으로 돼 있는 result를 String으로 변환 시켜 줘야 한다.
        return String.valueOf(result);
    }

    public static void main(String[] args) {
        System.out.println("정답 = i / 현재 풀이 값 = " + findMaxOccurredAlphabet("hello my name is dingcodingco"));
        System.out.println("정답 = e / 현재 풀이 값 = " + findMaxOccurredAlphabet("we love algorithm"));
        System.out.println("정답 = b / 현재 풀이 값 = " + findMaxOccurredAlphabet("best of best youtube"));
    }
}


/* count 배열에 index의 값을 증가시켜 주는 이유?

                    char c = 'h';
                    System.out.println((int)c); // h는 아스키코드로 104가 나오는걸 확인 할 수 있다.
                    int index = c - 'a'; // a는 아스키코드로 97 즉, a와 h를 빼면 7이 나온다.
                    count[index]++; // 배열의 7번 째 인덱스 값에 증가를 해준다.
                    
*/
