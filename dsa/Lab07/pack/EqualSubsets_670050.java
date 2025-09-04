package Lab07.pack;

//ให้ sum = ผลรวมทั้งหมด ถ้า sum เป็นเลขคี่ return false
//ถ้า sum ถ้าเป็นคู่ให้หา subset ที่รวมกันได้ target = sum/2 โดย เลือก/ไม่เลือก สมาชิกทีละตัว
public class EqualSubsets_670050 {
    // หาผลรวมด้วย
    private static int sumArray(int[] arr) {
        int sum = 0;
        for (int x : arr) sum += x;
        return sum;
    }
    //1) Recursion
    public static boolean canPartition_Recurse(int [] arr) {
        int sum = sumArray(arr);                 
        if ((sum & 1) == 1) return false;        // ผลรวมเป็นคี่ แบ่งเท่ากันไม่ได้
        return dfs(arr, 0, sum / 2);
    }

     private static boolean dfs(int[] a, int i, int target) {
        if (target == 0) return true;            // เจอ subset รวมได้พอดี
        if (i == a.length || target < 0) return false;
        // เลือก a[i] หรือไม่เลือก a[i]
        return dfs(a, i + 1, target - a[i]) || dfs(a, i + 1, target);
    }
    //2) Memoization
    public static boolean canPartition_Memoiz(int [] arr) {
        int sum = sumArray(arr);
        if ((sum & 1) == 1) return false;
        int target = sum / 2;
        Boolean[][] memo = new Boolean[arr.length][target + 1];
        return dfsMemo(arr, 0, target, memo);
    }

    private static boolean dfsMemo(int[] a, int i, int target, Boolean[][] memo) {
        if (target == 0) return true;
        if (i == a.length || target < 0) return false;
        if (memo[i][target] != null) return memo[i][target];
        // เลือก a[i] หรือไม่เลือก a[i]
        memo[i][target] = dfsMemo(a, i + 1, target - a[i], memo) || dfsMemo(a, i + 1, target, memo);
        return memo[i][target];
    }

    //3) Dynamic Programming
    public static boolean canPartition_DP(int [] arr) {
          int sum = sumArray(arr);                
        if ((sum & 1) == 1) return false;
        int target = sum / 2;

        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // รวมได้ 0 เสมอ (ไม่เลือกอะไร)

        for (int x : arr) {
            // เดินย้อนหลังเพื่อไม่ให้ใช้ค่าที่เพิ่งอัปเดตรอบเดียวกัน
            for (int t = target; t >= x; --t) {
                dp[t] = dp[t] || dp[t - x];
            }
        }
        return dp[target];
    }
}
