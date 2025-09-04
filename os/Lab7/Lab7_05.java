import java.util.Arrays;
public class Lab7_05 {
    public static void main(String args[]) {
        int matrixA[][] = {{5, 10, 13}, {12, 22, 9}};
        int matrixB[][] = {{11, 21}, {51, 12}, {20, 18}};
        MyData dataA = new MyData(matrixA);
        MyData dataB = new MyData(matrixB);
        int matrixC_row = dataA.data.length;
        int matrixC_col = dataB.data[0].length;
        MyData dataC = new MyData(matrixC_row, matrixC_col);
        Thread[][] threads = new Thread[matrixC_row][matrixC_col];
        for (int i = 0; i < matrixC_row; i++) {
            for (int j = 0; j < matrixC_col; j++) {
                threads[i][j] = new Thread(new MatrixMulThread(i, j, dataA, dataB, dataC));
                threads[i][j].start();
            }
        }
        
        for (int i = 0; i < matrixC_row; i++) {
            for (int j = 0; j < matrixC_col; j++) {
                try {
                    threads[i][j].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        dataC.show();
    }
}
class MatrixMulThread implements Runnable {
    private int processingRow;
    private int processingCol;
    private MyData dataA;
    private MyData dataB;
    private MyData dataC;
    MatrixMulThread(int targetRow, int targetCol, MyData dataA,
MyData dataB, MyData dataC) {
        processingRow = targetRow;
        processingCol = targetCol;
        this.dataA = dataA;
        this.dataB = dataB;
        this.dataC = dataC;
}
public void run() {
    int sum = 0;
    for (int k = 0; k < dataA.data[0].length; k++) {
        sum += dataA.data[processingRow][k] * dataB.data[k][processingCol];
    }
    dataC.data[processingRow][processingCol] = sum;
    }
}
class MyData {
    public int data[][];
    MyData(int data[][]) {
        this.data = data;
    }
    MyData(int row, int col) {
        data = new int[row][col];
        for (int aRow[]: data) {
            Arrays.fill(aRow, 0);
        }
    }
    public void show() {
        System.out.println(Arrays.deepToString(data));
    }
}