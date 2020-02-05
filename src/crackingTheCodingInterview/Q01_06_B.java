package crackingTheCodingInterview;

/**
 * Q01_06 : 반복되는 문자의 개수를  세는 방식의 압축 메서드 작성
 *  ex : aaabccddee 일 경우 a3b1c2d2e2와 같이 만드는데 압축전 문자열보다 길 경우 원본 문자열 리턴
 * */
public class Q01_06_B {
    public static String compressString(String s) {
        if(s.length() == 1) {
            return s;
        }

        StringBuilder sb = new StringBuilder();

        int cnt = 0;
        for(int i = 0; i < s.length(); i++) {
            cnt++;
            if( i + 1 >= s.length() || s.charAt(i) != s.charAt(i+1)) {
                sb.append(s.charAt(i)).append(cnt);
                cnt = 0;
            }
        }

        return  s.length() > sb.toString().length() ? sb.toString() : s;
    }


    public static void main(String[] args) {
        System.out.println(compressString("aaaabbc"));

    }
}
