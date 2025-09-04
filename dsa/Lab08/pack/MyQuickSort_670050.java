package Lab08.pack;

public class MyQuickSort_670050 {
    public void qSort(int[] arr) {
        qSort_lumoto(arr, 0, arr.length-1);
    }
    private void qSort_lumoto(int[] arr, int low, int high) {
        if (low < high) {
            int pivot_index = partition_lomuto(arr, low, high);
            qSort_lumoto(arr, low, pivot_index - 1);
            qSort_lumoto(arr, pivot_index + 1, high);
        }
    } 
    private int partition_lomuto(int[] arr, int low, int high) { 
        int pivot_v = arr[high];
        int i = low, tmp;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot_v) {
                // swap(arr[i], arr[j])
                tmp = arr[i]; arr[i] = arr[j]; arr[j] = tmp;
                i++;
            }
        }
        //เอา pivot วางตำแหน่งจริง
        tmp = arr[i]; arr[i] = arr[high]; arr[high] = tmp;
        return i;
    }
}
