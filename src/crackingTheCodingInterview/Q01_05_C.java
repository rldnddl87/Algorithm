package crackingTheCodingInterview;

public class Q01_05_C {
    public static boolean canEditAway(String s1, String s2) {
        if( Math.abs( s1.length() - s2.length()) > 1) {
            return false;
        }

        String shortStr = s1.length() > s2.length() ? s2 : s1;
        String longerStr = s1.length() > s2.length() ? s1 : s2;

        int shortIdx = 0;
        int longIdx = 0;
        boolean findDiffer = false;

        while(shortIdx < shortStr.length() && longIdx < longerStr.length()) {

            if( shortStr.charAt( shortIdx) != longerStr.charAt( longIdx)) {

                if(findDiffer) return false;

                findDiffer = true;

                if( shortStr.length() == longerStr.length()) { //길이가 같을경우 short idx ++;
                    shortIdx++;
                }
            } else {
                shortIdx++;
            }
            longIdx++; //길이가 같을경우 long idx++; and 길이가 다르고 다른 문자열이 있으면 긴 문자열의 idx++;
        }
        return true;
    }

    public static void main( String[] args) {
        String[][] input = {{"pale", "ple"}, {"pales", "pale"}, {"pale", "bale"}, {"pale", "bake"}};

        for( String[] str : input) {
            boolean b = canEditAway(str[0],str[1]);

            System.out.println(str[0] + ", " + str[1] + ": " + b);
        }
    }
}


