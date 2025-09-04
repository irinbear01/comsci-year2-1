package Lab08;
import Lab08.pack.*;
import java.util.Arrays;

public class Lab08_670050 {
    // int[] arr = {42,17,-5,88,23,91,-12,65,7,30,55,-9,2,48,76,1,-22,99,14,61,37,83,-18,50,29,72,6,40,-3,95,11,68};
    static void task_1() {
        int[] arr = {42,17,-5,88,23,91,-12,65,7,30,55,-9,2,48,76,1,-22,99,14,61,37,83,-18,50,29,72,6,40,11,68}; // -3, 95
        MyMergeSort_670050 sol = new MyMergeSort_670050();
        sol.mSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void task_2() {
        int[] arr = {42,17,-5,88,23,91,-12,65,7,30,55,-9,2,48,76,1,-22,99,14,61,37,83,-18,50,29,72,6,40,11,68}; // -3, 95
        MyQuickSort_670050 sol = new MyQuickSort_670050();
        sol.qSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void dutch_national_flag(int[] arr) {
        int left_value = arr[0];    // min
        int right_value = arr[0];   // max
        for (int i = 1; i < arr.length; i++) {
            left_value = Math.min(left_value, arr[i]);
            right_value = Math.max(right_value, arr[i]);
        }
        int minV = left_value, maxV = right_value;
        int left = 0, i = 0, right = arr.length - 1;

        while (i <= right) {
            if (arr[i] == minV) {
                // swap(arr[i], arr[left])
                int tmp = arr[i]; arr[i] = arr[left]; arr[left] = tmp;
                left++;
                i++;
            } else if (arr[i] == maxV) {
                // swap(arr[i], arr[right])
                int tmp = arr[i]; arr[i] = arr[right]; arr[right] = tmp;
                right--;
                // ไม่เพิ่ม i ที่นี่
            } else {
                // เป็น mid
                i++;
            }
        }       
        
    }
    static void task_3() {
        // R B W W B B R W W R R W R B W
        int[] arr = {1,0,2,2,0,0,1,2,2,1,1,2,1,0,2};
        dutch_national_flag(arr);
        System.out.println(Arrays.toString(arr));
    }
    static int k_th_min_element(int[] arr, int k) {
        int min = arr[0];    
        int max = arr[0];   
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        int[] count = new int[max - min + 1];
        // นับความถี่
        for (int v : arr) {
        count[v - min]++;
        }

        // เดินหาลำดับที่ k (1-based)
        int running = 0;
        for (int offset = 0; offset < count.length; offset++) {
        running += count[offset];
        if (running >= k) {
            return min + offset;
        }
        }
        return -1; // exception
    }
    static void task_4() {
        int[] arr = {-1,0,-2,-2,0,0,-1,-2,-2,-1,-1,-2,-1,0,-2};
        System.out.println(k_th_min_element(arr,2));        
    }
    public static void main(String[] args) {
        task_1();
        task_2();
        task_3();
        task_4();
    }
}
