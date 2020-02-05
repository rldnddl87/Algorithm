package crackingTheCodingInterview;
/**
 * 문자열 회전 : S1과 S2 두 문자열이 주어질때 S2가 S1을 회전시킨 결과인지 판별하는 isSubString메서드를 작성
 * 메서드는 한번만 호출된다.
 * */

public class Q01_09_A {
    public static boolean isSubString(String s1, String s2) {
        //s1을 회전싴키면 s2가 되는지 확인
        //ex erbottle wat ->(회전)-> wat erbottle

        if( s1.length() != s2.length()) return false;

        int idx1 = 0;


        int idx2 = 0;
        boolean check = false;

        while(true) {

            if(idx1 >= s1.length() || idx2 >= s2.length()) {
                break;
            }

            String tmpStr = "";
            String base = s1.substring(idx1, idx1 + 1);

            if(idx2 + 1 >= s2.length()){
                tmpStr = s2.substring(idx2);
            } else {
                tmpStr = s2.substring(idx2, idx2 + 1);
            }

            if( base.equals(tmpStr)){
                idx1++;
                idx2++;
                check = true;
            }else {
                idx2++;
                if(check) {
                    break;
                }
            }
        }
        String subStr1 = s1.substring(idx1);
        String subStr2 = s2.substring(0, s2.length() - idx1);

        if(subStr1.equals(subStr2)) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(isSubString("abc","cab"));


    }

}
