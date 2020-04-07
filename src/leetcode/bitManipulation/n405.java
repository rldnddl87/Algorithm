package leetcode.bitManipulation;

public class n405 {
    public String toHex(int num) {
        //0,1,2,3,4,5,6,7,8,9,a,b,c,d,e,f
        String[] hex = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
        //15 == f
        //16 == 10

        StringBuilder sb = new StringBuilder();

        int q = num / 16;
        int r = num % 16;

        while(true) {
            sb.append(hex[r]);

            if( q > 16) {
                q /= 16;
            } else {
                sb.append(hex[q]);
            }

            if( q > 16) break;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        n405 n = new n405();
        System.out.println(n.toHex(26));
    }

}
