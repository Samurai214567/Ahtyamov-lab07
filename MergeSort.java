import java.util.*;

public class MergeSort {
    public static int[] mergeSort(int[] a) {
        if (a.length <= 1) return a;                 // базовый случай
        int mid = a.length / 2;                      // середина
        int[] left = Arrays.copyOfRange(a, 0, mid);  // левая половина
        int[] right = Arrays.copyOfRange(a, mid, a.length); // правая
        return merge(mergeSort(left), mergeSort(right));
    }

    // Слияние двух отсортированных массивов в один
    private static int[] merge(int[] left, int[] right) {
        int[] res = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        // пока в обеих половинах есть элементы — выбираем меньший
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) res[k++] = left[i++];
            else res[k++] = right[j++];
        }
        // добавляем "хвосты"
        while (i < left.length) res[k++] = left[i++];
        while (j < right.length) res[k++] = right[j++];
        return res;
    }

    public static void main(String[] args) {
        int[] a = {38, 27, 43, 3, 9, 82, 10};
        int[] sorted = mergeSort(a);
        System.out.println(Arrays.toString(sorted));
    }
}
