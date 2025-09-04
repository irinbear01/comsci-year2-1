public class Gaussian4x4 {
    public static void main(String[] args) {
        // สมการตัวอย่าง: A x = b
        double[][] a = {
            {2, 1, -1, 2,  8},   // แถว 1 (รวม b)
            {-3,-1, 2,-11,-15},  // แถว 2
            {-2, 1, 2, -3,  1},  // แถว 3
            {1, 2, 3, -1,  2}    // แถว 4
        };

        int n = 4;

        // ===== Forward Elimination =====
        for (int k = 0; k < n-1; k++) {
            for (int i = k+1; i < n; i++) {
                double m = a[i][k] / a[k][k];
                for (int j = k; j <= n; j++) {
                    a[i][j] -= m * a[k][j];
                }
            }
        }

        // ===== Back Substitution =====
        double[] x = new double[n];
        for (int i = n-1; i >= 0; i--) {
            double sum = a[i][n];
            for (int j = i+1; j < n; j++) {
                sum -= a[i][j]*x[j];
            }
            x[i] = sum / a[i][i];
        }

        // แสดงผลลัพธ์
        for (int i = 0; i < n; i++) {
            System.out.printf("x%d = %.4f\n", i+1, x[i]);
        }
    }
}
