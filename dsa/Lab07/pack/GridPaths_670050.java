package Lab07.pack;

public class GridPaths_670050 {
    public int numberOfPaths(int [][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int m = grid.length, n = grid[0].length;
        if (grid[0][0] == 1 || grid[m-1][n-1] == 1) return 0;

        long[][] dp = new long[m][n];
        dp[0][0] = 1;

        // แถวแรก
        for (int c = 1; c < n; c++) {
            if (grid[0][c] == 0) {
                dp[0][c] = dp[0][c-1];
            } else {
                dp[0][c] = 0;
            }
        }
        // คอลัมน์แรก
        for (int r = 1; r < m; r++) {
            if (grid[r][0] == 0) {
                dp[r][0] = dp[r-1][0];
            } else {
                dp[r][0] = 0;
            }
        }
        // ช่องอื่น ๆ
        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                if (grid[r][c] == 1) {
                    dp[r][c] = 0;
                } else {
                    dp[r][c] = dp[r-1][c] + dp[r][c-1];
                }
            }
        }
        return (int) dp[m-1][n-1];
    }
}
