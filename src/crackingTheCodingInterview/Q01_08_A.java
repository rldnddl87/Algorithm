package crackingTheCodingInterview;
/**
 *  M * N 행렬의 한 원소가 0일 경우, 해당 원소가 속한 열과 행의 모든 원소를 0으로 설정하는 알고리즘
 * */
public class Q01_08_A {
    public static void process(int[][] matrix) {
        int sizeX = matrix.length;
        int sizeY = matrix[0].length;

        int idx1 = 0;
        int idx2 = 0;
        doubleLoop: for(int i = 0; i < sizeX; i++) {
            for(int j = 0; j < sizeY; j++) {
                if(matrix[i][j] == 0){
                    idx1 = i;
                    idx2 = j;
                    break doubleLoop;
                }
            }
        }

        for(int i = 0; i < sizeX; i++) {
            for(int j = 0; j < sizeY; j++) {
                if( i == idx1 || j == idx2) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main( String[] args) {
        int[][] arr = UtilMethods.makeMatrix(3,4);
        UtilMethods.printMatrix(arr);

        arr[1][2] = 0;

        UtilMethods.printMatrix(arr);

        process(arr);

        UtilMethods.printMatrix(arr);


    }
}
