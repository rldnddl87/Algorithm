package crackingTheCodingInterview;

/**
 * Q01_05 : 문자열을 편집하는 3개자 방법 문자삽입, 문자 삭제, 문자 교체
 * 이중 주어진 문자열을 편집하여 동일하게 만드는대 편집 횟수가 1회(1개의 문자열만 수정,삭제,삽입)인지 확인하는 함수
 * */
public class Q01_05_A {
    //문자 삽입, 삭제, 교체
    // 모두 1곳에서 실행되며, 개수 상관 없음

    public static boolean check(String str, String antStr) {

        //다른 문자가 양 끝단에 있을경우
        int length = Math.abs(str.length()  - antStr.length());

        if( length == 1 && str.contains( antStr)) {
            return true;
        }
        for(int i = 0; i < str.length(); i++) {
            if( str.charAt(i) != antStr.charAt(i)) {
                String result;
                //맨 마지막 문자열일 경우
                if( i == str.length() - 1) {
                    result = str.substring(i);
                } else {
                    result = str.substring(0, i) + str.substring(i + 1);
                }

                if( antStr.contains(result)) {
                    return true;
                }
            }

        }

        return false;
    }

    public static void main( String[] args) {
        String[][] input = {{"pale", "ple"}, {"pales", "pale"}, {"pale", "bale"}, {"pale", "bake"}};

        for( String[] str : input) {
            boolean b = check(str[0],str[1]);

            System.out.println(str[0] + ", " + str[1] + ": " + b);
        }
    }
}
