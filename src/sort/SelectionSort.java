package sort;


import java.util.Arrays;

/**
 * @author oulei
 * 选择排序：依次找出第一小的数，第二小的数据......
 * 时间复杂度：O(n²)
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] data = new int[]{4, 6, 1, 0, 9, 2, 3, 5, 8, 7};

        for (int i = 0; i < data.length - 1; i++) {
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[i]) {
                    // 交换数据
                    int temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                }
            }

        }

        // 数据数据
        Arrays.stream(data).forEach(t -> System.out.println(t));
    }
}