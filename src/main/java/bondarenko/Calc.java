package bondarenko;

public class Calc extends Thread {

    private int[][] matrix1;
    private int[][] matrix2;
    private int[][] result;
    private int begin;
    private int end;

    public Calc(int[][] matrix1, int[][] matrix2, int[][] result, int begin, int end) {
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.result = result;
        this.begin = begin;
        this.end = end;
    }

    public void run() {
        for (int index1 = begin; index1 < end; index1++) {
            for (int index2 = 0; index2 < 1000; index2++) {
                result[index1][index2] = 0;
                for (int k = 0; k < 1000; k++) {
                    result[index1][index2] += matrix1[index1][index2] * matrix2[index2][index1];
                }
            }
        }

    }
}
