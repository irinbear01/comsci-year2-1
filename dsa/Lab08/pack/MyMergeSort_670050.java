package Lab08.pack;

public class MyMergeSort_670050 {
    public void mSort(int[] arr) {
        mSort(arr,0,arr.length-1);
    }
    private void mSort(int[] arr, int low, int high) {
        if (low >= high)    return;
        int mid = low + ((high - low) >> 1);
        mSort(arr,low,mid);
        mSort(arr,mid+1,high);
        merge(arr,low,mid,high);
    }
    private void merge(int[] arr, int low, int mid, int high) { 
        int[] tmp = new int[high - low + 1];
        int i = low;       // pointer ของครึ่งซ้าย
        int j = mid + 1;   // pointer ของครึ่งขวา
        int k = 0;         // pointer ของ tmp

        // รวมสองช่วงที่ถูกจัดเรียงแล้ว
        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }

        // เก็บที่เหลือจากฝั่งซ้าย
        while (i <= mid) {
            tmp[k++] = arr[i++];
        }

        // เก็บที่เหลือจากฝั่งขวา
        while (j <= high) {
            tmp[k++] = arr[j++];
        }

        // คัดลอกกลับเข้าอาร์เรย์ต้นฉบับ
        for (int t = 0; t < tmp.length; t++) {
            arr[low + t] = tmp[t];
        }
    }
}

