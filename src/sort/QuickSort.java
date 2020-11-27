package sort;


import java.util.Arrays;

/**
 * @author oulei
 * 快速排序
 * 时间复杂度：O(nlogn)~O(n²)
 */
public class QuickSort {
    public static void main(String[] args) {
        int data[] = {3,8,2,1,9,6,5,4,7};
        quickSort(data, 0, data.length-1);
        Arrays.stream(data).forEach(t->{
            System.out.println(t);
        });


    }


    public static  void quickSort(int data[], int left, int right){
        if (left >= right){
            return;
        }
        int key = data[left];
        int i = left;
        int j = right;
        while (i < j){
            while (data[j] >= key && i < j){
                j--;
            }
            while (data[i] <= key && i < j){
                i++;
            }
            if (i < j){
                int temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
        }
        // 交换key和data[i]
        data[left] = data[i];
        data[i] = key;
        quickSort(data, left, i-1);
        quickSort(data, i+1, right);
    }
}
