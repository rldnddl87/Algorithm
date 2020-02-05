package crackingTheCodingInterview;
/**
 * 이미지를 표현하는 행렬 N * N 이 있다. 이미지의 각 픽셀은 4바이트로 표현
 * 행렬을 추가로 사용하지 않고 이미지를 90도로 회전시키는 메서드를 작성
 * */
public class Q01_07_A {

    public static void rotate90(int[][] matrix) {
        if( matrix.length != matrix[0].length || matrix.length == 0) return;
        int n = matrix.length;

        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;

            for(int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i]; //윗 부분을 저장해 놓는다.

                //왼쪽 - > 위쪽
                matrix[first][i] = matrix[last - offset][first];

                //아래쪽 -> 왼쪽
                matrix[last - offset][first] = matrix[last][last - offset];

                //오른쪽 -> 아래쪽
                matrix[last][last - offset] = matrix[i][last];

                //위쪽 -> 오른쪽
                matrix[i][last] = top; //미리 저장해 놓은 top

            }
        }

    }

    public static void printArr(int[][] n) {
        for(int[] arr : n) {
            for(int m = 0; m < arr.length; m++) {
                System.out.printf("%3s",arr[m]);
            }
            System.out.println();
        }
    }

    public static void main( String[] args) {
        int[][] n = new int[4][4];
        int i = 0;
        for(int k = 0; k < n.length; k++) {
            for(int j = 0; j < n.length; j++) {
                n[k][j] = i++;
            }
        }

        printArr(n);
        System.out.println("========");
        rotate90(n);
        printArr(n);

    }

}
