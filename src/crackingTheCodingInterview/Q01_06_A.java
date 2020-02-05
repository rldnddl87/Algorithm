package crackingTheCodingInterview;

/**
 * Q01_06 : 반복되는 문자의 개수를  세는 방식의 압축 메서드 작성
 *  ex : aaabccddee 일 경우 a3b1c2d2e2와 같이 만드는데 압축전 문자열보다 길 경우 원본 문자열 리턴
 *
 *  //마지막 문자열을 압축하지 못함(fail!)
 *  // 문자열의 마지막 index를 신경쓰다보니 s.length() - 1을 while이나 for문에 넣어서 확인하는 것 보다는
 *  // 기본적인 for문 안에서 index + 1이 s.length()와 같거나 큰지 확인하는게 더 효과 적일듯
 * */
public class Q01_06_A {
    public static String compressString(String s) {
        if(s.length() == 1) {
            return s;
        }

        int origin = s.length();

        StringBuilder sb = new StringBuilder();

        int idx = 0;

        while(idx < s.length() - 1) {

            boolean check = true;
            int cnt = 0;

            sb.append(s.charAt(idx));
            while( check && idx < s.length() - 1) {

                if(s.charAt(idx) != s.charAt(idx + 1)) {
                    sb.append(cnt);
                    check= false;
                } else {
                    cnt++;
                    check= true;
                }
                idx++;
            }

            if(cnt != 0 && sb.toString().equals(s.substring(0,1))) {
                sb.append(cnt + 1);
            }

        }

        return  origin > sb.toString().length() ? sb.toString() : s;
    }


    public static void main(String[] args) {
        System.out.println(compressString("aaaabbc"));

    }
}
