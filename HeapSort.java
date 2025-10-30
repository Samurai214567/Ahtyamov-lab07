import java.util.*;

public class HeapSort {
    // Основной метод сортировки
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // 1) Построение max-heap (снизу вверх)
        for (int i = n/2 - 1; i >= 0; i--) heapify(arr, n, i);

        // 2) Пошаговое извлечение максимума в конец массива
        for (int i = n - 1; i > 0; i--) {
            // меняем корень (максимум) и последний элемент
            int tmp = arr[0]; arr[0] = arr[i]; arr[i] = tmp;
            // восстанавливаем кучу на уменьшенном префиксе [0..i)
            heapify(arr, i, 0);
        }
    }

    // Вспомогательная функция: "просеивание" вниз (sift-down)
    private static void heapify(int[] arr, int n, int i) {
        int largest = i;          // предполагаемый максимум — текущий узел i
        int l = 2*i + 1;          // левый потомок
        int r = 2*i + 2;          // правый потомок

        // выбираем большего потомка
        if (l < n && arr[l] > arr[largest]) largest = l;
        if (r < n && arr[r] > arr[largest]) largest = r;

        // если потомок больше родителя — меняем и продолжаем просеивание
        if (largest != i) {
            int tmp = arr[i]; arr[i] = arr[largest]; arr[largest] = tmp;
            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
