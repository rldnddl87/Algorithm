package crackingTheCodingInterview;
/**
 * Q01_03 : 문자열에 있는 모든 공백을 %20으로 바꾼다
 * */
public class Q01_03_QA {
    public static String trimURL(String str, int length) {
        StringBuilder sb = new StringBuilder();
        String[] trim = str.split(" ");

        for(int i = 0; i < trim.length; i++) {
            sb.append(trim[i]);
            sb.append("%20");
        }

        return sb.toString();

    }
    public static void main(String[] args) {
        String str = "Mr John Smith      ";

        String rst = trimURL(str, str.length());
        System.out.println(rst);
    }
}
