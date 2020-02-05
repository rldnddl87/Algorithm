package crackingTheCodingInterview;

public class Q01_05_B {

    public static boolean check(String s1, String s2) {
        if( s1.length() == s2.length())
            return canReplace(s1, s2);
        else {
            if( s1.length() > s2.length()) {
                return canInputOrDelete(s1, s2);
            } else {
                return canInputOrDelete(s2, s1);
            }
        }
    }

    //길이가 같을 경우 교체 연산이 가능
    public static boolean canReplace(String s1, String s2) {
        boolean notSame = false;
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                if(notSame) {
                    return false;
                }
                notSame = true;
            }
        }

        return true;
    }

    //길이가 다를 경우 삽입 또는 삭제 연산이 가능
    public static boolean  canInputOrDelete(String s1, String s2) {
        //s1 is longer than s2

        int idx1 = 0;
        int idx2 = 0;

        while(idx1 < s1.length() && idx2 < s2.length()) {
            if(s1.charAt(idx1) != s2.charAt(idx2)) {
                if(idx1 != idx2)
                    return false;
                idx1++; //첫번째 다른 글자를 찾은 이후에는 idx1과 idx2는 같지 않다.
            } else {
                idx1++;
                idx2++;
            }
        }
        return true;
    }




    public static void main( String[] args) {
        String[][] input = {{"pale", "ple"}, {"pales", "pale"}, {"pale", "bale"}, {"pale", "bake"}};

        for( String[] str : input) {
            boolean b = check(str[0],str[1]);

            System.out.println(str[0] + ", " + str[1] + ": " + b);
        }
    }
}
